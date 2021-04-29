package edu.utdallas.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by asdha on 5/25/2017.
 */
@Entity
@Table(name = "course_section")
public class Section {

    @Id
    @Column(name = "section_id")
    private int sectionId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User user;

    @Column(name = "semester")
    private String semester;

    @Column(name = "course_year")
    private Date year;

    @OneToMany(mappedBy = "section")
    private List<StudentSection> students;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public List<StudentSection> getStudents() {
        return students;
    }

    public void setStudents(List<StudentSection> students) {
        this.students = students;
    }
}

