package springprojectislam_dini.service;


import springprojectislam_dini.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User newUser);

    List<User> findAllUser();

    User findById(Long userId);

    void updateUserById(Long userId, User newUser);

    void deleteUserById(Long userId);

    List<User> UserSearch(String word);

}
