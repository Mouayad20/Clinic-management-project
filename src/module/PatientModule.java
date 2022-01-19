package module;

import javax.lang.model.element.NestingKind;

public class PatientModule {
    private int id;
    private String id_patient;
    private String name;
    private String father_name;
    private String mother_name;
    private String birthday;
    private String mobilephone;
    private String job;
    private String descreption;
    private String warning;

    public PatientModule(){
        id_patient = "0";
        name=father_name=warning=mother_name=mobilephone=job=descreption = "لا يوجد";
        birthday = "1000-1-1";
    }

    /**
     *
     * @param id_patient
     * @param name
     * @param father_name
     * @param mother_name
     * @param birthday
     * @param mobilephone
     * @param job
     * @param descreption
     */
    public PatientModule(String id_patient,
                         String name,
                         String father_name,
                         String mother_name,
                         String birthday,
                         String mobilephone,
                         String job,
                         String descreption,
                         String warning) {
        this.id_patient = id_patient;
        this.name = name;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.birthday = birthday;
        this.mobilephone = mobilephone;
        this.job = job;
        this.descreption = descreption;
        this.warning = warning;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_patient(String id_patient) {
        this.id_patient = id_patient;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public int getId() {
        return id;
    }

    public String getId_patient() {
        return id_patient;
    }

    public String getName() {
        return name;
    }

    public String getFather_name() {
        return father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getJob() {
        return job;
    }

    public String getDescreption() {
        return descreption;
    }

    public String getWarning() {
        return warning;
    }
}
