/**
 * This class extends Human and created an object called healthy.
 * @author Zoe Passidou
 *@author Sohaib Nassar
 */
/**
 * @author zpass
 *
 */
public class Sick extends Human {
	private double PossibilityToInfect; //represents the Possibility of the sick human to infect others
	private double PossibilityOfInfectingSpace; //represents the Possibility of the sick human to infecting a space
	
	public Sick(boolean mask, double possibilityToInfect, double PossSpace) { //constructor
		super(mask);
		PossibilityToInfect=calcPossibility(possibilityToInfect);
		PossibilityOfInfectingSpace=calcPossibility(PossSpace);
	}
	
	/**
	 *Getter method for PossibilityOfInfection
	 *@return boolean, value of PossibilityOfInfection
	 */
	public double getPossibilityOfInfection() {
		return 0;
	}
	/**
	 * This method calculates the possibility of the sick human of infecting.
	 * @return double, the possibility of infection
	 */
	private double calcPossibility(double P) {
		  if(!getMask())  //if the sick human is  wearing a mask it reduces the possibility 
			  return P; 
		  return P/2;
	  }
	/**
	 *Getter method for PossibilityToInfection
	 *@return boolean, value of PossibilityOToInfection
	 */
	public double getPossibilityToInfect() {
		return PossibilityToInfect;
	}
	/**
	 *Getter method for PossibilityOfInfectingSpace
	 *@return boolean, value of PossibilityOfInfectingSpace
	 */
	public double getPossibilityOfInfectingSpace() {
		return PossibilityOfInfectingSpace;
	}
	
	/**
	 *toString method
	 */
	public String toString() {
		String S=super.toString();
		S+=" and is sick with a"+(getPossibilityToInfect()*100)+'%'+" of infecting others";
		return S;
	}
	
}