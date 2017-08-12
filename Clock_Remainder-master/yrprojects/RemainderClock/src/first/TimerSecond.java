package first;

import java.util.Timer;
import java.util.TimerTask;

public class TimerSecond {

	static int secondPassed = 0;

	static Timer myTimer = new Timer();
	static TimerTask task = new TimerTask() {
		public void run() {
			secondPassed++;
			//System.out.println("Second Passed: " + secondPassed);
			if (Calculation.distance == secondPassed) {
				FinishPanel.showScreen();
				myTimer.cancel();
			}
		}
	};

	public static void start() {
		myTimer.scheduleAtFixedRate(task, 1000, 1000);
	}
}
