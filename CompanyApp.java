import java.util.*;

public class CompanyApp {
  
  	public static int ID_BUILDING=0;
  	private static Scanner sc;
	static ArrayList<Building> buildings;
    static ArrayList<Expenditure> expenditureTypes;
    static ArrayList<BuildingExpenditure> buildingsExp;

  	public static void main(String[] args){
		CompanyApp ca = new CompanyApp();
    	buildings = new ArrayList<Building>();
      	expenditureTypes= new ArrayList<Expenditure>();
      	buildingsExp= new ArrayList<BuildingExpenditure>();
      
      	buildings.add(new Building(++ID_BUILDING,"First Building","Athens",25.0,95.0));
      	buildings.add(new Building(++ID_BUILDING,"Second Building","Patras",15.0,500.0));
      	buildings.add(new Building(++ID_BUILDING,"Third Building","Thessaloniki",23.0,440.0));
      	buildings.add(new Building(++ID_BUILDING,"Fourth Building","Crete",22.0,470.0));
        buildings.add(new Building(++ID_BUILDING,"Fifth Building","Ioannina",20.0,310.0));
      
      	expenditureTypes.add(new Cleaning("1","cleaning"));
      	expenditureTypes.add(new Rent("2","rent"));
      	expenditureTypes.add(new Water("3","water"));
      	expenditureTypes.add(new Energy("4","energy"));
        expenditureTypes.add(new Telephone("5","telephone"));            
                         
                    
      	buildingsExp.add(new BuildingExpenditure(buildings.get(0),expenditureTypes.get(2),100.0));
        buildingsExp.add(new BuildingExpenditure(buildings.get(0),expenditureTypes.get(3),100.0));
        buildingsExp.add(new BuildingExpenditure(buildings.get(0),expenditureTypes.get(1)));
        buildingsExp.add(new BuildingExpenditure(buildings.get(0),expenditureTypes.get(4),100.0));
        
        buildingsExp.add(new BuildingExpenditure(buildings.get(1),expenditureTypes.get(2),100.0));
        buildingsExp.add(new BuildingExpenditure(buildings.get(1),expenditureTypes.get(1)));
        buildingsExp.add(new BuildingExpenditure(buildings.get(1),expenditureTypes.get(0)));
        buildingsExp.add(new BuildingExpenditure(buildings.get(1),expenditureTypes.get(3),100.0));
        
        buildingsExp.add(new BuildingExpenditure(buildings.get(2),expenditureTypes.get(3),100.0));
        buildingsExp.add(new BuildingExpenditure(buildings.get(2),expenditureTypes.get(1)));
        buildingsExp.add(new BuildingExpenditure(buildings.get(2),expenditureTypes.get(0)));
        buildingsExp.add(new BuildingExpenditure(buildings.get(2),expenditureTypes.get(2),100.0));
                     
      	buildingsExp.add(new BuildingExpenditure(buildings.get(3),expenditureTypes.get(4),100.0));
        buildingsExp.add(new BuildingExpenditure(buildings.get(3),expenditureTypes.get(1)));
        buildingsExp.add(new BuildingExpenditure(buildings.get(3),expenditureTypes.get(0)));
        buildingsExp.add(new BuildingExpenditure(buildings.get(3),expenditureTypes.get(3),100.0));
                     
        buildingsExp.add(new BuildingExpenditure(buildings.get(4),expenditureTypes.get(4),100.0));
        buildingsExp.add(new BuildingExpenditure(buildings.get(4),expenditureTypes.get(1)));
        buildingsExp.add(new BuildingExpenditure(buildings.get(4),expenditureTypes.get(0)));
        buildingsExp.add(new BuildingExpenditure(buildings.get(4),expenditureTypes.get(2),100.0));
		
		showMenu();
    }
  
  	public static void showMenu(){
        sc = new Scanner(System.in);
      	boolean repeat= true;
      	while(repeat){
          	System.out.println("1.Insert new building\n2.Enter new building expense\n3.Show buildings\n4.Show costs for a building\n5.Calculation of the budgeted cost of a building\n6.Calculation of the budgeted cost type\nIf you want to exit enter 0\n");
      		int x = sc.nextInt();
        	switch(x){
              	case 0:
                	repeat = false;
                	break;
          		case 1:
            		newBuilding();
            		break;
          		case 2:
            		newBuildingExpenditure();
           		 	break;
          		case 3:
            		showBuildings();
            		break;
          		case 4:
					showExpOfBuilding();
            		break;
          		case 5:
					calculateCostofBuild();
           			break;
          		case 6:
					calculateCostofExpType();
            		break;
          		default:
            		System.out.println("Please choose a correct option from 1 to 6.");
            		break;
        	}
        }
    }
  
  	public static void newBuilding(){
      	String name,place;
      	double priceZone, sqrMeters;
      	System.out.println("Enter the name of the building");
		sc.nextLine();
      	name = sc.nextLine();
      	System.out.println("Enter the place of the building");
      	place = sc.nextLine();
      	System.out.println("Enter the priceZone");
      	priceZone = sc.nextDouble();
      	System.out.println("Enter squareMeter");
      	sqrMeters = sc.nextDouble();
        buildings.add(new Building(++ID_BUILDING,name,place,priceZone,sqrMeters)); 
    }
  
