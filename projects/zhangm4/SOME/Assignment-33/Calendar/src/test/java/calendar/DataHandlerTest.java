
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import java.util.*;
import java.io.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    DataHandler dataH = new DataHandler();
    GregorianCalendar cal1 = new GregorianCalendar();
    cal1.set(2018, 1, 27);
    GregorianCalendar cal2 = new GregorianCalendar();
    cal2.set(2018, 3, 27);
    List<CalDay> temp;
    assertTrue(dataH.getApptRange(cal1, cal2, false)!= null);
    temp = dataH.getApptRange(cal1, cal2, false);
    //temp = dataH.getApptRange(cal1, cal2, false);
    System.out.println("\n\n\n\n");
    System.out.println(temp.size());
    assertEquals(59, temp.size());
    assertTrue(dataH.getApptRange(cal1, cal2, false)!= null);
    temp = dataH.getApptRange(cal1, cal2, false);
    //temp = dataH.getApptRange(cal1, cal2, false);
    System.out.println("\n\n\n\n");
    System.out.println(temp.size());
    assertEquals(59, temp.size());
    Appt appt1 = new Appt(1, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt2 = new Appt(1, 2, 3, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertTrue(dataH.saveAppt(appt1));
    assertTrue(dataH.saveAppt(appt2));
    temp = dataH.getApptRange(cal1, cal2, false);
    System.out.println("\n\n\n\n");
    System.out.println(temp.size());
    System.out.println(temp.get(0).getDay());
    assertEquals(59, temp.size());
    assertEquals(27, temp.get(0).getDay());
    assertTrue(dataH.deleteAppt(appt1));
    Appt appt0 = new Appt(56, 80, 90, 14, -5, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertFalse(dataH.deleteAppt(appt0));
    assertTrue(dataH.saveAppt(appt0));

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    DataHandler dataH = new DataHandler("Birth Day", false);
    GregorianCalendar cal1 = new GregorianCalendar();
    cal1.set(2018, 1, 27);
    GregorianCalendar cal2 = new GregorianCalendar();
    cal2.set(2018, 3, 27);
    List<CalDay> temp;
    dataH.save();
    Appt appt1 = new Appt(1, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt2 = new Appt(1, 2, 3, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    int[] arr = new int[3];
    arr[0] = 1;
    arr[1] = 5;
    arr[2] = 9;
    appt1.setRecurrence(arr, 1, 1, 2);
    dataH.saveAppt(appt1);
    dataH.saveAppt(appt2);
    temp = dataH.getApptRange(cal1, cal2, true);
    dataH.deleteAppt(appt1);
    dataH.deleteAppt(appt1);
    Appt appt0 = new Appt(56, 80, 90, 14, -5, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt0.setValid();
    dataH.deleteAppt(appt0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    DataHandler dataH = new DataHandler("Birth Day", false);
    GregorianCalendar cal1 = new GregorianCalendar();
    cal1.set(2018, 1, 27);
    GregorianCalendar cal2 = new GregorianCalendar();
    cal2.set(2018, 3, 27);
    List<CalDay> temp;
    Appt appt0 = new Appt(56, 80, 90, 14, -5, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt0.setValid();
    Appt appt1 = new Appt(1, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setValid();
    dataH.saveAppt(appt1);
    temp = dataH.getApptRange(cal1, cal2, true);
    assertFalse(dataH.deleteAppt(appt0));
    assertTrue(dataH.deleteAppt(appt1));
    Appt appt3 = new Appt(1, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt2 = new Appt(1, 2, 3, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertTrue(dataH.saveAppt(appt3));
    assertTrue(dataH.saveAppt(appt2));
  }



}
