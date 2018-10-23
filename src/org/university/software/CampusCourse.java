package org.university.software;

import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.Classroom;
import org.university.people.*;

public class CampusCourse extends Course {
	//schedule
	private ArrayList<Integer> schedule = new ArrayList<Integer>();
	private int maxNumStudents;
	//classroom
	private Classroom classroom;
	private String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	private String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	public CampusCourse() {
		maxNumStudents = 0;
		
	}
	
	public ArrayList<Integer> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Integer> schedule) {
		this.schedule = schedule;
	}

	public int getMaxNumStudents() {
		return maxNumStudents;
	}

	public void setMaxCourseLimit(int maxNumStudents) {
		this.maxNumStudents = maxNumStudents;
	}

	public Classroom getClassroom() {
		return classroom;
	}
	
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public void setRoomAssigned(Classroom aClassroom) {
		classroom = aClassroom;
		aClassroom.addCourse(this);
	
	}
//
//	public void setRoomAssigned(Classroom aClassroom) {
//		//aClassroom.addCourse(this);
//		boolean conflicts = aClassroom.detectConflict(this);
//		if(conflicts == false)
//		{
//			courses.add(newCourse);
//			newCourse.setRoomAssigned(this);
//		}
//		//classroom = aClassroom;
//	
//	}
	
	public void setSchedule(Integer time) {
		schedule.add(time);
	}

	//TODO: This
	public boolean availableTo(Student aStudent) {
		if(roster.size() < this.getMaxNumStudents()) {
			return true;
		}
		else
		{
			//Daz can't add Campus Course CS387 Enterprise Web Applications. Because this Campus course has enough student.
			//System.out.println(aStudent.getName() + " can't add Campus Course " + this.getDepartment().getDepartmentName() + this.getCourseNumber() + " " + this.getName() + ". Because this Campus course has enough student.");
			return false;
		}
		
	}
	
	public void printSchedule() {
	Collections.sort(schedule);
	int hundreth = 0;
	int ones = 0;
	for(int i = 0; i < schedule.size(); i++) {
		hundreth = schedule.get(i) / 100;
		ones = schedule.get(i) % 10;
		System.out.println(Week[hundreth - 1] + " " + Slot[ones - 1] + " " + this.getClassroom().getRoomNumber());
		
	}
	
	}
	
	public String convertIntToString(Integer aInt) {
		int hundreth = aInt / 100;
		int ones = aInt % 10;
		String myString = Week[hundreth - 1] + " " + Slot[ones - 1];
		return myString;
	}

}
