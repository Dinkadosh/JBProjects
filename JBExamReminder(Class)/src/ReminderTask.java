import java.util.Date;
import java.util.TreeSet;

public class ReminderTask implements Runnable {
	private TreeSet<Reminder> reminders;
	private boolean isRun;

	public ReminderTask(TreeSet<Reminder> reminders) {
		this.reminders = reminders;
		this.isRun = true;
	}

	@Override
	public void run() {
		while (isRun) {
			try {
				for (Reminder reminder : reminders) {
					if (reminder.getExpiration().getTime().before(new Date())) {
						reminder.setPoped(true);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	public TreeSet<Reminder> getReminders() {
		return reminders;
	}

	public void setReminders(TreeSet<Reminder> reminders) {
		this.reminders = reminders;
	}

	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}

}
