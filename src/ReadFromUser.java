import java.util.Scanner;
public class ReadFromUser {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("COVID-19 SIMULATOR!");
		System.out.print("Give size of place (height width): ");
		int h=in.nextInt();
		int w=in.nextInt();
		
		System.out.print("Give number of people: ");
		int people = in.nextInt();
		
		System.out.print("Give time of simmulation in minuts: ");
		int time = in.nextInt();
		
		System.out.print("Give time for a space to be safe: ");
		int timeSpace = in.nextInt();
		
		System.out.print("Give possibility of moving (between 0-1): ");
		double movingP = in.nextDouble();
		
		System.out.print("Give possibility of infecting another human (between 0-1): ");
		double infectingP = in.nextDouble();
		
		System.out.print("Give possibility of infecting a space (between 0-1): ");
		double infSpaceP = in.nextDouble();
		
		System.out.print("Give possibility of getting infected froma a space (between 0-1): ");
		double spaceInfHuman = in.nextDouble();
		
		System.out.print("Give percentage of mask use (between 0-100): ");
		int maskPers = in.nextInt();
		
		System.out.print("Give percentage of immune peope (between 0-100): ");
		int immunePers = in.nextInt();
		
		Simulate s= new Simulate(maskPers,immunePers,infectingP,infSpaceP,spaceInfHuman,movingP,h,w,people,timeSpace,time);
		s.runSimulation();
	}

}