  	public static void newBuildingExpenditure(){
      	Building building = buildingSearch();
      	Expenditure exp;
      	System.out.println("1.Cleaning\n2.Rent\n3.Water\n4.Energy\n5.Telephone\n\nEnter the type of the expenditure:");
      	int x = sc.nextInt();
      	switch(x){
              
          		case 1:
          		case 2:
                    buildingsExp.add(new BuildingExpenditure(building, expenditureTypes.get(x-1)));
            		break;
          		case 3:
          		case 4:
          		case 5:
            		System.out.println("Enter precalculated monthly use: ");
            		double preCalcUse = sc.nextDouble();
           			buildingsExp.add(new BuildingExpenditure(building, expenditureTypes.get(x-1), preCalcUse));
            		break;
          		default:
            		System.out.println("Please choose a correct option from 1 to 6.");
            		break;
        	}
      	
    }
	
	public static void showExpOfBuilding(){
      	Building building = buildingSearch();
		int i = 0;
      	for(BuildingExpenditure exp : buildingsExp){
          	if(exp.getBuilding().equals(building))
				System.out.println((++i)+". "+exp.getExp().getDescription());
        }
		System.out.print("\n");
    }
	
	public static Building buildingSearch(){
      	System.out.println("Enter the id of the building: ");
      	int buildID= sc.nextInt();
      	for(Building build :buildings){
          	if(build.getId()==buildID)
              	return build;
        }
      	return null;
    }
	
	public static void calculateCostofBuild(){
      	double sum = 0.0, expense = 0.0;
      	showBuildings();
      	Building build = buildingSearch();
      	for(BuildingExpenditure b : buildingsExp){
          	if(b.getBuilding().equals(build)){
				Expenditure exp = b.getExp();
				String class_name = exp.getClass().getName();
				if(class_name.equals("Cleaning")){
					Cleaning a = (Cleaning)exp;
					expense = a.getExpenditure(b.getBuilding().getSquareMeter());
				}
				else if(class_name.equals("Rent")){
					Rent a = (Rent)exp;
					expense = a.getExpenditure(b.getBuilding().getSquareMeter());
				}
				else if(class_name.equals("Water")){
					Water a = (Water)exp;
					expense = a.getExpenditure(b.getPrecalcMonthlyUse());
				}
				else if(class_name.equals("Telephone")){
					Telephone a = (Telephone)exp;
					expense = a.getExpenditure(b.getPrecalcMonthlyUse());
				}
				else if(class_name.equals("Energy")){
					Energy a = (Energy)exp;
					expense = a.getExpenditure(b.getPrecalcMonthlyUse(),b.getBuilding().getSquareMeter());
				}
				sum += expense;
				System.out.println("The "+class_name+" is: "+expense+"\n");
            }
        }
		System.out.println("The total is : "+sum+"\n");
    }
	
	public static void calculateCostofExpType(){
		printExpTypes();
		System.out.print("\nWhich expenditure type do you want to calculate the cost of?");
		int i = sc.nextInt()-1;
		double sum=0,expCost=0;
		for(BuildingExpenditure buildExp : buildingsExp){
			Expenditure exp = buildExp.getExp();
			String class_name = exp.getClass().getName();
			if(class_name.equals(expenditureTypes.get(i).getClass().getName())){
				if(class_name.equals("Cleaning")){
					Cleaning a = (Cleaning) exp;
					expCost = a.getExpenditure(buildExp.getBuilding().getSquareMeter());
				}
				else if(class_name.equals("Rent")){
					Rent a = (Rent) exp;
					expCost = a.getExpenditure(buildExp.getBuilding().getSquareMeter());
				}
				else if(class_name.equals("Water")){
					Water a = (Water) exp;
					expCost = a.getExpenditure(buildExp.getPrecalcMonthlyUse());
				}
				else if(class_name.equals("Telephone")){
					Telephone a = (Telephone) exp;
					expCost = a.getExpenditure(buildExp.getPrecalcMonthlyUse());
				}
				else if(class_name.equals("Energy")){
					Energy a = (Energy) exp;
					expCost = a.getExpenditure(buildExp.getPrecalcMonthlyUse(),buildExp.getBuilding().getSquareMeter());
				}
				System.out.println("The building "+buildExp.getBuilding().getDescription()+" has "+Math.round(expCost)+" worth of "+class_name);
				sum+=expCost;
			}
		}
		System.out.println("The total cost is : "+Math.round(sum)+"\n");
	}
  	
	public static void printExpTypes(){
		int i = 0;
		for(Expenditure exp : expenditureTypes){
			System.out.println((++i)+exp.getDescription());
		}
	}
	
  	public static void showBuildings(){
      	for(Building build : buildings){
          	System.out.println(build.toString()+"\n");
        }
    }
}