package cn.wm.thread;


public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Thread daemonThread = new Thread(new ThreadDemo());
//		daemonThread.setName("测试thread");
//		// 设置为守护进程
//        daemonThread.setDaemon(true);
//        daemonThread.start();
//        System.out.println("isDaemon = " + daemonThread.isDaemon());
//        Thread t = new Thread(new ThreadDemo());
//        t.start();
		
		
	}
	@org.junit.Test
	public void joinTest(){
		
		Thread t = new Thread(new ThreadDemo1());
		Thread t2 = new Thread(new ThreadDemo1());
		t.start();
		t2.start();
		try {
			t.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==================");
	}
}
