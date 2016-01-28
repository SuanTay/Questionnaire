package fr.limos.db.entities;
// default package
// Generated 5 janv. 2016 13:26:43 by Hibernate Tools 4.3.1.Final




public class Section  {

	private int id;
	private int label;
	private int survey;
	private int frenquency;
	private int ordersection;
	private int normalsection;
	private int agregatedsection;

	public Section() {
	}

	public Section(int id, int label, int survey, int ordersection) {
		this.id = id;
		this.label = label;
		this.survey = survey;
		this.ordersection = ordersection;
	}

	public Section(int id, int label, int survey, int frenquency, int ordersection,
			int normalsection, int agregatedsection) {
		this.id = id;
		this.label = label;
		this.survey = survey;
		this.frenquency = frenquency;
		this.ordersection = ordersection;
		this.normalsection = normalsection;
		this.agregatedsection = agregatedsection;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getLabel() {
		return this.label;
	}

	public void setLabel(int label) {
		this.label = label;
	}


	public int getSurvey() {
		return this.survey;
	}

	public void setSurvey(int survey) {
		this.survey = survey;
	}


	public Integer getFrenquency() {
		return this.frenquency;
	}

	public void setFrenquency(int frenquency) {
		this.frenquency = frenquency;
	}


	public int getOrdersection() {
		return this.ordersection;
	}

	public void setOrdersection(int ordersection) {
		this.ordersection = ordersection;
	}


	public int getNormalsection() {
		return this.normalsection;
	}

	public void setNormalsection(int normalsection) {
		this.normalsection = normalsection;
	}


	public int getAgregatedsection() {
		return this.agregatedsection;
	}

	public void setAgregatedsection(int agregatedsection) {
		this.agregatedsection = agregatedsection;
	}

}
