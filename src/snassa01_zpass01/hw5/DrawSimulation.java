package snassa01_zpass01.hw5;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;

/**
 * This class creates an object called DrawSimulation used for drawing the simulation.
 * 
 *@author Zoe Passiadou
 *@author Sohaib Nassar
 */

public class DrawSimulation {
	int length;          //represents the length of the grid
	int width;          //represents the width of the grid
	
	public DrawSimulation(int l, int w) { //constructor
		length=l;
		width=w;
	}
	
	/**
	 * This method draws the grid 
	 */
	public void DrawGrid() {
		
	    StdDraw.setXscale(-1,length+1);  //setting the scale                             
        StdDraw.setYscale(-1,width+1);
        StdDraw.setPenColor(StdDraw.BLACK); //setting the colour black
        StdDraw.setPenRadius(0.2/(length*2));  //set pen radius
        if(width<length)                                //draw the scale
		 for(int i=0;i<=this.length;i++) {                                
  		     StdDraw.line(0.0,0.0+i,0.0+length,0.0+i); //draw lines diagonally and horizontally
  		     StdDraw.line(0.0+i,0.0,0.0+i,0.0+width);
         }
        else
        	for(int i=0;i<=this.width;i++) {      
        		StdDraw.setPenRadius(0.2/(width*2));;
     		     StdDraw.line(0.0,0.0+i,0.0+length,0.0+i);
     		     StdDraw.line(0.0+i,0.0,0.0+i,0.0+width);
            }
	}

/**
 * This method Draws a human in given position
 * @param x represents the row
 * @param y represents the column
 * @param c colour of the human
 */
public void DrawHuman(int x, int y, Color c) {
	StdDraw.setPenColor(c); //set the pen to given colour
	StdDraw.filledCircle(x+0.5, y+0.5, 0.4); // draw circle in give position
}
	
/**
 * This method Draws infected areas red
 * @param i represents the row
 * @param j represents the column
 */
public void DrawInfectedArea(int i, int j){
	
	StdDraw.setPenColor(StdDraw.RED);
	StdDraw.filledRectangle(i+0.5, j+0.5, 0.4, 0.4); 
	
}
/**
 * This method Draws disinfects area
 * @param i represents the row
 * @param j represents the column
 */
public void DisInfectArea(int i,int j) {
	
	StdDraw.setPenColor(StdDraw.WHITE);
	StdDraw.filledRectangle(i+0.5, j+0.5, 0.4, 0.4);
}

/**
 * resets the canvas
 */
public void FillAll() {
	StdDraw.filledRectangle(0, 0, length, width);
	DrawGrid();
}
}
