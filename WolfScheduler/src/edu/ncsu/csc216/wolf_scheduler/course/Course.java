package edu.ncsu.csc216.wolf_scheduler.course;

public class Course extends Activity {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** Course's name. */
    private String name;
	/** Course's section. */
    private String section;
	/** Course's credit hours. */
    private int credits;
	/** Course's instructor. */
    private String instructorId;
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
		super(title, meetingDays, startTime, endTime);
		setName(name);
		setSection(section);
		setCredits(credits);
		setInstructorId(instructorId);
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
	 * Returns a comma separated value String of all course fields.
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
		if (getMeetingDays().equals("A")) {
			return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," + getMeetingDays();
		}
		return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," + getMeetingDays() + "," + getStartTime() + "," + getEndTime();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + credits;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
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
		return true;
	}


	@Override
	public String[] getShortDisplayArray() {
		// TODO Auto-generated method stub
		String[] arr = {getName(), getSection(), getTitle(), getMeetingString()};
		
		return arr;
	}


	@Override
	public String[] getLongDisplayArray() {
		// TODO Auto-generated method stub
		String[] arr = {getName(), getSection(), getTitle(), getCredits() + "", getInstructorId(), getMeetingString(), ""};

		
		return arr;
	}
}
