import java.util.InputMismatchException;
import java.util.Scanner;
public class ReadFromUser {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h=0,w=0,people=0,time=0,timeSpace=0,maskPers=0,immunePers=0,timeSpaceInfected=0;
		double movingP=0,infectingP=0,infSpaceP=0,spaceInfHuman=0;
		boolean error=false;
	do {
		
	System.out.println();
		try {
			error=false;
	       System.out.println("COVID-19 SIMULATOR! ");
		   System.out.print("Give size of place (height width): ");
		   h=in.nextInt();
		   w=in.nextInt();
		
		   System.out.print("Give number of people: ");
		   people = in.nextInt();
		   if(people>(h*w))
			   throw new Exception("Number of people must be smaller than space capacity");
		
		   System.out.print("Give time of simmulation in minuts: ");
		   time = in.nextInt();
		    if(time<=0)
		    	throw new Exception("Time must be larger than 0");
		
		   System.out.print("Give time for a space to be safe: ");
		   timeSpace = in.nextInt();
		   if(timeSpace<=0)
		    	throw new Exception("Time must be larger than 0");
		   
		   System.out.print("Give time for a space to get infected: ");
		   timeSpaceInfected = in.nextInt();
		   if(timeSpaceInfected<=0)
		    	throw new Exception("Time must be larger than 0");
		   System.out.print("Give possibility of moving (between 0-1): ");
		   movingP = in.nextDouble();
		   if(movingP>1 || movingP<0)
			   throw new Exception("possibility of moving must be between 0 and 1!");
		
		   System.out.print("Give possibility of infecting another human (between 0-1): ");
		   infectingP = in.nextDouble();
		   if(infectingP>1 || infectingP<0)
			   throw new Exception("possibility of infecting another human must be between 0 and 1!");
		
		   System.out.print("Give possibility of infecting a space (between 0-1): ");
		   infSpaceP = in.nextDouble();
		   if(infSpaceP>1 || infSpaceP<0)
			   throw new Exception("possibility of infecting a space must be between 0 and 1!");
		
		   System.out.print("Give possibility of getting infected froma a space (between 0-1): ");
		   spaceInfHuman = in.nextDouble();
		   if(spaceInfHuman>1 || spaceInfHuman<0)
			   throw new Exception("possibility of getting infected froma a space must be between 0 and 1!");
		
		   System.out.print("Give percentage of mask use (between 0-100): ");
		   maskPers = in.nextInt();
		   if(spaceInfHuman>100 || spaceInfHuman<0)
			   throw new Exception("percentage of mask use must be between 0 and 100!");
		
		   System.out.print("Give percentage of immune peoplee (between 0-100): ");
		   immunePers = in.nextInt();
		   if(immunePers>100 || immunePers<0)
			   throw new Exception("percentage of immune people must be between 0 and 100!");
        }
		
		catch(InputMismatchException e) {
			error=true;
		     System.out.println("Wrong input!");
		     
		     String l=in.nextLine();
	       }
		catch(Exception e) {
			error=true;
			System.out.println(e.getMessage());
			
		}

		
	}while(error);
		
		Simulate s= new Simulate(maskPers,immunePers,infectingP,infSpaceP,spaceInfHuman,movingP,h,w,people,timeSpace,time,timeSpaceInfected);
		s.runSimulation();
	}

}