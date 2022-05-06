package studio8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Date {
	
	private int month;
	private int day;
	private int year;
	private boolean holiday;
	
	
	/**
	 * @param month a month, 1 through 12
	 * @param day a day, 1 through 31
	 * @param year a year
	 * @param holiday whether or not the day is a holiday
	 */
	 
	public Date (int month, int day, int year, boolean holiday) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.holiday = holiday;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}

	public String toString() {
		if (holiday) {
			return month + " / " + day + " / " + year + " is a holiday.";
		}
		else {
			return month + " / " + day + " / " + year + " is not a holiday.";
		}
	}
	


    public static void main(String[] args) {
    	Date hugoBday = new Date(8, 19, 1997, true);
    	Date elieBday = new Date(5, 28, 2003, true);
    	Date randomDay = new Date(8, 19, 1997, false);
    	Date judahBday = new Date(3, 18, 2002, true);
    	Date bestDay = new Date(4, 20, 1969, true);
    	LinkedList<Date> list = new LinkedList<Date>();
    	list.add(bestDay);
    	list.add(judahBday);
    	list.add(randomDay);
    	list.add(elieBday);
    	list.add(hugoBday);
    	list.add(bestDay);
    	HashSet<Date> set = new HashSet<Date>();
    	set.add(bestDay);
    	set.add(elieBday);
    	set.add(judahBday);
    	set.add(bestDay);
    	System.out.println(hugoBday.equals(elieBday));
    	System.out.println(hugoBday.equals(randomDay));
    	System.out.println(list);
    	System.out.println(set);
    }

}
