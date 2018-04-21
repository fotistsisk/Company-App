//Me pagio kai xrisi
public class ExpenditureFixedUse extends Expenditure{
	//price per unit of consumption measurement
	private double priceConsMeas;
	//unit of consumption measurement
	private String unitConsMeas;
	//mhniaio pagio
	private double monthlyFixed;
	
	public  ExpenditureFixedUse(String id,String description,double priceConsMeas,String unitConsMeas,double monthlyFixed){
		super(id,description);
		this.priceConsMeas=priceConsMeas;
		this.unitConsMeas=unitConsMeas;
		this.monthlyFixed=monthlyFixed;
	}
	
	public double getPriceConsMeas(){return priceConsMeas;}
	
	public String getUnitConsMeas(){return unitConsMeas;}
	
	public double getMonthlyFixed(){return monthlyFixed;}
}