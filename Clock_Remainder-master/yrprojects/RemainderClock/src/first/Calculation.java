package first;

public class Calculation {

	public static int distance;

	public static void calculateDistance(String D, String H, String M) {

		Integer day = Integer.parseInt(D);
		Integer hour = Integer.parseInt(H);
		Integer minute = Integer.parseInt(M);
		
		//System.out.println(D + " " + H + " " + M);
		
		int DD = day - GetDateAndTime.localDay;
		int HH = hour - GetDateAndTime.localHour;
		int MM = minute - GetDateAndTime.localMinute;
		
		//System.out.println(DD + " " + HH + " " + MM);

		if (MM < 0) {
			MM += 60;
			HH--;
		}
		if (HH < 0) {
			HH += 24;
			DD--;
		}
		
		distance = ((DD*246000) + (HH*3600) + (MM*60)) - GetDateAndTime.localSecond;
		//System.out.println(distance);
		
		TimerSecond.start();
	}

}
