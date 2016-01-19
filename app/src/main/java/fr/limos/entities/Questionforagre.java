package fr.limos.entities;
// default package
// Generated 5 janv. 2016 13:26:43 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Questionforagre generated by hbm2java
 */
@Entity
@Table(name = "questionforagre", catalog = "chu")
public class Questionforagre implements java.io.Serializable {

	private QuestionforagreId id;
	private Agregation agregation;
	private Labelchu label;
	private Integer orderquestionagr;
	private Set<Answer> answers = new HashSet(0);

	public Questionforagre() {
	}

	public Questionforagre(QuestionforagreId id, Agregation agregation, Labelchu label) {
		this.id = id;
		this.agregation = agregation;
		this.label = label;
	}

	public Questionforagre(QuestionforagreId id, Agregation agregation, Labelchu label, Integer orderquestionagr,
			Set<Answer> answers) {
		this.id = id;
		this.agregation = agregation;
		this.label = label;
		this.orderquestionagr = orderquestionagr;
		this.answers = answers;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idQuestionforagre", column = @Column(name = "id_questionforagre") ),
			@AttributeOverride(name = "fkIdAgregation", column = @Column(name = "fk_id_agregation") ) })
	public QuestionforagreId getId() {
		return this.id;
	}

	public void setId(QuestionforagreId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "fk_id_agregation", referencedColumnName = "id_agregation",  insertable = false, updatable = false),
			@JoinColumn(name = "fk_id_section", referencedColumnName = "fk_id_section", insertable = false, updatable = false),
			@JoinColumn(name = "fk_id_survey", referencedColumnName = "fk_id_survey", insertable = false, updatable = false) })
	public Agregation getAgregation() {
		return this.agregation;
	}

	public void setAgregation(Agregation agregation) {
		this.agregation = agregation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_label", nullable = false)
	public Labelchu getLabel() {
		return this.label;
	}

	public void setLabel(Labelchu label) {
		this.label = label;
	}

	@Column(name = "orderquestionagr")
	public Integer getOrderquestionagr() {
		return this.orderquestionagr;
	}

	public void setOrderquestionagr(Integer orderquestionagr) {
		this.orderquestionagr = orderquestionagr;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionforagre")
	public Set<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

}
