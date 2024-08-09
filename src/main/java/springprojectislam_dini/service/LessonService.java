package springprojectislam_dini.service;

import peaksoft.springprojectislam_dini.MyExeption.MyException;
import peaksoft.springprojectislam_dini.entity.Lesson;

import java.util.List;

public interface LessonService {
    void saveLesson(Long userId, Lesson lesson);

    List<Lesson>findAllLessons();
//    List<Lesson> findAllLessonsByUserId(Long userId);

    Lesson findByIdLesson(Long lessonId);

    void updateLessonById(Long lessonId, Lesson lesson) throws MyException;

    void deleteLessonById(Long lessonId);

    List<Lesson> LessonSearch(String word);

//    void assignLessonToUser(Long lessonId, List<Long>userId) throws MyException;
}
