package edu.ncsu.csc216.wolf_scheduler.course;

public abstract class Activity {

	/** Course's title. */
	private String title;
	/** Course's meeting days. */
	private String meetingDays;
	/** Course's starting time. */
	private int startTime;
	/** Course's ending time. */
	private int endTime;

	public Activity(String title, String meetingDays, int startTime, int endTime) {
		setTitle(title);
		setMeetingDays(meetingDays);
		setCourseTime(startTime, endTime);
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
	
	
	public abstract String[] getShortDisplayArray();
	public abstract String[] getLongDisplayArray();

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (endTime != other.endTime)
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
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

}




