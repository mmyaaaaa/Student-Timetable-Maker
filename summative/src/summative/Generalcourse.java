package summative;

import java.io.Serializable;
import java.util.ArrayList;

public class Generalcourse implements Serializable{
	
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String name;
   // the following attributes are used for the General course object “the big course” ( info for course)
    int peopletakingit = 0;

    ArrayList<String> prereq;
    
    // the number of classes that need to run for the general course
    int classesneeded;
 
    // all specific courses running under the  general course 
    ArrayList <Specificcourse> all; 

    public Generalcourse(String name) {
        this.name = name;
        all = new ArrayList <Specificcourse>();
    }

    public Generalcourse(String name, ArrayList<String> prereq) {
        this.name = name;
        this.prereq = prereq;
        all = new ArrayList <Specificcourse>();
    }


    public void makespecificcourses() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "K", "L", "M"}; 
        //System.out.println("classes needed: " + this.classesneeded);
		for (int x = 0; x < this.classesneeded; x++) {
			Specificcourse oneclass = new Specificcourse(this.name + letters[x]);
            this.all.add(oneclass); 
        } 
	}

}
