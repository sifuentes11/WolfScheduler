package edu.ncsu.csc216.wolf_scheduler.course;

public class Course {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** Course's name. */
    private String name;
	/** Course's title. */
    private String title;
	/** Course's section. */
    private String section;
	/** Course's credit hours. */
    private int credits;
	/** Course's instructor. */
    private String instructorId;
	/** Course's meeting days. */
    private String meetingDays;
	/** Course's starting time. */
    private int startTime;
	/** Course's ending time. */
    private int endTime;
    
    
	/**
	 * Constructs a Course object with values for all fields.
	 * @param name
	 * @param title
	 * @param section
	 * @param credits
	 * @param instructorId
	 * @param meetingDays
	 * @param startTime
	 * @param endTime
	 */
	public Course(String name, String title, String section, int credits, String instructorId,
			String meetingDays, int startTime, int endTime) {
		setName(name);
		setTitle(title);
		setSection(section);
		setCredits(credits);
		setInstructorId(instructorId);
		setMeetingDays(meetingDays);
		setCourseTime(startTime, endTime);
	}
	
	
	/**
	 * Create a Course with the given name, title, section, credits, instructorId, and 
	 * meeting days for courses that are arranged.
	 * @param name
	 * @param title
	 * @param section
	 * @param credits
	 * @param instructorId
	 * @param meetingDays
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays) {
		this(name, title, section, credits, instructorId, meetingDays, 0, 0);
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		
		if (name.length() < 4 || name.length() > 6) {
			throw new IllegalArgumentException();
		}
		
		
		this.name = name;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		
		
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException();
		}
		
		if (title.length() == 0) {
			throw new IllegalArgumentException();
		}
		
		this.title = title;
	}
	
	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}
	
	/**
	 * @param section the section to set
	 */
	public void setSection(String section) {
		if (section == null) {
			throw new IllegalArgumentException();
		}
		
		if (section.length() != 3) {
			throw new IllegalArgumentException();
		}
		
		this.section = section;
	}
	
	/**
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}
	/**
	 * @param credits the credits to set
	 */
	public void setCredits(int credits) {
		
		if (credits < 1 || credits > 5) {
			throw new IllegalArgumentException();
		}
		
		this.credits = credits;
	}
	/**
	 * @return the instructorId
	 */
	public String getInstructorId() {
		return instructorId;
	}
	/**
	 * @param instructorId the instructorId to set
	 */
	public void setInstructorId(String instructorId) {
		
		if (instructorId == null || instructorId.length() == 0) {
			throw new IllegalArgumentException();
		}
		
		this.instructorId = instructorId;
	}
	/**
	 * @return the meetingDays
	 */
	public String getMeetingDays() {
		return meetingDays;
	}
	/**
	 * @param meetingDays the meetingDays to set
	 */
	public void setMeetingDays(String meetingDays) {
				
		if (meetingDays == null || meetingDays.length() == 0) {
			throw new IllegalArgumentException();
		}
		
//		if (meetingDays.matches("^[MTWHFA]")) {   REGULAR EXPRESSIONS???
//			throw new IllegalArgumentException();
//		}
		
		for (int i = 0; i < meetingDays.length(); i++) {
			if (!(meetingDays.charAt(i) == 'M' || meetingDays.charAt(i) == 'T' || meetingDays.charAt(i) == 'W' 
					|| meetingDays.charAt(i) == 'H' || meetingDays.charAt(i) == 'F' || meetingDays.charAt(i) == 'A')) {
				throw new IllegalArgumentException();
			}
			
			if (meetingDays.charAt(i) == 'A' && meetingDays.length() > 1) {
				throw new IllegalArgumentException();
			}
		}
		
		this.meetingDays = meetingDays;
		
	}
	/**
	 * @return the startTime
	 */
	public int getStartTime() {
		return startTime;
	}
	
	
//	/**
//	 * @param startTime the startTime to set
//	 */
//	public void setStartTime(int startTime) {
//		
//		if (startTime < 0 || startTime > 2359 || (meetingDays.equals("A") && startTime != 0 && endTime != 0)) {
//			throw new IllegalArgumentException();
//		}
//		
//		this.startTime = startTime;
//	}
	
	
	/**
	 * @return the endTime
	 */
	public int getEndTime() {
		return endTime;
	}
	
	
	public void setCourseTime(int startTime, int endTime) {
		
		if ((startTime % 100 ) > 59 
				|| (endTime % 100 ) > 59 
				|| startTime < 0 
				|| startTime > 2359 
				|| endTime < 0 
				|| endTime > 2359 
				|| startTime > endTime
				|| (meetingDays.equals("A") && startTime != 0 && endTime != 0)) {
			throw new IllegalArgumentException();
		}
		
		this.startTime = startTime;
		this.endTime = endTime;
		
		
	}
	
	public String getMeetingString() {
		
	
		if (meetingDays.equals("A")) {
			return "Arranged";
		}
		
		int hour1 = startTime / 100;
		String suffix1 = "AM";
		if (hour1 > 12) {
			hour1 = hour1 - 12;
			suffix1 = "PM";
		}
		if (hour1 == 0) {
			hour1 = 12;
		}
		int minutes1 = startTime % 100;
		String minutes1Str = minutes1 + "";
		if (minutes1Str.equals("0")) {
			minutes1Str = "00";
		}
		
		int hour2 = endTime / 100;
		String suffix2 = "AM";
		if (hour2 > 12) {
			hour2 = hour2 - 12;
			suffix2 = "PM";
		}
		if (hour2 == 0) {
			hour2 = 12;
		}
		
		int minutes2 = endTime % 100;
		String minutes2Str = minutes2 + "";
		if (minutes2Str.equals("0")) {
			minutes2Str = "00";
		}
		
		return meetingDays + " " + hour1 + ":" + minutes1Str + suffix1 + "-" + hour2 + ":" + minutes2Str + suffix2;
		
		
		
	}
	
	
	
//	/**
//	 * @param endTime the endTime to set
//	 */
//	public void setEndTime(int endTime) {
//		
//		if (endTime < 0 || endTime > 2359 || endTime < startTime || (meetingDays.equals("A") && startTime != 0 && endTime != 0)) {
//			throw new IllegalArgumentException();
//		}
//		
//		this.endTime = endTime;
//	}


	/** 
	 *Generates a hashCode for Course using all fields.
	 * @return hashCode for Course
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + endTime;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	/**
	 * Compares a given object to this object for equality on all fields.
	 * @param obj the object to compare
	 * @return true if the objects are the same on all fields
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (endTime != other.endTime)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (startTime != other.startTime)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
		
	}
	
	/**
	 * Returns a comma separated value String of all course fields.
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
		if (meetingDays.equals("A")) {
			return name + "," + title + "," + section + "," + credits + "," + instructorId + "," + meetingDays;
		}
		return name + "," + title + "," + section + "," + credits + "," + instructorId + "," + meetingDays + "," + startTime + "," + endTime;
	}
}
