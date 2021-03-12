import dataBase.DBManager;
import entity.Group;
import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(
        DBManager.getThisTerm(6).getTermName());

    }
}
