package day12.product;

public class Laptop extends Product{
	private String cpu;
	private int ram;
	
	public Laptop() {
		
	}
	public Laptop(String brand, String code, String name, String cpu, int ram) {
		super("Laptop", brand, code, name);
		this.cpu = cpu;
	}
	
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("cpu: "+cpu);
		System.out.println("ram: "+ram);
	}
}
