package entity;

import java.util.Objects;

public class StudentProgress {
    private int idStudent;
    private int idLesson;
    private int mark;

    public StudentProgress() {
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
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
        return idStudent == that.idStudent && idLesson == that.idLesson && mark == that.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, idLesson, mark);
    }

    @Override
    public String toString() {
        return "StudentProgress{" +
                "idStudent=" + idStudent +
                ", idLesson=" + idLesson +
                ", mark=" + mark +
                '}';
    }
}
