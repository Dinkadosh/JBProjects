import java.util.Date;

public class ImportantReminderTask implements Runnable {
	private Reminder reminder;
	private boolean isRun;

	public ImportantReminderTask(Reminder reminder) {
		this.reminder = reminder;
		this.isRun = true;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			if (reminder.getExpiration().getTime().after(new Date())) {
				System.out.println("\n!!!IMPORTANT!!! " + reminder);
			}
			try {
				Thread.sleep(1000 * 60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}

}
