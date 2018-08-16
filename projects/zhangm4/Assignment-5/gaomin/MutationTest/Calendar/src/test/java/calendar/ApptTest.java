/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
          appt0.setValid();
          assertEquals(2, appt0.getRecurBy());
          assertFalse(appt0.isRecurring());
          assertEquals(0, appt0.getRecurIncrement());
          assertEquals("Birthday Party",appt0.getTitle());
          assertTrue(!appt0.getValid());
          String ab = appt0.toString();
         assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", ab);
         //System.out.println("\n\n\n");
         System.out.println(ab);
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
   Appt appt01 = new Appt(1, 1, 2018, "Birthday Party", "This is my birthday party", null);
   assertEquals(null, appt01.getXmlElement());

}
@Test(timeout = 4000)
 public void test02()  throws Throwable  {
  Appt appt0 = new Appt(56, 80, 90, 14, -5, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
  appt0.setStartMonth(1);
  appt0.setValid();
  assertEquals(80, appt0.getStartMinute());
  assertEquals("This is my birthday party", appt0.getDescription());
  assertEquals(1, appt0.getStartMonth());
  appt0.setStartMonth(-4);
  appt0.setValid();
  assertFalse(appt0.getValid());
  appt0.setStartMonth(18);
  appt0.setValid();
  assertFalse(appt0.getValid());
  appt0.setStartMonth(1);
  appt0.setValid();
  assertFalse(appt0.getValid());
  appt0.setStartHour(-9);
  appt0.setValid();
  assertFalse(appt0.getValid());
  appt0.setStartHour(89);
  appt0.setValid();
  assertFalse(appt0.getValid());
  appt0.setStartHour(1);
  appt0.setValid();
  assertFalse(appt0.getValid());
  appt0.setStartMinute(20);
  appt0.setValid();
  assertFalse(appt0.getValid());
  appt0.setStartYear(2018);
  appt0.setValid();
  appt0.setStartDay(1);
  appt0.setValid();
  appt0.setTitle(null);
  appt0.setDescription(null);
  assertEquals(1, appt0.getStartHour());
  assertEquals(20, appt0.getStartMinute());
  assertEquals(1, appt0.getStartDay());
  assertEquals(2018, appt0.getStartYear());
  assertEquals("", appt0.getDescription());
  assertEquals("xyz@gmail.com", appt0.getEmailAddress());
  assertTrue(appt0.isOn(1, 1, 2018));
  assertTrue(appt0.hasTimeSet());
  assertTrue(appt0.getValid());
  appt0.setStartMonth(12);
  appt0.setValid();
  assertTrue(appt0.getValid());
  appt0.setStartHour(23);
  appt0.setValid();
  assertTrue(appt0.getValid());
  appt0.setStartHour(0);
  appt0.setValid();
  assertTrue(appt0.getValid());
  appt0.setStartMinute(0);
  appt0.setValid();
  assertTrue(appt0.getValid());
  appt0.setStartYear(0);
  appt0.setValid();
  assertFalse(appt0.getValid());
  appt0.setStartYear(2018);
  appt0.setValid();
  assertTrue(appt0.getValid());
  appt0.setStartDay(1);
  appt0.setValid();
  assertTrue(appt0.getValid());
  appt0.setStartDay(3);
  appt0.setValid();
  assertTrue(appt0.getValid());
  appt0.setStartMinute(59);
  appt0.setValid();
  assertTrue(appt0.getValid());
  appt0.toString();
  int [] a = appt0.getRecurDays();
  appt0.setStartHour(0);
  appt0.toString();
  appt0.setStartHour(15);
  appt0.toString();
  int [] ab = new int[2];
  ab[0] = 2;
  ab[1] = 3;
  appt0.setRecurrence(ab, 1, 2,3);
  assertEquals(2, appt0.getRecurIncrement());
  assertEquals(3, appt0.getRecurNumber());
  assertEquals(ab, appt0.getRecurDays());

}
}
