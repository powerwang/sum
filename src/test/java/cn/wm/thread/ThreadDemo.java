package cn.wm.thread;

public class ThreadDemo implements Runnable {

	public void run() {
		// TODO Auto-generated method stub

		while (true) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
		}    
	}

}
