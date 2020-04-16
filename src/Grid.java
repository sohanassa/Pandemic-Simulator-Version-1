import java.awt.Color;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

/**
 * This Class creates an object Grid which represents the humans and the spaces in the simulation.
 * 
 * @author Zoe Passiadou
 * @author Sohaib Nassar
 *
 */
public class Grid {

	private int length;                        //represents the length of the grid
	private int width;                         //represents the width of the grid
	private Human[][] human;                   //An array type Human
	private boolean[][] infectedSpace;         //an array that represents whether or not the space at a certain position is infected
	private int[][] freeOfInfectedPeopleTime;  //an array that holds the time that a certain position has been free of an infected person
	private int[][] timeStayedInSamePosition;  //an array that holds the time that an infected person has been in the same position for
	private static Random randomizer = new Random();
	private DrawSimulation draw;  //an object type DrawSimulation

	
	public Grid(Human[][] h) {            //constuctor receives a 2D array type Human
		this.length=h.length;             //set length 
  		this.width=h[0].length;           //set width
		this.human=h;                         //set the 2D Human array of Grid equal to the given one 
		this.infectedSpace = new boolean[length][width];   //initialise the size of infectedspace
		this.freeOfInfectedPeopleTime=new int[length][width];  //initialise size of freeOfInfectedPeopleTime
		this.timeStayedInSamePosition=new int[length][width];  //initialise size of timeStayedInSamePositio
		draw = new DrawSimulation(length,width);  
		draw.DrawGrid();                                       //print the grid by callin the method DrawGrid in the class DrawSimulation
	}
	
	public void setHuman(Human hum, int i, int j) {    //this method takes as parameters a Human and two integers
		human[i][j]=hum;  //this sets the position i,j of the array human, equal to the given one
	}
	
	
	/**
	 * This method returns the human at the position i,j in the array human.
	 * @param i represents the row 
	 * @param j represents the column
	 * @return object Human at the given position
	 */
	public Human getHumanAt(int i, int j) {
		return human[i][j];
	}
	
	
//	public Human[][] getHuman2D(){
//		return human;
//	}
	
	/**
	 * This method returns the content of the array getInfectedSpaceAt at the given position.
	 * @param i represents the row
	 * @param j represents the column
	 * @return boolean,content of the array getInfectedSpaceAt at the given position. 
	 */
	public boolean getInfectedSpaceAt(int i, int j) {
		return infectedSpace[i][j];
	}
	
	/**
	 * This method checks to see if the positions will become infected.
	 * @param timeNeeded represents the time needed for space to get infected
	 */
	public void infectSpaces(int timeNeeded) {
		for(int i=0; i<length; i++)   //checking for every position in the array
			for(int j=0; j<width; j++)
				if(human[i][j]!=null && (human[i][j].getClass()==Sick.class)) { //if the human in that position is Sick
					//using randomizer,if the possibility is higher then the random number, and the time stayed in same spot is equal or larger than timeNeeded
					Sick sik = (Sick) human[i][j];  //downcasting
					if(sik.getPossibilityOfInfectingSpace()>=randomizer.nextDouble() && timeStayedInSamePosition[i][j]>=timeNeeded  )
					 infectedSpace[i][j]=true; //then infect the space
					 DrawOne(i,j);             //call method DrawOne to visually represent the infected area on our canvas
				}
	}
	
	/**
	 * This method moves the human by putting it in new position and setting old position equal to null. 
	 * @param Istart represents the row of current position
	 * @param Jstart represents the column of current position
	 * @param Idest  represents the row of new position
	 * @param Jdest  represents the column of new position
	 */
	private void move(int Istart, int Jstart, int Idest, int Jdest) {
		human[Idest][Jdest]=human[Istart][Jstart]; //move human to new position
		human[Istart][Jstart]=null;   //set old position equal to null 
		if(human[Idest][Jdest].getClass()==Sick.class) {  //if the human we just moved was sick
			freeOfInfectedPeopleTime[Idest][Jdest]=0;     //set the value of the array freeOfInfectedPeopleTime eqaul to zero for the new position
		}
		timeStayedInSamePosition[Idest][Jdest]=0; // as well as the value of timeStayedInSamePosition
		DrawOne(Idest, Jdest);    //call method DrawOne for both positions to represent them on our canvas 
		DrawOne(Istart, Jstart);
		
		
			
	}
	
