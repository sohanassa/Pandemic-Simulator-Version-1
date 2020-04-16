import java.util.Random;

/**
 * This class creates an object called Simulate
 * @author Zoe Passiadou
 * @author Sohaib Nassar
 *
 */
public class Simulate {
	
	private static int maskUsePers;  //represents the percentage of mask users
	private static int immunePers;   //represents the percentage of immune people
	private static double humanInfP;  //represents the possibility of a human infecting another
	private static double humanSpaceP;  //represents the possibility of a human to infect a space
	private static double spaceHumanP;     //represents the possibility of a space infecting a human
	private static double movingP;         //represents the possibility of moving
	private static int height;             //the heigth of the place
	private static int width;              //the width of the place
	private static int population;         
	private static int timeForSquareToBeSafe;   //represents the time needed for a square to be free of infection
	private static int time;                    //time of the simulaion
	private static int timeForSquareToGetInfected;  //time needed for a square to get infected
	private static int maskProtection;             //how much the mask protects
	private static Random randomizer = new Random();
	
	//constructor
	public Simulate(int mask, int immune, double humanInf, double spaceInf,double spacetoHuman, double moving, int h, int w, int pop, int timespace, int time, int timespacegettinginfected, int maskProtection){
		maskUsePers=mask;
		immunePers=immune;
		humanInfP=humanInf;
		humanSpaceP=spaceInf;
		spaceHumanP=spacetoHuman;
		movingP=moving;
		height=h;
		width=w;
		population=pop;
		timeForSquareToBeSafe=timespace;
		timeForSquareToGetInfected=timespacegettinginfected;
		this.time=time;
		this.maskProtection=maskProtection;
	}
	
	/**
	 * This method creates all the humans.
	 * @return array of humans.
	 */
	private Human[] makeHumans() {
		
		Human[] h=new Human[population];
		for(int i=0; i<population; i++) {
			boolean mask= randomizer.nextInt(101)<=maskUsePers; //to determine if the human will be using mask
			
			if(i==0) //make the first human sick
				h[i]=new Sick(mask, humanInfP, humanSpaceP, maskProtection);
			else {
				boolean im= randomizer.nextInt(101)<=immunePers;  //to determine if he will be immune
				h[i]=new Healthy(im, mask, maskProtection); //create human
			}
		}
		return h;
	}
	
	/**
	 * This method creates a 2d array with humans in random positions, representing the position that they are in.
	 * @param human array of humans.
	 * @return 2d array of humans.
	 */
	private Human[][] make2DHuman(Human[] human) {
		Human[][] h = new Human[height][width];
		for(int i=0; i<population; i++) {
			int[] pin=randomPos();  //get a random position
			while(h[pin[0]][pin[1]]!=null) {  //if that position is not null, get a new position
				pin=randomPos();
			}
			h[pin[0]][pin[1]]=human[i];
		}
		return h;
	}
	
    /**
     * This method returns 2 radnom numbers that represents a position.
     * @return an int array with the position.
     */
    private int[] randomPos() {
		int[] pin= {randomizer.nextInt(height),randomizer.nextInt(width)};
		return pin;
	}
	
    /**
     * This method turns a human sick.
     * @param hu represents the human that will become sick.
     * @return returns a sick human if the human is not a immune, else returns the human healthy.
     */
    private Human makeSick(Human hu) {
    	Healthy healthy = (Healthy) hu;
    	if(!healthy.getImmune())
    	   return new Sick(hu.getMask(),humanInfP ,humanSpaceP, maskProtection);
    	return hu;
    }
    
	/**
	 * This method runs the full simulation.
	 */
	public void runSimulation() {
		Human[][] h=make2DHuman(makeHumans());
		Grid g = new Grid(h);
		for(int i=0; i<time; i++) { //for each minute of the simulation
			System.out.println("Minute: "+(i+1)); 
			runOneMinute(g); //run one minute of it
		}
	}
	
	/**
	 * This method runs one minute of the simulation.
	 * @param g the grid
	 */
	private void runOneMinute(Grid g) {
		g.infectSpaces(timeForSquareToGetInfected); //infect all spaces that need to be
		
		for(int i=0;i<height;i++) {                                  //going through  all the spaces in the array
			for(int j=0;j<width;j++) {
				
			if(g.getHumanAt(i, j)!=null) {                               
				if(g.getHumanAt(i,j).getClass()==Healthy.class) {    //if the human is healthy
					Healthy healthyPer = (Healthy) g.getHumanAt(i, j);
					if(!healthyPer.getImmune() && g.CheckForInfected(i, j)) { //and it is not immune and has gotten infected be other human
						g.setHuman(makeSick(g.getHumanAt(i, j)), i, j);       //make sick
						System.out.println("A person was infected in position ("+i+","+j+") by another person!");
					}
					
					if(!healthyPer.getImmune() && g.CheckForInfectedSpace(i, j, spaceHumanP)) {//else if it got infected by space
						g.setHuman(makeSick(g.getHumanAt(i, j)), i, j);   //make sick
						System.out.println("A person was infected in position ("+i+","+j+") by the space around him/her!");
					}
				}
				if(randomizer.nextDouble()<=movingP)  //move the humans
					 g.move(i,j);
			    else
				     g.StayedInSamePosition(i, j); //else inncrease the time stayed in same position
				
			}// null check
			}//loop2
    	}//loop1
		g.AddFreeOfInfectedPeopleTime();                         //counts time that space been empty of infected people
		g.AllArrayHasBeenFreeOfInfected(timeForSquareToBeSafe);  //makes all infected spaces that have been clear of infected people for some time as safeA
	}//method
	
}

