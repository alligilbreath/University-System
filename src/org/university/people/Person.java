package org.university.people;

import java.util.ArrayList;
import java.util.Collections;

import org.university.software.*;

public abstract class Person {
	protected String name;
	protected ArrayList<Integer> schedule = new ArrayList<Integer>();
	protected ArrayList<CampusCourse> campusCourses = new ArrayList<CampusCourse>();
	protected ArrayList<OnlineCourse> onlineCourses = new ArrayList<OnlineCourse>();
	protected String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	protected String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Integer> schedule) {
		this.schedule = schedule;
	}

	public ArrayList<CampusCourse> getCampusCourses() {
		return campusCourses;
	}

	public void setCampusCourses(ArrayList<CampusCourse> campusCourses) {
		this.campusCourses = campusCourses;
	}

	public ArrayList<OnlineCourse> getOnlineCourses() {
		return onlineCourses;
	}

	public void setOnlineCourses(ArrayList<OnlineCourse> onlineCourses) {
		this.onlineCourses = onlineCourses;
	}

	public boolean detectConflict(CampusCourse aCourse) {
		boolean detectedConflict = false;
		Integer personVal = 0;
		Integer aCourseVal = 0;		
		for(int i = 0; i < campusCourses.size(); i++) {
			for(int j = 0; j < (campusCourses.get(i)).getSchedule().size(); j++) {
				for(int k = 0; k < aCourse.getSchedule().size(); k++) {
					//System.out.println("ACTUAL Student schedule val: " + (courses.get(i)).getSchedule().get(j));
					//System.out.println("ACTUAL aCourse schedule val: " + aCourse.getSchedule().get(k));
					personVal = (campusCourses.get(i).getSchedule().get(j));
					aCourseVal = aCourse.getSchedule().get(k);
					//System.out.println("Student schedule val: " + studentVal);
					//System.out.println("aCourse schedule val: " + aCourseVal);
					if(personVal.equals(aCourseVal)) {
						System.out.print(aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " course cannot be added to " + name + "'s Schedule.");
						System.out.print(" " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " conflicts with " + campusCourses.get(i).getDepartment().getDepartmentName() + campusCourses.get(i).getCourseNumber() + ".");
						System.out.println(" Conflicting time slot is " + campusCourses.get(i).convertIntToString(aCourse.getSchedule().get(k)) + ".");
						detectedConflict = true;
					}
				}
			}
		}
		return detectedConflict;
	}
	
	public String convertIntToString(Integer aInt) {
		int hundreth = aInt / 100;
		int ones = aInt % 10;
		String myString = Week[hundreth - 1] + " " + Slot[ones - 1];
		return myString;
	}
	
	public void printSchedule() {
		Integer currCourseVal = 0;
		for(int i = 0; i < campusCourses.size(); i++) {
			for(int j = 0; j < (campusCourses.get(i)).getSchedule().size(); j++)
			{
				currCourseVal = ((campusCourses.get(i)).getSchedule()).get(j);
				schedule.add(currCourseVal);
			
			}
		}
		Collections.sort(schedule);
		Integer currScheduleVal = 0;
		for(int i = 0; i < schedule.size(); i++) {
			currScheduleVal = schedule.get(i);
			for(int j = 0; j < campusCourses.size(); j++) {
				for(int k = 0; k < (campusCourses.get(j)).getSchedule().size(); k++) {
					currCourseVal = (campusCourses.get(j)).getSchedule().get(k);
					if(currScheduleVal == currCourseVal) {
						System.out.print(convertIntToString(currScheduleVal));
						System.out.println(" " + (campusCourses.get(j)).getDepartment().getDepartmentName() + (campusCourses.get(j)).getCourseNumber() + " " + (campusCourses.get(j)).getName());
						
					}
				}
			}
		}
		
		for(int i = 0; i < onlineCourses.size(); i++) {
			System.out.println(onlineCourses.get(i).getCourseNumber() + " " + onlineCourses.get(i).getName());
		}
		
		
	}
	
	public abstract void addCampusCourse(CampusCourse aCourse);
	public abstract void addOnlineCourse(OnlineCourse aCourse);
	
}
