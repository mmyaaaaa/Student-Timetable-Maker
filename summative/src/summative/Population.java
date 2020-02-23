package summative;

// Genetic Algorithm

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// A class to describe a population of virtual organisms
// In this case, each organism is just an instance of a Masterlist object
public class Population {

  double mutationRate; // Mutation rate
  Masterlist[] population; // Array to hold the current population
  ArrayList<Masterlist> matingPool; // ArrayList which we will use for our "mating pool"
  int generations; // Number of generations
  boolean finished; // Are we finished evolving?
  double perfectScore;
  Masterlist answer;

  // constructor that makes initial population pool
  public Population(double m, int num) { 
    mutationRate = m;
    // make initial population pool
    population = new Masterlist[num];

    // fill initial population pool with masterlist objects
    for (int i = 0; i < population.length; i++) {
      population[i] = new Masterlist();
    }

    // create empty mating pool
    matingPool = new ArrayList<Masterlist>();
    finished = false;
    generations = 1;

    perfectScore = 0.8;
    answer = null;

    // System.out.println("Generation " + generations + " done");
    // System.out.println(); 
  }

  // Fill our fitness array with a value for every member of the population
  public boolean calcFitness() {
    this.answer = new Masterlist(true);
    if (read() == true) { 
      System.out.println("red true");
      //this.answer.students = readstudents();
      return false;
    }

    else {
      for (int i = 0; i < population.length; i++) {
        // System.out.println("out: " + population[i].masterlist.size());
        population[i].calcFitness();
        // System.out.println("popultion fitness: " + population[i].fitness);
        if (population[i].fitness >= perfectScore) {
          this.answer = population[i];
          System.out.println("answer fitness: " + this.answer.fitness);
          write();
          return false;
        }
      }

      return true;
    }
  }

