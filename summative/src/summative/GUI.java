// Assignment: Summative GUI CLASS
// Names: Mya, Preesha & Eraj 
// Date: 2020-01-09
// Description: Runs main graphics window in conjunction with all other functionality of program



package summative;

import java.awt.BorderLayout;

import java.awt.CardLayout;
// imports to make graphics
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.text.html.ParagraphView;

import com.jgoodies.forms.layout.Size;


import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.print.DocFlavor.STRING;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;




public class GUI {
	// attributes 
	public JFrame frmStudentSchedulingSystem;
	public JLayeredPane layeredPane;
	private JPanel panelofbuttons;
	private JPanel StudentLibraryPanel;
	private JPanel AddAStudentPanelGrade9;
	private JLabel lblStudent;
	private JLabel lblScheduling;
	private JLabel lblNewLabel;
	private JButton btnStudentLibrary;
	private JButton btnAddAStudent;
	private JScrollPane scrollPane;
	private static JTable StudentLibraryTable;
	private JButton btnTeacherLibrary;
	private JButton btnCoursesOfferedLibrary;
	private JPanel TeacherLibraryPanel;
	private JTable TeacherLibraryTable;
	private JTable CoursesOfferedTable;
	
	// major arraylists used throughout program
	// lists are filled by extracting csv file data at the beginning of program when GUI is initialized 
	
	// arraylist of all courses offered by the school as general course objects 
	public static ArrayList<Generalcourse> coursesoffered = new ArrayList<Generalcourse>();

	//arraylist of all students at the school as student objects 
	public static  ArrayList<ArrayList<Student>> allstudents = new ArrayList<ArrayList<Student>>();
	
	// arraylist of all teachers at the school as teacher objects
	public ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private JPanel TimetablePanel;
	private JButton btnGenerateTimetables;
	private JScrollPane scrollPane_3;
	private JTable TimetableOutputTable;
	private JPanel SearchStudentContainingPanel;
	private JTable SearchTable;
	private JTextField TFSearchName;
	private JTextField TFStudentNumberSearch;
	private JTextField TFSearchByGrade;
	private JButton btnSearchStudent;
	private JButton btnTimetableGenerator;
	private JLabel lblgrade91;
	private JLabel lblgrade92;
	private JTextField nameGrade9TextField;
	private JTextField studentNumberGrade9TextField;
	private JLabel lblgrade94;
	private JLabel lblgrade95;
	private JLabel lblgrade93;
	private JLabel lblgrade96;
	private JLabel lblCourse;
	private JLabel lblCourse_1;
	private JLabel lblCourse_2;
	private JPanel AddStudentPanel;
	private JLabel label_1;
	private JComboBox comboBox_1;
	private JTextField course1textfieldgrade9;
	private JTextField course2textfieldgrade9;
	private JTextField course3textfieldgrade9;
	private JTextField course4textfieldgrade9;
	private JLabel lblCourse_3;
	private JLabel lblCourse_4;
	private JLabel lblCourse_5;
	private JLabel lblCourse_6;
	private JTextField course5textfieldgrade9;
	private JTextField course6textfieldgrade9;
	private JTextField course7textfieldgrade9;
	private JTextField course8textfieldgrade9;
	private JPanel AddAStudentPanelGrade10;
	private JLabel lblProvideAllCourses;
	private JLabel label_4;
	private JComboBox comboBox_2;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField TFname10;
	private JTextField TFstudentnumber10;
	private JLabel label_7;
	private JLabel lblMakeSureAll;
	private JButton button_2;
	private JTable grade10table;
	private JTextField course1TextFieldGrade10;
	private JTextField course2TextFieldGrade10;
	private JTextField course3TextFieldGrade10;
	private JTextField course4TextFieldGrade10;
	private JTextField course5TextFieldGrade10;
	private JTextField course6TextFieldGrade10;
	private JTextField course7TextFieldGrade10;
	private JTextField course8TextFieldGrade10;
	private JLabel lblSelectedGrade;
	private JLabel lblSelectedGrade_1;
	private JPanel AddAStudentPanelGrade11;
	private JLabel lblSelectedGrade_2;
	private JButton button_3;
	private JLabel label_2;
	private JTextField course4textfieldgrade11;
	private JLabel label_8;
	private JScrollPane scrollPane_6;
	private JLabel label_9;
	private JLabel label_10;
	private JComboBox comboBox_3;
	private JLabel label_11;
	private JLabel label_12;
	private JTextField TFnamegrade11;
	private JTextField TFstudentnumbergrade11;
	private JLabel label_13;
	private JLabel lblProvideAllCourses_1;
	private JLabel label_15;
	private JTextField course1textfieldgrade11;
	private JLabel label_16;
	private JTextField course2textfieldgrade11;
	private JLabel label_17;
	private JTextField course3textfieldgrade11;
	private JLabel label_18;
	private JTextField course7textfieldgrade11;
	private JLabel label_19;
	private JTextField course6textfieldgrade11;
	private JLabel label_20;
	private JTextField course5textfieldgrade11;
	private JLabel label_21;
	private JTextField course8textfieldgrade11;
	private JTable grade11table;
	private JPanel AddAStudentPanelGrade12;
	private JLabel lblSelectedGrade_3;
	private JButton button_4;
	private JLabel label_14;
	private JTextField course4textfieldgrade12;
	private JLabel label_22;
	private JScrollPane scrollPane_7;
	private JLabel label_23;
	private JLabel label_24;
	private JComboBox comboBox_5;
	private JLabel label_25;
	private JLabel label_26;
	private JTextField TFnamegrade12;
	private JTextField TFstudentnumbergrade12;
	private JLabel label_27;
	private JLabel lblProvideAllCourses_2;
	private JLabel label_29;
	private JTextField course1textfieldgrade12;
	private JLabel label_30;
	private JTextField course2textfieldgrade12;
	private JLabel label_31;
	private JTextField course3textfieldgrade12;
	private JLabel label_32;
	private JTextField course7textfieldgrade12;
	private JLabel label_33;
	private JTextField course6textfieldgrade12;
	private JLabel label_34;
	private JTextField course5textfieldgrade12;
	private JLabel label_35;
	private JTextField course8textfieldgrade12;
	private JTable grade12table;
	private JLabel lblTheFollowingWill;
	private JLabel lblInTheStudent;
	private JLabel lblInputAValue;
	private JLabel lblAddATeacher;
	private JLabel lblRemoveATeacher;
	private JLabel lblName;
	private JLabel lblAreaOfExpertise;
	private JButton btnAddTeacher;
	private JLabel lblTeacherNumber;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnRemoveTeacher;
	private JCheckBox chckbxGym;
	private JCheckBox chckbxTechnology;
	private JCheckBox chckbxBusiness;
	private JLabel lblTeacherLibrary;
	private JLabel lblStudentLibrary;
	
	static ArrayList<ArrayList<Teacher>> teachersbydepartment;
    String[][] fields = {{"English", "E"}, {"Math", "M"}, {"Science", "S"}, {"Social Studies", "C", "G", "H", "O", "N"}, {"French", "F"}, {"Arts", "A"}, {"Technology", "T", "I"}, {"Gym", "P"}, {"Business", "B"}};
    static ArrayList<ArrayList<Generalcourse>> coursesbydepartment;
    
    // for genetic algorithm 
    static int popmax;
    static double mutationRate;
    static Population population;
    
