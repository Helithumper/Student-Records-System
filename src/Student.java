import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;


public class Student {
	//Fields
	private String name;
	private int SID;
	private Adress address;
	private Date DATEOFBIRTH = new Date();
	private double gpa;
	private String gender;
	private Schedule schedule;
	private PhoneNumber phone;
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	
	//Constructor
	public Student(String name,Date DOB){
		this.name = name;
		//DATEOFBIRTH = DOB;
		address = new Adress();
		phone = new PhoneNumber();
		SID =  (int) (Math.random()*10000000);
	}
	@SuppressWarnings("deprecation")
	public Student(String name){
		this.name = name;
		address = new Adress(); 
		phone = new PhoneNumber();
		SID =  ((int)(100000 + (int)(Math.random() * ((999999 - 100000) + 1))));
		gpa = (double) ((Math.random()*100));
		DATEOFBIRTH = new Date((int)(90 + (int)(Math.random() * ((99 - 90) + 1))),(int)(0 + (int)(Math.random() * ((12 - 0) + 1))),(int)(0 + (int)(Math.random() * ((31 - 0) + 1))));
		DATEOFBIRTH.setHours((int)(0 + (int)(Math.random() * ((24 - 0) + 1))));
		DATEOFBIRTH.setMinutes((int)(0 + (int)(Math.random() * ((60 - 0) + 1))));
		DATEOFBIRTH.setSeconds((int)(0 + (int)(Math.random() * ((60 - 0) + 1))));
		
	}
	//Assessors and Mutators
	public Assignment getAssignment(int i){return assignments.get(i);}
	public void addAssignment(Assignment a){assignments.add(a);}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public int getSID() {return SID;}
	public void setSID(int sID) {SID = sID;}

	public Adress getAddress() {return address;}
	public void setAddress(Adress address) {this.address = address;}

	public double getGpa() {return gpa;}
	public void setGpa(double gpa) {this.gpa = gpa;}

	public String getGender() {
	return this.gender = "Male";
	}
	public void setGender(String gender) {this.gender = gender;}

	public Schedule getSchedule() {return schedule;}
	public void setSchedule(Schedule schedule) {this.schedule = schedule;}

	public Date getDATEOFBIRTH() {return DATEOFBIRTH;}
	
	public String getAssignments() {String result = "";for(Assignment a : assignments){
		result+="\t"+a.getAName()+"\t%"+a.getPercentage()+"\n";
	}
	return result;
	}
	
	//Methods
	public void dropLowest(){
			double lowestGrade = 100;
			int indexofLowest = 0;
			try{
			for(int i = 0;i<assignments.size();i++){
				if(assignments.get(i).getPercentage()<lowestGrade){
					lowestGrade = assignments.get(i).getPercentage();
					indexofLowest = i;
				}
			}
			assignments.remove(indexofLowest);}
			catch(Exception e){
				System.out.println("You Cannot Drop any more Assignments");
			}
		}
	
	public static double round(double unrounded, int precision, int roundingMode)
	{
	    BigDecimal bd = new BigDecimal(unrounded);
	    BigDecimal rounded = bd.setScale(precision, roundingMode);
	    return rounded.doubleValue();
	}
	
	public void fixPercentages(){
		for(Assignment a:assignments){
			a.setPercentage(round(a.getPercentage(),2,BigDecimal.ROUND_HALF_UP));
		}
	}
	//toString
	

	@Override
	public String toString(){
		return "\nName: \n\t" + name + 
				"\nGender: \n\t" + getGender() +
				"\nStudent ID: \n\t" + SID + 
				"\nDate of Birth: \n\t" + DATEOFBIRTH + 
				"\nGPA: \n\t" + gpa +
				"\nPhone Number: \n\t" + phone.toString() +
				"\nAddress: \n\t" + address.toString();
	}
}