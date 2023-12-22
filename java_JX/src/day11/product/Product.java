package day11.product;

public class Product {

	private String name;
	private int cost, amount;
	
	public Product() {
		
	}
	
	public Product(String name, int cost, int amount) {
		this.name = name;
		this.cost = cost;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void printProduct() {
		System.out.println("이름: "+name);
		System.out.println("가격: "+cost);
		System.out.println("수량: "+amount);
	}
	
	
}
