package module;

import java.util.Date;

public class VisitModule {
    String date = null;
    String description = null;
    String medecine = null;
    String notes = null;
    public VisitModule(){
        date = "1000-1-1";
        medecine = notes = description = "لا يوجد";
    }

    /**
     *
     * @param date
     * @param description
     * @param medecine
     * @param notes
     */
    public VisitModule(String date, String description, String medecine, String notes) {
        this.date = date;
        this.description = description;
        this.medecine = medecine;
        this.notes = notes;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMedecine(String medecine) {
        this.medecine = medecine;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getMedecine() {
        return medecine;
    }

    public String getNotes() {
        return notes;
    }
}
