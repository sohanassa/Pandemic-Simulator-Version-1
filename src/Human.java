/**
 * This class created an object called Human.
 * @author Zoe Passiadou
 * @author Sohaib Nassar
 *
 */
public class Human {
  private boolean mask;        //has a field named mask that represents whether or not the human is wearing one
  
 
  public Human(boolean mask) { //constructor
	  this.mask=mask;
	  
  }
  
  /**
   * Getter method for mask
 * @return boolean, value of mask
 */
public boolean getMask() { 
	  return this.mask;
  }

  /**
   * Method to be overriden.
 * @return
 */
public double getPossibilityOfInfection() {
	  return 0;
  }
 
/**
 * Method to be overriden.
* @return
*/
  public double getPossibilityToInfect() {
	  return 0;
  }
  /**
   * Method to be overriden.
 * @return
 */
  public double getPossibilityOfInfectingSpace() {
	  return 0;
  }
  
  /**
   * Method to be overriden.
 * @return
 */
public boolean getImmune() {
	  return false;
  }
  

  
  
/**
 *toString method
 *@return String 
 */
public String toString() {
	  String S="Human is ";
	  if(mask)
		  S+="wearing a mask ";
	  else
		  S+="not waring a mask ";
		  
	  return S;
	  
  }
}
