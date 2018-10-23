package org.university.software;

import java.util.ArrayList;
import org.university.hardware.*;
//import org.university.people.*;

public class University {
	public ArrayList<Department> departmentList;
//	private ArrayList<Student> studentList;
//	private ArrayList<Course> courseList;
	public ArrayList<Classroom> classroomList;

	public University() {
		departmentList = new ArrayList<Department>();
		//studentList = new ArrayList<Student>();
		//courseList = new ArrayList<Course>();
		classroomList = new ArrayList<Classroom>();
	}
	//getters
	public ArrayList<Department> getDepartmentList() {
		return departmentList;
	}
//	
//	public ArrayList<Student> getStudentList(){
//		return studentList;
//	}
//	
//	public ArrayList<Course> getCourseList(){
//		return courseList;
//	}
	
	public ArrayList<Classroom> getClassroomList(){
		return classroomList;
	}
	
	//setters
	public void setDepartmentList(ArrayList<Department> departments) {
		departmentList = departments;
	}
	
	public void setClassroomList(ArrayList<Classroom> classroomList) {
		this.classroomList = classroomList;
	}
	
//	public void setStudentList(ArrayList<Student> students) {
//		studentList = students;
//	}
//	
//	public void setCourseList(ArrayList<Course> courses) {
//		courseList = courses;
//	}
	
	//printers
	public void printDepartmentList() {
		//print
		for(int i = 0; i < departmentList.size(); i++)
		{
			System.out.println(departmentList.get(i).getDepartmentName());
		}
	}
	
	public void printStudentList() {
		//print
		for(int i = 0; i < departmentList.size(); i++) {
			departmentList.get(i).printStudentList();
		}
	}

	public void printProfessorList() {
		for(int i = 0; i < departmentList.size(); i++) {
			departmentList.get(i).printProfessorList();
		}
	}
	
	public void printStaffList() {
		for(int i = 0; i < departmentList.size(); i++) {
			departmentList.get(i).printStaffList();
		}
	}
	
	public void printCourseList() {
		//print
		ArrayList<CampusCourse> currCampusCourses = new ArrayList<CampusCourse>();
		ArrayList<OnlineCourse> currOnlineCourses = new ArrayList<OnlineCourse>();
		for(int i = 0; i < departmentList.size(); i++)
		{
			currCampusCourses = (departmentList.get(i)).getCampusCourseList();
			for(int j = 0; j < currCampusCourses.size(); j++) {
				System.out.println(departmentList.get(i).getDepartmentName() + currCampusCourses.get(j).getCourseNumber() + " " + currCampusCourses.get(j).getName());
			}
		}
		
		for(int i = 0; i < departmentList.size(); i++) {
			currOnlineCourses = (departmentList.get(i)).getOnlineCourses();
			for(int j = 0; j < currOnlineCourses.size(); j++) {
				System.out.println(departmentList.get(i).getDepartmentName() + currOnlineCourses.get(j).getCourseNumber() + " " + currOnlineCourses.get(j).getName());
			}
		}
		
	}
	

}
