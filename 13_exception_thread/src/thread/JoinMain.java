package thread;

class JoinTest implements Runnable{

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
//-------------------
public class JoinMain {

	public static void main(String[] args) {
		Thread jt = new Thread(new JoinTest());
		System.out.println("스레드 시작");
		jt.start();
		try {
			jt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("스레드 종료");
	}

}
