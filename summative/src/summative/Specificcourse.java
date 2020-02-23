package summative;


import java.io.Serializable;

//package summative;

public class Specificcourse implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // the following attributes are used when a course object is invoked for a
    // specific course with a room (info for a student)
    //float mark; 
    int peopletakingit;
    int roomnumber;
    Teacher teacher;
    int timeslot;
    String name;

// people in the specific class
    //static int peopleinclass;
    
    public Specificcourse(String name) {
        this.name = name;
        //peopleinclass++;
    }

    public Specificcourse() { 
    }

}
