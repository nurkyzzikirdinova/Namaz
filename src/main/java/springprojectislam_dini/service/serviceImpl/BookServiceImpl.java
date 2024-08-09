package springprojectislam_dini.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.springprojectislam_dini.MyExeption.MyException;
import peaksoft.springprojectislam_dini.entity.Book;
import peaksoft.springprojectislam_dini.entity.User;
import peaksoft.springprojectislam_dini.repository.BookRepository;
import peaksoft.springprojectislam_dini.repository.UserRepository;
import peaksoft.springprojectislam_dini.service.BookService;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public void saveBook(Long userId, Book newBook) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(String.format("User by id %d not found", userId)));
        user.getBooks().add(newBook);
        newBook.setUser(user);
        userRepository.save(user);
        bookRepository.save(newBook);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByIdBook(Long bookId) {
        try {
            return bookRepository.findById(bookId).orElseThrow(() -> new MyException("Agency not found!"));
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateBookById(Long bookId, Book newBook) {
        try {
            Book book = bookRepository.findById(bookId).orElseThrow(() -> new MyException("Agency not found!"));
            book.setName(newBook.getName());
            book.setPrice(newBook.getPrice());
            book.setImage(newBook.getImage());
            bookRepository.save(book);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<Book> BookSearch(String word) {
        try {
            String pattern = word = "%";
            List<Book> books = bookRepository.searchBook(pattern);
            if (books == null || books.isEmpty()) {
                throw new MyException("Not Books");
            } else {
                return books;
            }
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }
}