	/**
	 * This method uses Math.random to determine the new position of the human.
	 * @param i represents the row of the current position
	 * @param j represents the column of the current position
	 */
	public void move(int i,int j) {
		boolean move=false;     //will represent whether or not the human can actually move to new position 
		double r;
		int xp=i;  
		int yp=j;
		if(!CheckIfSurrounded(i,j)) {   //first we must check that the human is not surrounded and can in fact move
		while(!move) {                       
			xp=i;                        //set new positions equal to current 
			yp=j;
			  r=(double) Math.random()*2.0;  // get a random number using Math.random                                  
			  if(r<=0.25)                    //depending on the value of r get the new postion 
				  xp++;
			  else if(r<=0.50)
				  xp--;
			  else if(r<=0.75)
				  yp++;
			  else if(r<=1.00)
				  yp--;
			  else if(r<=1.25) {
				  xp--;
				  yp--;
			  }
			  else if(r<=1.50) {
				  xp--;
				  yp++;
			  }
			  else if(r<=1.75) {
				  xp++;
				  yp--;
			  }
			  else if(r<=2.00) {
				  xp++;
				  yp++;
			  }
			  
			 if(xp>=0 && xp<length && yp>=0 && yp<width && human[xp][yp]==null) {//if the human can move to the new position
				
				 move=true; //set move as true
				 this.move(i,j,xp,yp); // call move to make the swap

			 }
		}
		}
		else //else if the human is surrounded 
			StayedInSamePosition(i,j); //then call the method StayedInSamePosition
		}
	
/**
 * This method checks to see if the human is completely surrounded.
 * @param i represents the row in the array
 * @param j represents the column
 * @return boolean ,true if surrounded, else returns false
 */
private boolean CheckIfSurrounded(int i,int j) {
	for(int k=i-1;k<i+2; k++) { //going around all the surrounding positions
		for(int c=j-1;c<j+2;c++) {
		  if(c>=0 && c<width && k>=0 && k<length && i!=k && j!=c) { //if we are still within the array
			  if(human[k][c]==null) //check if the position is null
				  return false;     //if not then return false
			  }
		  }
	}
	return true; //else return true
}	
	/**
	 * This method checks if the there is a sick human around a healthy one, and checks if they get sick.
	 * @param i represents the row of the position of the healthy human
	 * @param j represents the row of the position of the healthy human
	 * @return boolean, true if they get sick , else returns false
	 */
	public boolean CheckForInfected(int i,int j) {
		for(int k=i-1;k<i+2; k++) { //going around all the surrounding positions
			for(int c=j-1;c<j+2;c++) {
			  if(c>=0 && c<width && k>=0 && k<length) {//if we are still within the array
				if(getHumanAt(k,c)!=null && (k!=i&&c!=j) && (getHumanAt(k,c).getClass()==Sick.class)) { //check if there is a sick human around
					double random = randomizer.nextDouble();
					//check if the healthy human gets sick
					Sick sik = (Sick) getHumanAt(k,c); //downcasting
						if(sik.getPossibilityToInfect()*( (Healthy) getHumanAt(i,j)).getPossibilityOfInfection()>=random)
							return true; //if so return true
				}
			  }
			}
			
		}
		return false; //else return false
		
	}
	

	/**
	 * This method checks if the human is in an infected spaces, and checks whether or not they get sick.
	 * @param i  represents the row of the position of the healthy human
	 * @param j  represents the column of the position of the healthy human
	 * @param SpaceToHumanP represents the possibility of human to get infected by a space
	 * @return boolean, true if they get sick, else return false
	 */
	public boolean CheckForInfectedSpace(int i,int j, double SpaceToHumanP) {
		double random = randomizer.nextDouble();
		if(infectedSpace[i][j]) //if the sapce they are in is infected
			if(getHumanAt(i,j).getClass()==Healthy.class && ((Healthy) getHumanAt(i,j)).getPossibilityOfInfection() *SpaceToHumanP>=random) //check to see if they get infected, using randomizer
				return true;
		return false;
			
		
	}
	
	/**
	 * This method checks to see if the position has become free of infection.
	 * @param timeForSquareToBeSafe represents the time that needs to pass in order for a position to become free of infection.
	 * @param i  represents the row of the position 
	 * @param j represents the row of the position 
	 * @return boolean, true if its not longer infected , else false
	 */
	private boolean hasBeenFreeOfInfected(int timeForSquareToBeSafe,int i,int j) {
		
		if(freeOfInfectedPeopleTime[i][j]>=timeForSquareToBeSafe) // checks if the time that it has been free is larger than timeForSquareToBeSafe
			return true; 
		return false;
		
	}
	
	/**
	 * this method checks for all positions if they are no longer infected.
	 * @param timeForSquareToBeSafe imeForSquareToBeSafe represents the time that needs to pass in order for a position to become free of infection.
	 */
	public void AllArrayHasBeenFreeOfInfected(int timeForSquareToBeSafe) {
		for(int i=0; i<length; i++) //for every position
			for(int j=0; j<width; j++) {
				if(hasBeenFreeOfInfected(timeForSquareToBeSafe,i,j)) { //call the method hasBeenFreeOfInfected
					infectedSpace[i][j]=false;   //if it returns true then set infectedSpace in that area equal to false 
					DrawOne(i, j);              // call DrawOne to represent it on our canvas
				}
			}
	}
	
	/**
	 * This method checks to see if the position is free of sick people and increases .
	 */
	public void AddFreeOfInfectedPeopleTime() {
		for(int i=0; i<length; i++) //for every position
			for(int j=0; j<width; j++) {
				if(human[i][j]==null || human[i][j].getClass()==Healthy.class) { //if it doesnt have a sick person in it
					freeOfInfectedPeopleTime[i][j]++; //increase the time
				}
			}
	}
	
	/**
	 * This method checks if the human in the given position is sick and increases the timeStayedInSamePosition.
	 * @param i represents the row 
	 * @param j represents the column
	 */
	public void StayedInSamePosition(int i, int j) {
		if(human[i][j].getClass()==Sick.class)
		   timeStayedInSamePosition[i][j]++;
	}
	
	/**
	 * This method is used to represents the humans and the infected area on the canvas.
	 * @param i represents the row 
	 * @param j represents the column
	 */
	private void DrawOne(int i, int j) {
		if(infectedSpace[i][j])             //if the area is infected
			draw.DrawInfectedArea(i, j);      //call DrawInfectedArea
		else
			draw.DisInfectArea(i, j);         // else call DisInfectArea
		
		if(human[i][j]!=null) {          //if the position is not null
		    Color c = StdDraw.GREEN;      
		    if(human[i][j].getClass()==Sick.class) // if the human is sick change pen colour
			   c=StdDraw.ORANGE;
			draw.DrawHuman(i, j, c);  //call DrawHuman
	    }
	}
}