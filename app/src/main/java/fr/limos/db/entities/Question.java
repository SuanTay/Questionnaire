package fr.limos.db.entities;
// default package
// Generated 5 janv. 2016 13:26:43 by Hibernate Tools 4.3.1.Final

/**
 * Question generated by hbm2java
 */

public class Question {

    private int id_question;
    private int orderquestion;
    private int fk_id_section;
    private int fk_id_survey;
    private int fk_id_label;
    private int fk_answerid_answer;
    private int fk_answerfk_questionforagreid_questionforagre;
    private int fk_answerfk_choicefk_normalsectionfk_surveyid_survey;
    private int fk_answerfk_choicefk_normalsectionid_section;
    private int	fk_answerfk_choiceid_question	;

    public Question() {
    }

    public int getFk_answerfk_choiceid_question() {
        return fk_answerfk_choiceid_question;
    }

    public void setFk_answerfk_choiceid_question(int fk_answerfk_choiceid_question) {
        this.fk_answerfk_choiceid_question = fk_answerfk_choiceid_question;
    }

    public Question(int id_question, int orderquestion, int fk_id_section, int fk_id_survey, int fk_id_label, int fk_answerid_answer, int fk_answerfk_questionforagreid_questionforagre, int fk_answerfk_choicefk_normalsectionfk_surveyid_survey, int fk_answerfk_choicefk_normalsectionid_section, int fk_answerfk_choiceid_question) {
        this.id_question = id_question;
        this.orderquestion = orderquestion;
        this.fk_id_section = fk_id_section;
        this.fk_id_survey = fk_id_survey;
        this.fk_id_label = fk_id_label;
        this.fk_answerid_answer = fk_answerid_answer;
        this.fk_answerfk_questionforagreid_questionforagre = fk_answerfk_questionforagreid_questionforagre;
        this.fk_answerfk_choicefk_normalsectionfk_surveyid_survey = fk_answerfk_choicefk_normalsectionfk_surveyid_survey;
        this.fk_answerfk_choicefk_normalsectionid_section = fk_answerfk_choicefk_normalsectionid_section;
        this.fk_answerfk_choiceid_question = fk_answerfk_choiceid_question;
    }

    public int getFk_answerfk_choicefk_normalsectionid_section() {
        return fk_answerfk_choicefk_normalsectionid_section;
    }

    public void setFk_answerfk_choicefk_normalsectionid_section(int fk_answerfk_choicefk_normalsectionid_section) {
        this.fk_answerfk_choicefk_normalsectionid_section = fk_answerfk_choicefk_normalsectionid_section;
    }

    public int getFk_answerfk_choicefk_normalsectionfk_surveyid_survey() {
        return fk_answerfk_choicefk_normalsectionfk_surveyid_survey;
    }

    public void setFk_answerfk_choicefk_normalsectionfk_surveyid_survey(int fk_answerfk_choicefk_normalsectionfk_surveyid_survey) {
        this.fk_answerfk_choicefk_normalsectionfk_surveyid_survey = fk_answerfk_choicefk_normalsectionfk_surveyid_survey;
    }

    public int getFk_answerfk_questionforagreid_questionforagre() {
        return fk_answerfk_questionforagreid_questionforagre;
    }

    public void setFk_answerfk_questionforagreid_questionforagre(int fk_answerfk_questionforagreid_questionforagre) {
        this.fk_answerfk_questionforagreid_questionforagre = fk_answerfk_questionforagreid_questionforagre;
    }

    public int getFk_answerid_answer() {
        return fk_answerid_answer;
    }

    public void setFk_answerid_answer(int fk_answerid_answer) {
        this.fk_answerid_answer = fk_answerid_answer;
    }

    public int getLabel() {
        return fk_id_label;
    }

    public void setFk_id_label(int fk_id_label) {
        this.fk_id_label = fk_id_label;
    }

    public int getFk_id_survey() {
        return fk_id_survey;
    }

    public void setFk_id_survey(int fk_id_survey) {
        this.fk_id_survey = fk_id_survey;
    }

    public int getFk_id_section() {
        return fk_id_section;
    }

    public void setFk_id_section(int fk_id_section) {
        this.fk_id_section = fk_id_section;
    }

    public int getOrderquestion() {
        return orderquestion;
    }

    public void setOrderquestion(int orderquestion) {
        this.orderquestion = orderquestion;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }
}