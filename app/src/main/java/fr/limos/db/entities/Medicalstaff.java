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
 * Medicalstaff generated by hbm2java
 */
@Entity
@Table(name = "medicalstaff", catalog = "chu")
public class Medicalstaff implements java.io.Serializable {

	private Integer idMedicalstaff;
	private String login;
	private String role;

	public Medicalstaff() {
	}

	public Medicalstaff(String login) {
		this.login = login;
	}

	public Medicalstaff(String login, String role) {
		this.login = login;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_medicalstaff", unique = true, nullable = false)
	public Integer getIdMedicalstaff() {
		return this.idMedicalstaff;
	}

	public void setIdMedicalstaff(Integer idMedicalstaff) {
		this.idMedicalstaff = idMedicalstaff;
	}

	@Column(name = "login", nullable = false, length = 50)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "role", length = 500)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
