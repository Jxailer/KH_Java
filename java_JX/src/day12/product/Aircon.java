package day12.product;

public class Aircon extends Product{
	private double size;
	
	public Aircon() {
		
	}
	public Aircon(String brand, String code, String name, double size) {
		super("Aircon", brand, code, name);
		this.size = size;
	}
	
	public double getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("냉방 면적: "+size);
	}
}
