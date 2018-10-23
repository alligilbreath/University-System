package org.university.people;

//import java.util.ArrayList;
//import java.util.Collections;

import org.university.hardware.*;
import org.university.software.*;

public class Student extends Person{
	
	//private String name;
	private Department department;
	//course list
	//private ArrayList<Course> courses = new ArrayList<Course>(); //in UML courses : Course[1..*]
	private int unitsCompleted; //units completed
	private int requiredUnits; //units needed for degree completion
	private int enrolledUnits;
	private int tuitionFee;
	//private ArrayList<Integer> schedule = new ArrayList<Integer>();
	//private String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
	//private String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	//constructor
	public Student() {
		name = "unknown student";
		unitsCompleted = 0;
		requiredUnits = 0;
		enrolledUnits = 0;
	}

	//getters
//	public String getName() {
//		return name;
//	}
	
/*	public ArrayList<Course> getCourses(){
		return courses;
	}*/

	public Department getDepartment() {
		return department;
	}
	
	public int getUnitsCompleted() {
		return unitsCompleted;
	}
	
	public int getRequiredUnits() {
		return requiredUnits;
	}
	
//	public ArrayList<Integer> getSchedule(){
//		return schedule;
//	}
	
	public int getTuitionFee() {
		calculateTotalTuitionFee();
		return tuitionFee;
	}
	
	public void calculateTotalTuitionFee() {
		int onCampusCredits = 0;
		int onCampusFee = 0;
		for(int i = 0; i < campusCourses.size(); i++) {
			onCampusCredits += campusCourses.get(i).getCreditUnits();
		}
		onCampusFee = onCampusCredits * 300;
		int onlineFee = 0;
		for(int i = 0; i < onlineCourses.size(); i++) {
			if(onlineCourses.get(i).getCreditUnits() == 3) {
				onlineFee += 2000;
			}
			else if(onlineCourses.get(i).getCreditUnits() == 4) {
				onlineFee += 3000;
			}
		}
		tuitionFee = onCampusFee + onlineFee;
	}

	//setters
//	public void setName(String name) {
//		this.name = name;
//	}

	public void setDepartment(Department department) {
		//need to also add student to Department's students
		this.department = department;
	}	
	
	/*public void setCourses(ArrayList<Course> courses)
	{
		this.courses = courses;
	}*/
	
	public void setCompletedUnits(int unitsCompleted) {
		this.unitsCompleted = unitsCompleted;
	}
	
//	public void setUnitsNeeded(int unitsNeeded) {
//		this.unitsNeeded = unitsNeeded;
//	}
	public void setRequiredCredits(int requiredUnits) {
		this.requiredUnits = requiredUnits;
	}
	
//	public void setSchedule(ArrayList<Integer> schedule) {
//		this.schedule = schedule;
//	}
	
	public int requiredToGraduate() {
		return (requiredUnits - unitsCompleted - enrolledUnits);
	}
	
	//TODO: public boolean detectConflict(Course aCourse)
	//return true if a schedule conflict is detected
	//ECE320 course cannot be added to Lahiru's Schedule. 
	//ECE320 conflicts with CS426. 
	//Conflicting time slot is Mon 9:30am to 10:45am.
	/*public boolean detectConflict(Course aCourse) {
		boolean detectedConflict = false;
		Integer studentVal = 0;
		Integer aCourseVal = 0;
		for(int i = 0; i < courses.size(); i++) {
			for(int j = 0; j < (courses.get(i)).getSchedule().size(); j++) {
				for(int k = 0; k < aCourse.getSchedule().size(); k++) {
					//System.out.println("ACTUAL Student schedule val: " + (courses.get(i)).getSchedule().get(j));
					//System.out.println("ACTUAL aCourse schedule val: " + aCourse.getSchedule().get(k));
					studentVal = (courses.get(i).getSchedule().get(j));
					aCourseVal = aCourse.getSchedule().get(k);
					//System.out.println("Student schedule val: " + studentVal);
					//System.out.println("aCourse schedule val: " + aCourseVal);
					if(studentVal.equals(aCourseVal)) {
						System.out.print(aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " course cannot be added to " + this.getName() + "'s Schedule.");
						System.out.print(" " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " conflicts with " + courses.get(i).getDepartment().getDepartmentName() + courses.get(i).getCourseNumber() + ".");
						System.out.println(" Conflicting time slot is " + courses.get(i).convertIntToString(aCourse.getSchedule().get(k)) + ".");
						detectedConflict = true;
					}
				}
			}
		}
		return detectedConflict;
	}*/
	
	//add
	/*public void addCourse(Course newCourse) {
		boolean conflicts = detectConflict(newCourse);
		if (conflicts == false)
		{
			courses.add(newCourse);
			newCourse.addStudent(this); //need to also add student to the course roster
		}
		
		
	}*/
	
	public int getEnrolledUnits() {
		return enrolledUnits;
	}

