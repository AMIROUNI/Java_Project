package org.example.college;

import org.example.college.modeles.Course;
import org.example.college.modeles.Department;
import org.example.college.modeles.Teacher;

public class Main{
public static void main(String[] args)throws Exception{
    Department dep = new Department(1,"info","ariana");
    Teacher t =new Teacher("taher",dep);
     Course cour= new Course("amir",dep,t);
    cour.addCourse();

}
}