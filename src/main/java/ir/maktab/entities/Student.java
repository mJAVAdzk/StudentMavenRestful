package ir.maktab.entities;

public class Student extends Entity {
    private String name;
    private Integer teacherId;
    private String department;
    private Integer birthYear;

    public Student() {
    }

    public Student(int id, String name, Integer teacherId, String department, Integer birthYear) {
        this.setId(id);
        this.name = name;
        this.teacherId = teacherId;
        this.department = department;
        this.birthYear = birthYear;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Student: id = " + this.getId() + ", name = " + name + ", department = " + department + ", birth year = "
                + birthYear + ", teacher id = " + teacherId;
    }
}
