package springprojectislam_dini.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.springprojectislam_dini.MyExeption.MyException;
import peaksoft.springprojectislam_dini.entity.User;
import peaksoft.springprojectislam_dini.repository.UserRepository;
import peaksoft.springprojectislam_dini.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void saveUser(User newUser) {
        userRepository.save(newUser);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) {
        try {
            return userRepository.findById(userId).orElseThrow(() -> new MyException("Agency not found!"));
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateUserById(Long userId, User newUser) {
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new MyException("Agency not found!"));
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setDateOfBirch(newUser.getDateOfBirch());
            user.setCountry(newUser.getCountry());
            user.setImage(newUser.getImage());
            user.setProfession(newUser.getProfession());
            userRepository.save(user);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }



    @Override
    public List<User> UserSearch(String word) {
        try {
            String pattern = word + "%";
            List<User> user = userRepository.searchUser(pattern);
            if (user == null || user.isEmpty()) {
                throw new MyException("User Not found");
            } else {
                return user;
            }
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }
    }
