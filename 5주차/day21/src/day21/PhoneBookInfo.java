package day21;

public class PhoneBookInfo {
	private String name;
	private int age;
	private String pnum;
	public PhoneBookInfo(String name, int age, String pnum) {
		this.name = name;
		this.age = age;
		this.pnum = pnum;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPnum() {
		return pnum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	@Override
	public String toString() {
		return String.format("%s, %s, %s", name, age, pnum);
	}
}
