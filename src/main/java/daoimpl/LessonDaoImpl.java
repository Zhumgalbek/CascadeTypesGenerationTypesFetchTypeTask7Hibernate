package daoimpl;

import cofig.Util;
import dao.LessonDao;
import jakarta.persistence.EntityManagerFactory;
import model.Course;
import model.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LessonDaoImpl implements LessonDao {

    private final SessionFactory sessionFactory = Util.createSessionFactory();

    private final EntityManagerFactory entityManagerFactory = Util.createEntityManagerFactory();

    @Override
    public void saveLesson(Long course_id, Lesson lesson) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Course course = session.get(Course.class, course_id);
            if (course == null) {
                System.out.println("no such course!!! (assignInstructorToCourse)");
            } else {
                lesson.setCourse(course);
                session.merge(lesson);
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception exception) {
            System.out.println("EXCEPTION !!! (saveCourse)");
        }
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();

            Lesson lesson1 = session.get(Lesson.class, id);
            if (lesson1 == null) {
                System.out.println("no such course!!! (assignInstructorToCourse)");
            } else {
                lesson1.setName(lesson.getName());
                lesson1.setTask(lesson.getTask());
                lesson1.setVideoLink(lesson.getVideoLink());
                lesson1.setCourse(lesson.getCourse());

                session.merge(lesson1);
                session.getTransaction().commit();
                session.close();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Lesson getLessonById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();

            Lesson lesson = session.find(Lesson.class, id);
            if (lesson == null) {
                System.out.println("no such identifier!!!");
            }

            session.getTransaction().commit();
            session.close();
            return lesson;
        } catch (Exception e) {
            System.out.println("no such identifier!!!");
        }
        return null;
    }

    @Override
    public List<Lesson> getAllCogetLessonsByCoursedurse(Long id) {
        try {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Course course = session.find(Course.class,id);
        List<Lesson> lessons = course.getLessons();

        session.getTransaction().commit();
        session.close();
        return lessons;

    } catch(Exception e){
        System.out.println("getInstructorByCourseId course error");
    }return null;
}
}
