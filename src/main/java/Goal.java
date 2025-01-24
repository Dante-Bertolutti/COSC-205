import java.util.Date;

public class Goal {
	private int id;
	private int status; //0 = In Progress, 1 = success, 2 = fail
	private String name;
	private String desc;
	private String startDate;
	private String endDate;
	//private User user;
	
//	private Goal(){
//		id = ;
//		status = 0;
//		name = ;
//		desc = ;
//		category = ;
//		startDate = ;
//		endDate = ;
//	}
	
	Goal(int id, String name, String desc, String startDate, String endDate) {
		this.id = id;
		this.status = 0;
		this.name = name;
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
		//this.user = user;
	}
	
	Goal(int id, int status, String name, String desc, String category, String startDate, String endDate) {
		this.id = id;
		this.status = status;
		this.name = name;
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
		//this.user = user;
	}
	
	public int getId() {
		return id;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public void finishGoal() {
		this.status = 1; // Finish successfully status = 1
	}
	
	public void failGoal() {
		this.status = 2; //Fail status = 2
	}
	
	public String calculateTimeRemaining() {
		//Format: MM/DD/YYYY
		int startMonth = Integer.parseInt(startDate.substring(0, 2));
		int startDay = Integer.parseInt(startDate.substring(3, 5));
		int startYear = Integer.parseInt(startDate.substring(6));
		int endMonth = Integer.parseInt(endDate.substring(0, 2));
		int endDay = Integer.parseInt(endDate.substring(3, 5));
		int endYear = Integer.parseInt(endDate.substring(6));
		int y = endYear - startYear;
		int m = 0;
		int d = 0;
		String timeRemaining = "";
		
		if (y != 0 ) {
			//Not the same year
			if (startMonth > endMonth) {
				y--; //Not a full year
				if (startDay > endDay) {
					m = (12 - startMonth) + (endMonth -1) ; //Not a full month
					d = 30 - (startDay - endDay);
				}else{
					m = (12 - startMonth) + endMonth; //Full month
					d = endDay - startDay;
				}
			}else if (startMonth < endMonth) {
				if (startDay > endDay) {
					m = endMonth - startMonth - 1;
					d = 30 - (startDay - endDay);
				}else{
					m = endMonth - startMonth;
					d = endDay - startDay;
				}
			}else {
				if (startDay > endDay) {
					y--;
					m = 12 - startMonth;
					d = 30 - (startDay - endDay);
				}else{
					m = 0;
					d = endDay - startDay;
				}
			}
			
			if (d > 30) {
				m += d / 30;
			}
			
			if (m > 12) {
				y += m / 12;
			}				
		}else {
			//Same year
			if (startMonth < endMonth) { //Different month
				if (startDay > endDay) {
					m = endMonth - startMonth - 1;
					d = 30 - (startDay - endDay);
				}else{
					m = endMonth - startMonth;
					d = endDay - startDay;
				}
			}else { //Same month
				m = 12 - startMonth;
				d = 30 - (startDay - endDay);
			}
		}
		
		//Build output
		if (y != 0) {
			timeRemaining += y + " years, ";
		}
		if (m != 0) {
			timeRemaining += m + " months, ";
		}
		timeRemaining += d + " days.";
		
		return timeRemaining;
	}
	
	public String toString() {
		return "(Goal #" + id + ") " + name + ": " + desc + " Time Remaining: " + calculateTimeRemaining();
	}
}
