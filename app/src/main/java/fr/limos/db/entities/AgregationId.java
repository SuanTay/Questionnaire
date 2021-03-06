package fr.limos.db.entities;
// default package
// Generated 5 janv. 2016 13:26:43 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AgregationId generated by hbm2java
 */
@Embeddable
public class AgregationId implements java.io.Serializable {

	private int idAgregation;
	private int fkIdSection;
	private int fkIdSurvey;

	public AgregationId() {
	}

	public AgregationId(int idAgregation, int fkIdSection, int fkIdSurvey) {
		this.idAgregation = idAgregation;
		this.fkIdSection = fkIdSection;
		this.fkIdSurvey = fkIdSurvey;
	}

	@Column(name = "id_agregation", nullable = false)
	public int getIdAgregation() {
		return this.idAgregation;
	}

	public void setIdAgregation(int idAgregation) {
		this.idAgregation = idAgregation;
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
		if (!(other instanceof AgregationId))
			return false;
		AgregationId castOther = (AgregationId) other;

		return (this.getIdAgregation() == castOther.getIdAgregation())
				&& (this.getFkIdSection() == castOther.getFkIdSection())
				&& (this.getFkIdSurvey() == castOther.getFkIdSurvey());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdAgregation();
		result = 37 * result + this.getFkIdSection();
		result = 37 * result + this.getFkIdSurvey();
		return result;
	}

}
