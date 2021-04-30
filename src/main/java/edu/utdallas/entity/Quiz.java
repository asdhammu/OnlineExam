package edu.utdallas.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue
	@Column(name = "quiz_id")
	private int quizId;

	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;

	@Column(name = "activation_time")
	private Timestamp activationTime;

	@JsonBackReference
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	private List<QuizQuestion> question;

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Timestamp getActivationTime() {
		return activationTime;
	}

	public void setActivationTime(Timestamp activationTime) {
		this.activationTime = activationTime;
	}

	public List<QuizQuestion> getQuestion() {
		return question;
	}

	public void setQuestion(List<QuizQuestion> question) {
		this.question = question;
	}

}
