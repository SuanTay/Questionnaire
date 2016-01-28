package fr.limos.db.entities;
// default package
// Generated 5 janv. 2016 13:26:43 by Hibernate Tools 4.3.1.Final

import java.util.Date;

public class Survey {
    private int id_survey;
    private Date startdate;
    private Date enddate;
    private int defaultfrequency;
    private String status;
    private int fk_id_label;

    public Survey() {
    }

    public int getLabel() {
        return fk_id_label;
    }

    public void setFk_id_label(int fk_id_label) {
        this.fk_id_label = fk_id_label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDefaultfrequency() {
        return defaultfrequency;
    }

    public void setDefaultfrequency(int defaultfrequency) {
        this.defaultfrequency = defaultfrequency;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public int getId_survey() {
        return id_survey;
    }

    public void setId_survey(int id_survey) {
        this.id_survey = id_survey;
    }
}