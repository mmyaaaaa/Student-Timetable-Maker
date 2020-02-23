package summative;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Random;
import java.util.Scanner;

public class generate2 implements Serializable { 
 ArrayList<Generalcourse> coursesoffered;
 ArrayList<ArrayList<Student>> allstudents;
 ArrayList<ArrayList<Specificcourse>> masterlist;
 ArrayList<ArrayList<Generalcourse>> coursesbydepartment;
 ArrayList<ArrayList<Teacher>> teachersbydepartment;
 ArrayList<Student> numberofstudentswitherrors;
 ArrayList<error> errors  = new ArrayList<error>();
 String[][] fields = {{"English", "E"}, {"Math", "M"}, {"Science", "S"}, {"Social Studies", "C", "G", "H", "O", "N"}, {"French", "F"}, {"Arts", "A"}, {"Technology", "T", "I"}, {"Gym", "P"}, {"Business", "B"}};

	public generate2() {
		readcourses();
		readstudents();
	}

	public void main(String[] args) { 
    }

    public void make() { 
		readcourses();
		readstudents();
		readteachers();
		masterlist = new ArrayList<ArrayList<Specificcourse>>();
		errors = new ArrayList<error>();

		for (int x = 0; x < allstudents.size(); x++) {
			for (int y = 0; y < allstudents.get(x).size(); y++) { 
				if (allstudents.get(x).get(y).courseschosen.size() != 8) {
					System.out.println("Less than 8 Chosen: " + allstudents.get(x).get(y).name);
				}

				if (allstudents.get(x).get(y).coursestaken.size() != (x * 8)) {
					if (allstudents.get(x).get(y).grade != 12) { 
						System.out.println("x: " + x);
						System.out.println("y: " + y);
						System.out.println("Wrong number taken: " + allstudents.get(x).get(y).name);
						System.out.println("Size: " + allstudents.get(x).get(y).coursestaken.size());
						for (int i = 0; i < allstudents.get(x).get(y).coursestaken.size(); i++) {
							System.out.println(allstudents.get(x).get(y).coursestaken.get(i).name);
						}
						System.out.println();
					}
				} 
		}
	}
	
	for (int c = 0; c < allstudents.size(); c++) {
		for (int d = 0; d < allstudents.get(c).size(); d++) {
			Student student = allstudents.get(c).get(d);
			for (int t = 0; t < student.courseschosen.size(); t++) {
				for (int y = 0; y < student.courseschosen.size(); y++) {
					if (t == y) {
						continue;
					}
					else if (student.courseschosen.get(t).equals(student.courseschosen.get(y))) {
						System.out.println(student.name);
						System.out.println(student.courseschosen.get(t).name);
						System.out.println();
					}
				}
			}
		}
	}

		for (int z = 0; z < teachersbydepartment.size(); z++) {
			for (int p = 0; p <teachersbydepartment.get(z).size(); p++) { 
				if (teachersbydepartment.get(z).get(p).teachername == null) {
					System.out.println("No name: " + (z + 1));
				}
			}
		} 

		//System.out.println(coursesoffered.get(6).prereq.size());
        generatetimetable(true);
        /* 
		for (int y = 0; y < 8; y++) {
			System.out.println("Period " + (y + 1) + ": " + masterlist.get(y).size());
        } 
         */
		//System.out.println(masterlist.get(5).get(2).name);
		 
		int prereqerrors = 0;
		for (int o = 0; o < errors.size(); o++) {
			for (int t = 0; t < errors.get(o).typeoferror.size(); t++) {
				if (errors.get(o).typeoferror.get(t).contains("Missing")) { 
					//System.out.println(errors.get(o).student.name);
					prereqerrors++;
					break;
				}
			}
			
		}
		//System.out.println("prereq erros: " + prereqerrors);
		int errorcheck = 0;
		for (int e = 0; e < allstudents.size(); e++) {
			for (int p = 0; p < allstudents.get(e).size(); p++) {
				for (int d = 0; d < allstudents.get(e).get(p).timetable.length; d++) { 
					if (allstudents.get(e).get(p).timetable[d] == null) {
						errorcheck++;
						break;
					}
				}
			}
		}
		
		//System.out.println("Done Ba Da Boom.");
		
	}

