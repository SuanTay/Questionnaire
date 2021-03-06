package fr.limos.db.entities;
// default package
// Generated 5 janv. 2016 13:26:43 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Result generated by hbm2java
 */
@Entity
@Table(name = "result", catalog = "chu")
public class Result implements java.io.Serializable {

	private Integer idResult;
	private Patient patient;
	private Ranking ranking;
	private Survey survey;
	private Text text;
	private Integer fkChoiceidQuestion;
	private Integer fkIdQuestionforagre;
	private Integer fkIdAnswer;
	private Date currentdate;
	private String value;
	private Set<Agregresult> agregresults = new HashSet(0);

	public Result() {
	}

	public Result(Patient patient, Ranking ranking, Survey survey, Text text, Date currentdate, String value) {
		this.patient = patient;
		this.ranking = ranking;
		this.survey = survey;
		this.text = text;
		this.currentdate = currentdate;
		this.value = value;
	}

	public Result(Patient patient, Ranking ranking, Survey survey, Text text, Integer fkChoiceidQuestion,
			Integer fkIdQuestionforagre, Integer fkIdAnswer, Date currentdate, String value, Set<Agregresult> agregresults) {
		this.patient = patient;
		this.ranking = ranking;
		this.survey = survey;
		this.text = text;
		this.fkChoiceidQuestion = fkChoiceidQuestion;
		this.fkIdQuestionforagre = fkIdQuestionforagre;
		this.fkIdAnswer = fkIdAnswer;
		this.currentdate = currentdate;
		this.value = value;
		this.agregresults = agregresults;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_result", unique = true, nullable = false)
	public Integer getIdResult() {
		return this.idResult;
	}

	public void setIdResult(Integer idResult) {
		this.idResult = idResult;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_patient", nullable = false)
	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "fk_rankingid_question", referencedColumnName = "fk_id_question"),
			@JoinColumn(name = "fk_id_section", referencedColumnName = "fk_id_section"),
			@JoinColumn(name = "fk_id_survey", referencedColumnName = "fk_id_survey") })
	public Ranking getRanking() {
		return this.ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_survey", nullable = false, insertable = false, updatable = false)
	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "fk_textid_question", referencedColumnName = "fk_id_question", insertable = false, updatable = false),
			@JoinColumn(name = "fk_id_section", referencedColumnName = "fk_id_section",  insertable = false, updatable = false),
			@JoinColumn(name = "fk_id_survey", referencedColumnName = "fk_id_survey",  insertable = false, updatable = false) })
	public Text getText() {
		return this.text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	@Column(name = "fk_choiceid_question")
	public Integer getFkChoiceidQuestion() {
		return this.fkChoiceidQuestion;
	}

	public void setFkChoiceidQuestion(Integer fkChoiceidQuestion) {
		this.fkChoiceidQuestion = fkChoiceidQuestion;
	}

	@Column(name = "fk_id_questionforagre")
	public Integer getFkIdQuestionforagre() {
		return this.fkIdQuestionforagre;
	}

	public void setFkIdQuestionforagre(Integer fkIdQuestionforagre) {
		this.fkIdQuestionforagre = fkIdQuestionforagre;
	}

	@Column(name = "fk_id_answer")
	public Integer getFkIdAnswer() {
		return this.fkIdAnswer;
	}

	public void setFkIdAnswer(Integer fkIdAnswer) {
		this.fkIdAnswer = fkIdAnswer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "currentdate", nullable = false, length = 19)
	public Date getCurrentdate() {
		return this.currentdate;
	}

	public void setCurrentdate(Date currentdate) {
		this.currentdate = currentdate;
	}

	@Column(name = "value", nullable = false, length = 500)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "result")
	public Set<Agregresult> getAgregresults() {
		return this.agregresults;
	}

	public void setAgregresults(Set<Agregresult> agregresults) {
		this.agregresults = agregresults;
	}

}
