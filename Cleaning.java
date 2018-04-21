public class Cleaning extends ExpenditureFixed{
  	public static final double PRICE_PER_SQUARE = 5.0;
    
  	public Cleaning(String id, String description){
    	super(id,description,PRICE_PER_SQUARE);
  	}
  	
  	
  	public double getExpenditure(double sqrMeter){
      return (PRICE_PER_SQUARE * sqrMeter);
    }
}