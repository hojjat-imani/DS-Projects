
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hojjat
 */
public class Controller {

    LinkedList<Student> list;
    Scanner inputReader;
    String input;

    public Controller() {
        list = new LinkedList<>();
        inputReader = new Scanner(System.in);
    }

    public void Loop() {
        while (true) {
            printValidCommands();
            System.out.print("Enter Command ->");
            input = inputReader.next();
            if (input.equalsIgnoreCase("new")) {
                addNewStudent();
            } else if (input.equalsIgnoreCase("list")) {
                list.print();
            } else if (input.equalsIgnoreCase("search")) {
                search();
            }else if(input.equalsIgnoreCase("exit")){
                System.exit(0);
            } else {
                System.out.println("invalid!");
            }
        }
    }

    private void printValidCommands() {
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.println("Valid Commands: ");
        System.out.println("\"new\" : Add new student data.");
        System.out.println("\"list\" : Print students List.");
        System.out.println("\"search\" : Search a grade.");
        System.out.println("\"exit\" : Exit.");
        System.out.println("---------------------------------------");
        System.out.println("");

    }

    private void addNewStudent() {
        int grade = 20;
        boolean sex = false;
        System.out.println("");
        System.out.print("Enter student name ->");
        String name = inputReader.next();
        System.out.print("Enter student ID ->");
        String ID = inputReader.next();
        System.out.print("Enter student sex (\"male\":male other:female) ->");
        input = inputReader.next();
        if (input.equalsIgnoreCase("male")) {
            sex = true;
        }
        System.out.print("Enter student grade (an integer in [0, 20] ) ->");
        try {
            grade = inputReader.nextInt();
        } catch (Exception e) {
            System.out.println("invalid input! 20 saved for student! :-D");
        }
        grade = (grade > 20 ? 20 : (grade < 0 ? 0 : grade));
        Student student = new Student(name, ID, sex, grade);
        list.add(student);
        System.out.println("student added!");
        System.out.println("");
    }

    private void search() {
        int grade = -1;
        System.out.print("Enter a grade to search (an integer in [0, 20]) ->");
        try {
            grade = inputReader.nextInt();
            grade = (grade > 20 ? 20 : (grade < 0 ? 0 : grade));
        } catch (Exception e) {
            System.out.println("invalid");
        }
        if (grade != -1) {
            System.out.println("Result: ");
            if (list.show(grade)) {
                System.out.println("No one has this grade!");
            }
        } else {
            return;
        }
        while (true) {
            System.out.print("Enter Command (next, prev, enough) ->");
            input = inputReader.next();
            if (input.equalsIgnoreCase("next")) {
                System.out.println("Result: ");
                int newGrade = list.showNext(grade);
                if (newGrade == grade) {
                    System.out.println("No next grade!");
                } else {
                    grade = newGrade;
                }
            } else if (input.equalsIgnoreCase("prev")) {
                System.out.println("Result: ");
                int newGrade = list.showPrev(grade);
                if (newGrade == grade) {
                    System.out.println("No previous grade!");
                } else {
                    grade = newGrade;
                }
            } else if (input.equalsIgnoreCase("enough")) {
                break;
            } else {
                System.out.println("invalid!");
            }
        }
    }
}
