package fr.limos.db.entities;

/**
 * Created by taysuan on 28/01/2016.
 */
public class Order {
    private int id_order;
    private int id_survey;
    private int id_section;
    private int id_question;
    private int ordersection;
    private int orderquestion;
    private int frequency;

    public Order() {
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_survey() {
        return id_survey;
    }

    public void setId_survey(int id_survey) {
        this.id_survey = id_survey;
    }

    public int getId_section() {
        return id_section;
    }

    public void setId_section(int id_section) {
        this.id_section = id_section;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getOrdersection() {
        return ordersection;
    }

    public void setOrdersection(int ordersection) {
        this.ordersection = ordersection;
    }

    public int getOrderquestion() {
        return orderquestion;
    }

    public void setOrderquestion(int orderquestion) {
        this.orderquestion = orderquestion;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
