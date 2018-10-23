package org.university.software;
import java.util.ArrayList;
//import java.util.Collections;

import org.university.hardware.*;
import org.university.people.*;

public abstract class Course {
	//course name
	//UML: - name: String
	protected String name;
	//course number
	//UML: - number: int
	protected int number;
	//student roster
	//UML: - roster: Student[1..*]
	protected ArrayList<Person> roster = new ArrayList<Person>();
	//department
	protected Department department;
	//schedule
	//private ArrayList<Integer> schedule = new ArrayList<Integer>();
	//professor
	protected Professor professor;
	//credit units
	protected int creditUnits;
	//classroom
//	private Classroom classroom;
//	private String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
//	private String[] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	
	//constructor
	//UML: + Course()
	public Course() {
		name = "unknown course";
		number = 0;
		department = new Department();
		professor = new Professor();
		creditUnits = 0;
		
	}
	
	
	//getters
	//UML: + getName(): String
	public String getName() {
		return name;
	}
	
	//UML: + getNumber(): int
	public int getCourseNumber() {
		return number;
	}
	
	//UML: + getStudentRoster(): Student[1..*]
	public ArrayList<Person> getStudentRoster(){
		return roster;
	}
	
	public int getCreditUnits() {
		return creditUnits;
	}
	
	//UML: + getSchedule(): Integer[1..*]
//	public ArrayList<Integer> getSchedule() {
//		return schedule;
//	}
	
	//UML: + getDepartment(): Department
	public Department getDepartment() {
		return department;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
//	public Classroom getClassroom() {
//		return classroom;
//	}
	
	//setters
	//UML: + setName(name:String): void
	public void setName(String name) {
		this.name = name;
	}
	
	//UML: + setCourseNumber(number:int): void
	public void setCourseNumber(int number) {
		this.number = number;
	}
	
	
//	public void setSchedule(Integer time) {
//		schedule.add(time);
//	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public void setCreditUnits(int creditUnits) {
		this.creditUnits = creditUnits;
	}
	
	public void setStudentRoster(ArrayList<Person> roster) {
		this.roster = roster;
	}
	
//	public void setClassroom(Classroom classroom) {
//		this.classroom = classroom;
//	}
	
//	public void setRoomAssigned(Classroom aClassroom) {
//		classroom = aClassroom;
//		aClassroom.addCourse(this);
//		
//	}
	
	//add
	//UML + addStudent(newStudent:Student): void
	public void addStudentToRoster(Person newPerson) {
		roster.add(newPerson);
	}
	
//	public void printSchedule() {
//		Collections.sort(schedule);
//		int hundreth = 0;
//		int ones = 0;
//		for(int i = 0; i < schedule.size(); i++) {
//			hundreth = schedule.get(i) / 100;
//			ones = schedule.get(i) % 10;
//			System.out.println(Week[hundreth - 1] + " " + Slot[ones - 1] + " " + this.getClassroom().getRoomNumber());
//			
//		}
//		
//	}

	
	public abstract boolean availableTo(Student aStudent);
	

}
