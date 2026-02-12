/*
 * Name: Ryan Lee
 * Date: 02/12/2026
 * Program: Course Grades Analyzer - reads CSV grade totals and analyzes A percentages.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{

    static ArrayList<Course> courses = new ArrayList<Course>();


    public static void main(String[] args) {
        // Read the CSV file and populate the courses list
        try {
            File file = new File("courseAndGradesData.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String courseName = parts[0];
                ArrayList<Integer> courseGrades = new ArrayList<Integer>();
                for (int i = 1; i < parts.length; i++) {
                    courseGrades.add(Integer.parseInt(parts[i]));
                }
                courses.add(new Course(courseName, courseGrades));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter a command: ");
        boolean inCommand = true;
        String command = scnr.nextLine();

        while (inCommand != false) {
            if (command.equals("exit")) {
                inCommand = false;
            }

            if (command.equals("list")) {
                System.out.println("Course     A     B     C     D     F   Total    A%");
                for (Course course: courses) {
                System.out.print(course.getCourseName() + "  ");
                for (int grade : course.getCourseGrades()) {
                    System.out.print(grade + "   ");
                }
                System.out.println();
            }
            } else if (command.equals("best")) {

                Course best = courses.get(0);
                for (Course course: courses) {
                    if (course.getAPercent() > best.getAPercent()) {
                        best = course;
                    }
                }
                System.out.println("\nBest Course: " + best.getCourseName() + " with A%: " + best.getAPercent());
            } else if (command.equals("Course Search")) {
                System.out.println("Enter course name to search: ");
                String searchCourse = scnr.nextLine();
                //an array of strings with grades a-f
                String[] gradeLetters = {"A", "B", "C", "D", "F"};
                for (Course course: courses) {
                    if (searchCourse.equals(course.getCourseName())) {
                        System.out.println("\nCourse: " + course.getCourseName());
                        for (Course c : courses) {
                            if (c.getCourseName().equals(course.getCourseName())) {
                                for(int i = 0; i < gradeLetters.length; i++) {
                                    System.out.println(gradeLetters[i] + ": " + c.getCourseGrades().get(i));
                                }
                                //System.out.println(gradeLetters[i++] + ": " + c.getCourseGrades().get(i));
                                //System.out.println("A: " + c.getCourseGrades().get(0));
                                //System.out.println("B: " + c.getCourseGrades().get(1));
                                //System.out.println("C: " + c.getCourseGrades().get(2));
                               // System.out.println("D: " + c.getCourseGrades().get(3));
                                //System.out.println("F: " + c.getCourseGrades().get(4));
                            }
                        }
                        System.out.printf("A-Percentage: %.2f\n", course.getAPercent());
                }
            }
            } else {
                    System.out.println("Invalid command. Please enter 'list', 'best', or 'Course Search'.");
            }
    }
}
}