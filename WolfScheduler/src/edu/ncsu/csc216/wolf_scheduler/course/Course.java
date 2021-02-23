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
		this.name = name;
		this.title = title;
		this.section = section;
		this.credits = credits;
		this.instructorId = instructorId;
		this.meetingDays = meetingDays;
		this.startTime = startTime;
		this.endTime = endTime;
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
		this.name = name;
		this.title = title;
		this.section = section;
		this.credits = credits;
		this.instructorId = instructorId;
		this.meetingDays = meetingDays;
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
	public void setName(String name) {
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
		this.meetingDays = meetingDays;
	}
	/**
	 * @return the startTime
	 */
	public int getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public int getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}


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
		return name + "," + title + "," + section + "," + credits + "," + instructorId + "," + meetingDays;
	}
}
