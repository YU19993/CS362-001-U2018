package calendar;


import org.junit.Test;
import java.util.Calendar;
import java.util.Random;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;
import org.junit.Test;
import java.util.GregorianCalendar;


/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
  		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

  		 System.out.println("Start testing...");

  		try{
  			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
 				long randomseed = System.currentTimeMillis(); //10
 				Random random = new Random(randomseed);

 		  		int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 25);
 		  		int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 60);
 		  		int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 32);
 		  		int startMonth=ValuesGenerator.getRandomIntBetween(random, -1, 13);
 		  		int startYear=ValuesGenerator.getRandomIntBetween(random, -1, 2200);
					Appt appt0 = new Appt(startHour, startMinute, startDay, startMonth, startYear, "Birthday", "This is a Birthday", "xyz@gmail.com");

					startHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
  		  	startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 60);
  		  	Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, "Birthday", "This is a Birthday", "xyz@gmail.com");

					startHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
					startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 60);
					Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, "Birthday", "This is a Birthday", "xyz@gmail.com");

					GregorianCalendar someday = new GregorianCalendar(startYear, startMonth, startDay);
					CalDay day0 = new CalDay(someday);
 	      	appt0.setValid();
 		  		appt1.setValid();
 		  		appt2.setValid();
 		  		day0.addAppt(appt0);
 	      	day0.addAppt(appt1);
 		  		day0.addAppt(appt2);

 				//show elapsed time
 				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
 			   	if((iteration%10000)==0 && iteration!=0 )
 					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
 			}

 		}catch(NullPointerException e){
 		}

 		System.out.println("Done testing...");


	 }



}
