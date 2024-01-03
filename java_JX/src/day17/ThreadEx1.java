package day17;

public class ThreadEx1 {

	public static void main(String[] args) {

		for(int i =0; i<50;i++) {
			System.out.print("-");
		}
		for(int i =0; i<50;i++) {
			System.out.print("+");
		}
		System.out.println();

		Thread t1 =new Thread1();
		t1.start();
		
		Thread t2 =new Thread(new Thread2());
		t2.start();
	}

}
class Thread1 extends Thread{
	@Override
	public void run() {
		for(int i =0; i<500;i++) {
			System.out.print("-");
		}
	}
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		for(int i =0; i<500;i++) {
			System.out.print("+");
		}
	}
	
}