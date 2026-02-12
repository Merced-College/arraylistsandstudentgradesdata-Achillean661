/*
 * Name: Ryan Lee
 * Date: 02/12/2026
 * Program: Course Grades Analyzer - reads CSV grade totals and analyzes A percentages.
 */

import java.util.ArrayList;

public class Course{
    
    // Identification for course name and array list for course grades
    private String courseName;
    private ArrayList<Integer> courseGrades;

    public Course(String courseName, ArrayList<Integer> courseGrades) {
        this.courseName = courseName;
        this.courseGrades = courseGrades;
    }

    public void setCourse(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseGrades(ArrayList<Integer> courseGrades) {
        this.courseGrades = courseGrades;
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<Integer> getCourseGrades() {
        return courseGrades;
    }

    //sumOf{A+B+C+D+F} 
    public int getTotalGrades() {
        int total = 0;
        for (int value : courseGrades) {
            total += value;
        }
        return total;
    }

    public double getAPercent() {
        int total = getTotalGrades();
        if (total == 0) 
        return 0.0;
        return (double) courseGrades.get(0) / total * 100.0;
    }

}