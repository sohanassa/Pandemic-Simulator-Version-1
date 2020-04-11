public class Sick extends Human {
	private double possibilityToInfect;
	
	public Sick() {

	public Sick(double possibilityToInfect) {
		this.possibilityToInfect=calcPossibilityToInfect(possibilityToInfect);
	}
	public double PossibilityofInfection() {
		return PossibilityofInfection;
	}
	
	private double calcPossibilityToInfect(double PossibiltytoInfect) {
		  if(!mask)
			  return PossibiltytoInfect;
		  return PossibiltytoInfect/2;
	  }
	
}