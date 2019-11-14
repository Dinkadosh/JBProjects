import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reminder implements Comparable<Reminder> {
	private Calendar expiration;
	private String text;
	private boolean important;
	private boolean poped;

	public Reminder(int day, int month, int year, int hour, int minute, String text, boolean important) {
		this.expiration = Calendar.getInstance();
		this.expiration.set(year, month, day, hour, minute);
		this.text = text;
		this.important = important;
		this.poped = false;
	}

	public Calendar getExpiration() {
		return expiration;
	}

	public void setExpiration(Calendar expiration) {
		this.expiration = expiration;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public boolean isPoped() {
		return poped;
	}

	public void setPoped(boolean poped) {
		this.poped = poped;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiration == null) ? 0 : expiration.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + (important ? 1231 : 1237);
		result = prime * result + (poped ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reminder other = (Reminder) obj;
		if (expiration == null) {
			if (other.expiration != null)
				return false;
		} else if (!expiration.equals(other.expiration))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (important != other.important)
			return false;
		if (poped != other.poped)
			return false;
		return true;
	}

	@Override
	public int compareTo(Reminder rem) {
		int result = expiration.compareTo(rem.expiration);
		if (result != 0) {
			return result;
		} else {
			return text.compareToIgnoreCase(rem.getText());
		}
	}

	@Override
	public String toString() {
		String dateFormat = new SimpleDateFormat(".h").format(expiration.getTime());
		return "Date: " + dateFormat + ", text: " + text + (important ? ", Important!!!" : ", not important")
				+ (poped ? ", not active" : ", active");
	}

}
