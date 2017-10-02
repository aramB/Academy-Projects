package Exercise9;

import java.time.*;

public class Ex9p1 {
	public static void main(String[] args) {
		LocalDate lastRunDate = LocalDate.of(2016, 11, 11);
		LocalDate today = LocalDate.of(2016, 11, 16);
		if (lastRunDate.getDayOfMonth() - today.getDayOfMonth()<=7){
			System.out.println("Not time yet!");
		}
		else {
			System.out.println("Time to run again!");
		}
	}
}
