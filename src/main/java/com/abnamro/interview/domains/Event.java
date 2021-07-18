package com.abnamro.interview.domains;


/**
 * Event of student's operation
 */
public class Event {
  private static final String DELIMITER = " ";

  private EventType type;
  private Student student;

  public Event(EventType type, Student student) {
    this.type = type;
    this.student = student;
  }

  public Event(String eventRepresentation) {
    String[] eventParts = eventRepresentation.split(DELIMITER);
    this.type = EventType.valueOf(eventParts[0]);
    if (this.type == EventType.ENTER){
      this.student = new Student(Integer.parseInt(eventParts[3]), eventParts[1], Double.parseDouble(eventParts[2]));
    }
  }

  public EventType getType() {
    return type;
  }

  public Student getStudent() {
    return student;
  }
}
