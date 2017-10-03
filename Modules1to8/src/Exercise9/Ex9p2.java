package Exercise9;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Ex9p2 {
	public static void main(String[] args) {
		int currentYear = LocalDate.now().getYear();

		LocalDate christmasNextYear = LocalDate.of(currentYear+1,12,24);
		LocalDate currentDate = LocalDate.now();

		System.out.println("Next years christmas: " + christmasNextYear);
		System.out.println("Current date: " + currentDate);

		//Lets get the period between these two days
		Period per = Period.between(currentDate, christmasNextYear);
		System.out.println("");
		System.out.printf("Next years chrismas is in %d years %d months and %d days\n",
						  per.getYears(),per.getMonths(), per.getDays());

		//Lets get the total number of days
		long totaldays = ChronoUnit.DAYS.between(currentDate, christmasNextYear);
		System.out.println("A total of " + totaldays + " days!");
	}
}
