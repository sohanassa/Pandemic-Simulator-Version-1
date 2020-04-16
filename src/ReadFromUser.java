import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is for reading the inputs from the user and running the simulation based on the inputs given.
 * 
 * @author Zoe Passiadou
 * @author Sohaib Nassar
 *
 */
public class ReadFromUser {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int h=0,w=0,people=0,time=0,timeSpace=0,maskPers=0,immunePers=0,timeSpaceInfected=0,maskProtection=0;
		double movingP=0,infectingP=0,infSpaceP=0,spaceInfHuman=0;
		
		boolean error=false;
	do {                                         // do while loop for re reading in case exception was thrown
		try {                                    //try for reading all inputs 
		   error=false;  //for checking if exception was thrown
	       System.out.println("COVID-19 SIMULATOR!\n");
	       System.out.println("*StdDraw Disclaimer*\n1)Green Circle <- Healthy Person\n2)Orange Circle <- Sick Person\n3)Red Square <- Infected Area\n");
		   System.out.print("Give size of place (height width):");
		   h=in.nextInt();
		   w=in.nextInt();
		
		   System.out.print("Give number of people:");
		   people = in.nextInt();
		   if(people>(h*w)) //if the people are more than the capacity of out place 
			   throw new Exception("Number of people must be smaller than space capacity"); //throw exception
		
		   System.out.print("Give time of simmulation in minutes:");
		   time = in.nextInt();
		    if(time<=0)   //if the time given is negative
		    	throw new Exception("Time must be larger than 0"); //throw exception
		
		   System.out.print("Give the time needed for a space to become disinfected:");
		   timeSpace = in.nextInt();
		   if(timeSpace<=0) //if the time given is negative
		    	throw new Exception("Time must be larger than 0");//throw exception
		   
		   System.out.print("Give the time needed for a space to get infected:");
		   timeSpaceInfected = in.nextInt();
		   if(timeSpaceInfected<=0)//if the time given is negative
		    	throw new Exception("Time must be larger than 0");//throw exception
		   System.out.print("Give possibility of moving (between 0-1):");
		   movingP = in.nextDouble();
		   if(movingP>1 || movingP<0) //if the possibility is not from 0-1
			   throw new Exception("possibility of moving must be between 0 and 1!");//throw exception
		
		   System.out.print("Give possibility of infecting another human (between 0-1):");
		   infectingP = in.nextDouble();
		   if(infectingP>1 || infectingP<0) //if the possibility is not from 0-1
			   throw new Exception("possibility of infecting another human must be between 0 and 1!");//throw exception
		
		   System.out.print("Give possibility of infecting a space (between 0-1):");
		   infSpaceP = in.nextDouble();
		   if(infSpaceP>1 || infSpaceP<0)//if the possibility is not from 0-1
			   throw new Exception("possibility of infecting a space must be between 0 and 1!");//throw exception
		
		   System.out.print("Give possibility of getting infected froma a space (between 0-1):");
		   spaceInfHuman = in.nextDouble();
		   if(spaceInfHuman>1 || spaceInfHuman<0)//if the possibility is not from 0-1
			   throw new Exception("possibility of getting infected froma a space must be between 0 and 1!");//throw exception
		
		   System.out.print("Give percentage of mask use (between 0-100):");
		   maskPers = in.nextInt();
		   if(spaceInfHuman>100 || spaceInfHuman<0)// if the possibility is not from 0-100
			   throw new Exception("percentage of mask use must be between 0 and 100!");//throw exception
		
		   System.out.print("Give percentage of immune peoplee (between 0-100):");
		   immunePers = in.nextInt();
		   if(immunePers>100 || immunePers<0)// if the possibility is not from 0-100
			   throw new Exception("percentage of immune people must be between 0 and 100!");//throw exception
		   
		   System.out.print("Give the percentage of protection that a face mask gives (between 0-100):");
		     maskProtection=in.nextInt();
		     if(maskProtection>100 || maskProtection<0)// if the possibility is not from 0-100
				   throw new Exception("percentage must be between 0 and 100!");//throw exception
		     
		     
        }
		
		catch(InputMismatchException e) {              //catch  InputMismatchException
			 error=true;                               //set error as true
		     System.out.println("Wrong input!");
		     in.nextLine();
	       }
		
		catch(Exception e) {//catch  InputMismatchException
			error=true;//set error as true
			System.out.println(e.getMessage());
			in.hasNextLine();
	    	}

		
	   }while(error);
		//create an object type Simulate
	   Simulate s= new Simulate(maskPers,immunePers,infectingP,infSpaceP,spaceInfHuman,movingP,h,w,people,timeSpace,time,timeSpaceInfected,maskProtection);
	   
	   s.runSimulation(); //call runSimulation
	   System.out.println("END OF SIMULATION!");
	   System.exit(0);
	}
}