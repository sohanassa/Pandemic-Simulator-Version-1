package snassa01_zpassi01.hw5;
/**
 * This class extends Human and created an object called healthy extends human.
 * 
 * @author Zoe Passidou
 *@author Sohaib Nassar
 */
public class Healthy extends Human {
  private boolean immune;                     // represents whether or not a healthy human is immune
  private double PossibilityofInfection;      // represents the possibility of getting infected
  
  
	public Healthy(boolean immune, boolean mask, int maskProtection) {       //constructor
		super(mask,maskProtection);                                     // calls super constructor
		this.immune=immune;
		this.PossibilityofInfection=calcPossibilityofInfection();
	}
	
	/**
	 * This method calculates the possibility of the healthy human getting infected.
	 * @return double, the possibility of infection
	 */
	private double calcPossibilityofInfection() {
		if(immune)  //if its immune , the possibility of infection is 0
			return 0;
		if(getMask())         //if its wearing a mask the possibility is down by half 
			return (100-getMaskProtection())/100.0;
		return 1;              
	}
	/**
	 *Getter method for immune.
	 *@return boolean, value of immune
	 */
	public boolean getImmune() {
		return immune;
	}
	/**
	 *Getter method for PossibilityOfInfection
	 *@return boolean, value of PossibilityOfInfection
	 */
	public double getPossibilityOfInfection(){
		return PossibilityofInfection;
	}
	 
	/**
	 *toString method
	 */
	public String toString() {
	   String S=super.toString();
	   S+= "and is healthy, with a "+(getPossibilityOfInfection()*100)+'%'+" of getting infected";
	   return S;
	}
	
	
}
