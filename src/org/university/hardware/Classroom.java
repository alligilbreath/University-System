package org.university.hardware;

import java.util.ArrayList;
import java.util.Collections;

//import org.university.people.*;
import org.university.software.*;

public class Classroom {
	private String roomNumber;
	private ArrayList<CampusCourse> courses = new ArrayList<CampusCourse>();
	private ArrayList<Integer> schedule = new ArrayList<Integer>();
	private String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	private String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	public Classroom() {
		roomNumber = "unknown Classroom";
	}
	//getters
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public ArrayList<Integer> getSchedule(){
		return schedule;
	}
	
	public ArrayList<CampusCourse> getCourses(){
		return courses;
	}
	
	//setters
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public void setSchedule(ArrayList<Integer> schedule) {
		this.schedule = schedule;
	}
	
	public void setCourses(ArrayList<CampusCourse> courses) {
		this.courses = courses;
	}
	
	//detect course conflict
	public boolean detectConflict(CampusCourse aCourse) {
		boolean detectedConflict = false;
		Integer classroomVal = 0;
		Integer aCourseVal = 0;
		for(int i = 0; i < courses.size(); i++) {
			for(int j = 0; j < (courses.get(i)).getSchedule().size(); j++) {
				for(int k = 0; k < aCourse.getSchedule().size(); k++) {
					//System.out.println("ACTUAL Student schedule val: " + (courses.get(i)).getSchedule().get(j));
					//System.out.println("ACTUAL aCourse schedule val: " + aCourse.getSchedule().get(k));
					classroomVal = (courses.get(i).getSchedule().get(j));
					aCourseVal = aCourse.getSchedule().get(k);
					//System.out.println("Student schedule val: " + studentVal);
					//System.out.println("aCourse schedule val: " + aCourseVal);
					if(classroomVal.equals(aCourseVal) && !(courses.get(i).getName().equals(aCourse.getName()))) {
						System.out.print(aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " conflicts with " + courses.get(i).getDepartment().getDepartmentName() + courses.get(i).getCourseNumber() + ".");
						System.out.print(" Conflicting time slot " + courses.get(i).convertIntToString(aCourse.getSchedule().get(k)) + ".");
						System.out.println(" " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " course cannot be added to " + this.getRoomNumber() + "'s Schedule.");
						detectedConflict = true;
					}
				}
			}
		}
		return detectedConflict;
	}
	//add
	public void addCourse(CampusCourse newCourse) {
		boolean conflicts = detectConflict(newCourse);
		if(conflicts == false)
		{
			courses.add(newCourse);
			newCourse.setClassroom(this);
		}
	}
	
	public String convertIntToString(Integer aInt) {
		int hundreth = aInt / 100;
		int ones = aInt % 10;
		String myString = Week[hundreth - 1] + " " + Slot[ones - 1];
		return myString;
	}
	
	//TODO: printSchedule
	public void printSchedule() {
		Integer currCourseVal = 0;
		for(int i = 0; i < courses.size(); i++) {
			for(int j = 0; j < (courses.get(i)).getSchedule().size(); j++)
			{
				currCourseVal = ((courses.get(i)).getSchedule()).get(j);
				schedule.add(currCourseVal);
			
			}
		}
		Collections.sort(schedule);
		Integer currScheduleVal = 0;
		for(int i = 0; i < schedule.size(); i++) {
			currScheduleVal = schedule.get(i);
			for(int j = 0; j < courses.size(); j++) {
				for(int k = 0; k < (courses.get(j)).getSchedule().size(); k++) {
					currCourseVal = (courses.get(j)).getSchedule().get(k);
					if(currScheduleVal == currCourseVal) {
						System.out.print(convertIntToString(currScheduleVal));
						System.out.println(" " + (courses.get(j)).getDepartment().getDepartmentName() + (courses.get(j)).getCourseNumber() + " " + (courses.get(j)).getName());
						
					}
				}
			}
		}
		
	}

}
