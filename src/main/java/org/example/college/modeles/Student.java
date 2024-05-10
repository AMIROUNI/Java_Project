package org.example.college.modeles;

import org.example.college.connexion.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student extends DAO {
    static private int id;
    private String name;
    private String prename;

    private int age;
    private int numberPhone;
    private String email;
    private String password;


    //private static int nextId = 1000;
    private static final String SCHOOL_NAME = "XYZ School";
    private Course enrolledCourse; // Relationship: Composition

   /* public org.example.college.modeles.Student(String name) {
        this.name = name;
        this.id = nextId++;
    }*/


    public Student(String name, String prename, int age, int numberPhone, String email) {
        this.name = name;
        this.prename = prename;
        this.age = age;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public String getName() {
        return name;
    }


    public static String getSchoolName() {
        return SCHOOL_NAME;
    }

    public void setEnrolledCourse(Course enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }

    public Course getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void enrollInCourse(Course course) {
        this.enrolledCourse = course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //add student in data base
    public void addStudent() throws SQLException {
        String sql = "INSERT INTO STUDENT (name, prename, age, numberPhone, email,password) VALUES (?, ?, ?, ?, ?,?)";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setString(1, this.getName());
        ps.setString(2, this.getPrename());
        ps.setInt(3, this.getAge());
        ps.setInt(4, this.getNumberPhone());
        ps.setString(5, this.getEmail());
        ps.setString(6, this.getPassword());
        ps.executeUpdate();
    }


    public void editStudent(String oldName, String newName, String newPrename, int newAge, int newNumberPhone, String newEmail,String password) throws SQLException {
        String sql = "UPDATE STUDENT SET name = ?, prename = ?, age = ?, numberPhone = ?, email = ?,password=? WHERE name = ?";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setString(1, newName);
        ps.setString(2, newPrename);
        ps.setInt(3, newAge);
        ps.setInt(4, newNumberPhone);
        ps.setString(5, newEmail);
        ps.setString(6, password);
        ps.setString(7, oldName);
        ps.executeUpdate();
    }


    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM STUDENT WHERE name = ?";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }



/*
    public <ObservableList> ObservableList<org.example.college.modeles.Student> getAllStudents() throws SQLException {
        String sql = "SELECT * FROM STUDENT";
        ResultSet rs = connect_db().createStatement().executeQuery(sql);
        ObservableList<org.example.college.modeles.Student> students = FXCollections.observableArrayList();
        while (rs.next()) {
            students.add(new org.example.college.modeles.Student(
                    rs.getString("name"),
                    rs.getString("prename"),
                    rs.getInt("age"),
                    rs.getInt("numberPhone"),
                    rs.getString("email")
            ));
        }
        return students;
    }*/

    public void displayStudent() throws SQLException {
        String sql = "SELECT * FROM TEACHER";
        ResultSet rs = connect_db().createStatement().executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String prename = rs.getString("prename");
            String email = rs.getString("email");
            int numberPhone = rs.getInt("numberPhone");
            System.out.println("ID: " + id + ", Name: " + name + ", Prename: " + prename +",Age : "+age+ ", Email: " + email + ", Phone: " + numberPhone);
        }
    }


    public void createTableStudent() throws SQLException {
        try (Connection connection = connect_db()) {
            String sql = "CREATE TABLE IF NOT EXISTS student (" +
                    "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "name TEXT," +
                    "prename TEXT," +
                    "age INTEGER," +
                    "numberPhone TEXT," +
                    "email TEXT" +
                    ")";
            connection.createStatement().execute(sql);
        }
    }

}