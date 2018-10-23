package org.university.software;

import org.university.people.Student;

public class OnlineCourse extends Course{
	
	public OnlineCourse() {
		name = "unknown online course";
	}
	
	public boolean availableTo(Student aStudent) {
		//Student Lahiru has only 4 on campus credits enrolled. 
		//Should have at least 6 credits registered before registering online courses.
		int campusCredits = 0;
		for(int i = 0; i < (aStudent.getCampusCourses()).size(); i++) {
			//System.out.println("Curr class is " + (aStudent.getCampusCourses()).get(i).getName() + " and its units is " + (aStudent.getCampusCourses()).get(i).getCreditUnits());
			campusCredits += ((aStudent.getCampusCourses()).get(i)).getCreditUnits();
		}
		//System.out.println("Student " + aStudent.getName() + " has: " + campusCredits);
		if(campusCredits < 6) {
			System.out.println("Student "+ aStudent.getName() + " has only " + campusCredits + " on campus credits enrolled. Should have at least 6 credits registered before registering online courses.");
			return false;
		}
		else
		{
			return true;
		}
		
	}


}
