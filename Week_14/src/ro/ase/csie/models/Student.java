package ro.ase.csie.models;

import java.util.ArrayList;

import ro.ase.csie.exceptions.WrongAgeException;
import ro.ase.csie.exceptions.WrongGradesException;
import ro.ase.csie.exceptions.WrongNameExceptions;

public class Student {
	
	public static final int MIN_AGE = 14;
	public static final int MAX_AGE = 90;
	public static final int MIN_GRADE = 1;
	public static final int MAX_GRADE = 10;
	public static final int MIN_NAME_SIZE = 3;
	public static final int MAX_NAME_SIZE = 255;
	
	protected String name;
	protected int age;
	protected ArrayList<Integer> grades;
	
	
	public Student(String name, int age, ArrayList<Integer> grades) {
		super();
		this.name = name;
		this.age = age;
		this.grades = grades;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) throws WrongNameExceptions{
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) throws WrongAgeException {
		if(age < MIN_AGE || age > MAX_AGE) {
			throw new WrongAgeException();
		}
		this.age = age;
	}


	public void setGrades(ArrayList<Integer> grades) throws WrongGradesException{
		this.grades = grades;
	}
	
	
	public int getGrade(int index) {
		return this.grades.get(index);
	}
	
	public int getNoGrades() {
		return this.grades.size();
	}
	

	public float getGradesAverage() {
		
		if(this.grades.size() == 0) {
			return 0;
		}
		
		float sum = 0;
		for(int grade : this.grades) {
			sum += grade;
		}
		return sum/this.grades.size();
		
	}
	
	public int getMinGrade() {
		int min = this.grades.get(0);
		for(int grade: this.grades) {
			if(min>grade) {
				min = grade;
			}
		}
		return min;
	}

}