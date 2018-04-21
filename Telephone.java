public class Telephone extends ExpenditureFixedUse{
	public static final String UNIT_CONS_MEAS = "Minutes";
  	public static final double PRICE_PER_MINUTE = 0.2;
	public static final double MONTHLY_PHONE_FEES = 25.0;
    public static final double MONTHLY_FIXED = 5.0;

	public Telephone(String id,String description){
		super(id,description,PRICE_PER_MINUTE,UNIT_CONS_MEAS,MONTHLY_FIXED);
	}
  
  	public double getExpenditure(double minutesUsed){
      return MONTHLY_FIXED + MONTHLY_PHONE_FEES + (PRICE_PER_MINUTE * minutesUsed);
    }
}