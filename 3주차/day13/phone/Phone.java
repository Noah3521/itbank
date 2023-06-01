package phone;

public class Phone {
	String model;
	String name;
	Phone(String model, String name) {
		this.model = model;
		this.name = name;
	}
	
	void setModel(String model) {
		this.model = model;
	}
	void setName(String name) {
		this.name = name;
	}
	
	void receive(Phone phone, String msg) {
		System.out.println(this.model);
		System.out.printf("┌───────────────┐\n");
		System.out.printf("│%4s에게받음\t│\n",phone.name);		
		System.out.printf("│%4s:%4s\t│\n",phone.name, msg);		
		System.out.println("│\t\t│");		
		System.out.println("└───────────────┘");
	}
	void send(Phone other, String msg) {
		System.out.println(this.model);
		System.out.printf("┌───────────────┐\n");
		System.out.printf("│%4s에게보냄\t│\n",other.name);		
		System.out.printf("│\t%4s\t│\n", msg);		
		System.out.println("│\t\t│");		
		System.out.println("└───────────────┘");
		other.receive(this, msg);
	}
}
