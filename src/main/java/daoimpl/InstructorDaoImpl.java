package daoimpl;

import cofig.Util;
import dao.InstructorDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.Course;
import model.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class InstructorDaoImpl implements InstructorDao {

    private final SessionFactory sessionFactory = Util.createSessionFactory();

    private final EntityManagerFactory entityManagerFactory = Util.createEntityManagerFactory();

    @Override
    public void saveInstructor(Instructor instructor) {
        try {
            EntityManager entityManager1 = entityManagerFactory.createEntityManager();
            entityManager1.getTransaction().begin();
            entityManager1.persist(instructor);
            entityManager1.getTransaction().commit();
            entityManager1.close();
            System.out.println("this course has been successfully added)" + instructor);
        } catch (Exception e) {
            System.out.println("sava Exception!");
        }
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Instructor instructor1 = session.find(Instructor.class, id);

            instructor1.setCourse(instructor.getCourse());
            instructor1.setEmail(instructor.getEmail());
            instructor1.setFirstName(instructor.getFirstName());
            instructor1.setLastName(instructor.getLastName());
            instructor1.setPhoneNumber(instructor.getPhoneNumber());

            session.merge(instructor1);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("updateInstructor EXCEPTION!!!");
        }
    }

    @Override
    public Instructor getInstructorById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Instructor instructor = session.find(Instructor.class, id);
            if (instructor==null){
                System.out.println("no such identifier!!!");
            }

            session.getTransaction().commit();
            session.close();
            return instructor;
        } catch (Exception e) {
            System.out.println("no such identifier!!!");
        }
        return null;
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Course course = session.find(Course.class,id);
            List<Instructor> instructors = course.getInstructors();

            session.getTransaction().commit();
            session.close();
            return instructors;

        } catch (Exception e) {
            System.out.println("getInstructorByCourseId course error");
        }
        return null;
    }

    @Override
    public void deleteInstructorById(Long id) {

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Instructor instructor = session.find(Instructor.class, id);
            session.remove(instructor);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("no such identifier (deleteInstructorById)!!!");
        }
    }

    @Override
    public void assignInstructorToCourse(Long course_id, Long instructor_id) {

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Course course = session.get(Course.class, course_id);
            if (course == null) {
                System.out.printf("no such course!!! (assignInstructorToCourse)");
            }
            else{
                Instructor instructor = session.get(Instructor.class, instructor_id);
                if (instructor == null){
                    System.out.println("no such instructor!!! (assignInstructorToCourse)");
                }
                else{
                    instructor.getCourse().add(course);
                    session.merge(instructor);
                }
            }


            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            System.out.println("assignInstructorToCourse course error");
        }
    }
}
