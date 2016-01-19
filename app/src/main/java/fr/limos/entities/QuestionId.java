package fr.limos.entities;
// default package
// Generated 5 janv. 2016 13:26:43 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * QuestionId generated by hbm2java
 */
@SuppressWarnings("serial")
@Embeddable
public class QuestionId implements java.io.Serializable {

	private int idQuestion;
	private int fkIdSection;
	private int fkIdSurvey;

	public QuestionId() {
	}

	public QuestionId(int idQuestion, int fkIdSection, int fkIdSurvey) {
		this.idQuestion = idQuestion;
		this.fkIdSection = fkIdSection;
		this.fkIdSurvey = fkIdSurvey;
	}
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_question", nullable = false)
	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	@Column(name = "fk_id_section", nullable = false)
	public int getFkIdSection() {
		return this.fkIdSection;
	}

	public void setFkIdSection(int fkIdSection) {
		this.fkIdSection = fkIdSection;
	}

	@Column(name = "fk_id_survey", nullable = false)
	public int getFkIdSurvey() {
		return this.fkIdSurvey;
	}

	public void setFkIdSurvey(int fkIdSurvey) {
		this.fkIdSurvey = fkIdSurvey;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof QuestionId))
			return false;
		QuestionId castOther = (QuestionId) other;

		return (this.getIdQuestion() == castOther.getIdQuestion())
				&& (this.getFkIdSection() == castOther.getFkIdSection())
				&& (this.getFkIdSurvey() == castOther.getFkIdSurvey());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdQuestion();
		result = 37 * result + this.getFkIdSection();
		result = 37 * result + this.getFkIdSurvey();
		return result;
	}

}
