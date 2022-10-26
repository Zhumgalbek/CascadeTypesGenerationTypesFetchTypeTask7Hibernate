package org.example;

import model.Course;
import model.Instructor;
import model.Lesson;
import model.Task;
import service.Service;
import service.ServiceImpl;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class App {

    public static Scanner scanner = new Scanner(System.in);

    private static final Service service = new ServiceImpl();
    public static void main(String[] args) {

        Instructor instructor = new Instructor("Zhanarbek","Abdurasulov","zhanarbek@gmail.com","+996999011699");

        Instructor instructor1 = new Instructor("Muhammed","Allanov","allanov@gmail.com","+996999011699");

        Lesson lesson = new Lesson("Hibernate","yhttps://www.youtube.com/");

        Lesson lesson1 = new Lesson("SQL","video");

        Course course = new Course("Peaksoft","Kygyzstan",LocalDate.of(2000,12,12),
                "peaksoft.talentlms.com","good course!)");

        Course course1 = new Course("JAVA7RULIT","Kygyzstan", LocalDate.now(),
                "peaksoft.talentlms.com","good course!)");

        Task task = new Task("JAVA7",LocalDate.now(),"HIBERNATE");

        Task task1 = new Task("JAVA7",LocalDate.now(),"HIBERNATE");

        Instructor instructor2 = new Instructor("RASUL","Abdurasulov","zhanarbek@gmail.com","+996999011699");

        Instructor instructor3 = new Instructor("AIASABEK","Allanov","allanov@gmail.com","+996999011699");

        Lesson lesson3 = new Lesson("OOP","yhttps://www.youtube.com/");

        Lesson lesson4 = new Lesson("MASSIV","video");

        Course cours3 = new Course("ITRUN","Kygyzstan", LocalDate.now(),
                "peaksoft.talentlms.com","good course!)");

        Course course4 = new Course("JS","Kygyzstan", LocalDate.now(),
                "peaksoft.talentlms.com","good course!)");

        Task task3 = new Task("JAVA_SCRIPT7",LocalDate.now(),"HIBERNATE");

        Task task4 = new Task("JAVA-8",LocalDate.now(),"HIBERNATE");

        while (true) {
            System.out.print("ВВЫБЕРИТЕ ЦИФРУ : ");
            String SelectNumber = scanner.nextLine();

            System.out.println();

            switch (SelectNumber) {
                case "1" -> service.saveCourse(course);
                case "2" -> service.updateCourse(1L, course1);
                case "3" -> System.out.println(service.getCourseById(1L));
                case "4" -> System.out.println(service.getAllCourse());
                case "5" -> service.deleteCourseById(1L);
                case "6"-> System.out.println(service.getCourseByName("Peaksoft"));
                case "7" -> service.saveInstructor(instructor);
                case "8" -> service.updateInstructor(1L, instructor1);
                case "9" -> System.out.println(service.getInstructorById(1L));
                case "10" -> System.out.println(service.getInstructorByCourseId(1L));
                case "11" -> service.deleteInstructorById(1L);
                case "12" -> service.assignInstructorToCourse(1L, 1L);
                case "13" -> service.saveLesson(10L, lesson);
                case "14" -> service.updateLesson(1L, lesson1);
                case "15" -> System.out.println(service.getLessonById(1L));
                case "16" -> service.getLessonsByCourseId(1L);
                case "17" -> service.saveTask(1L, task);
                case "18" -> service.updateTask(1L, task1);
                case "19" -> System.out.println(service.getAllTaskByLessonId(1L));
                case "20" -> service.deleteTaskById(1L);
                default -> System.out.println("no such number!!!!");

            }
        }
    }
}
