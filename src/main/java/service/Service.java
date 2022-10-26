package service;

import model.Course;
import model.Instructor;
import model.Lesson;
import model.Task;

import java.util.List;

public interface Service {

    void saveCourse(Course course);//-1

    void updateCourse(Long id, Course course);//0


    Course getCourseById(Long id); //1

    List<Course> getAllCourse(); //2

    void deleteCourseById(Long id);//3

    Course getCourseByName(String name);//4

    void saveInstructor(Instructor instructor);//5

    void updateInstructor(Long id, Instructor instructor);//6

    Instructor getInstructorById(Long id);//7

    List<Instructor> getInstructorByCourseId(Long id);//8

    void deleteInstructorById(Long id);//9

    void assignInstructorToCourse(Long course_id, Long instructor_id);//10

    void saveLesson(Long id, Lesson lesson);//11

    void updateLesson(Long id, Lesson lesson);//12

    Lesson getLessonById(Long id);//13

    List<Lesson> getLessonsByCourseId(Long id);//14

    void saveTask(Long id, Task task);//15

    void updateTask(Long id, Task task);//16

    List<Task> getAllTaskByLessonId(Long id);//17

    void deleteTaskById(Long id);//18
}
