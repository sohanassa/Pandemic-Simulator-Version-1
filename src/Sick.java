public class Sick extends Human {
	private double PossibilityToInfect;
	
	public Sick(boolean mask, double possibilityToInfect) {
		super(mask);
		this.PossibilityToInfect=calcPossibilityToInfect(possibilityToInfect);
	}
	public double getPossibilityOfInfection() {
		return 0;
	}
	
	private double calcPossibilityToInfect(double P) {
		  if(!getMask())
			  return P;
		  return P/2;
	  }

	public double getPossibilityToInfect() {
		return PossibilityToInfect;
	}
	
}