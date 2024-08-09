package springprojectislam_dini.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springprojectislam_dini.entity.Book;
import springprojectislam_dini.service.BookService;
import springprojectislam_dini.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final UserService userService;

    @GetMapping("/new")
    public String createBook(Model model) {
        model.addAttribute("newBook", new Book());
        model.addAttribute("allUser", userService.findAllUser());
        return "/book/newBook";
    }

    @PostMapping("/newBook")
    public String saveBook(@ModelAttribute("newBook") Book book, @RequestParam(value = "userId", required = false) Long userId) {
        bookService.saveBook(userId, book);
        return "redirect:/books/book";
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "/home-pagh";
    }

    @GetMapping("/book")
    public String getBook(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "/book/book-main";
    }

    @GetMapping("/update/{bookId}")
    public String getById(@PathVariable Long bookId, Model model) {
        model.addAttribute("book", bookService.findByIdBook(bookId));
        model.addAttribute("allUser", userService.findAllUser());
        return "/book/update-book";
    }

    @PostMapping("update/{bookId}")
    public String updateBook(@PathVariable Long bookId, @ModelAttribute Book book) {
        bookService.updateBookById(bookId, book);
        return "redirect:/books/book";
    }

    @PostMapping("/{bookId}/delete")
    public String delete(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
        return "redirect:/books/book";
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String word, Model model){
        List<Book>books = bookService.BookSearch(word);
        model.addAttribute("books", books);
        return "book/book-search";
    }

}
