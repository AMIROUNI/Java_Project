package org.example.college.modeles;

import org.example.college.connexion.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Department extends DAO {
    private int id_Departemnt;
    private String name;
    private String location;

    public Department(){}

    public Department(int id_Departemnt,String name, String location) {
        this.id_Departemnt=id_Departemnt;
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getId_Departemnt() {
        return id_Departemnt;
    }

    public void setId_Departemnt(int id_Departemnt) {
        this.id_Departemnt = id_Departemnt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Method to add a new department to the database
    public void addDepartment() throws SQLException {
        String sql = "INSERT INTO Department (name, location) VALUES (?, ?)";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setString(1, this.name);
        ps.setString(2, this.location);
        ps.executeUpdate();
    }

    // Method to edit an existing department in the database
    public void editDepartment(int id, String newName, String newLocation) throws SQLException {
        String sql = "UPDATE Department SET name = ?, location = ? WHERE id_Department = ?";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setString(1, newName);
        ps.setString(2, newLocation);
        ps.setInt(3, id);
        ps.executeUpdate();
    }

    // Method to delete a department from the database
    public void deleteDepartment(int id) throws SQLException {
        String sql = "DELETE FROM Department WHERE id_Department = ?";
        PreparedStatement ps = connect_db().prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    // Method to display all departments from the database
    public void displayDepartments() throws SQLException {
        String sql = "SELECT * FROM Department";
        ResultSet rs = connect_db().createStatement().executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id_Department");
            String name = rs.getString("name");
            String location = rs.getString("location");
            System.out.println("ID: " + id + ", Name: " + name + ", Location: " + location);
        }
    }
    //create table org.example.college.modeles.Department
    public void createTableDepartment() throws SQLException {
        try (Connection connection = connect_db()) {
            String sql = "CREATE TABLE IF NOT EXISTS Department (" +
                    "id_Department INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "name TEXT," +
                    "location TEXT" +
                    ");";
            connection.createStatement().execute(sql);
        }
    }

}