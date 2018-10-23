package org.university.hardware;
import java.util.ArrayList;

import org.university.people.*;
import org.university.software.*;

public class Department {
	private String name;
	//list of courses it offers
	//UML: - courses: Course[1..*]
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<CampusCourse> campusCourses = new ArrayList<CampusCourse>();
	private ArrayList<OnlineCourse> onlineCourses = new ArrayList<OnlineCourse>();
	//list of students enrolled
	//UML: - students: Student[1..*]
	private ArrayList<Student> students = new ArrayList<Student>();
	//list of professors
	private ArrayList<Professor> professors = new ArrayList<Professor>();
	//list of staff
	private ArrayList<Staff> staff = new ArrayList<Staff>();
	
	//constructor
	public Department() {
		name = "unknown department";
	}
	
	//getters
	public String getDepartmentName() {
		return name;
	}
	public ArrayList<Course> getCourseList() {
		return courses;
	}
	public ArrayList<Student> getStudentList() {
		return students;
	}
	
	public ArrayList<Professor> getProfessorList(){
		return professors;
	}
	
	public ArrayList<CampusCourse> getCampusCourseList(){
		return campusCourses;
	}
	
	public ArrayList<OnlineCourse> getOnlineCourses() {
		return onlineCourses;
	}

	public void setOnlineCourses(ArrayList<OnlineCourse> onlineCourses) {
		this.onlineCourses = onlineCourses;
	}

	//setters
	public void setDepartmentName(String name) {
		this.name = name;
	}
	
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	public void setProfessors(ArrayList<Professor> professors) {
		this.professors = professors;
	}
	
	public void setCampusCourses(ArrayList<CampusCourse> campusCourses) {
		this.campusCourses = campusCourses;
	}
	
	//add
	
//	public void addCourse(Course newCourse) {
//		courses.add(newCourse);
//		//need to set course's department to department
//		newCourse.setDepartment(this);
//	}
	
	public ArrayList<Staff> getStaffList() {
		return staff;
	}

	public void setStaff(ArrayList<Staff> staff) {
		this.staff = staff;
	}

	public void addCampusCourse(CampusCourse newCourse) {
		courses.add(newCourse);
		campusCourses.add(newCourse);
		newCourse.setDepartment(this);
		
	}
	
	public void addOnlineCourse(OnlineCourse newCourse) {
		courses.add(newCourse);
		onlineCourses.add(newCourse);
		newCourse.setDepartment(this);
	}
	
	//UML: + addStudent(newStudent:Student): void
	public void addStudent(Student newStudent) {
		students.add(newStudent);
		//need to set student's department
		newStudent.setDepartment(this);
	}
	
	public void addProfessor(Professor newProfessor) {
		professors.add(newProfessor);
		newProfessor.setDepartment(this);
	}
	
	public void addStaff(Staff newStaff) {
		staff.add(newStaff);
		newStaff.setDepartment(this);
	}
	
	
	public void printStudentList() {
		for(int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).getName());
		}
	}
	
	public void printProfessorList() {
		for(int i = 0; i < professors.size(); i++) {
			System.out.println(professors.get(i).getName());
		}
	}
	
	public void printStaffList() {
		for(int i = 0; i < staff.size(); i++) {
			System.out.println(staff.get(i).getName());
		}
	}
	//TODO: printCourseList
	public void printCourseList() {
		for(int i = 0; i < courses.size(); i++) {
			System.out.println(name + courses.get(i).getCourseNumber() + " " + courses.get(i).getName());
		}
	}
	

}
