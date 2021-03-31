package entity;

import java.util.Objects;

public class StudentProgress {
    private int idStudent;
    private int idStudentProgress;
    private String lessonName;
    private int mark;

    public StudentProgress() {
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdStudentProgress() {
        return idStudentProgress;
    }

    public void setIdStudentProgress(int idStudentProgress) {
        this.idStudentProgress = idStudentProgress;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentProgress that = (StudentProgress) o;
        return idStudent == that.idStudent && idStudentProgress == that.idStudentProgress && mark == that.mark && Objects.equals(lessonName, that.lessonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, idStudentProgress, lessonName, mark);
    }

    @Override
    public String toString() {
        return "StudentProgress{" +
                "idStudent=" + idStudent +
                ", idStudentProgress=" + idStudentProgress +
                ", lessonName='" + lessonName + '\'' +
                ", mark=" + mark +
                '}';
    }
}
