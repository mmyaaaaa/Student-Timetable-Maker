package summative;

import java.io.Serializable;
import java.util.ArrayList;

public class error implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    ArrayList<String> typeoferror;
    Student student;
    ArrayList<Integer> timeslot;

    public error (Student student) {
        this.typeoferror = new ArrayList<String>();
        this.timeslot = new ArrayList<Integer>();
        this.student = student;
    }

    public error () {
    }
}