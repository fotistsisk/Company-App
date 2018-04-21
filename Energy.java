public class Energy extends ExpenditureFixedUse{
	public static final double MONTHLY_FIXED = 10.0;
  	public static final double ERT= 7.0;
  	public static final double ZONE_PRICE= 3.5;
	public static final String UNIT_CONS_MEAS = "kWh";
  	public static final double PRICE_PER_KWH = 2.0;
      
    public Energy(String id,String description){
    	super(id,description,PRICE_PER_KWH,UNIT_CONS_MEAS,MONTHLY_FIXED);
    }
  	
  	public double getExpenditure(double kWh, double sqrMeter){
      double localTaxesCharge = ZONE_PRICE * sqrMeter;
      return (MONTHLY_FIXED+ ERT+ localTaxesCharge+(PRICE_PER_KWH * kWh));
    }
}