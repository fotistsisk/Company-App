//Me pagio
public class ExpenditureFixed extends Expenditure{
	//timi ana tetragvniko
	private double pricePerSquare;
	
	public ExpenditureFixed(String id,String description,double pricePerSquare){
		super(id,description);
		this.pricePerSquare=pricePerSquare;
	}
	
	public double getPricePerSquare(){return pricePerSquare;}
}