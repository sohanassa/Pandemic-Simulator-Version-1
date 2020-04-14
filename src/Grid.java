import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Grid {

	private int length;
	private int width;
	private Human[][] h;
	private boolean[][] infectedSpace;
	private int[][] freeOfInfectedPeopleTime;
	private static Random randomizer = new Random();

	public Grid(Human[][] h) {
		this.length=h.length;
		this.width=h[0].length;
		this.h=h;
		this.infectedSpace = new boolean[length][width];
		this.freeOfInfectedPeopleTime=new int[length][width];
	}
	
	public void setHuman(Human hum, int i, int j) {
		h[i][j]=hum;
	}
	
	
	public Human getHumanAt(int i, int j) {
		return h[i][j];
	}
	
	public Human[][] getHuman2D(){
		return h;
	}
	
	public boolean getInfectedSpaceAt(int i, int j) {
		return infectedSpace[i][j];
	}
	
	public boolean[][] getInfectedSpace() {
		return infectedSpace;
	}
	
	public void setSafeSpaceAt(int i, int j) {
		infectedSpace[i][j]=false;
	}
	
	public void setDangerousSpaceAt(int i, int j) {
		infectedSpace[i][j]=true;
	}
	
	public void infectSpaces(int timeNeeded) {
		for(int i=0; i<length; i++)
			for(int j=0; j<width; j++)
				if(h[i][j]!=null && (h[i][j].getClass()==Sick.class)) {
					if(h[i][j].getPossibilityOfInfectingSpace()*100>=randomizer.nextInt(100) &&  )
					 infectedSpace[i][j]=true;
				}
	}
	
	public void setFreeofInfectedPositionAt(int i, int j) {
		freeOfInfectedPeopleTime[i][j]++;
	}
	
	public int getFreeOfInfectedPeopleTimeAt(int i, int j) {
		return freeOfInfectedPeopleTime[i][j];
	}
	
	private void move(int Istart, int Jstart, int Idest, int Jdest) {
		h[Idest][Jdest]=h[Istart][Jstart];
		h[Istart][Jstart]=null;
		if(h[Idest][Jdest].getClass()==Sick.class) {
			freeOfInfectedPeopleTime[Idest][Jdest]=0;
			infectedSpace[Idest][Jdest]=true;
		}
			
			}
	
	public void move(int i,int j) {
		boolean move=false;
		double r;
		int xp=i;
		int yp=j;
				
		while(!move) {                                      
			
			  r=Math.random()*2;                                   
			  if(r<=0.25)
				  xp++;
			  else if(r>0.25&&r<=0.50)
				  xp--;
			  else if(r>0.50&&r<=0.75)
				  yp++;
			  else if(r>0.75&&r<=1.00)
				  yp--;
			  else if(r>1.00&&r<=1.25) {
				  xp--;
				  yp--;
			  }
			  else if(r>1.25&&r<=1.50) {
				  xp--;
				  yp++;
			  }
			  else if(r>1.50&&r<=1.75) {
				  xp++;
				  yp--;
			  }
			  else if(r>1.75&&r<=2.00) {
				  xp++;
				  yp++;
			  }
			  
			 if(h[xp][yp]==null) {
				 move=true;
				 this.move(i,j,xp,yp);

			 }
		}
		}
	
	public boolean CheckForInfected(int i,int j) {
		for(int k=i-1;k<i+2;k++) {
			for(int c=j-1;c<j+2;c++) {
				if(getHumanAt(k,c)!=null && (k!=i&&c!=j) && (getHumanAt(k,c).getClass()==Sick.class)) {
					int random = randomizer.nextInt(100);
						if(getHumanAt(k,c).getPossibilityToInfect()*getHumanAt(i,j).getPossibilityOfInfection()*100>=random)
							return true;
				}
			}
			
		}
		return false;
		
	}
	

	public boolean CheckForInfectedSpace(int i,int j, double SpaceToHumanP) {
		int random = randomizer.nextInt(100);
		if(infectedSpace[i][j])
			if(getHumanAt(i,j).getPossibilityOfInfection()*SpaceToHumanP*100>=random)
				return true;
		return false;
			
		
	}
	private boolean hasBeenFreeOfInfected(int timeForSquareToBeSafe,int i,int j) {
		
		if(getFreeOfInfectedPeopleTimeAt(i,j)>=timeForSquareToBeSafe)
			return true;
		return false;
		
	}
	
	public void AllArrayHasBeenFreeOfInfected(int timeForSquareToBeSafe) {
		for(int i=0; i<length; i++)
			for(int j=0; j<width; j++) {
				if(hasBeenFreeOfInfected(timeForSquareToBeSafe,i,j)) {
					infectedSpace[i][j]=false;
				}
			}
	}
	
	public void AddFreeOfInfectedPeopleTime() {
		for(int i=0; i<length; i++)
			for(int j=0; j<width; j++) {
				if(h[i][j]==null || h[i][j].getClass()==Healthy.class) {
					freeOfInfectedPeopleTime[i][j]++;
				}
			}
	}
	
	public void drawGrid() {
		 StdDraw.setXscale(-1,length+1);                               
         StdDraw.setYscale(-1,width+1);
         StdDraw.setPenColor(StdDraw.BLACK);
         StdDraw.setPenRadius(0.2/(length*2));
         
		 for(int i=0;i<=this.length;i++) {                                
   		     StdDraw.line(0.0,0.0+i,0.0+length,0.0+i);
   		     StdDraw.line(0.0+i,0.0,0.0+i,0.0+width);
          }
	}
}