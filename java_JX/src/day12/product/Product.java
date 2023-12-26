package day12.product;
/*공통: 브랜드, 제품코드, 제품명
* - TV: 화면크기
* - 에어컨: 냉방면적
* - 노트북: CPU, 램, 용량*/

public class Product {
	private String type, brand, code, name;
	
	public Product() {
		
	}
	public Product(String type, String brand, String code, String name) {
		this.type=type;
		this.brand =brand;
		this.code = code;
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void printInfo() {
		System.out.println("---------");
		System.out.println("제품종류: "+type);
		System.out.println("브랜드: "+brand);
		System.out.println("제품코드: "+code);
		System.out.println("브랜드: "+brand);
	}
}
