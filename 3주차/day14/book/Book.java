package book;

// 도서 관리 프로그램에서 다룰 도서를 나타내는 클래스
// 도서 제목	(문자열)
// 저자		(문자열)
// 출판일자	(문자열)
// 평점		(실수, 소수점 첫째자리까지)
// 가격		(정수, 출력시 천단위 구분기호를 포함)

public class Book {
	private String title;		// 책제목
	private String writer;		// 저자
	private String publishDate;	// 출판일자
	private int rating;			// 평점
	private int price;			// 가격
	
	// 제목, 저자, 출판일자, 평점, 가격을 매개변수로 받아서 멤버필드에 할당
	public Book(String title, String writer, String publishDate, int rating, int price) {
		this.title = title;
		this.writer = writer;
		this.publishDate = publishDate;
		this.rating = rating;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void show() {
		System.out.printf("│제목\t%-22s\t│\n", title);
		System.out.printf("│저자\t%-15s\t\t│\n", writer);		
		System.out.printf("│출판일\t%-10s\t\t│\n", publishDate);		

		// 평점의 개수만큼 별을 출력
		System.out.printf("│평점\t");
		for(int i = 0 ; i < 5; i++) {
			if (i<rating)
				System.out.print("★");
			else {
				System.out.print("☆");
			}
		}
		System.out.println("\t\t\t│");
		
		System.out.printf("│가격\t%,d\t\t\t│\n", price);
	}

	
}
