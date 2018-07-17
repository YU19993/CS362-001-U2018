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
    Iterator<?> gt;
    gt = cal.iterator();
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    GregorianCalendar cal1 = new GregorianCalendar();
    cal1.set(2018, 3, 27);
    CalDay cal = new CalDay(cal1);
    Appt appt1 = new Appt(1, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt2 = new Appt(16, 2, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt3 = new Appt(0, 56, 3, 3, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt0 = new Appt(56, 80, 90, 14, -5, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt0.setValid();
    appt1.setValid();
    cal.addAppt(appt0);
    cal.addAppt(appt1);
    cal.addAppt(appt2);
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

}