	public void printtimetable(Student student) {
		for (int x = 0; x < 8; x++) {
			if (student.timetable[x] == null) {
				System.out.println("null");
			}
			else { 
				System.out.println(student.timetable[x].name);
			}
		}
		System.out.println();
	}
 
	
	public void addstudent(String name, int grade, String studentnumbergiven, String[] chosen, String[] taken, String[] marksgiven) {
		 
		ArrayList<Generalcourse> courseschosen = new ArrayList <Generalcourse>();
		ArrayList <Generalcourse> coursestaken = new ArrayList <Generalcourse>();
		ArrayList <Float> marks = new ArrayList <Float>();
		int studentnumber;

		if (checkinput(studentnumbergiven, chosen, taken, marksgiven)) {
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

			for (int x = 0; x < courseschosen.size(); x++) {
				Generalcourse course = courseschosen.get(x);
				if (course.prereq.size() != 0) { 
					for (int i = 0; i < course.prereq.size(); i++) {
						for(int h = 0; h < coursestaken.size(); h++){ 
							if(coursestaken.get(h).name.equals(course.prereq.get(i))){ 
								if(marks.get(h) >= 50){
									Student student = new Student(name, grade, studentnumber, courseschosen, coursestaken, marks);
									allstudents.get(grade - 9).add(student);
									write(masterlist);
								}
								else {
									System.out.println("prereq error");
								}
							}
							else {
								System.out.println("prereq error");
							}
						}
					} 
				}
			} 
		}
	 
		else {
			System.out.println("Wrong input cant add");
		}

		
 
	} 

	public boolean checkinput(String studentnumbergiven, String[] chosen, String[] taken, String[] marksgiven) {
		if (taken != null) {
			for (int x = 0; x < taken.length; x++) { 
				Generalcourse course = checkifoffered(taken[x]);
				if (course == null) { 
					//marksgiven[x] = null;
					System.out.println(taken[x] + " not offered");
					return false;
				} 
			}
		}

		if (chosen.length != 8) {
			return false;
		}

		for (int y = 0; y < chosen.length; y++) { 
			Generalcourse course = checkifoffered(chosen[y]);
			if (course == null) { 
				return false;
			}
		}

		if (marksgiven != null) { 
			for (int z = 0; z < marksgiven.length; z++) {
				boolean isfloat = checkinteger(marksgiven[z]);
				if (isfloat == false) { 
					return false;
				}
			} 
		}

		int studentnumber = 0;
		if (checkinteger(studentnumbergiven)) {
			studentnumber = Integer.parseInt(studentnumbergiven);
			if (checkstudentnumber(studentnumber) == false){ 
				return false;
			}
		}
		else {
			return false;
		}
		return true;
	}
 
	public boolean checkstudentnumber(int studentnumbergiven) {
		for (int x = 0; x < allstudents.size(); x++) {
			for (int y = 0; y < allstudents.get(y).size(); y++) {
				if (studentnumbergiven == allstudents.get(x).get(y).studentnumber) {
					return false;
				}
			}
		}
		return true;
	}

	public Generalcourse checkifoffered(String coursename) {
		for (int x = 0; x < coursesoffered.size(); x++) {
			if (coursename.strip().equalsIgnoreCase(coursesoffered.get(x).name)) {
				return coursesoffered.get(x);
			}
		}

		return null;
	}

