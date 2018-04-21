public class Expenditure{
	//kvdikos kai perigrafi
	private String id,description;

	public Expenditure(String id,String description){
		this.id=id;
		this.description=description;
	}
	
	public String getId(){return id;}
	
	public String getDescription(){return description;}
}