package com.abnamro.interview.domains;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


/**
 * Class for processing incoming events using priority queue
 */
public class Priorities {

  private PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>( Comparator.comparing(Student::getCGPA).reversed()
                                                                                      .thenComparing(Student::getName)
                                                                                      .thenComparing(Student::getID));


  /**
   *  the method processes incoming events in string representation
   *  space complexity is the same as in processEvents() method
   *
   *  time complexity is  O(n) (iterate by collection) + O(n*log(n)) (processEvents() method)
   *  the additional time complexity of O(n) could be removed if we move incoming string transform to Main.main() method
   *
   * @param events incoming events  for adding to and removing from queue students
   * @return all the students yet to be served in the priority order.
   */
  public List<Student> getStudents(List<String> events) {
    return processEvents(events.stream().map(event -> new Event(event)).collect(Collectors.toList()));
  }

  /**
   *  the method processes incoming events
   *
   *  space complexity is O(n) - incoming List<Event> with n elements give O(n) space complexity
   *  and List<Student> at worst case will contain n elements and also give O(n) space complexity
   *  so in total we will get O(2n) space complexity, and according to the O transformation rules becomes O(n)
   *
   * time complexity is O(n*log(n)
   * as PriorityQueue is based on a priority heap in which add() and poll() methods cost O(log(n)).
   * We call this methods while first iteration over List<Event> and it gives O(n*log(n)) time complexity
   * and we call poll() method while constructing result and it gives also O(n*log(n))
   * so in total we get O(2n*log(n)) -> O(n*log(n))
   *
   * @param events incoming events  for adding to and removing from queue students
   * @return all the students yet to be served in the priority order.
   */
  public List<Student> processEvents(List<Event> events) {
    events.forEach( event -> {
      switch (event.getType()){
        case SERVED: studentPriorityQueue.poll();
                     break;
        case ENTER:  studentPriorityQueue.add(event.getStudent());
                     break;
      }
    });

    List<Student> students = new ArrayList<>();
    while (!studentPriorityQueue.isEmpty()) {
      students.add(studentPriorityQueue.poll());
    }

    return students;
  }
}
