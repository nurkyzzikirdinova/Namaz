package springprojectislam_dini.service;

import springprojectislam_dini.MyExeption.MyException;
import springprojectislam_dini.entity.Lesson;

import java.util.List;

public interface LessonService {
    void saveLesson(Long userId, Lesson lesson);

    List<Lesson> findAllLessons();

    Lesson findByIdLesson(Long lessonId);

    void updateLessonById(Long lessonId, Lesson lesson) throws MyException;

    void deleteLessonById(Long lessonId);

    List<Lesson> LessonSearch(String word);

}
