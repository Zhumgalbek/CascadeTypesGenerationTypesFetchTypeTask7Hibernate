package daoimpl;

import cofig.Util;
import dao.TaskDao;
import jakarta.persistence.EntityManagerFactory;
import model.Lesson;
import model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TaskDaoImpl implements TaskDao {

    private final SessionFactory sessionFactory = Util.createSessionFactory();

    private final EntityManagerFactory entityManagerFactory = Util.createEntityManagerFactory();

    @Override
    public void saveTask(Long id, Task task) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();

            Lesson lesson = session.find(Lesson.class,id);
            lesson.addTask(task);
            session.merge(lesson);

            session.getTransaction().commit();
            session.close();
        }catch (Exception exception){
            System.out.println("Exception (saveTask)");
        }
    }

    @Override
    public void updateTask(Long id, Task task) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();

            Task task1 = session.get(Task.class, id);
            if (task1 == null) {
                System.out.println("no such course!!! (updateTask)");
            } else {
               task1.setName(task.getName());
               task1.setTask(task.getTask());
               task1.setDeadline(task.getDeadline());

                session.merge(task1);
                session.getTransaction().commit();
                session.close();
            }
        } catch (Exception exception) {
            System.out.println("EXCEPTION !!! (updateTask)");
        }
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();

            Lesson lesson = session.find(Lesson.class,id);
            List<Task> taskList = lesson.getTask();

                session.getTransaction().commit();
                session.close();
                return taskList;

        } catch (Exception exception) {
            System.out.println("EXCEPTION !!! (getAllTaskByLessonId)");
        }
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Task task = session.find(Task.class,id);
            task.setLesson(null);
            session.remove(task);


            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("no such identifier (deleteTaskById)!!!");
        }
    }
}
