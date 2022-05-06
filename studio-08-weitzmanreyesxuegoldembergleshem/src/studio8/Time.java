package studio8;

import java.util.Objects;

public class Time {
	
	private int hour;
	private int minute;
	private boolean militaryTime;
	
	/**
	 * @param hour an hour, 0 through 23
	 * @param minute a minute, 0 through 59
	 * @param militaryTime whether or not we are displaying the time in a 24- or 12-hour format
	 */
	public Time (int hour, int minute, boolean militaryTime) {
		this.hour = hour;
		this.minute = minute;
		this.militaryTime = militaryTime;
	}
	
	public String toString () {
		int temphour = this.hour;
		if (!militaryTime) {
			if (this.hour > 12) {
				temphour =- 12;
			}
			return temphour + " : " + minute;
		}
		else {
			return this.hour + " : " + minute;
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(hour, minute);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hour == other.hour && minute == other.minute;
	}

	public static void main(String[] args) {
		Time rightNow = new Time(12, 01, false);
		
		
 
    }

}