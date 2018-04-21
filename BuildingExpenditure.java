public class BuildingExpenditure{
  	
  	private Building building;
  	private Expenditure exp;
  	// proypologistheisa miniaia katanalwsi
	private double precalcMonthlyUse;
  	
  	public BuildingExpenditure(Building building,Expenditure exp){
    	this.building=building;
      	this.exp=exp;
    }
  
  	public BuildingExpenditure(Building building,Expenditure exp,double precalcMonthlyUse){
      	this(building,exp);
      	this.precalcMonthlyUse=precalcMonthlyUse;
    }
  
  	public double getPrecalcMonthlyUse() {return precalcMonthlyUse;}
  	public Expenditure getExp() {return exp;}
  	public Building getBuilding() {return building;}
}