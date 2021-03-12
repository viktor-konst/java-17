package dataBase;

import entity.*;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Student> getAllActiveStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student join students_17.group \n" +
                    "on student.id_group = students_17.group.id\n" +
                    "where student.status = '1'");

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setLastname(rs.getString("lastname"));
                student.setFirstname(rs.getString("firstname"));
                student.setDate(rs.getDate("date"));
                Group group = new Group();
                group.setId(rs.getInt("id_group"));
                group.setGroupName(rs.getString("group_name"));
                student.setGroup(group);
                students.add(student);
            }
            for (Student st : students) {
                System.out.println(st);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return students;
    }

    public static void modifyStudent(int idStudent, String newName, String newLastname, int idGroup, String newDate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET " +
                    "`lastname` = '" + newLastname + "', " +
                    "`firstname` = '" + newName + "', `id_group` = '" + idGroup + "', `date` " +
                    "= '" + newDate + "' WHERE (`id` = '" + idStudent + "');");


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void deactivateStudent(int idStudent) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `students_17`.`student` SET `status` = '0' WHERE (`id` = '" + idStudent + "');");


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void createStudent(String newName, String newLastname, int idGroup, String newDate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `students_17`.`student` (`lastname`, `firstname`, `id_group`, `date`) VALUES ('" + newLastname + "', '" + newName + "', '" + idGroup + "', '" + newDate + "');");


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static Student getThisStudent(int idStudent) {
        Student student = new Student();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select students_17.student.id, students_17.student.lastname, students_17.student.firstname,students_17.group.group_name,students_17.student.date\n" +
                    "from students_17.student join students_17.group \n" +
                    "on students_17.student.id_group=students_17.group.id\n" +
                    "where students_17.student.id = '" + idStudent + "'");


            student.setId(idStudent);
            student.setLastname(rs.getString("lastname"));
            student.setFirstname(rs.getString("firstname"));
            student.setDate(rs.getDate("date"));
            Group group = new Group();
            group.setId(rs.getInt("id_group"));
            group.setGroupName(rs.getString("group_name"));
            student.setGroup(group);


        } catch (Exception e) {
            e.printStackTrace();

        }
        return student;
    }
    public static int getThisGroupID(String groupName){
     int id=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_17.group\n" +
                    "where students_17.group.group_name='"+groupName+"' and students_17.group.status=1");
            id= rs.getInt("id");
            System.out.println(id);
            } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }
   public static ArrayList<StudentProgress> getThisStudentProgress(int idStudent, int idTerm){
        ArrayList<StudentProgress> studentProgresses =new ArrayList<>();
       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("select lesson.id, student_progress.mark\n" +
                   "from students_17.lesson  right join students_17.term_lesson\n" +
                   "on students_17.term_lesson.id_lesson= students_17.lesson.id\n" +
                   "right join students_17.student_progress \n" +
                   "on students_17.student_progress.id_term_lesson=students_17.term_lesson.id\n" +
                   "where students_17.student_progress.id_student='"+idStudent+"' and students_17.term_lesson.id_term='"+idTerm+"'");

           while (rs.next()) {
              StudentProgress stprgrs = new StudentProgress();
              stprgrs.setIdStudent(idStudent);
              stprgrs.setIdLesson(rs.getInt("id"));
              stprgrs.setMark(rs.getInt("mark"));
           }
           for (StudentProgress stpr : studentProgresses) {
               System.out.println(stpr);
           }
       } catch (Exception e) {
           e.printStackTrace();

       }
        return studentProgresses;
   }

    public static ArrayList<Lesson> getAllActiveLessons() {
        ArrayList<Lesson> lessons = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_17.lesson\n" +
                    "where status=1;");

            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(rs.getInt("id"));
                lesson.setLessonName(rs.getString("lesson_name"));
                lessons.add(lesson);
            }
            for (Lesson lsn : lessons) {
                System.out.println(lsn);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lessons;
    }

    public static void createLesson(String newLesson) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `students_17`.`lesson` (`lesson_name`) VALUES ('" + newLesson + "');");


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void modifyLesson(int idlLesson, String newLesson) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `students_17`.`lesson` SET `lesson_name` = '" + newLesson + "' WHERE (`id` = '" + idlLesson + "');");


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void deactivateLesson(int idLesson) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `students_17`.`lesson` SET `status` = '0' WHERE (`id` = '" + idLesson + "');");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static ArrayList<Lesson> getAllLessonsOfTerm(int idTerm) {
        ArrayList<Lesson> lessons = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select  students_17.lesson.lesson_name\n" +
                    "from students_17.lesson join students_17.term_lesson\n" +
                    "on students_17.lesson.id= students_17.term_lesson.id_lesson\n" +
                    "where students_17.term_lesson.id_term='" + idTerm + "'");

            while (rs.next()) {
                Lesson lesson = new Lesson();
//                lesson.setId(rs.getInt("id"));
                lesson.setLessonName(rs.getString("lesson_name"));
                lessons.add(lesson);
            }
            for (Lesson lsn : lessons) {
                System.out.println(lsn);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lessons;
    }

    public static ArrayList<Term> getAllActiveTerm() {
        ArrayList<Term> terms = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_17.term\n" +
                    "where term.status=1;");

            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTermName(rs.getString("term_name"));
                term.setDuration(rs.getString("duration"));
                terms.add(term);
            }
            for (Term term : terms) {
                System.out.println(term);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return terms;
    }




    public static void modifyTerm(int idTerm, String newDuration, ArrayList<Lesson> lessons) {
        try {


    } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public static Term getThisTerm(int idTerm){
        Term term=new Term();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_17.term\n" +
                    "where term.id='"+idTerm+"';");
            rs.next();
             term.setId(rs.getInt("id"));
             term.setTermName(rs.getString("term_name"));
             term.setDuration(rs.getString("duration"));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return term;
    }

    public static void addNewTerm(String newName, String newDuration, ArrayList<Lesson> lessons) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `students_17`.`term` (`term_name`, `duration`) VALUES ('" + newName + "', '" + newDuration + "');");
            int idOfNewTerm = stmt.executeQuery("SELECT MAX(id) FROM term").getInt("MAX(id)");
            for (Lesson lesson : lessons) {
                stmt.execute("INSERT INTO `students_17`.`term_lesson` (`id_term`, `id_lesson`) VALUES ('" + idOfNewTerm + "', '" + lesson.getId() + "');");

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static ArrayList<Group> getAllActiveGroup() {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_17.group\n" +
                    "where status =1");

            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getInt("id"));
                group.setGroupName(rs.getString("group_name"));
                groups.add(group);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return groups;}

}
