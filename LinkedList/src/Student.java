/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hojjat
 */
public class Student {
    String name;
    String ID;
    //true:mail  false:female
    boolean sex;
    int grade;

    public Student(String name, String ID, boolean sex, int grade) {
        this.name = name;
        this.ID = ID;
        this.sex = sex;
        this.grade = grade;
    }
    
    public void print(){
        System.out.println("-name: " + name + "   -ID: " + ID + "   -sex: " + (sex ? "male" : "female") + "   -grade: " + grade);
    }
}
