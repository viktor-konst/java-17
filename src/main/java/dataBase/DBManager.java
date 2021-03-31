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
                    "where student.status = '1' ");

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
            ResultSet rs = stmt.executeQuery("select students_17.student.id, students_17.student.lastname, students_17.student.firstname,students_17.student.id_group , group.group_name,students_17.student.date\n" +
                    "from students_17.student join students_17.group \n" +
                    "on students_17.student.id_group=students_17.group.id\n" +
                    "where students_17.student.id = '" + idStudent + "'");

            rs.next();
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

    public static int getThisGroupID(String groupName) {
        int id = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_17.group\n" +
                    "where students_17.group.group_name='" + groupName + "' and students_17.group.status=1");
            id = rs.getInt("id");
            System.out.println(id);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }

    public static ArrayList<StudentProgress> getThisStudentProgress(int idStudent, int idTerm) {
        ArrayList<StudentProgress> studentProgresses = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select student_progress.id, students_17.lesson.lesson_name, students_17.student_progress.mark\n" +
                    "from students_17.lesson  right join students_17.term_lesson\n" +
                    "on students_17.term_lesson.id_lesson= students_17.lesson.id\n" +
                    "right join students_17.student_progress \n" +
                    "on students_17.student_progress.id_term_lesson=students_17.term_lesson.id\n" +
                    "where students_17.student_progress.id_student='" + idStudent + "' and students_17.term_lesson.id_term='" + idTerm + "'");

            while (rs.next()) {
                StudentProgress stprgrs = new StudentProgress();
                stprgrs.setIdStudent(idStudent);
                stprgrs.setIdStudentProgress(rs.getInt("id"));
                stprgrs.setLessonName(rs.getString("lesson_name"));
                stprgrs.setMark(rs.getInt("mark"));
                studentProgresses.add(stprgrs);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return studentProgresses;
    }
    public static void modifyThisMark( int id, int mark){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `students_17`.`student_progress` SET `mark` = '"+mark+"' WHERE (`id` = '"+id+"');");


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static StudentProgress getThisMark(int id){
       StudentProgress studentProgress = new StudentProgress();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select student_progress.id, students_17.lesson.lesson_name, students_17.student_progress.mark\n" +
                    "from students_17.lesson  right join students_17.term_lesson\n" +
                    "on students_17.term_lesson.id_lesson= students_17.lesson.id\n" +
                    "right join students_17.student_progress \n" +
                    "on students_17.student_progress.id_term_lesson=students_17.term_lesson.id\n" +
                    "where students_17.student_progress.id='" + id + "'");

            rs.next();

                studentProgress.setIdStudentProgress(rs.getInt("id"));
               studentProgress.setLessonName(rs.getString("lesson_name"));
                studentProgress.setMark(rs.getInt("mark"));



        } catch (Exception e) {
            e.printStackTrace();

        }
        return studentProgress;
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
    public static Lesson getThisLesson(String id){
        Lesson lesson= new Lesson();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_17.lesson\n" +
                    "where id='"+id+"';");

           rs.next();

                lesson.setId(rs.getInt("id"));
                lesson.setLessonName(rs.getString("lesson_name"));



        } catch (Exception e) {
            e.printStackTrace();

        }
        return lesson;
    }

    public static void modifyLesson(String idlLesson, String newLesson) {
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
                    "where status=1\n" +
                    "order by term_name;");

            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTermName(rs.getString("term_name"));
                term.setDuration(rs.getString("duration"));
                terms.add(term);
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

    public static Term getThisTerm(int idTerm) {
        Term term = new Term();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_17.term\n" +
                    "where term.id='" + idTerm + "';");
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
            int idOfNewTerm = 0;

            ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM term");
            rs.next();
            idOfNewTerm = rs.getInt("MAX(id)");
            ArrayList<Student> students = getAllActiveStudents();
            int idOfTermLesson=0;
            for (Lesson lesson : lessons) {
                stmt.execute("INSERT INTO `students_17`.`term_lesson` (`id_term`, `id_lesson`) VALUES ('" + idOfNewTerm + "', '" + lesson.getId() + "');");
                rs = stmt.executeQuery("SELECT MAX(id) FROM term_lesson");
                rs.next();
                idOfTermLesson = rs.getInt("MAX(id)");
                for (Student student: students){
                stmt.execute("INSERT INTO `students_17`.`student_progress` (`id_student`, `id_term_lesson`, `mark`) VALUES ('"+student.getId()+"', '"+idOfTermLesson+"', '0');");}
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static void deactivateTerm(int idTerm){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `students_17`.`term` SET `status` = '0' WHERE (`id` = '" + idTerm+ "');");

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
        return groups;
    }
  public static User getThisUser(String login){
        User user =new User();
      try {
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_17?user=root&password=19577591");
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT user.id, user.login, user.password, role.role\n" +
                  " FROM students_17.user join user_role on\n" +
                  " user_role.id_user=user.id\n" +
                  " join role on role.id=user_role.id_role\n" +
                  " where user.login='"+login+"';");
          ArrayList<Role> roles=new ArrayList<>();
          while (rs.next()) {
             Role role= new Role();
              user.setId(rs.getInt("id"));
              user.setLogin(rs.getString("login"));
              user.setPassword(rs.getString("password"));
              role.setRole(rs.getString("role"));
              roles.add(role);

          }
          user.setRoles(roles);

      } catch (Exception e) {
          e.printStackTrace();

      }
        return user;
  }
}
