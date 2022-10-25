package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 35)
    private String name;

    @Column(name = "dead_line")
    private LocalDate deadline;

    @Column(name = "task")
    private String task;

    @ManyToOne
    @JoinColumn(name = "lesson_id",referencedColumnName = "id")
    private Lesson lesson;

    public Task(String name, LocalDate deadline, String task) {
        this.name = name;
        this.deadline = deadline;
        this.task = task;
    }


}
