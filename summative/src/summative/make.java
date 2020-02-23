package summative;

import java.io.*; 
import java.util.*;

public class make{
    public static void main(String[] args) {
        File file = new File("idekdude.csv");
        try { 
            
            FileWriter csvWriter = new FileWriter(file);
            Random r = new Random();
            String[] fields = {"ADA4M0", "AVI4M0", "ASM4M0", "AMI4M0", "AMU4M0", "BAT4M0", "BBB4M0", "BOH4M0", "CHY4U0", "CGW4U0", "CIA4U0", "CLN4U0", "CHM4E0", "ICS4U0", "NDW4M0", "FSF4U0", "GLS4O0", "GLE4O0", "PPL4OM", "PAF4OF", "PAF4OM", "PSK4U0", "PLF4M0", "MEL4E0", "MHF4U0", "MCV4U0", "MDM4U0", "MAP4C0", "OLC4O0", "SNC4M0", "SBI4U0", "SCH4C0", "SCH4U0", "SPH4C0", "SPH4U0", "SES4U0", "HIP4O0", "HZT4U0", "HSB4U0", "HNB4M0", "HFA4U0", "HFA4C0", "HHG4M0", "TGJ4M0", "TCJ4C0", "TDJ4M0", "IDC4U0", "TTJ4C0"};
            String[] eng = {"ENG4C0", "ENG4U0", "EWC4U0" };
            for (int x = 0; x < 1000; x++) {
                String name = "Student_g" + Integer.toString((x / 250) + 9) +  "_name_" + Integer.toString(x + 1);
                String grade = Integer.toString((x / 250) + 9);
                String studentnumber = Integer.toString(x + 1);
                String[] courses = {name, grade, studentnumber};
                for (int y = 0; y < 3; y++) {
                    csvWriter.append(courses[y]);
                    csvWriter.append(",");
                }
                csvWriter.append("\n");
                
            }
            
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }      
    }

    public static boolean check(String toCheckValue, ArrayList<String> courses) { 
        for (String element : courses) {
            if (element.equals(toCheckValue)) {
                return true;
            }
        }
        return false;
    }
}