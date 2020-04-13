import java.util.InputMismatchException;
import java.util.Scanner;
public class ReadFromUser {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h=0,w=0,people=0,time=0,timeSpace=0,maskPers=0,immunePers=0;
		double movingP=0,infectingP=0,infSpaceP=0,spaceInfHuman=0;
		
		try {
	       System.out.println("COVID-19 SIMULATOR! ");
		   System.out.print("Give size of place (height width): ");
		   h=in.nextInt();
		   w=in.nextInt();
		
		   System.out.print("Give number of people: ");
		   people = in.nextInt();
		
		   System.out.print("Give time of simmulation in minuts: ");
		   time = in.nextInt();
		
		   System.out.print("Give time for a space to be safe: ");
		   timeSpace = in.nextInt();
		
		   System.out.print("Give possibility of moving (between 0-1): ");
		   movingP = in.nextDouble();
		
		   System.out.print("Give possibility of infecting another human (between 0-1): ");
		   infectingP = in.nextDouble();
		
		   System.out.print("Give possibility of infecting a space (between 0-1): ");
		   infSpaceP = in.nextDouble();
		
		   System.out.print("Give possibility of getting infected froma a space (between 0-1): ");
		   spaceInfHuman = in.nextDouble();
		
		   System.out.print("Give percentage of mask use (between 0-100): ");
		   maskPers = in.nextInt();
		
		   System.out.print("Give percentage of immune peope (between 0-100): ");
		   immunePers = in.nextInt();
        }
		
		catch(InputMismatchException e) {
		     System.out.println("Wrong inpu!");
		     System.exit(0);
	       }
		
		Simulate s= new Simulate(maskPers,immunePers,infectingP,infSpaceP,spaceInfHuman,movingP,h,w,people,timeSpace,time);
		s.runSimulation();
	}

}