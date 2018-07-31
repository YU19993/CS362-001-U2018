/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.Iterator;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    CalDay cal = new CalDay();
    assertFalse(cal.isValid());
    Iterator<?> gt;
    gt = cal.iterator();
    assertEquals(null, cal.getAppts());
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    GregorianCalendar cal1 = new GregorianCalendar();
    cal1.set(2018, 3, 27);
    CalDay cal = new CalDay(cal1);
    assertTrue(cal.isValid());
    assertEquals(2018, cal.getYear());
    assertEquals(4,  cal.getMonth());
    assertEquals(27, cal.getDay());
    Appt appt1 = new Appt(1, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt2 = new Appt(16, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt3 = new Appt(0, 56, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt0 = new Appt(56, 80, 90, 14, -5, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt0.setValid();
    appt1.setValid();
    cal.addAppt(appt0);
    assertEquals(0, cal.getSizeAppts());
    cal.addAppt(appt1);
    assertEquals(1, cal.getSizeAppts());
    cal.addAppt(appt2);
    assertEquals(2, cal.getSizeAppts());
    assertEquals(appt1, (Appt)(cal.getAppts().get(0)));
    assertEquals(2, cal.getSizeAppts());
    cal.addAppt(appt3);
    assertTrue(cal.isValid());
    int a = cal.getSizeAppts();
    a = cal.getDay();
    java.util.LinkedList <calendar.Appt> appts2;
    appts2= cal.getAppts();
    String convert;
		convert = cal.toString();
    Iterator<?> gt;
		gt = cal.iterator();
    String s = cal.getFullInfomrationApp( cal);

		//assertEquals(null, getit)

  }
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    GregorianCalendar cal1 = new GregorianCalendar();
    cal1.set(2018, 3, 27);
    CalDay cal = new CalDay(cal1);
    assertTrue(cal.isValid());
    assertEquals(2018, cal.getYear());
    assertEquals(4,  cal.getMonth());
    assertEquals(27, cal.getDay());
    Appt appt1 = new Appt(1, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt11 = new Appt(1, 10, 8, 7, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt2 = new Appt(16, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt3 = new Appt(0, 56, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt4 = new Appt(12, 56, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt0 = new Appt(56, 80, 90, 14, -5, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt0.setValid();
    appt1.setValid();
    cal.addAppt(appt0);
    assertEquals(0, cal.getSizeAppts());
    cal.addAppt(appt2);
    assertEquals(1, cal.getSizeAppts());
    cal.addAppt(appt1);
    assertEquals(2, cal.getSizeAppts());
    assertEquals(appt1, (Appt)(cal.getAppts().get(0)));
    assertEquals(2, cal.getSizeAppts());
    cal.addAppt(appt11);
    assertEquals(appt1, (Appt)(cal.getAppts().get(0)));
    cal.addAppt(appt3);
    assertTrue(cal.isValid());
    int a = cal.getSizeAppts();
    a = cal.getDay();
    java.util.LinkedList <calendar.Appt> appts2;
    appts2= cal.getAppts();
    String convert;
		convert = cal.toString();
    System.out.println("\n\n\n\n");
    System.out.println(convert);
    Iterator<?> gt;
		gt = cal.iterator();
    String s = cal.getFullInfomrationApp( cal);
    cal.addAppt(appt4);


    String convert1;
    convert = cal.toString();

   StringBuilder sb = new StringBuilder();
   String todayDate = (cal.getMonth()+1) + "/" + cal.getDay() + "/" + cal.getYear();
   sb.append("\t --- " + todayDate + " --- \n");
   sb.append(" --- -------- Appointments ------------ --- \n");
   Iterator<Appt> itr = cal.getAppts().iterator();
     while(itr.hasNext()) {
          Object element = itr.next();

          sb.append(element + " ");
       }

//			sb.append(this.appts);
   sb.append("\n");
   convert1 =  sb.toString();

   System.out.println("\n\n\n\n");
   System.out.println(convert1);
		//assertEquals(null, getit)
    assertEquals(convert1, convert);

    String buffer;    //test fullinfo
    String t2;

    Iterator itrr = ((CalDay)cal).iterator();
    buffer = Integer.toString(((CalDay)cal).getMonth())+ "-";
    buffer += Integer.toString(((CalDay)cal).getDay())+ "-";
    buffer += Integer.toString(((CalDay)cal).getYear())+ " ";

    Appt appointment;
    int minute;
    int hour;
    String minString;
    String meridianString;

    //go through the day and get the data to display
    while(itrr.hasNext()){

      buffer += "\n\t";

      appointment = (Appt)itrr.next();

  if(appointment.hasTimeSet()){

    //figure AM/PM notation
    hour = appointment.getStartHour();
    if(hour>12){
      meridianString = "PM";
    }
    else{
      meridianString = "AM";
    }

    //convert from 24 to 12 hour time
    if(hour == 0){
      hour = 12;
    }
    else{
      hour = hour%12;
    }

    //add preceding zero to minutes less than 10
    minute = appointment.getStartMinute();
    if(minute < 10){
      minString = new String("0" + Integer.toString(minute));
    }
    else{
      minString = Integer.toString(minute);
    }

    //create the string containing a data summary
    buffer += hour + ":" + minString + meridianString + " ";

  }
    buffer += appointment.getTitle()+ " ";
    buffer += appointment.getDescription()+ " ";
    }

    t2 = cal.getFullInfomrationApp(cal);
    assertEquals(buffer, t2);
    System.out.println(t2);

  }


}
