package org.university.people;

//import java.util.ArrayList;
//import java.util.Collections;

import org.university.hardware.*;
import org.university.software.*;

public class Professor extends Employee {
	//private String name;
	private double salary;
	//private ArrayList<CampusCourse> campusCourses = new ArrayList<CampusCourse>();
	private Department department = new Department();
	//private ArrayList<Integer> schedule = new ArrayList<Integer>();
	//private String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	//private String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	public Professor() {
		name = "unknown professor";
		department.setDepartmentName("unknown dept");
		salary = 0;
	}

	//getters
//	public String getName() {
//		return name;
//	}
//
//	public ArrayList<CampusCourse> getCampusCourses() {
//		return campusCourses;
//	}
//	
	public Department getDepartment() {
		return department;
	}
	
	
//	public ArrayList<Integer> getSchedule(){
//		return schedule;
//	}
//	
	//setters
//	public void setName(String name) {
//		this.name = name;
//	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

//	public void setCampusCourses(ArrayList<CampusCourse> campcourses) {
//		campusCourses = campcourses;
//	}
	
//	public void setSchedule(ArrayList<Integer> schedule) {
//		this.schedule = schedule;
//	}
	
//	//FROM ASSIGNMENT 2
//	public boolean detectConflict(CampusCourse aCourse) {
//		boolean detectedConflict = false;
//		Integer profVal = 0;
//		Integer aCourseVal = 0;
//		for(int i = 0; i < courses.size(); i++) {
//			for(int j = 0; j < (courses.get(i)).getSchedule().size(); j++) {
//				for(int k = 0; k < aCourse.getSchedule().size(); k++) {
//					//System.out.println("ACTUAL Student schedule val: " + (courses.get(i)).getSchedule().get(j));
//					//System.out.println("ACTUAL aCourse schedule val: " + aCourse.getSchedule().get(k));
//					profVal = (courses.get(i).getSchedule().get(j));
//					aCourseVal = aCourse.getSchedule().get(k);
//					//System.out.println("Student schedule val: " + studentVal);
//					//System.out.println("aCourse schedule val: " + aCourseVal);
//					if(profVal.equals(aCourseVal)) {
//						System.out.print(aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " course cannot be added to " + this.getName() + "'s Schedule.");
//						System.out.print(" " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " conflicts with " + courses.get(i).getDepartment().getDepartmentName() + courses.get(i).getCourseNumber() + ".");
//						System.out.println(" Conflicting time slot is " + courses.get(i).convertIntToString(aCourse.getSchedule().get(k)) + ".");
//						detectedConflict = true;
//					}
//				}
//			}
//		}
//		return detectedConflict;
//	}
	
	//FROM ASSIGNMENT 2
//	public void addCourse(Course newCourse) {
//		boolean detectedConflict = detectConflict(newCourse);
//		if(newCourse.getProfessor().getName() != "unknown professor") {
//			System.out.println("The professor cannot be assigned to this course because professor " + newCourse.getProfessor().getName() + " is already assigned to the course " + newCourse.getName() + ".");
//		}
//		else if(detectedConflict == false){
//			courses.add(newCourse);
//			//TODO: need to also add professor to the course
//			newCourse.setProfessor(this);
//		}
//		
//	}
	


	public void addCampusCourse(CampusCourse newCourse) {
		boolean detectedConflict = detectConflict(newCourse);
		if(newCourse.getProfessor().getName() != "unknown professor") {
			System.out.println("The professor " + this.getName() + " cannot be assigned to this campus course because professsor " + newCourse.getProfessor().getName() + " is already assigned to the course " + newCourse.getName() + ".");
			 
		}
		else if(detectedConflict == false){
			campusCourses.add(newCourse);
			//TODO: need to also add professor to the course
			newCourse.setProfessor(this);
		}
	}
	
	public void addOnlineCourse(OnlineCourse newCourse) {
		if(newCourse.getProfessor().getName() != "unknown professor") {
			System.out.println("The professor cannot be assigned to this online course because professsor " + newCourse.getProfessor().getName() + " is already assigned to the online course " + newCourse.getName() + ".");
		}
		else {
			onlineCourses.add(newCourse);
			newCourse.setProfessor(this);
		}
	}
	
//	public String convertIntToString(Integer aInt) {
//		int hundreth = aInt / 100;
//		int ones = aInt % 10;
//		String myString = Week[hundreth - 1] + " " + Slot[ones - 1];
//		return myString;
//	}
	
	//FROM ASSIGNMENT 2
//	public void printSchedule() {
//		Integer currCourseVal = 0;
//		for(int i = 0; i < courses.size(); i++) {
//			for(int j = 0; j < (courses.get(i)).getSchedule().size(); j++)
//			{
//				currCourseVal = ((courses.get(i)).getSchedule()).get(j);
//				schedule.add(currCourseVal);
//			
//			}
//		}
//		Collections.sort(schedule);
//		Integer currScheduleVal = 0;
//		for(int i = 0; i < schedule.size(); i++) {
//			currScheduleVal = schedule.get(i);
//			for(int j = 0; j < courses.size(); j++) {
//				for(int k = 0; k < (courses.get(j)).getSchedule().size(); k++) {
//					currCourseVal = (courses.get(j)).getSchedule().get(k);
//					if(currScheduleVal == currCourseVal) {
//						System.out.print(convertIntToString(currScheduleVal));
//						System.out.println(" " + (courses.get(j)).getDepartment().getDepartmentName() + (courses.get(j)).getCourseNumber() + " " + (courses.get(j)).getName());
//						
//					}
//				}
//			}
//		}
		
		
//	}
	
	public double earns() {
		return salary/26.0;
	}
	
	public void raise(double percent) {
		salary = salary + salary*(percent/100.0);
	}

}