	public void setEnrolledUnits(int enrolledUnits) {
		this.enrolledUnits = enrolledUnits;
	}

//	public void setUnitsCompleted(int unitsCompleted) {
//		this.unitsCompleted = unitsCompleted;
//	}

//	public void setRequiredUnits(int requiredUnits) {
//		this.requiredUnits = requiredUnits;
//	}

	public void setTuitionFee(int tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	public void addCampusCourse(CampusCourse aCourse) {
		boolean conflicts = detectConflict(aCourse);
		if (conflicts == false && aCourse.availableTo(this))
		{
			campusCourses.add(aCourse);
			aCourse.addStudentToRoster(this); //need to also add student to the course roster
			enrolledUnits += aCourse.getCreditUnits();
		}
		else if(!aCourse.availableTo(this)) {
			//Daz can't add Campus Course CS387 Enterprise Web Applications. Because this Campus course has enough student.
			System.out.println(this.getName() + " can't add Campus Course " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " " + aCourse.getName() + ". Because this Campus course has enough student.");
		}
		
		
	}
	
	public void addOnlineCourse(OnlineCourse aCourse) {
		boolean isAvailable = aCourse.availableTo(this);
		if (isAvailable)
		{
			onlineCourses.add(aCourse);
			aCourse.addStudentToRoster(this); //need to also add student to the course roster
			enrolledUnits += aCourse.getCreditUnits();
		}
		else
		{
			System.out.println(this.getName() + " can't add online Course " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " " + aCourse.getName() + ". Because this student don't have enough Campus course credit."); 
		}
	}
	
	//TODO: Check to see if the course is in the student's course list
	//If it is the course should be removed from their schedule
	//otherwise an error message should be printed out: 
	//“The course ‘course name’could not be dropped because ‘student name’is not enrolled in ‘course name’.”
	/*public void dropCourse(Course aCourse) {
		boolean foundCourse = false;
		for(int i = 0; i < courses.size(); i++)
		{
			if(courses.get(i) == aCourse) {
				foundCourse = true;
				courses.remove(i);
				break;
			}
		}
		if (foundCourse == false) {
			System.out.println("The course " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " could not be dropped because " + this.getName() + " is not enrolled in " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + ".");
		}
		
	}*/
	
	public void dropOnlineCourse(OnlineCourse aCourse) {
		boolean foundCourse = false;
		for(int i = 0; i < onlineCourses.size(); i++)
		{
			if(onlineCourses.get(i) == aCourse) {
				foundCourse = true;
				//courses.remove(i);
				enrolledUnits -= onlineCourses.get(i).getCreditUnits();
				onlineCourses.remove(i);
				aCourse.getStudentRoster().remove(this);
				break;
			}
		}
		if (foundCourse == false) {
			System.out.println("The course " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " could not be dropped because " + this.getName() + " is not enrolled in " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + ".");
			return;
		}
	}
	
	public void dropCampusCourse(CampusCourse aCourse) {
		boolean foundCourse = false;
		int foundIndex = -1;
		int campusCreditsWO = 0;
		for(int i = 0; i < campusCourses.size(); i++)
		{
			if(campusCourses.get(i) == aCourse) {
				foundCourse = true;
				foundIndex = i;
				//courses.remove(i);
				break;
			}
		}
		if (foundCourse == false) {
			System.out.println("The course " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " could not be dropped because " + this.getName() + " is not enrolled in " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + ".");
			return;
		}
		else {
			if(onlineCourses.size() > 0) {
				for(int i = 0; i < campusCourses.size(); i++) {
					if(i != foundIndex) {
						campusCreditsWO += campusCourses.get(i).getCreditUnits();
					}
				}
				//campusCreditsWO = enrolledUnits - campusCourses.get(foundIndex).getCreditUnits();
				if(campusCreditsWO >= 6) {
					enrolledUnits -= campusCourses.get(foundIndex).getCreditUnits();
					campusCourses.remove(foundIndex);
					aCourse.getStudentRoster().remove(this);
				}
				else
				{
					System.out.println(this.getName() +" can't drop this CampusCourse, because student don't has enough campus course credit to hold online course"); 
					
				}
			}
			else {
				//System.out.print("Removed " + campusCourses.get(foundIndex).getName());
				enrolledUnits -= campusCourses.get(foundIndex).getCreditUnits();
				campusCourses.remove(foundIndex);
				aCourse.getStudentRoster().remove(this);
				return;
			}
		}
		
	}
	
//	public String convertIntToString(Integer aInt) {
//		int hundreth = aInt / 100;
//		int ones = aInt % 10;
//		String myString = Week[hundreth - 1] + " " + Slot[ones - 1];
//		return myString;
//	}
//	
	//TODO: printSchedule
	//Print chronologically
	//will need to convert numbers (ex: 102) to (ex: Mon 9:30am to 10:45am
	//need to also print course name ex: Mon 9:30am to 10:45 CourseName
	/*public void printSchedule() {
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
		
		
	}*/

}
