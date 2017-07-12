package edu.UTDallas.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by asdha on 5/25/2017.
 */
@Entity
@Table(name = "student_section")
public class StudentSection implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private User user;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
