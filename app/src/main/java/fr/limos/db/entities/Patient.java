package fr.limos.db.entities;


public class Patient {

	private int idPatient;
	private String codepatient;


	public Patient() {
	}

	public String getCodepatient() {
		return codepatient;
	}

	public void setCodepatient(String codepatient) {
		this.codepatient = codepatient;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
}