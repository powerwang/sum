package cn.wm.thread;

public class ThreadDemo1 implements Runnable {

	public void run() {
		// TODO Auto-generated method stub

//		while (true) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
//                try {
////                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
//		}    
	}

}
