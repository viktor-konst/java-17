package entity;

import java.util.ArrayList;
import java.util.Objects;

public class Term {
    private int id;
    private String termName;
    private String duration;
    private int status=1;
    private ArrayList<Lesson> lessons= new ArrayList<>();

    public Term() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return id == term.id && status == term.status && Objects.equals(termName, term.termName) && Objects.equals(duration, term.duration) && Objects.equals(lessons, term.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, termName, duration, status, lessons);
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", termName='" + termName + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", lessons=" + lessons +
                '}';
    }
}
