package edu.utdallas.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue
	@Column(name = "question_id")
	private int questionId;

	@Column(name = "description")
	private String questionDescription;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private Set<Tag> tags;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private List<TestCase> testCases;

	@JsonBackReference
	@OneToMany(mappedBy = "questionQuiz", cascade = CascadeType.ALL)
	private List<QuizQuestion> quiz;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public List<TestCase> getTestCases() {
		return testCases;
	}

	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	}

	public List<QuizQuestion> getQuiz() {
		return quiz;
	}

	public void setQuiz(List<QuizQuestion> quiz) {
		this.quiz = quiz;
	}

}
