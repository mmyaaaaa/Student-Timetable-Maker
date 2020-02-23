package summative;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int grade;
    int studentnumber; 
    
	// this is all the courses they chose for next year
	 ArrayList<Generalcourse>  courseschosen; 
     ArrayList <Generalcourse> coursestaken; 

    // specific classes they’re put into 
     Specificcourse[] timetable = new Specificcourse[8];
     ArrayList<Generalcourse> missing;
     ArrayList<Float> marks; 

     // constructor 
	public Student (String name, int grade, int studentnumber, ArrayList <Generalcourse> courseschosen, ArrayList <Generalcourse> coursestaken, ArrayList<Float> marks){
		missing = new ArrayList<Generalcourse>();
		this.name = name;
		this.grade = grade;
		
		this.studentnumber = studentnumber;
		this.courseschosen = courseschosen;
		this.coursestaken = coursestaken;
		this.marks = marks;

	}

	public Specificcourse findfreespot(Generalcourse coursetoput) {
		for (int x = 0; x < coursetoput.all.size(); x++) {
			Specificcourse thiscourse = new Specificcourse();
			if (checkstudenttimeslot(thiscourse.timeslot) == true) {
				return thiscourse;
			}
		}
		return null;
	}



	public boolean checkstudenttimeslot(int timeslot) {
		if (this.timetable[timeslot] == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean checkiftken(String chosencourse) { 
		String[] name = chosencourse.split("");
		String generalcourse = name[0] + name[1] + name[2] + name[3] + name[4] + name[5];

		for (int x = 0; x < 8; x++) {
			if (this.timetable[x] != null) { 
				if (this.timetable[x].name != null) { 
					String[] name2 = this.timetable[x].name.split("");
					String generalcourse2 = name2[0] + name2[1] + name2[2] + name2[3] + name2[4] + name2[5];

					if (generalcourse.equals(generalcourse2)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean checkiftken2(String generalcourse) {  

		for (int x = 0; x < 8; x++) {
			if (this.timetable[x] != null) { 
				if (this.timetable[x].name != null) { 
					String[] name2 = this.timetable[x].name.split("");
					String generalcourse2 = name2[0] + name2[1] + name2[2] + name2[3] + name2[4] + name2[5];

					if (generalcourse.equals(generalcourse2)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/*
	public int countfreespots(ArrayList<ArrayList<Specificcourse>> masterlist) {
		int[] freespots = new int[8];
		for (int x = 1; x <= 8; x++) {
			int freespotsthisperiod = 0;
			for (int y = 0; y < masterlist.get(x - 1).size(); y++) {
				if (Integer.parseInt(masterlist.get(x - 1).get(y).name.split("")[3]) == grade - 8) {
					if (this.checkiftken(masterlist.get(x - 1).get(y)) == false) {
						freespotsthisperiod++;
					}
				}
			}
			freespots[x - 1] = freespotsthisperiod;
		}

		int highest = 0;
		for (int z = 0; z < freespots.length; z++) {
			if (freespots[z] > freespots[highest]) {
				highest = z;
			}
		}

		return highest;
	}
	*/
	public boolean checkprereq(Generalcourse course) { 
		if (course.prereq.size() == 0) {
            return true;
		} 
		
        else{
			for (int x = 0; x < course.prereq.size(); x++) {
				for(int h = 0; h < this.coursestaken.size(); h++){ 
					if(this.coursestaken.get(h).name.equals(course.prereq.get(x))){ 
						if(this.marks.get(h) >= 50){
							return true;
						}
					}
				}
			}
            
            return false;
        }
	}
	
	public void fillupspots(ArrayList<ArrayList<Specificcourse>> masterlist, int timeslot) { 
		int index = 0;
		Specificcourse chosencourse = masterlist.get(timeslot).get(index);
		//System.out.println("size: " + masterlist.get(timeslot).size());
		//System.out.println("start index: " + index);
		int grde = this.grade - 8;
		int letter = 0;
		try {
			letter = Integer.parseInt(chosencourse.name.split("")[3]);
		} catch (Exception e) {
			System.out.println(chosencourse.name);
			//letter = Integer.parseInt(chosencourse.name.split("")[3]);
		}
		
		//System.out.println(chosencourse.name);
		while (letter != grde || chosencourse.peopletakingit >= 31 || this.checkiftken(chosencourse.name) == true) { 
			if (index == masterlist.get(timeslot).size() - 1) {
				//x++;
				break;
			}
			else { 
				index++;
				//System.out.println(index);
				chosencourse = masterlist.get(timeslot).get(index);
				//System.out.println(chosencourse.name);
			}
		} 

		if (index != masterlist.get(timeslot).size() - 1) { 
			this.timetable[timeslot] = chosencourse;
			//System.out.println("X: " + x);
			//System.out.println("Size: " + numberofstudentswitherrors.size());
			//System.out.println( );
			//numberofstudentswitherrors.remove(x);
		} 
	}

	public boolean checkerror(ArrayList<error> errors) {
		if (errors.size() != 0) {
			for (int x = 0; x < errors.size(); x++) {
				if (this.equals(errors.get(x).student)) {
					return true;
				}
			}
		}
		return false;
	}

	public int geterrorindex(ArrayList<error> errors) {
		for (int x = 0; x < errors.size(); x++) {
			if (this.equals(errors.get(x).student)) {
				return x;
			}
		}
		return 9999;
	}

	public ArrayList<Generalcourse> ifspaceduringspare(int timeslot) {
		ArrayList<Generalcourse> courses = new ArrayList<Generalcourse>();
		for (int x = 0; x < courseschosen.size(); x++) {
			for (int y = 0; y < courseschosen.get(x).all.size(); y++) {
				if (courseschosen.get(x).all.get(y).timeslot == timeslot) {
					if (courseschosen.get(x).all.get(y).peopletakingit < 31) { 
						courses.add(courseschosen.get(x));
					}
				}
			}
		}

		return courses;
	}
/*
	public Specificcourse filluptimeslot(int timeslot, Generalcourse coursefound) {
		for (int x = 0; x < coursefound.all.size(); x++) { // looks through ll the specific courses running under it
			if (coursefound.all.get(x).timeslot == timeslot) { // sees if the timeslot for any matches
				if (coursefound.all.get(x).peopletakingit < 30) { // if there are less than 30 people in class 
						for (int z = 0; z < this.timetable.length; z++){ // then looks through the courses student is taking already
							if (this.timetable[z].equals(coursefound.all.get(x))) {
								continue;
							}
							else { 
								//this.timetable[timeslot] = coursefound.all.get(x);
								return coursefound.all.get(x);
							}
						}
					}
				}
			}
		
		return null;
	}
*/
	public ArrayList<Generalcourse> findmissingcourse() {
		ArrayList<Generalcourse> missing = new ArrayList<Generalcourse>();  
		for (int x = 0; x < courseschosen.size(); x++) {
			boolean takingthiscourse = false;
			for (int y = 0; y < courseschosen.get(x).all.size(); y++) {
				Specificcourse thiscourse = courseschosen.get(x).all.get(y);
				for (int z = 0; z < this.timetable.length; z++) {
					if (this.timetable[z] != null) { 
						if (this.timetable[z].equals(thiscourse)) {
							takingthiscourse = true;
						}
					}
				}
			}
			if (takingthiscourse == false) {
				missing.add(courseschosen.get(x));
			}
		}

		if (this.name.equals("Student_g12_name_950")){
			//System.out.print("missing: ");
			for (int x = 0; x < missing.size(); x++) {
				//System.out.print(missing.get(x).name);
			}
		}

		//System.out.println(this.name);
		return missing;
	}

	public int whentaken(Generalcourse find) {
		for (int x = 0; x < find.all.size(); x++) {
			for (int y = 0; y < this.timetable.length; y++) { 
				if (find.all.get(x).equals(this.timetable[y])) {
					return y;
				}
			}
		}
		return 9;
	}

	public boolean fitinspre(int newspre, Generalcourse missingcourse) { 
		for (int x = 0; x < missingcourse.all.size(); x++) {
			if (missingcourse.all.get(x).timeslot == newspre) {
				if (missingcourse.all.get(x).peopletakingit < 31) {
					return true;
				}
			}
		}
		
		return false;
	} 
}
 


