import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;

public class DrawSimulation {
	int length=10;
	int width=10;
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
	public  void DrawHumansMovement(int newpx, int newpy, int x, int y, Color c) {
	
	StdDraw.setPenRadius(0.2);
	StdDraw.setPenColor(c);
	StdDraw.filledCircle(newpx+0.5, newpy+0.5, 0.05);   //taking a blind guess about where it will be placed lollll
	StdDraw.setPenColor(StdDraw.WHITE);
	StdDraw.filledCircle(x+0.5, y+0.5, 0.05);
	
}
public void DrawInfectedArea(int i, int j){
	StdDraw.setPenRadius(0.2);
	StdDraw.setPenColor(StdDraw.GREEN);
	StdDraw.filledRectangle(i, j, halfWidth, halfHeight); //idk what this is gonna look like damn
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawSimulation n=new DrawSimulation();
		//n.DrawHumansMovement(5,5,6,7,StdDraw.BLACK);

		n.drawGrid();

	}

}
