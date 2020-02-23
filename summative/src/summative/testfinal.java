package summative;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class testfinal{ 
	static ArrayList<Generalcourse> coursesoffered;
	static ArrayList<ArrayList<Student>> allstudents;
	static ArrayList<Teacher> teachers;

	public static void main(String[] args) { 
		coursesoffered = readcourses();
		allstudents = readstudents(coursesoffered);
		teachers = readteachers();

		for (int x = 0; x < allstudents.size(); x++) {
			for (int y = 0; y < allstudents.get(x).size(); y++) {
				if (allstudents.get(x).get(y).courseschosen.size() != 8) {
					System.out.println("Less than 8 Chosen: " + allstudents.get(x).get(y).name);
				}
				if (allstudents.get(x).get(y).coursestaken.size() != 8) {
					if (allstudents.get(x).get(y).grade != 9) { 
						System.out.println("Less than 8 Taken: " + allstudents.get(x).get(y).name);}
				}
				if (allstudents.get(x).get(y).coursestaken.size() != 0) {
					if (allstudents.get(x).get(y).grade != 10) {
						System.out.println("More than 0 Taken: " + allstudents.get(x).get(y).name);}
					}
			}
		} 
		for (int z = 0; z < teachers.size(); z++) {
			if (teachers.get(z).teachername == null) {
				System.out.println("No name: " + (z + 1));
			} 
		} 
		System.out.println("Done Ba Da Boom.");
	}

	public void generatetimetable() {
		
	}

	public static ArrayList<Teacher> readteachers() {
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		Scanner sc = null;
		try {
			File file = new File("teachers.csv"); 
			sc = new Scanner(file); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		  
		while (sc.hasNextLine() == true) {
			String teacherinfo = sc.nextLine();
			String[] propertiesofteacher = teacherinfo.split(",");
			String teachername = propertiesofteacher[0];
			int number = Integer.parseInt(propertiesofteacher[1]);
			String field = propertiesofteacher[2];
			 
			teachers.add(new Teacher(teachername, field, number));
		}
		sc.close();
		sc = null;

		return teachers;
	}

	public static boolean checkinteger(String value) { 
		if (value == null) {
			return false;
		}
		try {
 			Float.parseFloat(value);
 			return true;
 		} 
 		catch (Exception e) {
 			return false;
 		} 	
	} 
	
	public static ArrayList<ArrayList<Student>> readstudents( ArrayList<Generalcourse>  coursesoffered) { 
		ArrayList<Student> grade9 = new ArrayList<Student>();
		ArrayList<Student> grade10 = new ArrayList<Student>();
		ArrayList<Student> grade11 = new ArrayList<Student>();
		ArrayList<Student> grade12 = new ArrayList<Student>();
		  
		ArrayList<ArrayList<Student> > allstudents =  new ArrayList<ArrayList<Student> >(4);

		allstudents.add(grade9);
		allstudents.add(grade10);
		allstudents.add(grade11);
		allstudents.add(grade12);
		
		Scanner sc = null;
		try {
			File file = new File("students.csv"); 
			sc = new Scanner(file); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		  
		while (sc.hasNextLine() == true) {
			String studentinfo = sc.nextLine();
			String[] propertiesofstudents = studentinfo.split(",");
			
			String name = propertiesofstudents[0];
	     	int grade = Integer.parseInt(propertiesofstudents[1]);
	     	int studentnumber = Integer.parseInt(propertiesofstudents[2]);
	     	int x = 3;
			 
	     	ArrayList<Generalcourse> courseschosen = new ArrayList <Generalcourse>();
	     	ArrayList <Generalcourse> coursestaken = new ArrayList <Generalcourse>();
	     	
	     	ArrayList <Float> marks = new ArrayList <Float>();
	     	
	     	
				while (true) {
					if (x + 1 < propertiesofstudents.length) { 
						if (checkinteger(propertiesofstudents[x + 1]) == false) { 
							for (int y = 0; y < coursesoffered.size(); y++) { 
								if (coursesoffered.get(y).name.equals( propertiesofstudents[x])) { 
									courseschosen.add(coursesoffered.get(y));
									coursesoffered.get(y).peopletakingit++;
									break;} }
									x++;}
						else {
							break;
						}
							
							
						}
					else if (x + 1 == propertiesofstudents.length) {
						for (int y = 0; y < coursesoffered.size(); y++) { 
							if (coursesoffered.get(y).name.equals( propertiesofstudents[x])) { 
								courseschosen.add(coursesoffered.get(y));
								coursesoffered.get(y).peopletakingit++;
								break;} }
								x++;
							break;} 	
				}
			 
	     	for (int l = x; l < propertiesofstudents.length; l+= 2) { 
	     		for (int y = 0; y < coursesoffered.size(); y++) { 
	     			if (coursesoffered.get(y).name.equals(propertiesofstudents[l])) { 
						coursestaken.add(coursesoffered.get(y));
						marks.add(Float.parseFloat(propertiesofstudents[l + 1]));
						break;}} 
						} 
	     	Student tempstudent = new Student(name, grade, studentnumber, courseschosen, coursestaken, marks);
	     	int number = grade - 9;
	     	allstudents.get(number).add(tempstudent);}
		
		sc.close();
		sc = null;
	      
	  return allstudents;}
	
	public static ArrayList<Generalcourse> readcourses() {
		ArrayList<Generalcourse> coursesoffered = new ArrayList<Generalcourse>();
		Scanner sc = null;

		try {
			File file = new File("Courses.csv"); 
			sc = new Scanner(file); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		while (sc.hasNextLine() == true) {
			String coursecode = sc.nextLine(); 
			Generalcourse course = new Generalcourse(coursecode);
			coursesoffered.add(course);}
		sc.close();
			sc = null;
		return coursesoffered;
	}
	//}
}
