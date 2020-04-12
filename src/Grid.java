
import edu.princeton.cs.introcs.StdDraw;

public class Grid {

	private int length;
	private int width;
	private Human[][] h;
	private boolean[][] infectedSpace;

	public Grid(Human[][] h) {
		this.length=h.length;
		this.width=h[0].length;
		this.h=h;
		this.infectedSpace = new boolean[length][width];
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
	
	public void move(int Istart, int Jstart, int Idest, int Jdest) {
		h[Idest][Jdest]=h[Istart][Jstart];
		h[Istart][Jstart]=null;
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

