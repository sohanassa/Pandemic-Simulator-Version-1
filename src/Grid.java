
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Grid {

	private int length;
	private int width;
	private Human[][] h;
	private boolean[][] infectedSpace;
	private int[][] freeOfInfectedPeople;
	private static Random randomizer = new Random();

	public Grid(Human[][] h) {
		this.length=h.length;
		this.width=h[0].length;
		this.h=h;
		this.infectedSpace = new boolean[length][width];
		this.freeOfInfectedPeople=new int[length][width];
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
	
	public void setAllOccupiedSpacesDangerous() {
		for(int i=0; i<length; i++)
			for(int j=0; j<width; j++)
				if(h[i][j]!=null && (h[i][j].getClass()==Sick.class)) {
					infectedSpace[i][j]=true;
				}
	}
	
	public void setTimeStayedInSamePositionAt(int i, int j) {
		timeStayedInSamePosition[i][j]++;
	}
	
	public int getTimeStayedInSamePositionAt(int i, int j) {
		return timeStayedInSamePosition[i][j];
	}
	
	public void move(int Istart, int Jstart, int Idest, int Jdest) {
		h[Idest][Jdest]=h[Istart][Jstart];
		h[Istart][Jstart]=null;
		timeStayedInSamePosition[Idest][Jdest]=0;
		timeStayedInSamePosition[Istart][Jstart]=0;
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
		boolean gotSick=false;
		for(int k=i-1;k<i+2;k++) {
			for(int c=j-1;c<j+2;c++) {
				if(getHumanAt(k,c)!=null && (k!=i&&c!=j) && (getHumanAt(k,c).getClass()==Sick.class)) {
					int random = randomizer.nextInt(100);
						if(getHumanAt(k,c).getPossibilityToInfect()*100>=random && getHumanAt(i,j).getPossibilityOfInfection()*100>=random)
							gotSick=true;
				}
			}
			
		}
		return gotSick;
		
	}
	

	public boolean CheckForInfectedSpace(int i,int j, double SpaceToHumanP) {
		boolean infected[][]=getInfectedSpace();
		int random = randomizer.nextInt(100);
		if(infected[i][j])
			if(getHumanAt(i,j).getPossibilityOfInfection()*100>random && SpaceToHumanP>random)
				return true;
		return false;
			
		
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