	public void generatetimetable(boolean generate) {
		String[][] fields = {{"English", "E"}, {"Math", "M"}, {"Science", "S"}, {"Social Studies", "C", "G", "H", "O", "N"}, {"French", "F"}, {"Arts", "A"}, {"Technology", "T", "I"}, {"Gym", "P"}, {"Business", "B"}};
		String[] departmentname = { "English", "Math", "Science", "Social Studies", "French", "Arts", "Technology", "Gym", "Business"};
		
		if (generate == true) { 
			// Figure out how many people are taking the course and how many classes are needed
			for (int x = 0; x < coursesoffered.size(); x++) {
				int peopletakingit = coursesoffered.get(x).peopletakingit;
				int classesneeded = peopletakingit / 20;
				int remainder = peopletakingit % 20;
				if (remainder >= 5) {
					classesneeded++;
				}
				coursesoffered.get(x).classesneeded = classesneeded;
			} 

			// Counts how many classes per department are run and then how many teachers per department are available.
			for (int h = 0; h < coursesbydepartment.size(); h++) {
				int departmentclasses = 0;
				for (int o = 0; o < coursesbydepartment.get(h).size(); o++) {
					departmentclasses = departmentclasses + coursesbydepartment.get(h).get(o).classesneeded;
				}
				//System.out.println(departmentname[h] + ": " + departmentclasses + " classes");
			}

			for (int p = 0; p < 8; p++) { 
				ArrayList<Specificcourse> period = new ArrayList<Specificcourse>(); 
				masterlist.add(period);
			}
			
			for (int g = 0; g < departmentname.length; g++) { 	
				//System.out.println(departmentname[g]);	
                int index = 0;
                //int index2 = 0;
				for (int e = 0; e < coursesbydepartment.get(g).size(); e++) {
				    coursesbydepartment.get(g).get(e).makespecificcourses(); 
                    
					for (int x = 0; x < coursesbydepartment.get(g).get(e).all.size(); x++) {
						
						Teacher thisteacher = teachersbydepartment.get(g).get(index);
						//System.out.println("Index: " + index);
							
							//System.out.println("Free spots: " + freespots[0] + freespots[1] + freespots[2] + freespots[3] + freespots[4] + freespots[5] + freespots[6] + freespots[7]);
							
						while (thisteacher.checkfreespot() == false) {
							//System.out.println(thisteacher.teachername);
							index++;
							thisteacher = teachersbydepartment.get(g).get(index);
							//System.out.println(departmentname[g]);
							
                        } 
						int freespot = thisteacher.getfreespot();
						//System.out.println(freespot);
						//System.out.println(coursesbydepartment.get(g).get(e).all.size());
						//System.out.println(coursesbydepartment.get(g).get(e).all.get(x).name);
						thisteacher.timetable[freespot] = coursesbydepartment.get(g).get(e).all.get(x).name;
						coursesbydepartment.get(g).get(e).all.get(x).teacher = thisteacher;
						coursesbydepartment.get(g).get(e).all.get(x).timeslot = freespot;
                        masterlist.get(freespot).add(coursesbydepartment.get(g).get(e).all.get(x));
                        //index2++;
                        /*if (index2 == 8) {
                            index2 = 0;
                        }*/
					} 
				}
            }
            
			 

			
	 
			//System.out.println(errors.size());
			//write();
    }
}
    // if generate timetables is false just flood the students in 
    public void fillstudents(ArrayList<ArrayList<Specificcourse>> newtimetable, boolean readstudents) {
		readcourses();
		//errors.clear();
		//readstudents();

		if (readstudents) {
			//readstudents();
			masterlist = newtimetable;
			errors = new ArrayList<error>();
			//System.out.println("errors strt: " + errors.size());
		}	
			ArrayList<Student> errorstudent = new ArrayList<Student>();
			ArrayList<Generalcourse> errorcourse = new ArrayList<Generalcourse>();

			//System.out.println(allstudents.get(0).get(25).courseschosen.get(3).all.get(2).name);
			// u is grade
			for (int u = 0; u < allstudents.size(); u++) {
				// r is number of student in grade
				for (int r = 0; r < allstudents.get(u).size(); r++) {
					Student student =  allstudents.get(u).get(r);
					// w is courses chosen by the student
					for (int w = 0; w < student.courseschosen.size(); w++) {
						String letter = student.courseschosen.get(w).name.split("")[0];
						
							//System.out.println("no issues");
							if (letter.equals(fields[0][1]) || letter.equals(fields[1][1]) || letter.equals(fields[2][1])) {
								if(student.checkprereq(student.courseschosen.get(w)) == true){
								Generalcourse coursetoassign = student.courseschosen.get(w);
								ArrayList<Specificcourse> availableslots = new ArrayList<Specificcourse>();
								// t is the specific course chosen to check
								for (int t = 0; t < coursetoassign.all.size(); t++) {
									Specificcourse thiscourse = coursetoassign.all.get(t);
									if (thiscourse.peopletakingit <= 25) { 
										//System.out.println("Timeslot: " + thiscourse.name + " " + thiscourse.timeslot);
										if (student.checkstudenttimeslot(thiscourse.timeslot) == true) {
											availableslots.add(thiscourse);
										}
									}
									else {
										if (t == coursetoassign.all.size() - 1) {
											if (student.checkstudenttimeslot(thiscourse.timeslot) == true) {
												availableslots.add(thiscourse);
											}
										}
									}
								}
								//Random random = new Random();
								Specificcourse chosencourse = new Specificcourse();
								if (availableslots.size() >= 1) { 
									chosencourse = availableslots.get(0);
									student.timetable[chosencourse.timeslot] = chosencourse;
								}
								else {
									errorstudent.add(student);
									errorcourse.add(coursetoassign);
									//mandatoryerrors++;
									//System.out.println("Student: " + student.name);
									//System.out.println("General Course: " + coursetoassign.name);
									// Call error class
									
								} 
							 
						}
							else {
								//System.out.println("issues");
								if (student.checkerror(errors) == true) {
									//System.out.println("in the if");
									//if (student.grade != 9) { 
									//if (student.name.equals("Student_g10_name_476") && student.courseschosen.get(w).name.equals("ENG2P0") ) { 
									//System.out.println(student.name);
									//System.out.println("Missing Prerequisite for " + student.courseschosen.get(w).name);
									//System.out.println();}
									if (student.grade == 9) {
										System.out.println("issue");
									} 
									int indexoferror = student.geterrorindex(errors);
									String type = "Missing Prerequisite for " + student.courseschosen.get(w).name;
									errors.get(indexoferror).typeoferror.add(type);
								}
								else { 
									//if (student.grade != 9) { 
									//if (student.name.equals("Student_g10_name_476") && student.courseschosen.get(w).name.equals("ENG2P0") ) { 
									///System.out.println(student.name);
									///System.out.println("Missing Prerequisite for " + student.courseschosen.get(w).name);
									//System.out.println();}
									if (student.grade == 9) {
										System.out.println("issue");
									} 
									error thiserror = new error(student);
									String type = "Missing Prerequisite for " + student.courseschosen.get(w).name;
									thiserror.typeoferror.add(type);
									errors.add(thiserror);
								} 
							}
						}	
					}
				}
			}

			for (int u = 0; u < allstudents.size(); u++) {
				// r is number of student in grade
				for (int r = 0; r < allstudents.get(u).size(); r++) {
					Student student =  allstudents.get(u).get(r);
					// w is courses chosen by the student
					for (int w = 0; w < student.courseschosen.size(); w++) {
						String letter = student.courseschosen.get(w).name.split("")[0];
						
							if (letter.equals(fields[0][1]) || letter.equals(fields[1][1]) || letter.equals(fields[2][1])) {
								continue;
							}
							else { 
								if(student.checkprereq(student.courseschosen.get(w))==true){ 
								Generalcourse coursetoassign = student.courseschosen.get(w);
								ArrayList<Specificcourse> availableslots = new ArrayList<Specificcourse>();
								// t is the specific course chosen to check
								for (int t = 0; t < coursetoassign.all.size(); t++) {
									Specificcourse thiscourse = coursetoassign.all.get(t);
									if (thiscourse.peopletakingit <= 25) { 
										if (student.checkstudenttimeslot(thiscourse.timeslot) == true) {
											availableslots.add(thiscourse);
										}
									}
									else {
										if (t == coursetoassign.all.size() - 1) {
											if (student.checkstudenttimeslot(thiscourse.timeslot) == true) {
												availableslots.add(thiscourse);
											}
										}
									}
								}
								//Random random = new Random();
								Specificcourse chosencourse = new Specificcourse();
								if (availableslots.size() >= 1) {   
									chosencourse = availableslots.get(0);
									student.timetable[chosencourse.timeslot] = chosencourse;
								}
								else {
									//electiveerrors++;
									errorstudent.add(student);
									errorcourse.add(coursetoassign);
									//System.out.println("Student: " + student.name);
									//System.out.println("General Course: " + coursetoassign.name);
									// Call error class
									
								} 
							}
						 
							else {
								if (student.checkerror(errors) == true) {
									//if (student.grade != 9) { 
									//System.out.println(student.name);
									//System.out.println("Missing Prerequisite for " + student.courseschosen.get(w).name);
									//System.out.println();}
									if (student.grade == 9) {
										System.out.println("issue");
									} 
									int indexoferror = student.geterrorindex(errors);
									String type = "Missing Prerequisite for " + student.courseschosen.get(w);
									errors.get(indexoferror).typeoferror.add(type);
								}
								else { 
									//if (student.grade != 9) { 
									//System.out.println(student.name);
									//System.out.println("Missing Prerequisite for " + student.courseschosen.get(w).name);
									//System.out.println();}
									if (student.grade == 9) {
										System.out.println("issue");
									} 
									error thiserror = new error(student);
									String type = "Missing Prerequisite for " + student.courseschosen.get(w).name;
									thiserror.typeoferror.add(type);
									errors.add(thiserror);
								}
							}
						}
					}
				}
			}

			//System.out.println("Mandatory Errors: " + mandatoryerrors);
			//System.out.println("Electives Errors: " + electiveerrors);
			//System.out.println("Before handling errors");
			//System.out.println("Student Errors: " + errorstudent.size());
			//System.out.println("Courses Errors: " + errorcourse.size());
			//System.out.println();

			int j = 0;
			while (j < errorstudent.size()) { 
				//Specificcourse foundfreespot = findfreespot(errorstudent.get(j), errorcourse.get(j));
				Specificcourse foundfreespot = errorstudent.get(j).findfreespot(errorcourse.get(j));

				if (foundfreespot != null) {
					//System.out.println(foundfreespot.name);
					errorstudent.get(j).timetable[foundfreespot.timeslot] = foundfreespot;
					errorstudent.remove(j);
					errorcourse.remove(j);
				}

				else {
					j++;
				}
				
			}

			//System.out.println("after handling errors");
			//System.out.println("Student Errors: " + errorstudent.size());
			//System.out.println("Courses Errors: " + errorcourse.size());
			//System.out.println();

			numberofstudentswitherrors = new ArrayList<Student>();
			for (int c = 0; c < errorstudent.size(); c++) {
				Student student = errorstudent.get(c);
				if (numberofstudentswitherrors.size() == 0) {
					numberofstudentswitherrors.add(student);
				}
				else {
					for (int d = 0; d < numberofstudentswitherrors.size(); d++) {
						if (student.equals(numberofstudentswitherrors.get(d))) {
							//System.out.println("stdetn here");
							break;
						}
						else {
							//System.out.println("entered else");
							if (d == numberofstudentswitherrors.size() - 1) {
								//System.out.println("entered the next if");
								numberofstudentswitherrors.add(student);
							}
						}
					}
					}
			}

			//System.out.println("Before: Number of students with errors: " + numberofstudentswitherrors.size());

			swap(newtimetable);			

			int errorcheck = 0;
			for (int e = 0; e < allstudents.size(); e++) {
				for (int p = 0; p < allstudents.get(e).size(); p++) {
					for (int d = 0; d < allstudents.get(e).get(p).timetable.length; d++) { 
						if (allstudents.get(e).get(p).timetable[d] == null) {
							errorcheck++;
							//break;
						}
					}
				}
			}
		//System.out.println("total errors: " +  errors.size());
		//System.out.println("error check before: " + errorcheck);
			
			//fillupspots(); 
			 
			for (int x = 0; x < numberofstudentswitherrors.size(); x++) { 
				Student thisstudent = numberofstudentswitherrors.get(x);
				for (int y = 0; y < thisstudent.timetable.length; y++) {
					if (thisstudent.timetable[y] == null) {
						thisstudent.fillupspots(masterlist, y);
					}
				} 
			} 
  
			int errorcheck2 = 0;
		for (int e = 0; e < allstudents.size(); e++) {
			for (int p = 0; p < allstudents.get(e).size(); p++) {
				for (int d = 0; d < allstudents.get(e).get(p).timetable.length; d++) { 
					if (allstudents.get(e).get(p).timetable[d] == null) {
						errorcheck2++;
						//break;
					}
				}
			}
		}
		//System.out.println("total errors: " +  errors.size());
		//System.out.println("error check fter: " + errorcheck2);
		 
			//numberofstudentswitherrors.clear();

			for (int e = 0; e < 4; e++) {
				for (int r = 0; r < allstudents.get(e).size() ; r++) {
					int numberoferrors = 0;
					for (int u = 0; u < 8; u++) {
						if (allstudents.get(e).get(r).timetable[u] == null) {
							//System.out.println(allstudents.get(e).get(r).name);
							//printtimetable(allstudents.get(e).get(r));
							if (numberoferrors == 0) {
								//numberofstudentswitherrors.add(allstudents.get(e).get(r));
								error newstudent = new error(allstudents.get(e).get(r));
								errors.add(newstudent);
								numberoferrors++;
							} 
							errors.get(errors.size() - 1).typeoferror.add("Cnt fit");
							errors.get(errors.size() - 1).timeslot.add(u);
						}
					}
				}
            } 
            //write(newtimetable);

			int missingerrors = 0;
			for (int y = 0; y < errors.size(); y++) {
				for (int x = 0; x < errors.get(y).typeoferror.size(); x++) { 
					if (errors.get(y).typeoferror.get(x).contains("Cnt fit")) {
						missingerrors++;
						break;
					}
				}
			}
			//System.out.println("errors end: " + errors.size());
    }

