package summative;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Teacher implements Serializable{
	/**
     *
     */
    private static final long serialVersionUID = 1L;
    // teachers timetable, 2 will be null one for each semester
	String[] timetable = new String[8]; 
    String teachername;
	int teachernumber;
	//static int index = 0;
    
    // a list of what field(s) (ex. English math…) a teacher can teach that’ll determine what courses they can teach  
    String qualifiedfield;

    public Teacher(String classroom,int index) {
    	timetable[index] = classroom;
    }
    
    public Teacher(String teachername, String qualifiedfield, int teachernumber) {
    	this.teachername = teachername;
        this.qualifiedfield = qualifiedfield;
        this.teachernumber = teachernumber;
    }

    public int getfreespot() {
		int[] freespots = new int[8];
		int index2 = 0;
		for (int x = 0; x < 4; x++) {
			if (this.timetable[x] == null) {
				int numberofused = 0;
				for (int y = 0; y < 4; y++) {
					if (this.timetable[y] != null) {
						numberofused++;
					}
				}
				if (numberofused == 3) {
					continue;
				}
				else {
					freespots[index2] = (x + 1);
					index2++;
				}
			}
		}

		for (int x = 4; x < 8; x++) {
			
			if (this.timetable[x] == null) {
				//System.out.println("here");
				int numberofused = 0;
				for (int y = 4; y < 8; y++) {
					if (this.timetable[y] != null) {
						//System.out.println("used");
						numberofused++;
					}
				}
				//System.out.println(numberofused);
				if (numberofused == 3) {
					continue;
				}
				else {
					freespots[index2] = (x + 1);
					index2++;
				}
			}
		}

		//System.out.println("Free spots: " + freespots[0] + " " + freespots[1] + " " + freespots[2] + " " + freespots[3] + " " + freespots[4] + " " + freespots[5] + " " + freespots[6] + " " + freespots[7]);
		Random r = new Random();
		int randomnum = r.nextInt(7);  
		int finalint = freespots[randomnum];
		while (finalint == 0) { 
			randomnum = r.nextInt(7); 
			finalint = freespots[randomnum]; 
			} 

		return (finalint - 1);
    }
    
    public boolean checkfreespot() {
		
		int numberofspotstakensem1 = 0;
		for (int x = 0; x < 4; x++) { 
			if (this.timetable[x] != null) {
				numberofspotstakensem1++;
			}
		}
		//System.out.println("Sem 1: " + numberofspotstakensem1);
		int numberofspotstakensem2 = 0;
		for (int x = 4; x < 8; x++) { 
			if (this.timetable[x] != null) {
				numberofspotstakensem2++;
			}
		}

		//System.out.println("Sem 2: " + numberofspotstakensem2);
		
		// No free spots - all busy
		if (numberofspotstakensem1 == 3 && numberofspotstakensem2 == 3) {
			//if (checker.qualifiedfield.equals("Social Studies")) { 
				//System.out.println(checker.teachername);
				//System.out.println("Techer done");
				//System.out.println( );}
			return false;
		}

		// Some error came up and it exceeded
		else if (numberofspotstakensem1 > 3 || numberofspotstakensem2 > 3) {
			System.out.println("sfghjhkjkdgrgfhl.kjhgfdxfghjkjhgfdxfk");
			return false;
		}

		// There is spot left
		else {
			return true;
		}
	}
    
}
