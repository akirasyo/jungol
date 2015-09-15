package Common;
import java.io.*;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idx;
	private String name;
	private String id;
	private String pwd;
	private String tel;
	private int birth;
	private int mileage;
	public Member(){
		this.idx = 0;
		this.name = "";
		this.birth = 0;
		this.id = "";
		this.pwd = "";
		this.tel = "";
		this.mileage = 0;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
}
