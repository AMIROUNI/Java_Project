package org.example.college;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modeles.Course;
import modeles.Department;
import modeles.Teacher;

import java.io.IOException;

public class Main{
public static void main(String[] args)throws Exception{
    Department dep = new Department(1,"info","ariana");
    Teacher t =new Teacher("taher",dep);
     Course cour= new Course("amir",dep,t);
    cour.addCourse();

}
}