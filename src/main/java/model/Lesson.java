package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(name = "video_link", length = 35)
    private String videoLink;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},fetch = FetchType.EAGER)
    private Course course;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Task> task;



    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;
    }
    public void addTask(Task newTask) {
        this.task.add(newTask);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", videoLink='" + videoLink +
                '}';
    }


}