		//System.out.println("Fter: Number of students with errors: " + numberofstudentswitherrors.size());
	//}  
	/*
	public void swap() {
		// goes by grade
		for (int x = 0; x < allstudents.size(); x++) {
			// goes each student
			for (int y = 0; y < allstudents.get(x).size(); y++) {
				Student student = allstudents.get(x).get(y); // current student
				for (int z = 0; z < student.timetable.length; z++) { // goes through their schedule
					if (student.timetable[z] == null) { // to see if theres a spare
						//Specificcourse coursefound = student.ifspaceduringspare(z); // function checks if there is any class that they want running during their spare
						if (coursefound != null) { // if it doesnt return null, means there is something
							Generalcourse toput = student.findmissingcourse();
							String[] nme = coursefound.name.split("");
							String generlcourse = nme[0] + nme[1] + nme[2] + nme[3] + nme[4] + nme[5];
							int newtimeslot = student.whentaken(generlcourse);
							Specificcourse coursefound2 = student.filluptimeslot(newtimeslot, toput); // now tries to see if there is something else they can take during their "new" spare
							if (coursefound2 != null) { // if there is something a SC is returned
								for (int t = 0; t < masterlist.get(coursefound.timeslot).size(); t++) { // puts one of their chosen courses in their original spare
									if (masterlist.get(coursefound.timeslot).get(t).equals(coursefound)) { // finds it
										masterlist.get(coursefound.timeslot).get(t).peopletakingit++; // and adds a student taking it
									}
								}
								for (int w = 0; w < masterlist.get(coursefound2.timeslot).size(); w++) { // in their new spare they are offered something else
									if (masterlist.get(coursefound2.timeslot).get(w).equals(coursefound2)) { // finds it
										masterlist.get(coursefound2.timeslot).get(w).peopletakingit++; // adds a student taking it
									}
								}
								student.timetable[z] = coursefound; // makes the above changes to their timetable as well
								student.timetable[coursefound2.timeslot] = coursefound2; // makes the above changes to their timetable as well
							}
							break;
						}
					} 
				}
			} 
		}
	}*/

