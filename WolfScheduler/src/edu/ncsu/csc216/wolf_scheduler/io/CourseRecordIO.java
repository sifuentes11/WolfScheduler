/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_scheduler.course.Course;

/**
 * @author Sifuentes11
 *
 */
public class CourseRecordIO {

	public static ArrayList<Course> readCourseRecords(String fileName) throws FileNotFoundException{
		// TODO Auto-generated method stub
		
		Scanner fileReader = new Scanner( new FileInputStream(fileName));
		ArrayList<Course> courses = new ArrayList<Course>();
		
		
		while (fileReader.hasNextLine()) {
			try {
				Course course = readCourse(fileReader.nextLine());
				boolean duplicate = false;
				for (int i = 0; i < courses.size(); i++) {
					Course c = courses.get(i);
					if (course.getName().equals(c.getName()) && course.getSection().equals(c.getSection())) {
						duplicate = true;
					}
				}
				if (!duplicate) {
					courses.add(course);
				}
			} catch (IllegalArgumentException e) {

			}
		}

		fileReader.close();

		return courses;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	private static Course readCourse(String nextLine) {
		// TODO Auto-generated method stub
		
		
		try {
			Scanner fileReader = new Scanner(nextLine);
			fileReader.useDelimiter(",");
			String courseCode = fileReader.next();
			String description = fileReader.next();
			String section = fileReader.next();
			int hours = fileReader.nextInt();
			String instructorID = fileReader.next();
			String meetingDays = fileReader.next();
			if (meetingDays.equals("A") && fileReader.hasNext() == false) {
				
				fileReader.close();
				
				return new Course (courseCode, description, section, hours, instructorID, meetingDays);

			}
			
			int startTime = fileReader.nextInt();
			int endTime = fileReader.nextInt();
			
			fileReader.close();
			
			return new Course (courseCode, description, section, hours, instructorID, meetingDays, startTime, endTime);
			
		
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException();
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void writeCourseRecords(String fileName, ArrayList<Course> courses) throws IOException {
		// TODO Auto-generated method stub
		
		PrintStream fileWriter = new PrintStream(new File(fileName));
		
		for (int i = 0; i < courses.size(); i++) {
			fileWriter.println(courses.get(i).toString());
		}
		
		fileWriter.close();
		
	}

}
