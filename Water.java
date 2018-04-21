public class Water extends ExpenditureFixedUse{
  
  	public static final String UNIT_CONS_MEAS = "Cubic Meter";
  	public static final double PRICE_1 = 2.0;
  	public static final double PRICE_2 = 1.5;
  	public static final double MONTHLY_FIXED = 2.5;

	public Water(String id,String description){
      	super(id,description,PRICE_1,UNIT_CONS_MEAS,MONTHLY_FIXED);
	}
  
  	public double getExpenditure(double cubicMeter){
      double finalPrice = (cubicMeter>100?PRICE_1:PRICE_2);
      return (MONTHLY_FIXED + finalPrice*cubicMeter);
    }
}