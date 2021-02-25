/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.scheduler;

import java.io.IOException;
import java.util.ArrayList;

import edu.ncsu.csc216.wolf_scheduler.course.Course;
import edu.ncsu.csc216.wolf_scheduler.io.CourseRecordIO;

/**
 * @author Sifuentes11
 *
 */
public class WolfScheduler {
	
	ArrayList<Course> catalog;
	ArrayList<Course> schedule;
	String title;
	
	
	

	public WolfScheduler(String fileName) {
		// TODO Auto-generated constructor stub
		catalog = new ArrayList<Course>();
		schedule = new ArrayList<Course>();
		title = "My Schedule";
		
		try {
			catalog = CourseRecordIO.readCourseRecords(fileName);
		} catch (Exception e){
			throw new IllegalArgumentException("Cannot find file.");
		}
		
	}

	public String[][] getCourseCatalog() {
		// TODO Auto-generated method stub
		
		String[][] resultCatalog = new String[catalog.size()][3]; 
		
		for (int i = 0; i < catalog.size(); i++) {
			
	
			resultCatalog[i][0] = catalog.get(i).getName();
			resultCatalog[i][1] = catalog.get(i).getSection();
			resultCatalog[i][2] = catalog.get(i).getTitle();
			
		}
		
		return resultCatalog;
	}

	public String[][] getScheduledCourses() {
		// TODO Auto-generated method stub
		
		String[][] resultSchedule = new String[schedule.size()][3]; 
		
		for (int i = 0; i < schedule.size(); i++) {
			
	
			resultSchedule[i][0] = schedule.get(i).getName();
			resultSchedule[i][1] = schedule.get(i).getSection();
			resultSchedule[i][2] = schedule.get(i).getTitle();
			
		}
		
		return resultSchedule;
		
		
	}

	public String[][] getFullScheduledCourses() {
		// TODO Auto-generated method stub
		String[][] resultSchedule = new String[schedule.size()][6]; 
		
		for (int i = 0; i < schedule.size(); i++) {
			
	
			resultSchedule[i][0] = schedule.get(i).getName();
			resultSchedule[i][1] = schedule.get(i).getSection();
			resultSchedule[i][2] = schedule.get(i).getTitle();
			resultSchedule[i][3] = schedule.get(i).getCredits() + "";
			resultSchedule[i][4] = schedule.get(i).getInstructorId();
			resultSchedule[i][5] = schedule.get(i).getMeetingString();
			
		}
		
		return resultSchedule;
		
		
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		
		
		
		return title;
	}
	
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
		if (title == null) {
			throw new IllegalArgumentException("Title cannot be null.");
		}
		
		this.title = title;

	}

	public void exportSchedule(String fileName) {
		// TODO Auto-generated method stub
		
		try {
			
			CourseRecordIO.writeCourseRecords(fileName, schedule);
			
		} catch (IOException e) {
			throw new IllegalArgumentException("The file cannot be saved.");
		}
		
		
	}

	public Course getCourseFromCatalog(String courseName, String section) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).getName().equals(courseName) && catalog.get(i).getSection().equals(section)) {
				return catalog.get(i);
			}
		}
		
		return null;
	}

	public boolean addCourse(String courseName, String section) {
		// TODO Auto-generated method stub
		
		Course courseToAdd = getCourseFromCatalog(courseName, section);
		if (courseToAdd == null) {
			return false;
		}
		for (int i = 0; i < schedule.size(); i++) {
			if (schedule.get(i).getName().equals(courseName)) {
				throw new IllegalArgumentException("You are already enrolled in " + courseName);
			}
		
		}
	
		schedule.add(courseToAdd);
		
		return true;
	}
	
	
	

	public boolean removeCourse(String courseName, String section) {
		// TODO Auto-generated method stub

		
		for (int i = 0; i < schedule.size(); i++) {
			if (schedule.get(i).getName().equals(courseName) && schedule.get(i).getSection().equals(section)) {
				schedule.remove(schedule.get(i));
				return true;
			}
		
		}
	
		return false;
	}
	
	
	

	public void resetSchedule() {
		// TODO Auto-generated method stub
		
		
		schedule = new ArrayList<Course>();
		
	}

}
