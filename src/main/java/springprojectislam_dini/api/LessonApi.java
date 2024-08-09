package springprojectislam_dini.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springprojectislam_dini.MyExeption.MyException;
import peaksoft.springprojectislam_dini.entity.Lesson;
import peaksoft.springprojectislam_dini.service.LessonService;
import peaksoft.springprojectislam_dini.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonApi {

    private final LessonService lessonService;
    private final UserService userService;

    @GetMapping("/new")
    public String createLesson(Model model) {
        model.addAttribute("newLesson", new Lesson());
        model.addAttribute("allUser", userService.findAllUser());
        return "/lesson/new-lesson";
    }

    @PostMapping("/newLesson")
    public String saveLesson(@ModelAttribute("newLesson") Lesson lesson, @RequestParam(value = "userId", required = false) Long userId) {
        lessonService.saveLesson(userId , lesson);
        return "redirect:/lessons/lesson";
    }

    @GetMapping
    public String getAllLesson(Model model) {
        model.addAttribute("lessons", lessonService.findAllLessons());
        return "/home-pagh";
    }

    @GetMapping("/lesson")
    public String getLesson(Model model) {
        model.addAttribute("lessons", lessonService.findAllLessons());
        return "/lesson/lesson-main";
    }

    @GetMapping("/update/{lessonId}")
    public String getById(@PathVariable Long lessonId, Model model) {
        model.addAttribute("lesson", lessonService.findByIdLesson(lessonId));
        model.addAttribute("allUser", userService.findAllUser());
        return "/lesson/update-lesson";
    }

    @PostMapping("/update/{lessonId}")
    public String updateLesson(@PathVariable Long lessonId, @ModelAttribute Lesson lesson) throws MyException {
        lessonService.updateLessonById(lessonId, lesson);
        return "redirect:/lessons/lesson";
    }

    @PostMapping("/{lessonId}/delete")
    public String delete(@PathVariable Long lessonId) {
        lessonService.deleteLessonById(lessonId);
        return "redirect:/lessons/lesson";
    }

    @GetMapping("/search")
    public String searchLesson(@RequestParam String word, Model model){
        List<Lesson>lessons = lessonService.LessonSearch(word);
        model.addAttribute("lessons", lessons);
        return "/lesson/lesson-search";
    }
}
