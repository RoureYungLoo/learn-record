package org.example.domain;

public class StudentMark {
    private Long id;
    private String name;
    private Integer age;
    private Long sid;
    private Double marks;
    private Integer year;

    @Override
    public String toString() {
        return "StudentMark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sid=" + sid +
                ", marks=" + marks +
                ", year=" + year +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public StudentMark(Long id, String name, Integer age, Long sid, Double marks, Integer year) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sid = sid;
        this.marks = marks;
        this.year = year;
    }

    public StudentMark() {
    }
}
