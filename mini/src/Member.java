
public class Member {
	private String name;
	private String id;
	private String pwd;
	private String tel;
	private String mileage;
	Member(String name, String id, String pwd, String tel, String mileage){
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.tel = tel;
		this.mileage = mileage;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getTel() {
		return tel;
	}
	public String getMileage() {
		return mileage;
	}
}
