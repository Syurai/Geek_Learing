package asyncRun;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 * 在java的并发包中，有很多同步的工具可以来实现这个场景，定义一个CountDownLatch，需要倒计时的线程为1，
 * 当main线程启动线程之后，让CountDownLatch执行await方法，计算线程在计算完毕之后，执行countdown方法。mian线程则会继续执行。
 */
public class AsyncRun08 {
	
	private static final CountDownLatch latch = new CountDownLatch(1);
	
    public static void main(String[] args) throws InterruptedException {
        
        long start = System.currentTimeMillis();
    
        SumThread sumThread = new SumThread();
		sumThread.start();
		
		latch.await();
		
		int result = sumThread.getResult();
        
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    
    static class SumThread extends Thread {

		private Integer result;

		public Integer getResult() {
			return result;
		}

		@Override
		public void run() {
			result = sum();
			latch.countDown();
		}
	}
    
    private static int sum() {
        return fibo(36);
    }
    
    private static int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
