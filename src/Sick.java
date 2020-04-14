public class Sick extends Human {
	private double PossibilityToInfect;
	private double PossibilityOfInfectingSpace;
	
	public Sick(boolean mask, double possibilityToInfect, double PossSpace) {
		super(mask);
		PossibilityToInfect=calcPossibility(possibilityToInfect);
		PossibilityOfInfectingSpace=calcPossibility(PossSpace);
	}
	
	
	public double getPossibilityOfInfection() {
		return 0;
	}
	
	private double calcPossibility(double P) {
		  if(!getMask())
			  return P;
		  return P/2;
	  }

	public double getPossibilityToInfect() {
		return PossibilityToInfect;
	}
	
	public double getPossibilityOfInfectingSpace() {
		return PossibilityOfInfectingSpace;
	}
	public String toString() {
		String S=super.toString();
		S+=" and is sick with a"+(getPossibilityToInfect()*100)+'%'+" of infecting others";
		return S;
	}
	
}