	public void swap(ArrayList<ArrayList<Specificcourse>> newmasterlist) {
		for (int x = 0; x < allstudents.size(); x++) { // grde
			for (int y = 0; y < allstudents.get(x).size(); y++) { // student
				Student student = allstudents.get(x).get(y); // this student
				for (int z = 0; z < student.timetable.length; z++) { //their timetlbe
					//boolean done = false;
					if (student.timetable[z] == null) { // find spare
						int spare = z;
						ArrayList<Generalcourse> courseduringspare = student.ifspaceduringspare(spare); // finds coursse they're tking during their spre
						ArrayList<Generalcourse> missingcourses = student.findmissingcourse();
						//System.out.println(" period: " + z);
						boolean done = false;
						for (int j = 0; j < missingcourses.size(); j++) {
							if (done == false) { 
								for (int e = 0; e < courseduringspare.size(); e++) { 
									int newspare = student.whentaken(courseduringspare.get(e)); // new spre would be when they originlly hd the course missing course tht is not in the timetble
									boolean fitinnewspare = student.fitinspre(newspare, missingcourses.get(j)); // tries to see if the msising course is running during their new spre
									if (fitinnewspare) {
										Specificcourse scduringspre = new Specificcourse(); // the course during their spre
										Specificcourse scduringnewspare = new Specificcourse(); // the course during their new spre (old course's spot)
										for (int m = 0; m < newmasterlist.get(z).size(); m++) { // looks thruohg during old spre n finds the sc course
											for (int n = 0; n < courseduringspare.get(e).all.size(); n++) {
												if (courseduringspare.get(e).all.get(n).equals(newmasterlist.get(z).get(m))) {
													newmasterlist.get(z).get(m).peopletakingit++; 
													scduringspre = newmasterlist.get(z).get(m); // assings it
												}
											}
										}
										for (int r = 0; r < newmasterlist.get(newspare).size(); r++) { // same with the new spare
											for (int s = 0; s < missingcourses.get(j).all.size(); s++) {
												if (missingcourses.get(j).all.get(s).equals(newmasterlist.get(newspare).get(r))) {
													newmasterlist.get(newspare).get(r).peopletakingit++;
													scduringnewspare = newmasterlist.get(newspare).get(r); // assings it
												}
											}
										}
										student.timetable[z] = scduringspre; // assings to student
										student.timetable[newspare] = scduringnewspare; // assigns to student 
										done = true;
										break;
									}
								}
							}
						}
					} 		 
				}
			}
		}
	}

	

