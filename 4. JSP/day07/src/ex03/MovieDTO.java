package ex03;

public class MovieDTO {
	private int movie_rank;
	private String title;
	private String openningDate;
	private double reserveRate;
	private int reserveCount;
	private int watchCount;

	public MovieDTO() {
	}
	
	public MovieDTO(int movie_rank, String title, String openningDate, double reserveRate, int reserveCount,
			int watchCount) {
		this.movie_rank = movie_rank;
		this.title = title;
		this.openningDate = openningDate;
		this.reserveRate = reserveRate;
		this.reserveCount = reserveCount;
		this.watchCount = watchCount;
	}

	public int getMovie_rank() {
		return movie_rank;
	}

	public void setMovie_rank(int movie_rank) {
		this.movie_rank = movie_rank;
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
