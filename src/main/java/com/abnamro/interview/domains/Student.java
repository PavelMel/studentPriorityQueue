package com.abnamro.interview.domains;

/**
 * information about student
 * id - id of the student
 * name - name of student
 * cgpa - Cumulative Grade Point Average
 */
public class Student {
  private int id;
  private String name;
  private double cgpa;

  public Student(int id, String name, double cgpa) {
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }

  public int getID() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getCGPA() {
    return cgpa;
  }
}
