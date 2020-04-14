import java.util.Random;

public class Simulate {
	
	private static int maskUsePers;
	private static int immunePers;
	private static double humanInfP;
	private static double humanSpaceP;
	private static double spaceHumanP;
	private static double movingP;
	private static int height;
	private static int width;
	private static int population;
	private static int timeForSquareToBeSafe;
	private static int time;
	private static int timeForSquareToGetInfected;
	private static Random randomizer = new Random();
	
	
	
	public Simulate(int mask, int immune, double humanInf, double spaceInf,double spacetoHuman, double moving, int h, int w, int pop, int timesquare, int time, int timespacegettinginfected){
		maskUsePers=mask;
		immunePers=immune;
		humanInfP=humanInf;
		humanSpaceP=spaceInf;
		spaceHumanP=spacetoHuman;
		movingP=moving;
		height=h;
		width=w;
		population=pop;
		timeForSquareToBeSafe=timesquare;
		timeForSquareToGetInfected=timespacegettinginfected;
		this.time=time;
	}
	
	private Human[] makeHumans() {
		
		Human[] h=new Human[population];
		for(int i=0; i<population; i++) {
			boolean mask= randomizer.nextInt(100)<=maskUsePers;
			
			if(i==0)
				h[i]=new Sick(mask, humanInfP, humanSpaceP);
			else {
				boolean im= randomizer.nextInt(100)<=immunePers;
				h[i]=new Healthy(im, mask);
			}
		}
		return h;
	}
	
	private Human[][] make2DHuman(Human[] human) {
		Human[][] h = new Human[height][width];
		for(int i=0; i<population; i++) {
			int[] pin=randomPos();
			while(h[pin[0]][pin[1]]!=null) {
				pin=randomPos();
			}
			h[pin[0]][pin[1]]=human[i];
		}
		return h;
	}
	
    private int[] randomPos() {
		int[] pin= {randomizer.nextInt(height),randomizer.nextInt(width)};
		return pin;
	}
	
    private Human makeSick(Human he) {
    	Healthy healthy = (Healthy) he;
    	if(!healthy.getImmune())
    	   return new Sick(he.getMask(),humanInfP ,humanSpaceP);
    	return null;
    }
    
    
	
    
	public void runSimulation() {
		Human[][] h=make2DHuman(makeHumans());
		Grid g = new Grid(h);
		for(int i=0; i<time; i++)
			runOneMinute(g);
	}
	
	private void runOneMinute(Grid g) {
		g.infectSpaces(timeForSquareToGetInfected);
		
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				
				if(g.getHumanAt(i, j)!=null) {
				if(g.getHumanAt(i,j).getClass()==Healthy.class) {
					if(g.CheckForInfected(i, j)) {
						g.setHuman(makeSick(g.getHumanAt(i, j)), i, j);
						System.out.println("Person was infected in position ("+i+","+j+") by another human");
					}
					if(g.CheckForInfectedSpace(i, j, spaceHumanP)) {
						g.setHuman(makeSick(g.getHumanAt(i, j)), i, j);
						System.out.println("Person was infected in position ("+i+","+j+") by space");
					}
					
					}
				if(randomizer.nextInt(100)<=movingP*100) {
					g.move(i,j);
					
				}
				else
					g.StayedInSamePosition(i, j);
				
				
				
				
			}
		}
		
    	}
	}
	
	
	
	
	
	
	
}

