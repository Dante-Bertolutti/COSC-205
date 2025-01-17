import java.util.Date;

public class Goal {
	private int id;
	private int status; //0 = In Progress, 1 = success, 2 = fail
	private String name;
	private String desc;
	private Date startDate;
	private Date endDate;
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
	
	Goal(int id, String name, String desc, Date startDate, Date endDate) {
		this.id = id;
		this.status = 0;
		this.name = name;
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
		//this.user = user;
	}
	
	Goal(int id, int status, String name, String desc, String category, Date startDate, Date endDate) {
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
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
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
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public void finishGoal() {
		this.status = 1;
	}
	
	public void failGoal() {
		this.status = 2;
	}
	
	public Date calculateTimeRemaining() {
		Date currDate = new Date();
		Date output = new Date(endDate.getTime() - currDate.getTime());
		return output;
	}
}
