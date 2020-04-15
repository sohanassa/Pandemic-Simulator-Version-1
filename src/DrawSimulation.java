import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;

public class DrawSimulation {
	int length;
	int width;
	
	public DrawSimulation(int l, int w) {
		length=l;
		width=w;
	}
	
	public void DrawGrid() {
		
	    StdDraw.setXscale(-1,length+1);                               
        StdDraw.setYscale(-1,width+1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.2/(length*2));
        if(width<length)
		 for(int i=0;i<=this.length;i++) {                                
  		     StdDraw.line(0.0,0.0+i,0.0+length,0.0+i);
  		     StdDraw.line(0.0+i,0.0,0.0+i,0.0+width);
         }
        else
        	for(int i=0;i<=this.width;i++) {      
        		StdDraw.setPenRadius(0.2/(width*2));;
     		     StdDraw.line(0.0,0.0+i,0.0+length,0.0+i);
     		     StdDraw.line(0.0+i,0.0,0.0+i,0.0+width);
            }
	}
	
/*public  void DrawHumansMovement(int newpx, int newpy, int x, int y, Color c) {
	
    StdDraw.setPenColor(c);
	StdDraw.filledCircle(newpx-0.5, newpy+0.5, 0.4);   //taking a blind guess about where it will be placed lollll
	StdDraw.setPenColor(StdDraw.WHITE);
	StdDraw.filledRectangle(x-0.5, y+0.5, 0.4, 0.4);
}*/

public void DrawHuman(int x, int y, Color c) {
	StdDraw.setPenColor(c);
	StdDraw.filledCircle(x+0.5, y+0.5, 0.4);
}
	
public void DrawInfectedArea(int i, int j){
	
	StdDraw.setPenColor(StdDraw.RED);
	StdDraw.filledRectangle(i+0.5, j+0.5, 0.4, 0.4); //idk what this is gonna look like damn
	
}
public void DisInfectArea(int i,int j) {
	
	StdDraw.setPenColor(StdDraw.WHITE);
	StdDraw.filledRectangle(i+0.5, j+0.5, 0.4, 0.4);
}

public void FillAll() {
	StdDraw.filledRectangle(0, 0, length, width);
	DrawGrid();
}

	/*public static void main(String[] args) {

		DrawSimulation n=new DrawSimulation(10,30);
		n.DrawGrid();
     //   n.DrawHumansMovement(5,5,6,7,StdDraw.GREEN);
        n.DrawInfectedArea(9,29);
      //  n.DrawHumansMovement(6,6,5,5,StdDraw.GREEN);
	}*/

}
