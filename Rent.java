public class Rent extends ExpenditureFixed{
  	public static final double PRICE_PER_SQUARE = 2.3;
    
  	public Rent(String id, String description){
    	super(id,description,PRICE_PER_SQUARE);
  	}
  	
  	public double getExpenditure(double sqrMeter){
      return (PRICE_PER_SQUARE * sqrMeter);
  	}
}