	/*
	public void rearrange() {
		for (int x = 0; x < numberofstudentswitherrors.size(); x++) {
			Student student = numberofstudentswitherrors.get(x);
			int timeslot = student.countfreespots(masterlist);
			if (student.timetable[timeslot] == null) {
				student.fillupspots(masterlist, timeslot);
			}
			else {
				student.fillupspots(masterlist, timeslot);

			}
		}
	}
	*/
	

	

	public void write(ArrayList<ArrayList<Specificcourse>> newmasterlist) {
		try { 
			FileOutputStream fos = new FileOutputStream("newmasterlist"); // Opens an output stream to a file.
			ObjectOutputStream oos = new ObjectOutputStream(fos); // Opens a stream that lets you write objec
			oos.writeObject(newmasterlist); // Writes object.
			oos.close();
			fos.close();
		}
		
		catch (IOException e) {
			System.out.println("dtfyui");
			e.printStackTrace();
		}

		try { 
			FileOutputStream fos = new FileOutputStream("teachersbydepartment"); // Opens an output stream to a file.
			ObjectOutputStream oos = new ObjectOutputStream(fos); // Opens a stream that lets you write objec
			oos.writeObject(teachersbydepartment); // Writes object.
			oos.close();
			fos.close();
		}
		
		catch (IOException e) {
			System.out.println("dtfyui");
			e.printStackTrace();
		}

		try { 
			FileOutputStream fos = new FileOutputStream("students"); // Opens an output stream to a file.
			ObjectOutputStream oos = new ObjectOutputStream(fos); // Opens a stream that lets you write objec
			oos.writeObject(allstudents); // Writes object.
			oos.close();
			fos.close();
		}
		
		catch (IOException e) {
			System.out.println("dtfyui");
			e.printStackTrace();
		}

		try { 
			FileOutputStream fos = new FileOutputStream("errors"); // Opens an output stream to a file.
			ObjectOutputStream oos = new ObjectOutputStream(fos); // Opens a stream that lets you write objec
			oos.writeObject(errors); // Writes object.
			oos.close();
			fos.close();
		}
		
		catch (IOException e) {
			System.out.println("dtfyui");
			e.printStackTrace();
		}
	} 

	 

	public void readteachers() {
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
	}

	public boolean checkinteger(String value) { 
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
	
	public void readstudents() { 
		ArrayList<Student> grade9 = new ArrayList<Student>();
		ArrayList<Student> grade10 = new ArrayList<Student>();
		ArrayList<Student> grade11 = new ArrayList<Student>();
		ArrayList<Student> grade12 = new ArrayList<Student>();
		  
		allstudents =  new ArrayList<ArrayList<Student> >(4);

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
			//System.out.println(propertiesofstudents[1]);
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

	}
	
	public void readcourses() {
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
	} 
}
