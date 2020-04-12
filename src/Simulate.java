import java.util.Random;

public class Simulate {
	
	private static int maskUsePers;
	private static int immunePers;
	private static double humanInfP;
	private static double humanSpaceP;
	private static double movingP;
	private static int height;
	private static int width;
	private static int population;
	private static int initialPop;
	private static int timeForSquareToBeSafe;
	private static Random randomizer = new Random();
	
	public Simulate(int mask, int immune, double humanInf, double spaceInf, double moving, int h, int w, int pop, int initialpop, int timesquare){
		maskUsePers=mask;
		immunePers=immune;
		humanInfP=humanInf;
		humanSpaceP=spaceInf;
		movingP=moving;
		height=h;
		width=w;
		population=pop;
		initialPop=initialpop;
		timeForSquareToBeSafe=timesquare;
	}
	
	private Human[] makeHumans() {
		Human[] h=new Human[population];
		for(int i=0; i<population; i++) {
			boolean mask= randomizer.nextInt(101)<=maskUsePers;
			
			if(i<initialPop)
				h[i]=new Sick(mask, humanInfP);
			else {
				boolean im= randomizer.nextInt(101)<=immunePers;
				h[i]=new Healthy(im, mask, humanInfP);
			}
		}
	}
	
	
	public void runSimulation() {
		Human[] h=makeHumans();
		
		//Grid g = new Grid(height,width);
	}
	
	private void randomPos() {
		
		
	}
		
}

