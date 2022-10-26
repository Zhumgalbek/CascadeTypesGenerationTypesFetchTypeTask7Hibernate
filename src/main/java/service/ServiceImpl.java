package service;

import dao.CourseDao;
import dao.InstructorDao;
import dao.LessonDao;
import dao.TaskDao;
import daoimpl.CourseDaoImpl;
import daoimpl.InstructorDaoImpl;
import daoimpl.LessonDaoImpl;
import daoimpl.TaskDaoImpl;
import model.Course;
import model.Instructor;
import model.Lesson;
import model.Task;

import java.util.List;

public class ServiceImpl implements Service{

    private final CourseDao courseDao = new CourseDaoImpl();

    private final InstructorDao instructorDao = new InstructorDaoImpl();

    private final LessonDao lessonDao = new LessonDaoImpl();

    private final TaskDao taskDao = new TaskDaoImpl();

    @Override
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        courseDao.updateCourse(id,course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public void deleteCourseById(Long id) {
        courseDao.deleteCourseById(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseDao.getCourseByName(name);
    }

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorDao.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructorDao.updateInstructor(id,instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        return instructorDao.getInstructorByCourseId(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorDao.deleteInstructorById(id);
    }

    @Override
    public void assignInstructorToCourse(Long course_id, Long instructor_id) {
        instructorDao.assignInstructorToCourse(course_id,instructor_id);
    }

    @Override
    public void saveLesson(Long id, Lesson lesson) {
        lessonDao.saveLesson(id,lesson);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        lessonDao.updateLesson(id,lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long id) {
        return lessonDao.getAllCogetLessonsByCoursedurse(id);
    }

    @Override
    public void saveTask(Long id, Task task) {
        taskDao.saveTask(id,task);
    }

    @Override
    public void updateTask(Long id, Task task) {
        taskDao.updateTask(id,task);
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        return taskDao.getAllTaskByLessonId(id);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskDao.deleteTaskById(id);
    }
}
