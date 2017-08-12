package first;

import java.time.LocalDateTime;

public class GetDateAndTime {

	public static int localDay;
	public static int localHour;
	public static int localMinute;
	public static int localSecond;

	public void testLocalDateTime() {

		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();

		localDay = currentTime.getDayOfMonth();
		localHour = currentTime.getHour();
		localMinute = currentTime.getMinute();
		localSecond = currentTime.getSecond();

//		System.out.println(currentTime);
//		System.out.println(localSecond);
	}
}