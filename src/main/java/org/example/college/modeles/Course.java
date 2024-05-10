package org.example.college.modeles;

import org.example.college.connexion.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Course extends DAO {
    private String name;
    private Department department;
    private Teacher instructor;


    public Course() {
    }

    public Course(String name, Department department, Teacher instructor) {
        this.name = name;
        this.department = department;
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public Teacher getInstructor() {
        return instructor;
    }


    public void addCourse() throws SQLException {
        String sql = "INSERT INTO COURSE (name, department, instructor) VALUES (?, ?, ?)";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setString(1, this.name);
        ps.setString(2, this.department.getName());
        ps.setString(3, this.instructor.getName());
        ps.executeUpdate();
    }

    public void updateCourse(String newName, String newDepartment, String newInstructor) throws SQLException {
        String sql = "UPDATE COURSE SET name = ?, department = ?, instructor = ? WHERE name = ?";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setString(1, newName);
        ps.setString(2, newDepartment);
        ps.setString(3, newInstructor);
        ps.setString(4, this.name);
        ps.executeUpdate();
    }

    public void deleteCourse() throws SQLException {
        String sql = "DELETE FROM COURSE WHERE name = ?";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setString(1, this.name);
        ps.executeUpdate();
    }

    public void displayCourses() throws SQLException {
        String sql = "SELECT * FROM COURSE";
        ResultSet rs = connect_db().createStatement().executeQuery(sql);
        while (rs.next()) {
            String name = rs.getString("name");
            String department = rs.getString("department");
            String instructor = rs.getString("instructor");
            System.out.println("org.example.college.modeles.Course: " + name + ", org.example.college.modeles.Department: " + department + ", Instructor: " + instructor);
        }
    }
}