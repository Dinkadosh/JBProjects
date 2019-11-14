import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class ReminderSystem {
	private TreeSet<Reminder> reminders = new TreeSet<>();
	private ReminderTask task;

	public ReminderSystem() {
		task = new ReminderTask(reminders);
		Thread thread = new Thread(task);
		thread.start();
	}

	public boolean addReminder(Reminder reminder) {
		reminders.add(reminder);
		return true;
	}

	public List<Reminder> getReminders() {
		List<Reminder> list = new ArrayList<>(reminders);
		return list;
	}

	public void reminderMenu() {
		System.out.println("==========REMINDER MENU==========");
		System.out.println("=1. Add reminder \t\t=");
		System.out.println("=2. Print list of reminders \t=");
		System.out.println("=3. Exit \t\t\t=");
		System.out.println("=================================");
		System.out.print("Please, enter the number: ");

		Scanner scanner = new Scanner(System.in);
		int enter = scanner.nextInt();

		while (true) {
			if (enter == 3) {
				task.setRun(false);
				scanner.close();
				return;
			}
			outerMenu:
			if (enter == 1) {
				System.out.println("Creating a new reminder");
				System.out.print("Enter the day: ");
				int day = scanner.nextInt();
				System.out.print("Enter the month: ");
				int month = scanner.nextInt();
				System.out.print("Enter the year: ");
				int year = scanner.nextInt();
				System.out.print("Enter the hour: ");
				int hour = scanner.nextInt();
				System.out.print("Enter the minutes: ");
				int minutes = scanner.nextInt();
				System.out.print("Enter the text: ");
				String text = scanner.next();
				System.out.print("The reminder is important? Y/N: ");
				String answer = scanner.next();
				boolean isImportant = answer.toLowerCase().equals("y") ? true : false;

				Reminder reminder = new Reminder(day, month, year, hour, minutes, text, isImportant);
				if (reminder.getExpiration().getTime().before(new Date())) {
					System.out.println("The date not allowed. Please try again.");
					break outerMenu;
				}
				boolean isExist = false;
				for (Reminder rem : reminders) {
					if (reminder.equals(rem)) {
						isExist = true;
					}
				}
				if (isExist) {
					System.out.println("The remind is already exist! Please try again.");
					break outerMenu;
				}
				if (reminder.isImportant()) {
					ImportantReminderTask importantTask = new ImportantReminderTask(reminder);
					Thread importantThread = new Thread(importantTask);
					importantThread.start();
				}
				reminders.add(reminder);
				System.out.println("The reminder is added.");
			}
			if (enter == 2) {
				System.out.println("The reminders list:");
				for (Reminder reminder : reminders) {
					System.out.println(reminder);
				}
			}
			System.out.print("Please, enter the number: ");
			enter = scanner.nextInt();
		}
	}

	public static void main(String[] args) {
		ReminderSystem reminderSystem = new ReminderSystem();
		reminderSystem.reminderMenu();
	}
}
