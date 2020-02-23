// Genetic Algorithm 

// A class to describe a psuedo-Masterlist, i.e. genotype
//   Here, a virtual organism's Masterlist is an array of character.
//   Functionality:
//      -- convert Masterlist into a string
//      -- calculate Masterlist's "fitness"
//      -- mate Masterlist with another set of Masterlist
//      -- mutate Masterlist

package summative;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Masterlist implements Serializable{

  // The genetic sequence
  ArrayList<ArrayList<Specificcourse>> masterlist;
  //ArrayList<Specificcourse> periods;
  
  double fitness;
  generate2 ggg;
  ArrayList<ArrayList<Student>> students;
  
  Random random;

  
  // Constructor (makes a random Masterlist)
  // create a new one for the 1st time 
  // only evoked once 
  public Masterlist() {
    random = new Random();
    ggg = new generate2();
    ggg.make();
    this.masterlist = ggg.masterlist;
    ggg.fillstudents(this.masterlist, false);
    
    //System.out.println("Errors in Initial population " + this.ggg.errors.size());
    
  }
  
  public Masterlist(boolean diff) {
    random = new Random();
    ggg = new generate2();
  }
   


  
  // Fitness function (returns floating point % of "correct" characters)
  public void calcFitness () {
    // flood students
    //System.out.println("in: " + this.masterlist.size());
    generate2 ggg2 = new generate2();
    ggg2.make();
    ggg2.fillstudents(this.masterlist, true); 
    students = ggg2.allstudents;

    //System.out.println("errors in fitness clc: " + this.ggg.errors.size());

    double errors = ggg2.errors.size();
    //System.out.println("errors: " + errors);
    double errordouble = errors / 1000;
    //System.out.println("error divide bt thousnd: " + errordouble);
    double one = 1.00;
    this.fitness = one - errordouble;
    //System.out.println("Fitness: " + this.fitness);
    //System.out.println("1 - errordouble: " + (one - errordouble));

  }
  
  // Crossover
  public Masterlist crossover(Masterlist partner ) {
    // A new child
    Masterlist child = new Masterlist(true);
    child.masterlist = fillnull();
    // Partner A 
    // the masterlist itself, this is a copy of the original that will be thrown away 
    ArrayList<ArrayList<Specificcourse>> copyA = this.masterlist; 
    
      // Partner B 
    // the masterlist accepted, this is a copy of the partner that will be thrown away 
    //System.out.println(partner.fitness);
    ArrayList<ArrayList<Specificcourse>> copyB = partner.masterlist; 

    ArrayList<Specificcourse> allspecificcourses = getall();

    for (int x = 0; x < allspecificcourses.size(); x++) { 
      ArrayList<ArrayList<Specificcourse>> test = null;
      if (x % 2 == 0) { 
        test = copyA;
      }
      else {
        test = copyB;
      }
      int[] spots = find(test, allspecificcourses.get(x));
      child.masterlist.get(spots[0]).add(test.get(spots[0]).get(spots[1]));
    } 
    return child;
  } 

  public int[] find(ArrayList<ArrayList<Specificcourse>> test, Specificcourse specificcourse) {
    int[] spots = new int[2];
    boolean found = false;
    for (int x = 0; x < test.size(); x++) {
      if (found == false) { 
        for (int y = 0; y < test.get(x).size(); y++) {
          if (test.get(x).get(y).equals(specificcourse)) {
            spots[0] = x;
            spots[1] = y;
            found = true;
            break;  
          }
        }
      }
    }
    return spots;
  }

  public ArrayList<ArrayList<Specificcourse>> randomchoice(ArrayList<ArrayList<Specificcourse>> copyA,
    ArrayList<ArrayList<Specificcourse>> copyB) {
    double randomnum = random.nextDouble();
    if (randomnum < 0.5) {
      return copyA;
    }

    else {
      return copyB;
    } 
  }

  public ArrayList<ArrayList<Specificcourse>> fillnull() {
    ArrayList<ArrayList<Specificcourse>> list = new ArrayList<ArrayList<Specificcourse>>();
    for (int x = 0; x < 8; x++) { 
      list.add(new ArrayList<Specificcourse>());
    }

    return list;
     
  }

  public ArrayList<Specificcourse> getall() {
    ArrayList<Specificcourse> courses = new ArrayList<Specificcourse>();
    for (int x = 0; x < this.masterlist.size(); x++) {
      for (int y = 0; y < this.masterlist.get(x).size(); y++) {
        courses.add(this.masterlist.get(x).get(y));
      }
    }

    return courses;
  } 
  
  // This mutation swaps 2 course offereings into different periods
  public void mutate(double mutationRate) {
    if (random.nextDouble() < mutationRate) {
      int period1 = random.nextInt(8);
      while (this.masterlist.get(period1).size() == 0) {
        period1 = random.nextInt(8);
      }
      //System.out.println("masterlist size: " + this.masterlist.size());
      //System.out.println("period " + period1 + " size: " + this.masterlist.get(period1).size());
      int index1 = random.nextInt(this.masterlist.get(period1).size());
      Specificcourse course1 = this.masterlist.get(period1).get(index1); 
      this.masterlist.get(period1).remove(index1);

      int period2 = random.nextInt(7);
      while (this.masterlist.get(period2).size() == 0) {
        period2 = random.nextInt(8);
      }
      int index2 = random.nextInt(this.masterlist.get(period2).size());
      Specificcourse course2 = this.masterlist.get(period2).get(index2);
      this.masterlist.get(period2).remove(index2);

      this.masterlist.get(period1).add(course2);
      this.masterlist.get(period2).add(course1);
     } 
  }
}