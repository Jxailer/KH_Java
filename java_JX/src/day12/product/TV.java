package day12.product;

public class TV extends Product{
	private int size;
	
	public TV() {
		
	}
	public TV(String brand, String code, String name, int size) {
		super("TV", brand, code, name);
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("화면 크기: "+size);
	}
}
