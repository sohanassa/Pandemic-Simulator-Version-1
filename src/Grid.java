
import edu.princeton.cs.introcs.StdDraw;

public class Grid {

	private int length;
	private int width;
	private Human[][] h;

	public Grid(int length,int width, Human[][] h) {
		this.length=length;
		this.width=width;
		this.h=h;
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

