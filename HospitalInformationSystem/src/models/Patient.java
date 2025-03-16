package models;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String contact;
    private String medicalHistory;

    public Patient(int id, String name, int age, String gender, String contact, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.medicalHistory = medicalHistory;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContact() { return contact; }
    public String getMedicalHistory() { return medicalHistory; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setContact(String contact) { this.contact = contact; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Contact: " + contact + ", History: " + medicalHistory;
    }
}
