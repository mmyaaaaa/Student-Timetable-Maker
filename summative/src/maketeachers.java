import java.io.*; 
import java.util.*;

public class maketeachers{
    public static void main(String[] args) {
        File file = new File("teachers.csv");
        try { 
            
            FileWriter csvWriter = new FileWriter(file);
            Random r = new Random();
            String[] fields = {"Math", "English", "Science", "History", "French", "arts", "Social Sciences", "Gym"};
            for (int x = 0; x <= 99; x++) {
                String name = "teacher_" + (x + 1);
                String fieldone = fields[r.nextInt(fields.length)];
                String fieldtwo = fields[r.nextInt(fields.length)];
                while (fieldone == fieldtwo) {
                    fieldtwo = fields[r.nextInt(fields.length)];
                }
                String[] things = {name, ",", fieldone, ",", fieldtwo, "\n"};
                for (int y = 0; y < 6; y++) {
                    csvWriter.append(things[y]);
                }
                
            }
            
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }      
    }
}