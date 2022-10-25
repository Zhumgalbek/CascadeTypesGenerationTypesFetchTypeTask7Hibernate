package service;

import model.Course;
import model.Instructor;
import model.Lesson;
import model.Task;

import java.util.List;

public class ServiceImpl implements Service{
    @Override
    public void saveCourse(Course course) {

    }

    @Override
    public void updateCourse(Long id, Course course) {

    }

    @Override
    public Course getCourseById(Long id) {
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return null;
    }

    @Override
    public void deleteCourseById(Long id) {

    }

    @Override
    public Course getCourseByName(String name) {
        return null;
    }

    @Override
    public void saveInstructor(Instructor instructor) {

    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {

    }

    @Override
    public Instructor getInstructorById(Long id) {
        return null;
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        return null;
    }

    @Override
    public void deleteInstructorById(Long id) {

    }

    @Override
    public void assignInstructorToCourse(Long course_id, Long instructor_id) {

    }

    @Override
    public void saveLesson(Long id, Lesson lesson) {

    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {

    }

    @Override
    public Lesson getLessonById(Long id) {
        return null;
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long id) {
        return null;
    }

    @Override
    public void saveTask(Long id, Task task) {

    }

    @Override
    public void updateTask(Long id, Task task) {

    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {

    }
}