    // for generate popup window 
    JFrame generateFrame;
    JPanel panelongenerateframe;
    JTable generatedisplayinfotable;
    JLabel lblNumberOfGenerations;
    
    
	// Launch the application.
	public static void main(String[] args) {
			
		
		// this allows me to bypass logging in while testing so i can run main window directly 
		// the user will run the whole program from the login window
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmStudentSchedulingSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// function to switch panels and create new screen effect 
	public void switchPanels(JPanel panel) {

		// panels are switched by removing and adding them to layered pane
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	public void switchButtonColors (JButton clickedbutton) {
		
		// for all the buttons make their colors dark blue 
		btnStudentLibrary.setBackground(Color.decode("#5DADE2"));
		btnAddAStudent.setBackground(Color.decode("#5DADE2"));
		btnCoursesOfferedLibrary.setBackground(Color.decode("#5DADE2"));
		btnTimetableGenerator.setBackground(Color.decode("#5DADE2"));
		btnTeacherLibrary.setBackground(Color.decode("#5DADE2"));
		btnSearchStudent.setBackground(Color.decode("#5DADE2"));
		
		clickedbutton.setBackground(Color.decode("#85C1E9"));
		
	}
	
	// METHODS TO EXTRACT DATA FROM FILES BELOW 	
	
	// creates general course objects for all course info provided by csv
	public static ArrayList<Generalcourse> readcourses() throws FileNotFoundException {
		coursesoffered = new ArrayList<Generalcourse>();

		Scanner sc = null;
		String[][] fields = {{"English", "E"}, {"Math", "M"}, {"Science", "S"}, {"Social Studies", "C", "G", "H", "O", "N"}, {"French", "F"}, {"Arts", "A"}, {"Technology", "T", "I"}, {"Gym", "P"}, {"Business", "B"}};
		String[] departmentname = { "English", "Math", "Science", "Social Studies", "French", "Arts", "Technology", "Gym", "Business"};
		coursesbydepartment = new ArrayList<ArrayList<Generalcourse>>();

		try {
			File file = new File("Courses.csv");
			sc = new Scanner(file); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		while (sc.hasNextLine() == true) {
			String courseinfo = sc.nextLine(); 
			String[] coursedetails = courseinfo.split(",");
			String coursecode = coursedetails[0];
			int x = 1;
			ArrayList<String> prereq = new ArrayList<String>();
			while (x < coursedetails.length) {
				prereq.add(coursedetails[x]);
				x++;
			}
			Generalcourse course = new Generalcourse(coursecode, prereq);
			coursesoffered.add(course);}
		
			sc.close();
			sc = null;

			// Looks through each course and sorts in into it's respective department in the coursesbydepartment list.
			for (int z = 0; z < departmentname.length; z++) {
				int num = 1;
				ArrayList<String> letters = new ArrayList<String>();
				letters.add(fields[z][num]);
				num++;
				while (num < fields[z].length) {
					letters.add(fields[z][num]);
					num++;
				} 
				ArrayList<Generalcourse> coursesindepartment = new ArrayList<Generalcourse>();
				for (int m = 0; m < coursesoffered.size(); m++) {
					for (int n = 0; n < letters.size(); n++) {
						if (coursesoffered.get(m).name.split("")[0].equals(letters.get(n))) { 
							coursesindepartment.add(coursesoffered.get(m));
						}
					}
				}
				coursesbydepartment.add(coursesindepartment);
			} 
		return coursesoffered;
	}
	
	
	// creates teacher objects based on teacher info provided by csv
	public static ArrayList<Teacher> readteachers() {
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		Scanner sc = null;
		//String[][] fields = {{"English", "E"}, {"Math", "M"}, {"Science", "S"}, {"Social Studies", "C", "G", "H", "O", "N"}, {"French", "F"}, {"Arts", "A"}, {"Technology", "T", "I"}, {"Gym", "P"}, {"Business", "B"}};
		String[] departmentname = { "English", "Math", "Science", "Social Studies", "French", "Arts", "Technology", "Gym", "Business"};
		teachersbydepartment  = new ArrayList<ArrayList<Teacher>>();

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
			int teachernum = Integer.parseInt(propertiesofteacher[ 1]);
			String field = propertiesofteacher[2];
			teachers.add(new Teacher(teachername, field, teachernum));
		}
		sc.close();
		sc = null;

		// Looks through the teachers and sorts them into their respective departments
		for (int w = 0; w < departmentname.length; w++) {
			ArrayList<Teacher> teachersindept = new ArrayList<Teacher>();
			for (int u = 0; u < teachers.size(); u++) {
				if (teachers.get(u).qualifiedfield.equals(departmentname[w])) {
					teachersindept.add(teachers.get(u));
				}
			}
			
			teachersbydepartment.add(teachersindept);
		}
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
		
	// creates student objects for all students based on data provided by csv
	public static ArrayList<ArrayList<Student>> readstudents( ArrayList<Generalcourse>  coursesoffered) 
			throws FileNotFoundException { 
		ArrayList<Student> grade9 = new ArrayList<Student>();
		ArrayList<Student> grade10 = new ArrayList<Student>();
		ArrayList<Student> grade11 = new ArrayList<Student>();
		ArrayList<Student> grade12 = new ArrayList<Student>();
		  
		ArrayList<ArrayList<Student> > allstudents =  new ArrayList<ArrayList<Student> >(4);

		allstudents.add(grade9);
		allstudents.add(grade10);
		allstudents.add(grade11);
		allstudents.add(grade12);
		
		File file = new File("students.csv"); 
		Scanner sc = new Scanner(file); 
		  
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
	     
 	  //returns list of all student objects 
	  return allstudents;
	  }
	
	// this method uses the above methods to fill all arraylists
	
	public void fillLists () {
		
		try {
			// extract data from csv and populate list
			coursesoffered = readcourses();
			}
		
		catch (FileNotFoundException e) { 
			e.printStackTrace();
			}
		
		try {
			// extract data from csv and populate list
			allstudents = readstudents(coursesoffered);
			
		// if file not found print errors 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		try {
			// extract data from csv and populate list
			allstudents = readstudents(coursesoffered);
			
		// if file not found print errors 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		// extract data from csv and populate list
		teachers = readteachers();
	}
	
	// this method populates the courses offered data table 
	public void populatecourses () {
		
		DefaultTableModel model = (DefaultTableModel) CoursesOfferedTable.getModel();
		
		// empty the table 
		model.setRowCount(0);
		
		// list of objects to be used to populate table 
		Object rowData[] = new Object[2];
		
		for (int x = 0; x < coursesoffered.size(); x++) {
				
				// fill the table with variables that correspond to the column
				rowData[0] = coursesoffered.get(x).name;
				rowData[1] = coursesoffered.get(x).peopletakingit;
			
				// fill in the row of data then move to next course
				model.addRow(rowData);
				
		}
	}
	
	// this method populates the teacher library data table 
	
	public void populateTeacherLibrary() {
		
		DefaultTableModel model = (DefaultTableModel) TeacherLibraryTable.getModel();
		
		// empty the table 
		model.setRowCount(0);
		
		// list of objects to be used to populate table 
		Object rowData[] = new Object[3];
		
		for (int x = 0; x < teachers.size(); x++) {
				
				// fill the table with variables that correspond to the column
				rowData[0] = teachers.get(x).teachername;
				rowData[1] = teachers.get(x).teachernumber;
				rowData[2] = teachers.get(x).qualifiedfield;		
				// fill in the row of data then move to next course
				model.addRow(rowData);
				
		}
		
	}
	
	public void populateStudentLibrary() {
		
		System.out.println("Adding kids ");
		
		DefaultTableModel model = (DefaultTableModel) StudentLibraryTable.getModel();
		
		// empty the table 
		model.setRowCount(0);
		
		// list of objects to be used to populate table 
		Object rowData[] = new Object[3];
		
		// for all 4 grades fill in all the students 
		for (int j = 0; j < allstudents.size(); j++) {
			System.out.println(allstudents.get(j).size());
			for (int x = 0; x < allstudents.get(j).size(); x++) {
				
				// fill the table with variables that correspond to the column
				// allstudents.whatgrade.aStudentObject
				rowData[0] = allstudents.get(j).get(x).name;
				rowData[1] = allstudents.get(j).get(x).grade;
				rowData[2] = allstudents.get(j).get(x).studentnumber;
				// fill in the row of data then move to next course
				model.addRow(rowData);
				
			}
		}
		
	}
	
	
	public void populateStudentTimetables () {
		
		DefaultTableModel model = (DefaultTableModel) TimetableOutputTable.getModel();
		
		// empty the table 
		model.setRowCount(0);
		
		// list of objects to be used to populate table 
		Object rowData[] = new Object[10];
		
		for (int j = 0; j < allstudents.size(); j++) {
		
		for (int x = 0; x < allstudents.get(j).size(); x++) {
				Student thisstudent= population.answer.students.get(j).get(x);
				generate2 ggg = new generate2();
				//ggg.printtimetable(thisstudent);
				
				// fill the table with variables that correspond to the column
				rowData[0] = thisstudent.name;
				rowData[1] = thisstudent.studentnumber;
				//System.out.println("Timetable " +thisstudent.timetable[0].name);
				try {
					//System.out.println("Timetable " +thisstudent.timetable[0].name);
					rowData[2] = thisstudent.timetable[0].name;
					if (thisstudent.timetable[0].name == null) {
						int kkk1 =  2/0;
					}
				} catch (Exception e) {
					rowData[2] = "Spare";
				}
				try {
					rowData[3] = thisstudent.timetable[1].name;
					if (thisstudent.timetable[1].name == null) {
						int kkk2 =  2/0;
					}
				} catch (Exception e) {
					rowData[3] = "Spare";
				}
				try {
					rowData[4] = thisstudent.timetable[2].name;
					if (thisstudent.timetable[2].name == null) {
						int kkk3 =  2/0;
					}
				} catch (Exception e) {
					rowData[4] = "Spare";
				}
				try {
					rowData[5] = thisstudent.timetable[3].name;
					if (thisstudent.timetable[3].name == null) {
						int kkk4 =  2/0;
					}
				} catch (Exception e) {
					rowData[5] = "Spare";
				}
				try {
					rowData[6] = thisstudent.timetable[4].name;
					if (thisstudent.timetable[4].name == null) {
						int kkk5 =  2/0;
					}
				} catch (Exception e) {
					rowData[6] = "Spare";
				}
				try {
					rowData[7] = thisstudent.timetable[5].name;
					if (thisstudent.timetable[5].name == null) {
						int kkk6 =  2/0;
					}
				} catch (Exception e) {
					rowData[7] = "Spare";
				}
		
				try {
					rowData[8] = thisstudent.timetable[6].name;
					if (thisstudent.timetable[6].name == null) {
						int kkk7 =  2/0;
					}
				} catch (Exception e) {
					rowData[8] = "Spare";
				}
				
				try {
					rowData[9] = thisstudent.timetable[7].name;
					if (thisstudent.timetable[7].name == null) {
						int kkk8 =  2/0;
					}
				} catch (Exception e) {
					rowData[9] = "Spare";
				}
				
				// fill in the row of data then move to next course
				model.addRow(rowData);
				
		}
		}
		
	}
	
	// search for a student name 
	// if a name contains the arrangement of characters it will display to table 
	public ArrayList<Integer> searchContainsName (String name) {
		
		
		// return list of indexes found 
		// must return the grade and index of student together 
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		
		// for all 4 grades fill in all the students 
		for (int j = 0; j < allstudents.size(); j++) {
			for (int x = 0; x < allstudents.get(j).size(); x++) {
				
				// if the characters are present in the name add the grade and student index to the arraylist
				if (allstudents.get(j).get(x).name.strip().toLowerCase().contains(name.strip().toLowerCase())) {
		
					indexes.add(j);	
					indexes.add(x);
				}
			}
		}
		
		if (indexes.size() ==0) {
			JOptionPane.showInternalMessageDialog(null, "Name Not Found, Please Try Again");
		}
		else {
			JOptionPane.showInternalMessageDialog(null, indexes.size()/2 + " Entries found");
		}
		
		return indexes;
	}
	
	public void printIndexesFoundToTable (ArrayList<Integer> indexes) {
		
	DefaultTableModel model = (DefaultTableModel) SearchTable.getModel();
		
		// empty the table 
		model.setRowCount(0);
		
		// list of objects to be used to populate table 
		Object rowData[] = new Object[3];
		
		
		// for all elements in the arraylist 
		for (int x=0; x< indexes.size(); x+= 2) {
				
				// fill the table with variables that correspond to the column
				// allstudents.whatgrade.aStudentObject
				rowData[0] = allstudents.get(indexes.get(x)).get(indexes.get(x+1)).name;
				rowData[1] = allstudents.get(indexes.get(x)).get(indexes.get(x+1)).grade;
				rowData[2] = allstudents.get(indexes.get(x)).get(indexes.get(x+1)).studentnumber;
			
				// fill in the row of data then move to next course
				model.addRow(rowData);
				
		}
				
	}
	
	
	public ArrayList<Integer> searchContainsStudentNumber (String studentNumber){
		
		// return list of indexes found 
		// must return the grade and index of student together 
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		
		// for all 4 grades fill in all the students 
		for (int j = 0; j < allstudents.size(); j++) {
			for (int x = 0; x < allstudents.get(j).size(); x++) {
				
				// if the characters are present in the name add the grade and student index to the arraylist
				if (Integer.toString(allstudents.get(j).get(x).studentnumber).contains(studentNumber.strip() )){
		
					indexes.add(j);	
					indexes.add(x);
				}
			}
		}
		
		if (indexes.size() ==0) {
			JOptionPane.showInternalMessageDialog(null, "Student Number Not Found, Please Try Again");
		}
		else {
			JOptionPane.showInternalMessageDialog(null, indexes.size()/2 + " Entries found");
		}
		
		return indexes;
		
				
	}
	
	
	public void searchByGrade (int grade){
		
		int whattoprint = -1;
		
		if (grade == 9) {
			whattoprint = 0;
		}
		else if (grade == 10) {
			whattoprint = 1;
		}
		else if (grade == 11) {
			whattoprint = 2;
		}
		else if (grade == 12) {			
			whattoprint = 3;
		}
		else {
			JOptionPane.showMessageDialog(null, "Grade Does Not Exist, Please Try Again");			
		}
		
		if (whattoprint != -1) {
			// display to user 
			
			JOptionPane.showInternalMessageDialog(null, allstudents.get(whattoprint).size() + " Entries Found");
			
			DefaultTableModel model = (DefaultTableModel) SearchTable.getModel();
				
				// empty the table 
				model.setRowCount(0);
				
				// list of objects to be used to populate table 
				Object rowData[] = new Object[3];
				
				
				// for all elements in the arraylist 
				for (int x=0; x< allstudents.get(whattoprint).size(); x++) {
						
						// fill the table with variables that correspond to the column
						// allstudents.whatgrade.aStudentObject
						rowData[0] = allstudents.get(whattoprint).get(x).name;
						rowData[1] = allstudents.get(whattoprint).get(x).grade;
						rowData[2] = allstudents.get(whattoprint).get(x).studentnumber;
					
						// fill in the row of data then move to next course
						model.addRow(rowData);				
				}			
		}		
	}
	
	
	// adds student to database 
	public void addstudent(String name, int grade, String studentnumbergiven, String[] chosen, String[] taken, String[] marksgiven) {
        
        ArrayList<Generalcourse> courseschosen = new ArrayList <Generalcourse>();
        ArrayList <Generalcourse> coursestaken = new ArrayList <Generalcourse>();
        ArrayList <Float> marks = new ArrayList <Float>();
        int studentnumber;

        if ("Student Sucessfully Added".equalsIgnoreCase(checkinput(name,grade,studentnumbergiven, chosen, taken, marksgiven))) {
            studentnumber = Integer.parseInt(studentnumbergiven);
            if (taken != null) {
                for (int x = 0; x < taken.length; x++) { 
                    Generalcourse course = checkifoffered(taken[x]);
                    coursestaken.add(course);
                    }
                }
             
            for (int y = 0; y < chosen.length; y++) { 
                Generalcourse course = checkifoffered(chosen[y]);
                courseschosen.add(course);
            }

            if (marksgiven != null) { 
                for (int z = 0; z < marksgiven.length; z++) {
                    boolean isfloat = checkinteger(marksgiven[z]);
                    marks.add(Float.parseFloat(marksgiven[z]));
                } 
            }

            Student student = new Student(name, grade, studentnumber, courseschosen, coursestaken, marks);
            allstudents.get(grade - 9).add(student);
            //write();
            
            // STUDENT HAD BEEN ADDED
            // update student table
			
            JOptionPane.showInternalMessageDialog(null, "Student Sucessfully Added");

        }
        
        else {
        	// student has not been added
            System.out.println("Wrong input cant add");
            JOptionPane.showInternalMessageDialog(null, checkinput(name, grade, studentnumbergiven, chosen, taken, marksgiven));
            
        }

        
    } 

    public static String checkinput(String name,Integer grade, String studentnumbergiven, String[] chosen, String[] taken, String[] marksgiven) {

    	// the name can't be whitespace 
    	if (name.isBlank()) {
    		return "Name field can not be left empty";
    	}
    	
        int studentnumber;
        // check to see if the student number is a number and is unique 
        if (checkinteger(studentnumbergiven)) {
            studentnumber = Integer.parseInt(studentnumbergiven);
            if (checkstudentnumber(studentnumber) == false){ 
                return "The Student Number Already Exists";
            }
        }
        else {
            return "The Student Number must be an integer";
        }
    	
    	// see that they chose 8 courses if in grade 9 10 or 11
    	// you can not elect to have a spare in these grades 
        if (chosen.length != 8 & grade == 9) {
            return "You must choose 8 courses";
        }
        else if (chosen.length != 8 & grade == 10) {
            return "You must choose 8 courses";
        }
        else if (chosen.length != 8 & grade == 11) {
            return "You must choose 8 courses";
        }
        
        
        // check to see that all chosen courses are valid and offered
        for (int y = 0; y < chosen.length; y++) { 
            Generalcourse course = checkifoffered(chosen[y]);
            if (course == null) { 
                return "The course " + chosen[y] + " selected is not offered";
            }
        }
        
        if (taken != null & marksgiven != null) {
        // make sure a mark is provided for every previous course listed 
        //these arrays must be the same length
        if (taken.length != marksgiven.length) {
        	return "A Final Mark Must Be Provided For Each Previously Taken Course Listed";        	
        }        
        }
        
        // check for valid previous courses 
    	if (taken != null) {
            for (int x = 0; x < taken.length; x++) { 
                Generalcourse course = checkifoffered(taken[x]);
                if (course == null) { 
                    //marksgiven[x] = null;
                    System.out.println(taken[x] + " not offered");
                    return "The course " + taken[x] + " is not offered/does not exist";
                }
            }
        }

        if (marksgiven != null) { 
            for (int z = 0; z < marksgiven.length; z++) {
                boolean isfloat = checkinteger(marksgiven[z]);
                if (isfloat == false) { 
                    return "The marks inputted must all be numbers";
                }
            } 
        }


        return "Student Sucessfully Added";
    }
 
    public static  boolean checkstudentnumber(int studentnumbergiven) {
        for (int x = 0; x < allstudents.size(); x++) {
            for (int y = 0; y < allstudents.get(x).size(); y++) {
            	
                if (studentnumbergiven == allstudents.get(x).get(y).studentnumber) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Generalcourse checkifoffered(String coursename) {
        for (int x = 0; x < coursesoffered.size(); x++) {
            if (coursename.strip().equalsIgnoreCase(coursesoffered.get(x).name)) {
                return coursesoffered.get(x);
            }
        }

        return null;
    }
	
	// adds a teacher object	
	public void addTeacher (String nameString, boolean math, boolean english, boolean gym,
			boolean science, boolean socialStudies, boolean technology, boolean frencg,
			boolean arts, boolean Business) {	
		
	}
	
	
	// gets courses from table 	
	public String[] getCoursesTaken (JTable table) {
				
		int num = 0;
		// get how many courses were provided
		for (int i=0; i < table.getRowCount(); i++){
			
			if(table.getValueAt(i, 0) != null  && !(table.getValueAt(i,0).toString().isBlank())) {
				num++;				
			}			
		}
		
		String[] taken = new String[num];
		int ind = 0;
		
		// for every row get the 1st column info and put in table
		for (int i=0; i < table.getRowCount(); i++){
			
			if(table.getValueAt(i, 0) != null  && !(table.getValueAt(i,0).toString().isBlank())) {
				taken[ind] = table.getValueAt(i, 0).toString();	
				ind++;
			}			
		}
		
		return taken;
	}
	
	// get marks given from table 
	public String[] getMarksGiven (JTable table) {
				
		int num = 0;
		// get how many courses were provided
		for (int i=0; i < table.getRowCount(); i++){
			
			if(table.getValueAt(i, 1) != null && !(table.getValueAt(i,1).toString().isBlank())) {
				num++;				
			}			
		}
		
		String[] marksGiven = new String[num];
		int ind = 0;
		
		// for every row get the 1st column info and put in table
		for (int x=0; x < table.getRowCount(); x++){
			
			if(table.getValueAt(x, 1) != null  && !(table.getValueAt(x,1).toString().isBlank())) {
				marksGiven[ind] = table.getValueAt(x, 1).toString();	
				ind++;
			}			
		}
		
		return marksGiven;
	}
	
	
	// BELOW ARE ALL GENETIC ALGORITHM METHODS
	
	public static void setup() { 
		     
	        popmax = 25;
	        mutationRate = 0.07;
	        
	        System.out.println("Creating initial population");
	        
	        // Create a population with a target phrase, mutation rate, and population max
	        population = new Population(mutationRate, popmax);
	}
	
	
	public static void draw() {
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
	        LocalDateTime now = LocalDateTime.now(); 
	        System.out.println("Start:     " + dtf.format(now)); 

	        while (true) { 
	            // calculate fitness via population class 
	            // looks through fitness of whole population to find if there's a perfect masterlist
	            // if there's a perfect masterlist it will return false 
	            boolean run = population.calcFitness();
	            System.out.println(population.read());
	            // Calculate fitness  
	            if (run) {
	                // Generate mating pool
	                population.naturalSelection();
	                //Create next generation
	                population.generate();

	            } 
	            // perfect masterlist found
	             else { 
	                // end
	                break;
	            } 
	    
	            
	        } 

	        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");  
	        LocalDateTime now2 = LocalDateTime.now(); 
	       
	        System.out.println();
		    System.out.println("End:       " + dtf2.format(now2));  

	        // print out runtime info  
	        System.out.println();
	        System.out.println("total generations:     " + population.generations);
	        System.out.println("average fitness:       " + population.getAverageFitness());
	        System.out.println("total population:      " + popmax);
	        System.out.println("mutation rate:         " + (int)(mutationRate * 100));
	        System.out.println();
	        
	        population.generatetimetables();
	    } 
	
	
	
	
	
	
	//Create the application.
	public GUI() {
		initialize();
	}

	
	//Initialize the contents of the frame
	private void initialize() {
		
		// fills arraylists with data from files
		fillLists();
		
		
		// make GUI frames, widgets etc.
		frmStudentSchedulingSystem = new JFrame();
		frmStudentSchedulingSystem.setTitle("Student Scheduling System");
		frmStudentSchedulingSystem.setBounds(100, 100, 1100, 700);
		frmStudentSchedulingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentSchedulingSystem.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		// split the view so buttons are on left and content is right 
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		splitPane.setBorder(null);
		splitPane.setEnabled(false);
		splitPane.setBackground(Color.WHITE);
		
		// set x location for divider
		splitPane.setDividerLocation(300);			
		
		// layered pane to hold all panels and switch between them to display content to user 
		layeredPane = new JLayeredPane();
		
		// right component 
		splitPane.setRightComponent(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		StudentLibraryPanel = new JPanel();
		layeredPane.add(StudentLibraryPanel, "name_1437800945097500");
		
		scrollPane = new JScrollPane();
		
		lblStudentLibrary = new JLabel("Student Library ");
		lblStudentLibrary.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_StudentLibraryPanel = new GroupLayout(StudentLibraryPanel);
		gl_StudentLibraryPanel.setHorizontalGroup(
			gl_StudentLibraryPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_StudentLibraryPanel.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addGroup(gl_StudentLibraryPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_StudentLibraryPanel.createSequentialGroup()
							.addComponent(lblStudentLibrary, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_StudentLibraryPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 762, GroupLayout.PREFERRED_SIZE)
							.addGap(33))))
		);
		gl_StudentLibraryPanel.setVerticalGroup(
			gl_StudentLibraryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_StudentLibraryPanel.createSequentialGroup()
					.addGap(35)
					.addComponent(lblStudentLibrary)
					.addGap(65)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		
		StudentLibraryTable = new JTable();
		StudentLibraryTable.setEnabled(false);
		StudentLibraryTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Name", "Grade", "Student Number"
			}
		));
		StudentLibraryTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		StudentLibraryTable.getColumnModel().getColumn(2).setPreferredWidth(92);
		scrollPane.setViewportView(StudentLibraryTable);
		StudentLibraryPanel.setLayout(gl_StudentLibraryPanel);
		
		// populate student table 
		populateStudentLibrary();
		
		AddAStudentPanelGrade9 = new JPanel();
		layeredPane.add(AddAStudentPanelGrade9, "name_1437804444561200");
		
		JLabel lblWhatGradeIs = new JLabel("Select Grade:");
		lblWhatGradeIs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		// this combobox is on the grade 9 panel 
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"9", "10", "11", "12"}));
		
		// see what grade is selected and perform required alterations to GUI 
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    
		    	// use index of combobox to know what grade was selected
		    	// the first index says 'null', disregard this choice if the user re-selects it 
		    	
		    	if (comboBox.getSelectedIndex() == 0 ) {
		    		// grade 9, already there don't do anything  
		    		System.out.println("already on grade 9");
		    	}
		    	
		    	else if (comboBox.getSelectedIndex() == 1) {
		    		// grade 10
		    		switchPanels(AddAStudentPanelGrade10);
		    	}
		    	
		    	else if (comboBox.getSelectedIndex() == 2) {
		    		// grade 11		
		    		switchPanels(AddAStudentPanelGrade11);
		    	}
		    	
		    	else if (comboBox.getSelectedIndex() == 3) {
		    		// grade 12 
		    		switchPanels(AddAStudentPanelGrade12);
		    	}

		    	
		    }
		});
		
		lblgrade91 = new JLabel("Name:");
		lblgrade91.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblgrade92 = new JLabel("Student Number:");
		lblgrade92.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		nameGrade9TextField = new JTextField();
		nameGrade9TextField.setColumns(10);
		
		studentNumberGrade9TextField = new JTextField();
		studentNumberGrade9TextField.setColumns(10);
		
		lblgrade94 = new JLabel("Select Courses For The Year Below");
		lblgrade94.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblgrade95 = new JLabel("Be Sure Not To Leave Any Blank");
		lblgrade95.setFont(new Font("Tahoma", Font.ITALIC, 20));
		
		lblgrade93 = new JLabel("(Student Number Must Be A Unique Integer)");
		lblgrade93.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		lblgrade96 = new JLabel("Course 1:");
		lblgrade96.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblCourse = new JLabel("Course 2:");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblCourse_1 = new JLabel("Course 3:");
		lblCourse_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblCourse_2 = new JLabel("Course 4:");
		lblCourse_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course1textfieldgrade9 = new JTextField();
		course1textfieldgrade9.setColumns(10);
		
		course2textfieldgrade9 = new JTextField();
		course2textfieldgrade9.setColumns(10);
		
		course3textfieldgrade9 = new JTextField();
		course3textfieldgrade9.setColumns(10);
		
		course4textfieldgrade9 = new JTextField();
		course4textfieldgrade9.setColumns(10);
		
		lblCourse_3 = new JLabel("Course 5:");
		lblCourse_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblCourse_4 = new JLabel("Course 6:");
		lblCourse_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblCourse_5 = new JLabel("Course 7:");
		lblCourse_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblCourse_6 = new JLabel("Course 8:");
		lblCourse_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course5textfieldgrade9 = new JTextField();
		course5textfieldgrade9.setColumns(10);
		
		course6textfieldgrade9 = new JTextField();
		course6textfieldgrade9.setColumns(10);
		
		course7textfieldgrade9 = new JTextField();
		course7textfieldgrade9.setColumns(10);
		
		course8textfieldgrade9 = new JTextField();
		course8textfieldgrade9.setColumns(10);
		
		JButton btnSubmitGrade9 = new JButton("Submit");
		btnSubmitGrade9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] courseschosen = {course1textfieldgrade9.getText(), course2textfieldgrade9.getText(),
				                       						 course3textfieldgrade9.getText(),course4textfieldgrade9.getText(),
				                    						 course5textfieldgrade9.getText(),course6textfieldgrade9.getText(),
				                    						 course7textfieldgrade9.getText(),course8textfieldgrade9.getText()};
				
				
				// ADDING A GRADE 9 STUDENT 
				addstudent(nameGrade9TextField.getText(), 9, studentNumberGrade9TextField.getText(), courseschosen, null, null);
				//change student library table
				populateStudentLibrary();

				
			}
		});
		btnSubmitGrade9.setBackground(new Color(144, 238, 144));
		btnSubmitGrade9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		lblSelectedGrade_1 = new JLabel("Selected Grade: 9");
		lblSelectedGrade_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		GroupLayout gl_AddAStudentPanelGrade9 = new GroupLayout(AddAStudentPanelGrade9);
		gl_AddAStudentPanelGrade9.setHorizontalGroup(
			gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
					.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblgrade94, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
									.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
										.addComponent(lblgrade92, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblgrade91, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
										.addComponent(nameGrade9TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
											.addComponent(studentNumberGrade9TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblgrade93, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
									.addComponent(lblWhatGradeIs, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblSelectedGrade_1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
									.addGap(21))))
						.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
							.addGap(132)
							.addComponent(lblgrade95, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
							.addGap(77)
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblCourse_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCourse_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCourse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblgrade96, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
							.addGap(29)
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
								.addComponent(course1textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(course2textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(course3textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(course4textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(83)
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
									.addComponent(lblCourse_6, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(course8textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
									.addComponent(lblCourse_5, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(course7textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
									.addComponent(lblCourse_4, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(course6textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
									.addComponent(lblCourse_3, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(course5textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(72, Short.MAX_VALUE))
				.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
					.addContainerGap(640, Short.MAX_VALUE)
					.addComponent(btnSubmitGrade9, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
		);
		gl_AddAStudentPanelGrade9.setVerticalGroup(
			gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWhatGradeIs)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectedGrade_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameGrade9TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblgrade91))
					.addGap(18)
					.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblgrade92, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentNumberGrade9TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblgrade93, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addComponent(lblgrade94)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblgrade95, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
						.addComponent(lblgrade96, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.TRAILING)
							.addComponent(course1textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
								.addComponent(course5textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCourse_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course2textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCourse_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course3textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
								.addComponent(course4textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCourse_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_AddAStudentPanelGrade9.createSequentialGroup()
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCourse_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course6textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCourse_5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course7textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade9.createParallelGroup(Alignment.LEADING)
								.addComponent(course8textfieldgrade9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCourse_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addGap(61)
					.addComponent(btnSubmitGrade9)
					.addGap(81))
		);
		AddAStudentPanelGrade9.setLayout(gl_AddAStudentPanelGrade9);
		
		TeacherLibraryPanel = new JPanel();
		layeredPane.add(TeacherLibraryPanel, "name_1454344572019400");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		lblAddATeacher = new JLabel("Add A Teacher:");
		lblAddATeacher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblRemoveATeacher = new JLabel("Remove A Teacher:");
		lblRemoveATeacher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblAreaOfExpertise = new JLabel("Area of Expertise:");
		lblAreaOfExpertise.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.setForeground(new Color(0, 0, 0));
		btnAddTeacher.setBackground(new Color(147, 112, 219));
		btnAddTeacher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblTeacherNumber = new JLabel("Teacher Number:");
		lblTeacherNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		btnRemoveTeacher = new JButton("Remove Teacher");
		btnRemoveTeacher.setBackground(new Color(238, 130, 238));
		btnRemoveTeacher.setForeground(new Color(0, 0, 0));
		btnRemoveTeacher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox chckbxMath = new JCheckBox("Math");
		chckbxMath.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxEnglish = new JCheckBox("English");
		chckbxEnglish.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxScience = new JCheckBox("Science");
		chckbxScience.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxSocialStudies = new JCheckBox("Social Studies");
		chckbxSocialStudies.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxFrench = new JCheckBox("French");
		chckbxFrench.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxArts = new JCheckBox("Arts");
		chckbxArts.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxGym = new JCheckBox("Gym");
		chckbxGym.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxTechnology = new JCheckBox("Technology");
		chckbxTechnology.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxBusiness = new JCheckBox("Business");
		chckbxBusiness.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblTeacherLibrary = new JLabel("Teacher Library");
		lblTeacherLibrary.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_TeacherLibraryPanel = new GroupLayout(TeacherLibraryPanel);
		gl_TeacherLibraryPanel.setHorizontalGroup(
			gl_TeacherLibraryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddATeacher, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 758, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
									.addComponent(lblTeacherLibrary, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
									.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(chckbxGym, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(chckbxTechnology, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnAddTeacher, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
											.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblAreaOfExpertise, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(chckbxBusiness, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())
										.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
											.addGap(178)
											.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblRemoveATeacher, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
													.addComponent(lblTeacherNumber, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(btnRemoveTeacher, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
											.addGap(160))))
								.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
									.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(chckbxEnglish, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addComponent(chckbxMath, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
											.addComponent(chckbxScience, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
											.addGap(50))
										.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
											.addComponent(chckbxSocialStudies, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)))
									.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxFrench, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(chckbxArts, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
									.addGap(461))))))
		);
		gl_TeacherLibraryPanel.setVerticalGroup(
			gl_TeacherLibraryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
					.addGap(35)
					.addComponent(lblTeacherLibrary)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblRemoveATeacher, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAreaOfExpertise, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTeacherNumber, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxMath)
						.addComponent(chckbxScience, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxFrench, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxGym, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxTechnology, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxBusiness, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddTeacher)
						.addComponent(btnRemoveTeacher, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_TeacherLibraryPanel.createSequentialGroup()
					.addGap(396)
					.addComponent(lblAddATeacher)
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addGroup(gl_TeacherLibraryPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxEnglish, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxSocialStudies, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxArts, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(105))
		);
		
		TeacherLibraryTable = new JTable();
		TeacherLibraryTable.setEnabled(false);
		TeacherLibraryTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Teacher's Name", "Teacher Number", "Area Of Expertise "
			}
		));
		TeacherLibraryTable.getColumnModel().getColumn(0).setPreferredWidth(189);
		TeacherLibraryTable.getColumnModel().getColumn(1).setPreferredWidth(103);
		TeacherLibraryTable.getColumnModel().getColumn(2).setPreferredWidth(350);
		scrollPane_1.setViewportView(TeacherLibraryTable);
		TeacherLibraryPanel.setLayout(gl_TeacherLibraryPanel);
		
		// populate teacher library table 
		populateTeacherLibrary();
		
		JPanel CoursesOfferedPanel = new JPanel();
		layeredPane.add(CoursesOfferedPanel, "name_1454610485254400");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_CoursesOfferedPanel = new GroupLayout(CoursesOfferedPanel);
		gl_CoursesOfferedPanel.setHorizontalGroup(
			gl_CoursesOfferedPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_CoursesOfferedPanel.createSequentialGroup()
					.addContainerGap(369, Short.MAX_VALUE)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
		);
		gl_CoursesOfferedPanel.setVerticalGroup(
			gl_CoursesOfferedPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_CoursesOfferedPanel.createSequentialGroup()
					.addGap(21)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 624, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		
		CoursesOfferedTable = new JTable();
		CoursesOfferedTable.setEnabled(false);
		CoursesOfferedTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Course Code", "Number of people enrolled"
			}
		));
		CoursesOfferedTable.getColumnModel().getColumn(0).setPreferredWidth(109);
		CoursesOfferedTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		scrollPane_2.setViewportView(CoursesOfferedTable);
		CoursesOfferedPanel.setLayout(gl_CoursesOfferedPanel);
		
		TimetablePanel = new JPanel();
		layeredPane.add(TimetablePanel, "name_1508986382098200");
		
		btnGenerateTimetables = new JButton("Generate Timetables ");
		btnGenerateTimetables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// big generate button 				
				
				// warn the user that generating can take a long time 
				
				int result = JOptionPane.showConfirmDialog(null, 
						   "Generating Timetables For A New Data Set Can Take Some Time Do You Still Wish To Proceed?"
						,null, JOptionPane.YES_NO_OPTION);
				
				
				// keep going if they say yes
				if(result == JOptionPane.YES_OPTION) {
					setup();
					draw();																																	
							
					// display to user 
					populateStudentTimetables();																				
							
				} 
				
				
				
				
				
			}
		});
		btnGenerateTimetables.setFont(new Font("Arial", Font.PLAIN, 35));
		
		scrollPane_3 = new JScrollPane();
		
		lblTheFollowingWill = new JLabel("The Following Will Generate Timetables For All Students Displayed");
		lblTheFollowingWill.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblInTheStudent = new JLabel("In The Student Library");
		lblInTheStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_TimetablePanel = new GroupLayout(TimetablePanel);
		gl_TimetablePanel.setHorizontalGroup(
			gl_TimetablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TimetablePanel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_TimetablePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_TimetablePanel.createSequentialGroup()
							.addComponent(lblInTheStudent, GroupLayout.PREFERRED_SIZE, 778, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_TimetablePanel.createSequentialGroup()
							.addGroup(gl_TimetablePanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTheFollowingWill, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
								.addComponent(scrollPane_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
							.addGap(30))))
				.addGroup(gl_TimetablePanel.createSequentialGroup()
					.addGap(229)
					.addComponent(btnGenerateTimetables)
					.addContainerGap(239, Short.MAX_VALUE))
		);
		gl_TimetablePanel.setVerticalGroup(
			gl_TimetablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TimetablePanel.createSequentialGroup()
					.addGap(33)
					.addComponent(lblTheFollowingWill)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInTheStudent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnGenerateTimetables, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(129, Short.MAX_VALUE))
		);
		
		TimetableOutputTable = new JTable();
		TimetableOutputTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Name", "Student Number", "S1 Period 1", "S1 Period 2", "S1 Period 3", "S1 Period 4", "S2 Period 1", "S2 Period 2", "S2 Period 3", "S2 Period 4"
			}
		));
		TimetableOutputTable.getColumnModel().getColumn(0).setPreferredWidth(96);
		TimetableOutputTable.getColumnModel().getColumn(1).setPreferredWidth(99);
		scrollPane_3.setViewportView(TimetableOutputTable);
		TimetablePanel.setLayout(gl_TimetablePanel);
		
		SearchStudentContainingPanel = new JPanel();
		layeredPane.add(SearchStudentContainingPanel, "name_1515907022805600");
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		JLabel lblSearchByName = new JLabel("Search By Name:");
		lblSearchByName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblSearchByStudent = new JLabel("Search By Student Number:");
		lblSearchByStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblSearchByGrade = new JLabel("Search By Grade:");
		lblSearchByGrade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		TFSearchName = new JTextField();
		TFSearchName.setColumns(10);
		
		TFStudentNumberSearch = new JTextField();
		TFStudentNumberSearch.setColumns(10);
		
		TFSearchByGrade = new JTextField();
		TFSearchByGrade.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// see if the name is found and print what's found 
				
				ArrayList<Integer> ints = searchContainsName(TFSearchName.getText());
				
				if (ints.size() != 0){
					printIndexesFoundToTable(ints);				
				}
				
				
			}
		});
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Integer> intzArrayList = searchContainsStudentNumber(TFStudentNumberSearch.getText());
				
				if (intzArrayList.size() != 0) {
					printIndexesFoundToTable(intzArrayList);
				}
				
			}
		});
		
		JButton button_1 = new JButton("Search");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				searchByGrade(Integer.valueOf(TFSearchByGrade.getText()));
				}
				catch (Exception h) {
					// TODO: handle exception
					JOptionPane.showInternalMessageDialog(null, "Please Input an Integer");
				}
				
			}
		});
		
		lblInputAValue = new JLabel("Input A Value In The Corrosponding Field To Search Through The Students");
		lblInputAValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_SearchStudentContainingPanel = new GroupLayout(SearchStudentContainingPanel);
		gl_SearchStudentContainingPanel.setHorizontalGroup(
			gl_SearchStudentContainingPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_SearchStudentContainingPanel.createSequentialGroup()
					.addGroup(gl_SearchStudentContainingPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SearchStudentContainingPanel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_SearchStudentContainingPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSearchByGrade, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_SearchStudentContainingPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblInputAValue, GroupLayout.PREFERRED_SIZE, 737, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_SearchStudentContainingPanel.createSequentialGroup()
										.addGroup(gl_SearchStudentContainingPanel.createParallelGroup(Alignment.TRAILING, false)
											.addGroup(Alignment.LEADING, gl_SearchStudentContainingPanel.createSequentialGroup()
												.addComponent(lblSearchByName, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(TFSearchName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(Alignment.LEADING, gl_SearchStudentContainingPanel.createParallelGroup(Alignment.TRAILING)
												.addComponent(TFSearchByGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_SearchStudentContainingPanel.createSequentialGroup()
													.addComponent(lblSearchByStudent, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(TFStudentNumberSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
										.addGap(18)
										.addGroup(gl_SearchStudentContainingPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
											.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
											.addComponent(button, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))))
							.addGap(76))
						.addGroup(gl_SearchStudentContainingPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_SearchStudentContainingPanel.setVerticalGroup(
			gl_SearchStudentContainingPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SearchStudentContainingPanel.createSequentialGroup()
					.addGap(37)
					.addComponent(lblInputAValue)
					.addGap(42)
					.addGroup(gl_SearchStudentContainingPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchByName)
						.addComponent(TFSearchName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addGap(46)
					.addGroup(gl_SearchStudentContainingPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchByStudent, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(TFStudentNumberSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(41)
					.addGroup(gl_SearchStudentContainingPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchByGrade, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(TFSearchByGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addGap(29)
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		
		SearchTable = new JTable();
		SearchTable.setEnabled(false);
		SearchTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Name", "Grade", "Student #", "S1 Period 1", "S1 Period 2", "S1 Period 3", "S1 Period 4", "S2 Period 1", "S2 Period 2", "S2 Period 3", "S2 Period 4"
			}
		));
		SearchTable.getColumnModel().getColumn(0).setResizable(false);
		SearchTable.getColumnModel().getColumn(0).setPreferredWidth(127);
		SearchTable.getColumnModel().getColumn(1).setPreferredWidth(44);
		SearchTable.getColumnModel().getColumn(2).setPreferredWidth(60);
		scrollPane_4.setViewportView(SearchTable);
		SearchStudentContainingPanel.setLayout(gl_SearchStudentContainingPanel);
		
		AddStudentPanel = new JPanel();
		layeredPane.add(AddStudentPanel, "name_1808309867663600");
		
		label_1 = new JLabel("Select Grade:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		// this is the combobox on the initial page before you choose a grade "null page"
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"null", "9", "10", "11", "12"}));
		
		// see what grade is selected and perform required alterations to GUI 
				comboBox_1.addActionListener (new ActionListener () {
				    public void actionPerformed(ActionEvent e) {
				    	
				    	if (comboBox_1.getSelectedIndex() == 0 ) {
				    		// already there don't do anything			   				    		
				    	}
				    	
				    	else if (comboBox_1.getSelectedIndex() == 1) {
				    		// grade 9 
				    		switchPanels(AddAStudentPanelGrade9);						
				    	}
				    	
				    	else if (comboBox_1.getSelectedIndex() == 2) {
				    		// grade 10		
				    		switchPanels(AddAStudentPanelGrade10);				    
				    	}
				    	
				    	else if (comboBox_1.getSelectedIndex() == 3) {
				    		// grade 11
				    		switchPanels(AddAStudentPanelGrade11);				    		
				    	}
				    	
				    	else if (comboBox_1.getSelectedIndex() == 4) {
				    		// grade 12
				    		switchPanels(AddAStudentPanelGrade12);			
				    		System.out.println("doing it");
				    	}				    	
				    }
				});						
		
		GroupLayout gl_AddStudentPanel = new GroupLayout(AddStudentPanel);
		gl_AddStudentPanel.setHorizontalGroup(
			gl_AddStudentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddStudentPanel.createSequentialGroup()
					.addGap(28)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(413, Short.MAX_VALUE))
		);
		gl_AddStudentPanel.setVerticalGroup(
			gl_AddStudentPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 663, Short.MAX_VALUE)
				.addGroup(gl_AddStudentPanel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_AddStudentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(591, Short.MAX_VALUE))
		);
		AddStudentPanel.setLayout(gl_AddStudentPanel);
		
		AddAStudentPanelGrade10 = new JPanel();
		layeredPane.add(AddAStudentPanelGrade10, "name_1810247725582700");
		
		lblProvideAllCourses = new JLabel("Provide all courses previously taken in grade 9 and the final grade recieved");
		lblProvideAllCourses.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		label_4 = new JLabel("Select Grade:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		// this is the combobox on the grade 10 panel
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"10", "9", "11", "12"}));
		
		// see what grade is selected and perform required alterations to GUI 
		comboBox_2.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if (comboBox_2.getSelectedIndex() == 0 ) {
		       		// grade 10, do nothing this is grade 10 panel				   				    		
		    	}
		    	
		    	else if (comboBox_2.getSelectedIndex() == 1) {
		    		// grade 9 
		    		switchPanels(AddAStudentPanelGrade9);						
		    	}
		    	
		    	else if (comboBox_2.getSelectedIndex() == 2) {
		    		// grade 11	    
		    		switchPanels(AddAStudentPanelGrade11);
		    	}
		    	
		    	else if (comboBox_2.getSelectedIndex() == 3) {
		    		// grade 12
		    		switchPanels(AddAStudentPanelGrade12);
		    	}
		    
		    }
		});
			
		
		label_5 = new JLabel("Student Number:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		label_6 = new JLabel("Name:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		TFname10 = new JTextField();
		TFname10.setColumns(10);
		
		TFstudentnumber10 = new JTextField();
		TFstudentnumber10.setColumns(10);
		
		label_7 = new JLabel("(Student Number Must Be A Unique Integer)");
		label_7.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		lblMakeSureAll = new JLabel("Make Sure All Course Codes Are Accurate");
		lblMakeSureAll.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		button_2 = new JButton("Submit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// grade 10 
				
				String[] courseschosen = {course1TextFieldGrade10.getText(), course2TextFieldGrade10.getText(),
  						 course3TextFieldGrade10.getText(),course4TextFieldGrade10.getText(),
						 course5TextFieldGrade10.getText(),course6TextFieldGrade10.getText(),
						 course7TextFieldGrade10.getText(),course8TextFieldGrade10.getText()};
				
				System.out.println(getCoursesTaken(grade10table) );
				String[] a = getCoursesTaken(grade10table);
				for (int x=0; x<a.length; x++) {
					
					System.out.print(a[x]+" ,");
				}
		
				System.out.println(getMarksGiven(grade10table));
				String[] b = getMarksGiven(grade10table);
				for (int x=0; x<b.length; x++) {
					
					System.out.print(b[x]+" ,");
				}
				
				addstudent(TFname10.getText(), 10, TFstudentnumber10.getText(), courseschosen, getCoursesTaken(grade10table), getMarksGiven(grade10table));
				populateStudentLibrary();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_2.setBackground(new Color(144, 238, 144));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		
		JLabel lblIndicateChosenCourses = new JLabel("Indicate Chosen Courses For The Current Year:");
		lblIndicateChosenCourses.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCourse_7 = new JLabel("Course 1");
		lblCourse_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCourse_8 = new JLabel("Course 2");
		lblCourse_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCourse_9 = new JLabel("Course 3");
		lblCourse_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCourse_10 = new JLabel("Course 4");
		lblCourse_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course1TextFieldGrade10 = new JTextField();
		course1TextFieldGrade10.setColumns(10);
		
		course2TextFieldGrade10 = new JTextField();
		course2TextFieldGrade10.setColumns(10);
		
		course3TextFieldGrade10 = new JTextField();
		course3TextFieldGrade10.setColumns(10);
		
		course4TextFieldGrade10 = new JTextField();
		course4TextFieldGrade10.setColumns(10);
		
		JLabel lblCourse_11 = new JLabel("Course 5");
		lblCourse_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCourse_12 = new JLabel("Course 6");
		lblCourse_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCourse_13 = new JLabel("Course 7");
		lblCourse_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCourse_14 = new JLabel("Course 8");
		lblCourse_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course5TextFieldGrade10 = new JTextField();
		course5TextFieldGrade10.setColumns(10);
		
		course6TextFieldGrade10 = new JTextField();
		course6TextFieldGrade10.setColumns(10);
		
		course7TextFieldGrade10 = new JTextField();
		course7TextFieldGrade10.setColumns(10);
		
		course8TextFieldGrade10 = new JTextField();
		course8TextFieldGrade10.setColumns(10);
		
		lblSelectedGrade = new JLabel("Selected Grade: 10");
		lblSelectedGrade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_AddAStudentPanelGrade10 = new GroupLayout(AddAStudentPanelGrade10);
		gl_AddAStudentPanelGrade10.setHorizontalGroup(
			gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
							.addComponent(lblCourse_10, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(course4TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
										.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
											.addComponent(lblMakeSureAll, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())
										.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
											.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
													.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
													.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
														.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
														.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
														.addComponent(TFname10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.TRAILING)
															.addComponent(lblSelectedGrade)
															.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
																.addComponent(TFstudentnumber10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)))))
												.addComponent(lblProvideAllCourses, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE))
											.addContainerGap(25, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
									.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.TRAILING)
										.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblIndicateChosenCourses, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE))
									.addContainerGap()))
							.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
								.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
										.addComponent(lblCourse_7, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course1TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
										.addComponent(lblCourse_8, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course2TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
										.addComponent(lblCourse_9, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course3TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(61)
								.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
										.addComponent(lblCourse_13, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course7TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
										.addComponent(lblCourse_12, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course6TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
										.addComponent(lblCourse_11, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course5TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
										.addComponent(lblCourse_14, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course8TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(335)))))
		);
		gl_AddAStudentPanelGrade10.setVerticalGroup(
			gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectedGrade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFname10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addGap(18)
					.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(TFstudentnumber10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblProvideAllCourses)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMakeSureAll, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblIndicateChosenCourses, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
							.addComponent(lblCourse_7)
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCourse_8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course2TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCourse_9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course3TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_AddAStudentPanelGrade10.createSequentialGroup()
							.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblCourse_11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(course5TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(course1TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCourse_12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course6TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCourse_13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course7TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCourse_10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(course4TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AddAStudentPanelGrade10.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCourse_14, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(course8TextFieldGrade10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addComponent(button_2)
					.addGap(40))
		);
		
		grade10table = new JTable();
		grade10table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Course Code", "Grade"
			}
		));
		scrollPane_5.setViewportView(grade10table);
		AddAStudentPanelGrade10.setLayout(gl_AddAStudentPanelGrade10);
		
		AddAStudentPanelGrade11 = new JPanel();
		layeredPane.add(AddAStudentPanelGrade11, "name_1811375371777100");
		
		lblSelectedGrade_2 = new JLabel("Selected Grade: 11");
		lblSelectedGrade_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		button_3 = new JButton("Submit");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] courseschosen = {course1textfieldgrade11.getText(), course2textfieldgrade11.getText(),
 						 course3textfieldgrade11.getText(),course4textfieldgrade11.getText(),
						 course5textfieldgrade11.getText(),course6textfieldgrade11.getText(),
						 course7textfieldgrade11.getText(),course8textfieldgrade11.getText()};
				
				System.out.println(getCoursesTaken(grade11table) );
				String[] a = getCoursesTaken(grade11table);
				for (int x=0; x<a.length; x++) {
					
					System.out.print(a[x]+" ,");
				}
		
				System.out.println(getMarksGiven(grade11table));
				String[] b = getMarksGiven(grade11table);
				for (int x=0; x<b.length; x++) {
					
					System.out.print(b[x]+" ,");
				}
				
				addstudent(TFnamegrade11.getText(), 11, TFstudentnumbergrade11.getText(), courseschosen, getCoursesTaken(grade11table), getMarksGiven(grade11table));
				populateStudentLibrary();
				
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_3.setBackground(new Color(144, 238, 144));
		
		label_2 = new JLabel("Course 4");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course4textfieldgrade11 = new JTextField();
		course4textfieldgrade11.setColumns(10);
		
		label_8 = new JLabel("Indicate Chosen Courses For The Current Year:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		scrollPane_6 = new JScrollPane();
		
		label_9 = new JLabel("Make Sure All Course Codes Are Accurate");
		label_9.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		label_10 = new JLabel("Select Grade:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		// grade 11 combobox 
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"11", "9", "10", "12"}));
		
		// see what grade is selected and perform required alterations to GUI 
		comboBox_3.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if (comboBox_3.getSelectedIndex() == 0 ) {
		       		// grade 11, do nothing this is grade 11 panel				   				    		
		    	}
		    	
		    	else if (comboBox_3.getSelectedIndex() == 1) {
		    		// grade 9 
		    		switchPanels(AddAStudentPanelGrade9);						
		    	}
		    	
		    	else if (comboBox_3.getSelectedIndex() == 2) {
		    		// grade 10	    
		    		switchPanels(AddAStudentPanelGrade10);
		    	}
		    	
		    	else if (comboBox_3.getSelectedIndex() == 3) {
		    		// grade 12
		    		switchPanels(AddAStudentPanelGrade12);
		    	}
		    
		    }
		});
		
		label_11 = new JLabel("Student Number:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		label_12 = new JLabel("Name:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		TFnamegrade11 = new JTextField();
		TFnamegrade11.setColumns(10);
		
		TFstudentnumbergrade11 = new JTextField();
		TFstudentnumbergrade11.setColumns(10);
		
		label_13 = new JLabel("(Student Number Must Be A Unique Integer)");
		label_13.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		lblProvideAllCourses_1 = new JLabel("Provide all courses previously taken in grade 9 and 10 and the final grade recieved");
		lblProvideAllCourses_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		label_15 = new JLabel("Course 1");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course1textfieldgrade11 = new JTextField();
		course1textfieldgrade11.setColumns(10);
		
		label_16 = new JLabel("Course 2");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course2textfieldgrade11 = new JTextField();
		course2textfieldgrade11.setColumns(10);
		
		label_17 = new JLabel("Course 3");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course3textfieldgrade11 = new JTextField();
		course3textfieldgrade11.setColumns(10);
		
		label_18 = new JLabel("Course 7");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course7textfieldgrade11 = new JTextField();
		course7textfieldgrade11.setColumns(10);
		
		label_19 = new JLabel("Course 6");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course6textfieldgrade11 = new JTextField();
		course6textfieldgrade11.setColumns(10);
		
		label_20 = new JLabel("Course 5");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course5textfieldgrade11 = new JTextField();
		course5textfieldgrade11.setColumns(10);
		
		label_21 = new JLabel("Course 8");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course8textfieldgrade11 = new JTextField();
		course8textfieldgrade11.setColumns(10);
		GroupLayout gl_AddAStudentPanelGrade11 = new GroupLayout(AddAStudentPanelGrade11);
		gl_AddAStudentPanelGrade11.setHorizontalGroup(
			gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(course4textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
										.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
											.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())
										.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
											.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
													.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
													.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
														.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
														.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
														.addComponent(TFnamegrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.TRAILING)
															.addComponent(lblSelectedGrade_2)
															.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
																.addComponent(TFstudentnumbergrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)))))
												.addComponent(lblProvideAllCourses_1, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE))
											.addContainerGap(25, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
									.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.TRAILING)
										.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE))
									.addContainerGap()))
							.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
								.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
										.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course1textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
										.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course2textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
										.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course3textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(61)
								.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
										.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course7textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
										.addComponent(label_19, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course6textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
										.addComponent(label_20, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course5textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
										.addComponent(label_21, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course8textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(335)))))
		);
		gl_AddAStudentPanelGrade11.setVerticalGroup(
			gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_10)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectedGrade_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFnamegrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_12))
					.addGap(18)
					.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(TFstudentnumbergrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblProvideAllCourses_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
							.addComponent(label_15)
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course2textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course3textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_AddAStudentPanelGrade11.createSequentialGroup()
							.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_20, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(course5textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(course1textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_19, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course6textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course7textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(course4textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AddAStudentPanelGrade11.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_21, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(course8textfieldgrade11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addComponent(button_3)
					.addGap(44))
		);
		
		grade11table = new JTable();
		grade11table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Course Code", "Grade"
			}
		));
		scrollPane_6.setViewportView(grade11table);
		AddAStudentPanelGrade11.setLayout(gl_AddAStudentPanelGrade11);
		
		AddAStudentPanelGrade12 = new JPanel();
		layeredPane.add(AddAStudentPanelGrade12, "name_1811537641936200");
		
		lblSelectedGrade_3 = new JLabel("Selected Grade: 12");
		lblSelectedGrade_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		button_4 = new JButton("Submit");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] courseschosen = {course1textfieldgrade12.getText(), course2textfieldgrade12.getText(),
  						 course3textfieldgrade12.getText(), course4textfieldgrade12.getText(),
						 course5textfieldgrade12.getText(),course6textfieldgrade12.getText(),
						 course7textfieldgrade12.getText(),course8textfieldgrade12.getText()};
				
				System.out.println(getCoursesTaken(grade12table) );
				String[] a = getCoursesTaken(grade12table);
				for (int x=0; x<a.length; x++) {
					
					System.out.print(a[x]+" ,");
				}
		
				System.out.println(getMarksGiven(grade12table));
				String[] b = getMarksGiven(grade12table);
				for (int x=0; x<b.length; x++) {
					
					System.out.print(b[x]+" ,");
				}
				
				addstudent(TFnamegrade12.getText(), 12, TFstudentnumbergrade12.getText(), courseschosen, getCoursesTaken(grade12table), getMarksGiven(grade12table));
				populateStudentLibrary();
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_4.setBackground(new Color(144, 238, 144));
		
		label_14 = new JLabel("Course 4");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course4textfieldgrade12 = new JTextField();
		course4textfieldgrade12.setColumns(10);
		
		label_22 = new JLabel("Indicate Chosen Courses For The Current Year:");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		scrollPane_7 = new JScrollPane();
		
		label_23 = new JLabel("Make Sure All Course Codes Are Accurate");
		label_23.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		label_24 = new JLabel("Select Grade:");
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		// grade 12 combobox panel 
		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"12", "9", "10", "11"}));
		
		// see what grade is selected and perform required alterations to GUI 
		comboBox_5.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if (comboBox_5.getSelectedIndex() == 0 ) {
		       		// grade 12, do nothing this is grade 12 panel				   				    		
		    	}
		    	
		    	else if (comboBox_5.getSelectedIndex() == 1) {
		    		// grade 9 
		    		switchPanels(AddAStudentPanelGrade9);						
		    	}
		    	
		    	else if (comboBox_5.getSelectedIndex() == 2) {
		    		// grade 10
		    		switchPanels(AddAStudentPanelGrade10);
		    	}
		    	
		    	else if (comboBox_5.getSelectedIndex() == 3) {
		    		// grade 11
		    		switchPanels(AddAStudentPanelGrade11);
		    	}
		    
		    }
		});
		
		
		label_25 = new JLabel("Student Number:");
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		label_26 = new JLabel("Name:");
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		TFnamegrade12 = new JTextField();
		TFnamegrade12.setColumns(10);
		
		TFstudentnumbergrade12 = new JTextField();
		TFstudentnumbergrade12.setColumns(10);
		
		label_27 = new JLabel("(Student Number Must Be A Unique Integer)");
		label_27.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		lblProvideAllCourses_2 = new JLabel("Provide all courses previously taken in grade 9, 10 and 11 and the final grade recieved");
		lblProvideAllCourses_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		label_29 = new JLabel("Course 1");
		label_29.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course1textfieldgrade12 = new JTextField();
		course1textfieldgrade12.setColumns(10);
		
		label_30 = new JLabel("Course 2");
		label_30.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course2textfieldgrade12 = new JTextField();
		course2textfieldgrade12.setColumns(10);
		
		label_31 = new JLabel("Course 3");
		label_31.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course3textfieldgrade12 = new JTextField();
		course3textfieldgrade12.setColumns(10);
		
		label_32 = new JLabel("Course 7");
		label_32.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course7textfieldgrade12 = new JTextField();
		course7textfieldgrade12.setColumns(10);
		
		label_33 = new JLabel("Course 6");
		label_33.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course6textfieldgrade12 = new JTextField();
		course6textfieldgrade12.setColumns(10);
		
		label_34 = new JLabel("Course 5");
		label_34.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course5textfieldgrade12 = new JTextField();
		course5textfieldgrade12.setColumns(10);
		
		label_35 = new JLabel("Course 8");
		label_35.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		course8textfieldgrade12 = new JTextField();
		course8textfieldgrade12.setColumns(10);
		GroupLayout gl_AddAStudentPanelGrade12 = new GroupLayout(AddAStudentPanelGrade12);
		gl_AddAStudentPanelGrade12.setHorizontalGroup(
			gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
							.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(course4textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
										.addComponent(scrollPane_7, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
											.addComponent(label_23, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())
										.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
											.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
													.addComponent(label_24, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
													.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
														.addComponent(label_25, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
														.addComponent(label_26, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
														.addComponent(TFnamegrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.TRAILING)
															.addComponent(lblSelectedGrade_3)
															.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
																.addComponent(TFstudentnumbergrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(label_27, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)))))
												.addComponent(lblProvideAllCourses_2, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE))
											.addContainerGap(25, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
									.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.TRAILING)
										.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_22, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE))
									.addContainerGap()))
							.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
								.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
										.addComponent(label_29, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course1textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
										.addComponent(label_30, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course2textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
										.addComponent(label_31, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course3textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(61)
								.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
										.addComponent(label_32, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course7textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
										.addComponent(label_33, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course6textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
										.addComponent(label_34, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course5textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
										.addComponent(label_35, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(course8textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(335)))))
		);
		gl_AddAStudentPanelGrade12.setVerticalGroup(
			gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_24)
						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectedGrade_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.BASELINE)
						.addComponent(TFnamegrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_26))
					.addGap(18)
					.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_25, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(TFstudentnumbergrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_27, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblProvideAllCourses_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_23, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_7, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_22, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
							.addComponent(label_29)
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_30, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course2textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_31, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course3textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_AddAStudentPanelGrade12.createSequentialGroup()
							.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_34, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(course5textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(course1textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_33, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course6textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_32, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(course7textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(course4textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AddAStudentPanelGrade12.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_35, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(course8textfieldgrade12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(button_4)
					.addGap(38))
		);
		
		grade12table = new JTable();
		grade12table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Course Code", "Grade"
			}
		));
		scrollPane_7.setViewportView(grade12table);
		AddAStudentPanelGrade12.setLayout(gl_AddAStudentPanelGrade12);
		
		// fill up courses offered table 
		populatecourses();
		
		// panel to hold all buttons 
		panelofbuttons = new JPanel();
		panelofbuttons.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panelofbuttons.setBorder(new LineBorder(new Color(51, 153, 255), 5));
		// set blue background color
		panelofbuttons.setBackground(Color.decode("#5DADE2"));
		panelofbuttons.setForeground(Color.WHITE);
		
		// left component 
		splitPane.setLeftComponent(panelofbuttons);
		
		btnStudentLibrary = new JButton("Student Library");
		btnStudentLibrary.setIcon(new ImageIcon(GUI.class.getResource("/summative/apple.png")));
		btnStudentLibrary.setForeground(new Color(255, 255, 255));
		btnStudentLibrary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStudentLibrary.setBackground(Color.decode("#5DADE2"));
		btnStudentLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// switch the panels 
				switchPanels(StudentLibraryPanel);
				
				// change colors of button 
				switchButtonColors(btnStudentLibrary);
			}
		});
		
		btnAddAStudent = new JButton("Add A Student");
		btnAddAStudent.setIcon(new ImageIcon(GUI.class.getResource("/summative/studenticon.png")));
		btnAddAStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddAStudent.setForeground(new Color(255, 255, 255));
		btnAddAStudent.setBackground(Color.decode("#5DADE2"));
		btnAddAStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// switch the panels 
				switchPanels(AddStudentPanel);
				
				// change colors of button
				switchButtonColors(btnAddAStudent);
			}
		});
		
		btnTimetableGenerator = new JButton("Timetable Maker");
		btnTimetableGenerator.setIcon(new ImageIcon(GUI.class.getResource("/summative/timeicon.png")));
		btnTimetableGenerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(TimetablePanel);
				
				switchButtonColors(btnTimetableGenerator);
			}
		});
		btnTimetableGenerator.setForeground(new Color(255, 255, 255));
		btnTimetableGenerator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTimetableGenerator.setBackground(Color.decode("#5DADE2"));
		
		btnSearchStudent = new JButton("Search");
		btnSearchStudent.setIcon(new ImageIcon(GUI.class.getResource("/summative/searchicon.png")));
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(SearchStudentContainingPanel);
				switchButtonColors(btnSearchStudent);
			}
		});
		btnSearchStudent.setForeground(new Color(255, 255, 255));
		btnSearchStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchStudent.setBackground(Color.decode("#5DADE2"));
		
		lblStudent = new JLabel("Student");
		lblStudent.setForeground(new Color(255, 255, 255));
		lblStudent.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		
		lblScheduling = new JLabel("Scheduling System");
		lblScheduling.setForeground(new Color(255, 255, 255));
		lblScheduling.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		
		lblNewLabel = new JLabel("──────────────────────────────────");
		lblNewLabel.setForeground(new Color(0, 153, 204));
		
		btnTeacherLibrary = new JButton("Teacher Library");
		btnTeacherLibrary.setIcon(new ImageIcon(GUI.class.getResource("/summative/teacherlibraryicon.png")));
		btnTeacherLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(TeacherLibraryPanel);
				switchButtonColors(btnTeacherLibrary);
			}
		});
		btnTeacherLibrary.setForeground(Color.WHITE);
		btnTeacherLibrary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTeacherLibrary.setBackground(new Color(93, 173, 226));
		
		btnCoursesOfferedLibrary = new JButton("Courses Offered");
		btnCoursesOfferedLibrary.setIcon(new ImageIcon(GUI.class.getResource("/summative/courselibraryicon.png")));
		btnCoursesOfferedLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(CoursesOfferedPanel);
				switchButtonColors(btnCoursesOfferedLibrary);
			}
		});
		btnCoursesOfferedLibrary.setForeground(Color.WHITE);
		btnCoursesOfferedLibrary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCoursesOfferedLibrary.setBackground(new Color(93, 173, 226));
		GroupLayout gl_panelofbuttons = new GroupLayout(panelofbuttons);
		gl_panelofbuttons.setHorizontalGroup(
			gl_panelofbuttons.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelofbuttons.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelofbuttons.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelofbuttons.createSequentialGroup()
							.addGroup(gl_panelofbuttons.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStudent, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblScheduling, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 220, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelofbuttons.createSequentialGroup()
							.addComponent(btnStudentLibrary, GroupLayout.PREFERRED_SIZE, 211, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(Alignment.TRAILING, gl_panelofbuttons.createSequentialGroup()
							.addComponent(btnTeacherLibrary, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panelofbuttons.createSequentialGroup()
							.addComponent(btnSearchStudent, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(Alignment.TRAILING, gl_panelofbuttons.createSequentialGroup()
							.addComponent(btnAddAStudent, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(Alignment.TRAILING, gl_panelofbuttons.createSequentialGroup()
							.addComponent(btnCoursesOfferedLibrary, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(gl_panelofbuttons.createSequentialGroup()
							.addComponent(btnTimetableGenerator, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
							.addGap(19))))
		);
		gl_panelofbuttons.setVerticalGroup(
			gl_panelofbuttons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelofbuttons.createSequentialGroup()
					.addGap(18)
					.addComponent(lblStudent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblScheduling, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addGap(27)
					.addComponent(btnStudentLibrary, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnTeacherLibrary, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCoursesOfferedLibrary, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(btnAddAStudent, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnTimetableGenerator, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSearchStudent, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(153, Short.MAX_VALUE))
		);
		panelofbuttons.setLayout(gl_panelofbuttons);
		splitPane.setDividerLocation(250);
		frmStudentSchedulingSystem.getContentPane().add(splitPane);
	
		
		
		
	}
}
