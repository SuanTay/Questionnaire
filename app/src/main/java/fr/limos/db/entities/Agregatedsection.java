package fr.limos.db.entities;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Agregatedsection generated by hbm2java
 */
@Entity
@Table(name = "agregatedsection", catalog = "chu")
public class Agregatedsection implements java.io.Serializable {

	private AgregatedsectionId id;
	private Section section;
	private Set<Agregation> agregations = new HashSet(0);

	public Agregatedsection() {
	}

	public Agregatedsection(Section section) {
		this.section = section;
	}

	public Agregatedsection(Section section, Set<Agregation> agregations) {
		this.section = section;
		this.agregations = agregations;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idSection", column = @Column(name = "id_section") ),
			@AttributeOverride(name = "fkIdSurvey", column = @Column(name = "fk_id_survey") ) })
	public AgregatedsectionId getId() {
		return this.id;
	}

	public void setId(AgregatedsectionId id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agregatedsection")
	public Set<Agregation> getAgregations() {
		return this.agregations;
	}

	public void setAgregations(Set<Agregation> agregations) {
		this.agregations = agregations;
	}

}
