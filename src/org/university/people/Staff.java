package org.university.people;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;

public class Staff extends Employee{
	private Department department;
	private double payRate;
	private double hoursWorked;
	private int tuitionFee;
	
	public Staff() {
		payRate = 0;
		hoursWorked = 0;
		tuitionFee = 0;
		
	}
	
	public Department getDepartment() {
		return department;
	}
	
	
	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setMonthlyHours(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int getTuitionFee() {
		calculateTotalTuitionFee();
		return tuitionFee;
	}

	public void setTuitionFee(int tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

	public double earns() {
		return payRate * hoursWorked;
	}
	
	public void raise(double percent) {
		payRate = payRate + payRate*(percent/100.0);
		
	}

	@Override
	public void addCampusCourse(CampusCourse aCourse) {
		if(!campusCourses.isEmpty()) {
			//CS387 is removed from Carol's schedule(Staff can only take one class at a time).
			//CS372 has been added to Carol's Schedule.
			System.out.println(campusCourses.get(0).getDepartment().getDepartmentName() + campusCourses.get(0).getCourseNumber() + " is removed from "
					+ this.getName() + "'s schedule(Staff can only take one class at a time). "
					+ aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " has been added to " + this.getName() + "'s Schedule.");
			campusCourses.clear();
			campusCourses.add(aCourse);
			aCourse.addStudentToRoster(this);
		}
		else if(!onlineCourses.isEmpty()) {
			System.out.println(onlineCourses.get(0).getDepartment().getDepartmentName() + onlineCourses.get(0).getCourseNumber() + " is removed from "
					+ this.getName() + "'s schedule(Staff can only take one class at a time). "
					+ aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " has been added to " + this.getName() + "'s Schedule.");
			onlineCourses.clear();
			campusCourses.add(aCourse);
			aCourse.addStudentToRoster(this);
			
		}
		else {
			campusCourses.add(aCourse);
			aCourse.addStudentToRoster(this);
		}
		
	}

	@Override
	public void addOnlineCourse(OnlineCourse aCourse) {
		if(!campusCourses.isEmpty()) {
			//CS387 is removed from Carol's schedule(Staff can only take one class at a time).
			//CS372 has been added to Carol's Schedule.
			System.out.println(campusCourses.get(0).getDepartment().getDepartmentName() + campusCourses.get(0).getCourseNumber() + " is removed from "
					+ this.getName() + "'s schedule(Staff can only take one class at a time). "
					+ aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " has been added to " + this.getName() + "'s Schedule.");
			campusCourses.clear();
			onlineCourses.add(aCourse);
			aCourse.addStudentToRoster(this);
		}
		else if(!onlineCourses.isEmpty()) {
			System.out.println(onlineCourses.get(0).getDepartment().getDepartmentName() + onlineCourses.get(0).getCourseNumber() + " is removed from "
					+ this.getName() + "'s schedule(Staff can only take one class at a time). "
					+ aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " has been added to " + this.getName() + "'s Schedule.");
			onlineCourses.clear();
			onlineCourses.add(aCourse);
			aCourse.addStudentToRoster(this);
			
		}
		else {
			onlineCourses.add(aCourse);
		}
		
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

}
