package org.example;

import daoimpl.CourseDaoImpl;
import daoimpl.InstructorDaoImpl;
import daoimpl.LessonDaoImpl;
import daoimpl.TaskDaoImpl;
import model.Course;
import model.Instructor;
import model.Lesson;
import model.Task;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Instructor> instructors = new ArrayList<>();
        ArrayList<Lesson> lessons = new ArrayList<>();
        instructors.add(new Instructor());
        lessons.add(new Lesson());
//        courseDao.saveCourse(new Course("Peaksoft","9 - aй", LocalDate.now(),
//                "hkjkdf",
//                "very good course",instructors,lessons));
//        System.out.println("sdaffffffffffffffffffffffffffffffffffffffffffffffffff");

        InstructorDaoImpl instructorDao = new InstructorDaoImpl();

//        instructorDao.updateInstructor(1L,new Instructor("por","asfd","sdafas","asdfa"));

//        System.out.println(instructorDao.getInstructorById(1L));
//        instructorDao.deleteInstructorById(1L);
//        instructorDao.assignInstructorToCourse(3L,2L)
//        System.out.println(instructorDao.getInstructorById(3L));
        LessonDaoImpl lessonDao = new LessonDaoImpl();
//        lessonDao.saveLesson(3L,new Lesson("privet","lka;sjdfl;kakjsdl"));
//        lessonDao.updateLesson(2L,new Lesson("askjdfld","asdkhfa"));
//        System.out.println(lessonDao.getLessonById(6L));
//        courseDao.deleteCourseById(3l);
//        System.out.println(lessonDao.getAllCogetLessonsByCoursedurse(1L));

        TaskDaoImpl taskDao = new TaskDaoImpl();
//        taskDao.saveTask(1L,new Task("akjdsfhkj",LocalDate.now(),"aslkdjf"));
//        taskDao.updateTask(1L,new Task("pricet",LocalDate.now(),"doctor"));

//        System.out.println(courseDao.getCourseByName("dgh"));
//        instructorDao.assignInstructorToCourse(3L,3L);
//        System.out.println(taskDao.getAllTaskByLessonId(1L));

//        taskDao.deleteTaskById(3L);
//        System.out.println(instructorDao.getInstructorByCourseId(1L));
        instructorDao.deleteInstructorById(3L);
    }
}
