package snassa01_zpassi01.hw5;

/**
 * This class extends Human and creates an object Sick extends human.
 * Represents a Sick Human
 * 
 * @author Zoe Passidou
 * @author Sohaib Nassar
 */
public class Sick extends Human {
	private double PossibilityToInfect; //represents the Possibility of the sick human to infect others
	private double PossibilityOfInfectingSpace; //represents the Possibility of the sick human to infecting a space
	
	public Sick(boolean mask, double possibilityToInfect, double PossSpace, int maskProtection) { //constructor
		super(mask,maskProtection);
		PossibilityToInfect=calcPossibility(possibilityToInfect);
		PossibilityOfInfectingSpace=calcPossibility(PossSpace);
	}
	
	/**
	 * This method calculates the possibility of the sick human of infecting.
	 * @return double, the possibility of infection
	 */
	private double calcPossibility(double P) {
		  if(!getMask())  //if the sick human is  wearing a mask it reduces the possibility 
			  return P; 
		  return ((100-getMaskProtection())/100.0)*P;
	  }
	/**
	 *Getter method for PossibilityToInfection.
	 *@return boolean, value of PossibilityOToInfection
	 */
	public double getPossibilityToInfect() {
		return PossibilityToInfect;
	}
	/**
	 *Getter method for PossibilityOfInfectingSpace.
	 *@return boolean, value of PossibilityOfInfectingSpace
	 */
	public double getPossibilityOfInfectingSpace() {
		return PossibilityOfInfectingSpace;
	}
	
	/**
	 *toString method.
	 */
	public String toString() {
		String S=super.toString();
		S+=" and is sick with a"+(getPossibilityToInfect()*100)+'%'+" of infecting others";
		return S;
	}
	
}