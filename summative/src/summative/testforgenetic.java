/*
// The Nature of Code
// Daniel Shiffman 

// Genetic Algorithm, Evolving Shakespeare

// Demonstration of using a genetic algorithm to perform a search

// setup()
//  # Step 1: The Population 
//    # Create an empty population (an array or ArrayList)
//    # Fill it with DNA encoded objects (pick random values to start)

// draw()
//  # Step 1: Selection 
//    # Create an empty mating pool (an empty ArrayList)
//    # For every member of the population, evaluate its fitness based on some criteria / function, 
//      and add it to the mating pool in a manner consistant with its fitness, i.e. the more fit it 
//      is the more times it appears in the mating pool, in order to be more likely picked for reproduction.

//  # Step 2: Reproduction Create a new empty population
//    # Fill the new population by executing the following steps:
//       1. Pick two "parent" objects from the mating pool.
//       2. Crossover -- create a "child" object by mating these two parents.
//       3. Mutation -- mutate the child's DNA based on a given probability.
//       4. Add the child object to the new population.
//    # Replace the old population with the new population
//  
//   # Rinse and repeat
*/
package summative;


import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class testforgenetic{ 
    //static PFont f;
  
    static int popmax;
    static double mutationRate;
    static Population population;

    //ArrayList<Generalcourse> coursesoffered;
    static ArrayList<ArrayList<Student>> allstudents = new ArrayList<ArrayList<Student>>();
    static ArrayList<ArrayList<Specificcourse>> masterlist = new ArrayList<ArrayList<Specificcourse>>();
    //ArrayList<ArrayList<Generalcourse>> coursesbydepartment;
    static ArrayList<ArrayList<Teacher>> teachersbydepartment = new ArrayList<ArrayList<Teacher>>();
    //ArrayList<Student> numberofstudentswitherrors;
    static ArrayList<error> errors = new ArrayList<error>();

    public static void main(String args[]) {

       
        setup();
        draw();
        
        
    }

    public static void setup() { 
     
        popmax = 100;
        mutationRate = 0.07;
        
        // Create a populationation with a target phrase, mutation rate, and populationation max
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

    public static void readteachersbydepartment() {
		try {
			FileInputStream fis = new FileInputStream("teachersbydepartment"); // Opens input stream to a file.
			ObjectInputStream ois = new ObjectInputStream(fis); // Lets you read an Object.
			teachersbydepartment = (ArrayList<ArrayList<Teacher>>) ois.readObject(); // Reads product from last time it ran.
			
			ois.close();
			fis.close(); 
			
		} catch (IOException e) { 
			System.out.println("e");
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) { 
			System.out.println("not found");
			//e.printStackTrace();
		}
    }
    
    public static void readstudentsfromtemp() {
		
    }
    
    public static void readmsterlist() {
		try {
			FileInputStream fis = new FileInputStream("masterlist"); // Opens input stream to a file.
			ObjectInputStream ois = new ObjectInputStream(fis); // Lets you read an Object.
			masterlist = (ArrayList<ArrayList<Specificcourse>>) ois.readObject(); // Reads product from last time it ran.
			
			ois.close();
			fis.close(); 
			
		} catch (IOException e) {
			System.out.println("catches");
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found.");
			e.printStackTrace();
		}
	}

	public static void readerrors() {
		try {
			FileInputStream fis = new FileInputStream("errors"); // Opens input stream to a file.
			ObjectInputStream ois = new ObjectInputStream(fis); // Lets you read an Object.
			errors = (ArrayList<error>) ois.readObject(); // Reads product from last time it ran.
			
			ois.close();
			fis.close(); 
			
		} catch (IOException e) {
			System.out.println("catches");
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found.");
			e.printStackTrace();
		}
		
	}
}