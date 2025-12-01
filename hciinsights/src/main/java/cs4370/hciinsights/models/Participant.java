package cs4370.hciinsights.models;

public class Participant {

    private final int participantId;
    private final String fname;
    private final String lname;
    private final Integer age;
    private String occupation;
    private String occupationExp;
    private String email;

    public Participant(int participantId, String fname, String lname, Integer age, String occupation, String occupationExp, String email) {
        this.participantId = participantId;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.occupation = occupation;
        this.occupationExp = occupationExp;
        this.email = email;
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Integer getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getOccupationExp() {
        return occupationExp;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fname + " " + lname;
    }

}