  public ArrayList<ArrayList<Student>> readstudents() {
    ArrayList<Generalcourse> coursesoffered = readcourses();
    ArrayList<Student> grade9 = new ArrayList<Student>();
		ArrayList<Student> grade10 = new ArrayList<Student>();
		ArrayList<Student> grade11 = new ArrayList<Student>();
		ArrayList<Student> grade12 = new ArrayList<Student>();
		  
		ArrayList<ArrayList<Student>> allstudents =  new ArrayList<ArrayList<Student>>(4);

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

	 
    return allstudents;
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

  public ArrayList<Generalcourse> readcourses() { 
    ArrayList<Generalcourse> coursesoffered = new ArrayList<Generalcourse>();

		Scanner sc = null;
		String[][] fields = {{"English", "E"}, {"Math", "M"}, {"Science", "S"}, {"Social Studies", "C", "G", "H", "O", "N"}, {"French", "F"}, {"Arts", "A"}, {"Technology", "T", "I"}, {"Gym", "P"}, {"Business", "B"}};
		String[] departmentname = { "English", "Math", "Science", "Social Studies", "French", "Arts", "Technology", "Gym", "Business"};
		ArrayList<ArrayList<Generalcourse>> coursesbydepartment = new ArrayList<ArrayList<Generalcourse>>();

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

  // Generate a mating pool
  public void naturalSelection() {
    // Clear the ArrayList
    matingPool.clear();

    double maxFitness = 0;
    for (int i = 0; i < population.length; i++) {
      if (population[i].fitness > maxFitness) {
        maxFitness = population[i].fitness;
      }
    }

    //System.out.println("Highest In Generation: " + maxFitness);
    // System.out.println();
    // Based on fitness, each member will get added to the mating pool a certain
    // number of times
    // a higher fitness = more entries to mating pool = more likely to be picked as
    // a parent
    // a lower fitness = fewer entries to mating pool = less likely to be picked as
    // a parent
    for (int i = 0; i < population.length; i++) {

      double fitness = population[i].fitness / maxFitness;
      int n = (int) fitness * 100; // Arbitrary multiplier, we can also use monte carlo method
      for (int j = 0; j < n; j++) { // and pick two random numbers
        matingPool.add(population[i]);
      }
    }
  }

  // Create a new generation
  public void generate() {
    //double[] fitnesses = new double[population.length];
    //int[] indexes = new int[population.length];
    //for (int x = 0; x < population.length; x++) {
    //  fitnesses[x] = population[x].fitness;
    //}

    double maxFitness = 0;
    int index = 0;
   
    for (int i = 0; i < population.length; i++) {
      if (population[i].fitness > maxFitness) {
        maxFitness = population[i].fitness;
        index = i;
        //highest = population[i];
      }
    }
    //Masterlist partnerA = population[index];

    double secondmx = 0;
    int index2 = 0;
    for (int y = 0; y < population.length; y++) {
      if (population[y].fitness > secondmx) {
        if (index != index2) { 
          secondmx = population[y].fitness;
          index2 = y;
        }
      }
    }
    //Masterlist partnerB = population[index2];

    //Arrays.sort(fitnesses); 
    //Masterlist[] newpop = sortpopulation(fitnesses);
 
    Random random = new Random();
    // Refill the population with children from the mating pool
    for (int i = 0; i < population.length; i++) {
      //System.out.println(matingPool.size());
      Masterlist partnerA = null;
      Masterlist partnerB = null;
      Masterlist child = null;
      //while (true) { 
        int a = (int)(random.nextInt(matingPool.size()));
        int b = (int)(random.nextInt(matingPool.size())); 
        partnerA = matingPool.get(a); 
        partnerB = matingPool.get(b);

        child = partnerA.crossover(partnerB); 
        //if (child.fitness > 0.68) {
          //break;
      //  }
      //} 
      child.mutate(mutationRate);
      population[i] = child; 
    }
    generations++; 
  }  
 
  public void write() {
    try { 
      FileOutputStream fos = new FileOutputStream("answer"); // Opens an output stream to a file.
      ObjectOutputStream oos = new ObjectOutputStream(fos); // Opens a stream that lets you write objec
      oos.writeObject(this.answer); // Writes object.
      //System.out.println("writtten");
      oos.close();
      fos.close();
    }

    catch (IOException e) {
      //System.out.println("dtfyui");
      e.printStackTrace();
    }
  }

  public boolean read() {
    try {
			FileInputStream fis = new FileInputStream("answer"); // Opens input stream to a file.
			ObjectInputStream ois = new ObjectInputStream(fis); // Lets you read an Object.
			this.answer = (Masterlist) ois.readObject(); // Reads product from last time it ran.
			
			ois.close();
			fis.close(); 
      
      if (this.answer.fitness >= perfectScore) {
        System.out.println("this. nswer. gitnes " + this.answer.fitness);
        //System.out.println("Students with errors: " + this.answer.students.get(0).size());
        //System.out.println("Students 9: " + this.answer.students.get(0).size());
        //System.out.println("Students ten: " + this.answer.students.get(1).size());
        //System.out.println("Students eleven: " + this.answer.students.get(2).size());
        //System.out.println("Students twelve: " + this.answer.students.get(3).size());

        return true;
      }
			
		} catch (IOException e) {
			//System.out.println("catches");
			//e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			//System.out.println("Class not found.");
			//e.printStackTrace();
		}

    return false;
  }

  public Masterlist[] sortpopulation(double[] fitnesses ){  
    Masterlist[] highest = new Masterlist[population.length];
    for (int x = 0; x < 2; x++) {
      for (int y = 0; y < population.length; y++) {
        if (highest[x]!=highest[y]) { 
          if (fitnesses[x] == population[y].fitness) {
            highest[x] = population[y]; 
          }
        } 
      }
    }

    return highest;
  }

  // Compute average fitness for the population
  public double getAverageFitness() {
    double total = 0;
    for (int i = 0; i < population.length; i++) {
      total += population[i].fitness;
    }
    return total / (population.length) ;
  }

  public void generatetimetables() {
    generate2 ggg = new generate2();
    ggg.fillstudents(this.answer.masterlist, true);
    //System.out.println("Finl fitness: " + this.answer.fitness);
    //int errorcheck = 0;
    int errorcheck2 = 0;
		for (int e = 0; e < this.answer.students.size(); e++) {
			for (int p = 0; p < this.answer.students.get(e).size(); p++) {
				for (int d = 0; d < this.answer.students.get(e).get(p).timetable.length; d++) { 
					if (this.answer.students.get(e).get(p).timetable[d] == null) {
             if (e == 2) { 
              //System.out.println(this.answer.students.get(e).get(p).name);
              //ggg.printtimetable(this.answer.students.get(e).get(p));
            }
            else if (p == 249) {
              //System.out.println("dfghjlko;kjkhgf");
            } 
						errorcheck2++;
						break;
					}
				}
			}
    }
    /*
    ArrayList<error> errors = filluperrors(this.answer.students);
    System.out.println(errors.size());

    for (int x = 0; x < errors.size(); x++) { 
      for (int y = 0; y < errors.get(x).typeoferror.size(); y++) {
        if (errors.get(x).typeoferror.get(y).contains("Cnt fit")) {
          if (errors.get(x).student.grade == 9) { 
            System.out.println(errors.get(x).student.name);
            ggg.printtimetable(errors.get(x).student);
          }
        }
      }
    }
*/
    //System.out.println("Students with errors: " + errorcheck2);  

    //System.out.println("Error count: " + errors.size()); 
  }

  public ArrayList<error> filluperrors(ArrayList<ArrayList<Student>> students) {
    ArrayList<error> errors = new ArrayList<error>();

    // go through grde
    for (int x = 0; x < students.size(); x++) {
      // choose student
      for (int y = 0; y < students.get(x).size(); y++) {
        Student thisstudent = students.get(x).get(y);
        error error = new error(thisstudent);
        // see throuhg courses chosen
        for (int z = 0; z < thisstudent.courseschosen.size(); z++) { 
          // if not tken
          if (thisstudent.checkiftken(thisstudent.courseschosen.get(z).name) == false) {
            // check if prere error
            if (thisstudent.checkprereq(thisstudent.courseschosen.get(z)) == false) { 
                error.typeoferror.add("Missing Prereuisite"); 
              } 
            else { 
              error.typeoferror.add("Cnt fit " + thisstudent.courseschosen.get(z).name);
            }
            //errors.add(error);
          }
        } 
        if (error.typeoferror.size() > 0) { 
          errors.add(error);
        }
      }
    }
    return errors;
  }
}
 