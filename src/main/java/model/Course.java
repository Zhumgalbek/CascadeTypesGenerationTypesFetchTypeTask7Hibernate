package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "courses")
@Getter
@Setter

@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(length = 25)
    private String name;

    @Column(length = 30)
    private String duration;

    @Column(length = 50)
    private LocalDate createAt;

    @Column(name = "imagine_link", length = 35)
    private String imagineLink;

    @Column
    private String description;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "course")
    private List<Instructor> instructors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", fetch = FetchType.EAGER)
    private List<Lesson> lessons;

    public Course(String name, String duration, LocalDate createAt, String imagineLink,
                  String description) {
        this.name = name;
        this.duration = duration;
        this.createAt = createAt;
        this.imagineLink = imagineLink;
        this.description = description;

    }

    @Override
    public String toString() {
        return "Course{ " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", createAt=" + createAt +
                ", imagineLink='" + imagineLink + '\'' +
                ", description='" + description + '\'' +

                '}';
    }
}
