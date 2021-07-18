package com.abnamro.interview;


import com.abnamro.interview.domains.Event;
import com.abnamro.interview.domains.Priorities;
import com.abnamro.interview.domains.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * read incoming events from System.in
 * and write result to System.out
 */
public class Main {

  private static final String SKIP_CHARACTERS = "(\r\n|[\n\r\u2028\u2029\u0085])?";
  private static final String DEFAULT_RESPONSE_EMPTY = "EMPTY";

  private static Scanner scanner= null;
  private final static Priorities priorities = new Priorities();


  public static void main(String[] arg){
    scanner = new Scanner(System.in);

    Integer countTests = getNextInteger();
    List<String> events = new ArrayList<>(countTests);

    for (int testNumber = 0; testNumber < countTests; testNumber++){
      String eventRepresentation = getNextString();
      events.add(eventRepresentation);
    }

    List<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println(DEFAULT_RESPONSE_EMPTY);
    } else {
      students.forEach(student -> {
        System.out.println(student.getName());
      });
    }

  }


  private static Integer getNextInteger(){
    Integer number = scanner.nextInt();
    scanner.skip(SKIP_CHARACTERS);

    return number;
  }

  private static String getNextString(){
    String line = scanner.nextLine();
    scanner.skip(SKIP_CHARACTERS);

    return line;
  }

}
