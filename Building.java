public class Building{
	
	private int id;
	private double squareMeters,priceZone;
	private String description,address;
	
	public Building(int id,String description,String address,double priceZone,double squareMeters){
		this.id=id;
		this.description=description;
		this.address=address;
		this.priceZone=priceZone;
		this.squareMeters=squareMeters;
	}
	
	public int getId(){return id;}
	public double getSquareMeter(){return squareMeters;}
	public String getDescription(){return description;}
	public String getAddress(){return address;}
	public double getPriceZone(){return priceZone;}
  	public String toString(){
    	return ("ID: "+id+"\nDescription: "+description+"\nAddress: "+address+"\nPrice Zone: "+priceZone+"\nSquare Meter: "+squareMeters);                
    }
}