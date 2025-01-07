package org.example.domain;

public class MarkPO {
    private Long sid;
    private Double marks;
    private Integer year;

    @Override
    public String toString() {
        return "MarkPO{" +
                "sid=" + sid +
                ", marks=" + marks +
                ", year=" + year +
                '}';
    }

    public MarkPO(Long sid, Double marks, Integer year) {
        this.sid = sid;
        this.marks = marks;
        this.year = year;
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
}
