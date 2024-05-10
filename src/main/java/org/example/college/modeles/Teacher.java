package org.example.college.modeles;

import org.example.college.connexion.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher extends DAO {

    private  int id_teacher;
    private String name;
    private  String prename;
    private  String  email;
    private  int numberPhone;
    private Department department;

    public Teacher(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }


    public void setDepartment(Department department) {
        this.department = department;
    }



    //add teacher

    public void addTeacher() throws SQLException {
        String sql = "INSERT INTO TEACHER (name, prename, email, numberPhone) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setString(1, this.name);
        ps.setString(2, this.prename);
        ps.setString(3, this.email);
        ps.setInt(4, this.numberPhone);
        ps.executeUpdate();
    }


    public void editTeacher(int id_teacher, String newName, String newPrename, String newEmail, int newNumberPhone) throws SQLException {
        String sql = "UPDATE TEACHER SET name = ?, prename = ?, email = ?, numberPhone = ? WHERE name = ?";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setString(1, newName);
        ps.setString(2, newPrename);
        ps.setString(3, newEmail);
        ps.setInt(4, newNumberPhone);
        ps.setInt(5, id_teacher);
        ps.executeUpdate();
    }


    public void deleteTeacher() throws SQLException {
        String sql = "DELETE FROM TEACHER WHERE name = ?";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setInt(1, this.id_teacher);
        ps.executeUpdate();
    }

    public void displayTeacher() throws SQLException {
        String sql = "SELECT * FROM TEACHER";
        ResultSet rs = connect_db().createStatement().executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id_teacher");
            String name = rs.getString("name");
            String prename = rs.getString("prename");
            String email = rs.getString("email");
            int numberPhone = rs.getInt("numberPhone");
            System.out.println("ID: " + id + ", Name: " + name + ", Prename: " + prename + ", Email: " + email + ", Phone: " + numberPhone);
        }
    }
    public void createTableTeacher() throws SQLException {
        try (Connection connection = connect_db()) {
            String sql = "CREATE TABLE IF NOT EXISTS Teacher (" +
                    "id_teacher INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "name TEXT," +
                    "prename TEXT," +
                    "email TEXT," +
                    "numberPhone INTEGER," +
                    "department_id INTEGER," + // Foreign key reference to department table
                    "FOREIGN KEY (department_id) REFERENCES Department(id_Department)" +
                    ");";
            connection.createStatement().execute(sql);
        }
    }


    /*
    public ObservableList<org.example.college.modeles.Teacher> getAllTeachers() throws SQLException {
        String sql = "SELECT * FROM TEACHER";
        ResultSet rs = connect_db().createStatement().executeQuery(sql);
        ObservableList<org.example.college.modeles.Teacher> teachers = FXCollections.observableArrayList();
        while (rs.next()) {
            teachers.add(new org.example.college.modeles.Teacher(
                    rs.getString("name"),
                    new org.example.college.modeles.Department(rs.getString("department")),
                    ((ResultSet) rs).getString("email"),
                    rs.getInt("numberPhone")
            ));
        }
        return teachers;
    }*/
}
