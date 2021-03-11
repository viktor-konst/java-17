package entity;

import java.util.Objects;

public class Lesson {
    private int id;
    private  String lessonName;
    private int status=1;

    public Lesson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id == lesson.id && status == lesson.status && Objects.equals(lessonName, lesson.lessonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lessonName, status);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonName='" + lessonName + '\'' +
                ", status=" + status +
                '}';
    }
}
