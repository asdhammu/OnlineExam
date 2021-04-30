package edu.utdallas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "quiz_question")
public class QuizQuestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	@JsonManagedReference
	private Quiz quiz;

	@Id
	@ManyToOne
	@JoinColumn(name = "question_id")
	@JsonManagedReference
	private Question questionQuiz;

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Question getQuestionQuiz() {
		return questionQuiz;
	}

	public void setQuestionQuiz(Question questionQuiz) {
		this.questionQuiz = questionQuiz;
	}

}
