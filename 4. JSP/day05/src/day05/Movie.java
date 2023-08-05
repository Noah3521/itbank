package day05;

public class Movie {

	private int rank;
	private String title;
	private String openningDate;
	private double reserveRate;
	private int reserveCount;
	private int watchCount;
	
	public Movie(int rank, String title, String openningDate, double reserveRate, int reserveCount, int watchCount) {
		this.rank = rank;
		this.title = title;
		this.openningDate = openningDate;
		this.reserveRate = reserveRate;
		this.reserveCount = reserveCount;
		this.watchCount = watchCount;
	}
	
	public Movie() { }
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOpenningDate() {
		return openningDate;
	}
	public void setOpenningDate(String openningDate) {
		this.openningDate = openningDate;
	}
	public double getReserveRate() {
		return reserveRate;
	}
	public void setReserveRate(double reserveRate) {
		this.reserveRate = reserveRate;
	}
	public int getReserveCount() {
		return reserveCount;
	}
	public void setReserveCount(int reserveCount) {
		this.reserveCount = reserveCount;
	}
	public int getWatchCount() {
		return watchCount;
	}
	public void setWatchCount(int watchCount) {
		this.watchCount = watchCount;
	}
	
}
