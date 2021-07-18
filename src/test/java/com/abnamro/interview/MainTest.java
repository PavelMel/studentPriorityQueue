package com.abnamro.interview;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;
  private final InputStream originalIn = System.in;

  @Before
  public void setUpStreams() throws Exception{
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));

  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
    System.setIn(originalIn);
  }



  @Test
  public void main() throws Exception{

    String expectedOutput = "Dan\n" +
                            "Ashley\n" +
                            "Shafaet\n" +
                            "Maria\n";

    File initialFile = new File("src/test/resources/testInput.txt");
    InputStream inputStream = new FileInputStream(initialFile);
    System.setIn(inputStream);

    Main.main(null);

    assertEquals(expectedOutput, outContent.toString());

    System.setIn(originalIn);

  }
}