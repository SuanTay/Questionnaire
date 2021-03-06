package fr.limos.db.entities;
// default package
// Generated 5 janv. 2016 13:26:43 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Ontologicalterm generated by hbm2java
 */
@Entity
@Table(name = "ontologicalterm", catalog = "chu")
public class Ontologicalterm implements java.io.Serializable {

	private Integer idOntologicalterm;
	private String codeonto;
	private String labelonto;

	public Ontologicalterm() {
	}

	public Ontologicalterm(String codeonto, String labelonto) {
		this.codeonto = codeonto;
		this.labelonto = labelonto;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_ontologicalterm", unique = true, nullable = false)
	public Integer getIdOntologicalterm() {
		return this.idOntologicalterm;
	}

	public void setIdOntologicalterm(Integer idOntologicalterm) {
		this.idOntologicalterm = idOntologicalterm;
	}

	@Column(name = "codeonto", nullable = false, length = 20)
	public String getCodeonto() {
		return this.codeonto;
	}

	public void setCodeonto(String codeonto) {
		this.codeonto = codeonto;
	}

	@Column(name = "labelonto", nullable = false, length = 500)
	public String getLabelonto() {
		return this.labelonto;
	}

	public void setLabelonto(String labelonto) {
		this.labelonto = labelonto;
	}

}
