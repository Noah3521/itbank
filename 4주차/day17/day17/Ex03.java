package day17;

// 현재 패키지 내부에서 다른 패키지의 클래스를 참조하여 사용하려면 import를 한다

//import product.Product;
//import product.Food;
//import product.IndustrialProduct;
abstract class Product {

	String name;
	int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public abstract String toString();
}

class Food extends Product {

	String expireDate; // 유통기한

	public Food(String name, int price, String expireDate) {
		super(name, price);
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		String format = "%s] %,d원 (유통기한 : %s)";
		Object[] args = { name, price, expireDate };
		return String.format(format, args);
	}

}

class IndustrialProduct extends Product {

	String madeIn;

	public IndustrialProduct(String name, int price, String madeIn) {
		super(name, price);
		this.madeIn = madeIn;
	}

	@Override
	public String toString() {
		String format = "%s] %,d원 (made in %s)";
		Object[] args = { name, price, madeIn };
		return String.format(format, args);
	}
}

public class Ex03 {
	public static void main(String[] args) {
		Product[] arr1 = new Product[] { new Food("사과", 1000, "2023-10-01"), new Food("감자", 2000, "2023-09-12"),
				new Food("포도", 3999, "2024-12-29"), new Food("고등어", 20000, "2022-01-05"),
				new IndustrialProduct("컴퓨터", 2000000, "중국"), new IndustrialProduct("아이폰", 20000000, "미국"),
				new IndustrialProduct("키보드", 2000000, "대만"), };
		String search = "아이폰";

		int length = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != null && arr1[i].name.contains(search)) {
				length++;
			}
		}

		Product[] arr2 = new Product[length];

		length = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != null && arr1[i].name.contains(search)) {
				arr2[length++] = arr1[i];
			}
		}
		
		for(Product p : arr1) if (p!=null) System.out.println(p);
		System.out.println();
		for(Product p : arr2) if (p!=null) System.out.println(p);
	}
}
