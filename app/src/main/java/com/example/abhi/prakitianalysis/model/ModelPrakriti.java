package com.example.abhi.prakitianalysis.model;

public class ModelPrakriti {
    private String questions;
    private String vata;
    private String pitta;
    private String kapha;
    private String answer;
    private int checkedId = -1;

    public int getSelectedRadioButtonId() {
        return checkedId;
    }

    public void setSelectedRadioButtonId(int checkedId) {
        this.checkedId = checkedId;
    }


    public ModelPrakriti(String questions, String vata, String pitta, String kapha) {
        this.questions = questions;
        this.vata = vata;
        this.pitta = pitta;
        this.kapha = kapha;
    }
    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getVata() {
        return vata;
    }

    public void setVata(String vata) {
        this.vata = vata;
    }

    public String getPitta() {
        return pitta;
    }

    public void setPitta(String pitta) {
        this.pitta = pitta;
    }

    public String getKapha() {
        return kapha;
    }

    public void setKapha(String kapha) {
        this.kapha = kapha;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
