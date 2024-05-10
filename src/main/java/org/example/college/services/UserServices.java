package org.example.college.services;

import org.example.college.modeles.Student;
import org.example.college.interfaces.CRUDInterface;


import java.sql.SQLException;
import java.util.ArrayList;

public class UserServices implements CRUDInterface<Student> {

    @Override
    public void add(Student student) throws SQLException {

    }

    @Override
    public ArrayList<Student> getAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Student student) throws SQLException {

    }

    @Override
    public void delete(String t) throws SQLException {

    }
}
