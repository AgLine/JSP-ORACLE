package DB;

public class DTO {
	private String ename;
	private String job;
	
	public DTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public DTO(String ename, String job) {
		super();
		this.ename = ename;
		this.job = job;
	}
	
	
	
}