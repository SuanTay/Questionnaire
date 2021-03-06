package fr.limos.db.entities;
// default package
// Generated 5 janv. 2016 13:26:43 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * NormalsectionId generated by hbm2java
 */
@SuppressWarnings("serial")
@Embeddable
public class NormalsectionId implements java.io.Serializable {

	private int idSection;
	private int fkIdSurvey;

	public NormalsectionId() {
	}

	public NormalsectionId(int idSection, int fkIdSurvey) {
		this.idSection = idSection;
		this.fkIdSurvey = fkIdSurvey;
	}

	@Column(name = "id_section", nullable = false)
	public int getIdSection() {
		return this.idSection;
	}

	public void setIdSection(int idSection) {
		this.idSection = idSection;
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
		if (!(other instanceof NormalsectionId))
			return false;
		NormalsectionId castOther = (NormalsectionId) other;

		return (this.getIdSection() == castOther.getIdSection()) && (this.getFkIdSurvey() == castOther.getFkIdSurvey());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdSection();
		result = 37 * result + this.getFkIdSurvey();
		return result;
	}

}
