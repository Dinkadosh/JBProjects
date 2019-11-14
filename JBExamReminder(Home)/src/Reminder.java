import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reminder implements Comparable<Reminder> {
	private Calendar expiration;
	private String text;
	private boolean important;
	private boolean poped;

	public Reminder(int day, int month, int year, int hour, int minute, String text, boolean important) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		Date date = null;
		try {
			date = dateFormat.parse(year + "-"+month+"-"+day+" "+hour+":"+minute);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.expiration = Calendar.getInstance();
		expiration.setTime(date);
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
	public int compareTo(Reminder rem) {
		int result = this.expiration.compareTo(rem.expiration);
		if (result != 0) {
			return result;
		} else {
			return this.text.compareToIgnoreCase(rem.getText());
		}
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
		if (this.expiration == null) {
			if (other.expiration != null)
				return false;
		} else if (!this.expiration.equals(other.expiration))
			return false;
		if (this.important != other.important)
			return false;
		if (this.poped != other.poped)
			return false;
		if (this.text == null) {
			if (other.text != null)
				return false;
		} else if (!this.text.equals(other.text))
			return false;
		return true;
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
	public String toString() {
		String dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(expiration.getTime());
		return "Date: " + dateFormat + ", text: " + text + (important ? ", Important!!!" : ", not important")
				+ (poped ? ", not active" : ", active");
	}

}
