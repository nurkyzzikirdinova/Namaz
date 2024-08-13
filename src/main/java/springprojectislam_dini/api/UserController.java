package springprojectislam_dini.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springprojectislam_dini.entity.User;
import springprojectislam_dini.enums.Profession;
import springprojectislam_dini.service.UserService;


import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("professions", Profession.values());
        return "/user/new-user";
    }

    @PostMapping("/newUser")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/users/alymdar";
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUser());
        return "/home-pagh";
    }

    @GetMapping("/alymdar")
    public String getAlymdar(Model model) {
        model.addAttribute("users", userService.findAllUser());
        return "/user/user_main";
    }

    @GetMapping("/biografia/{userId}")
    public String biografia(@PathVariable Long userId, Model model){
        model.addAttribute("userss", userService.findById(userId));
        model.addAttribute("userId",userId);
        return "/user/user-biography";
    }

    @GetMapping("/update/{userId}")
    public String getById(@PathVariable("userId") Long userId, Model model){
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("professions", Arrays.asList(Profession.values()));
        return "user/update-User";
    }


    @PostMapping("/update/{userId}")
    public String updateUser(@PathVariable("userId") Long userId, @ModelAttribute("user") User user) {
        userService.updateUserById(userId, user);
        return "redirect:/users/alymdar";
    }


    @PostMapping("/{userId}/delete")
    public String delete(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return "redirect:/users/alymdar";
    }

    @GetMapping("/search")
    public String searchUser(@RequestParam String word, Model model) {
        List<User> user = userService.UserSearch(word);
        model.addAttribute("users", user);
        return "/user/user-search";
    }
}
