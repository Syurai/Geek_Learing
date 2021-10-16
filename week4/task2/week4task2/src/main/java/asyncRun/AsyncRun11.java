package asyncRun;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Phaser;

/**
 * Phaser
 * Phaser如果要实现这个场景，则设置Phaser为2，在主线程和计算线程中都执行arriveAndAwaitAdvance。
 */
public class AsyncRun11 {
	
	private static final Phaser phaser = new Phaser(2);
	
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        
        long start = System.currentTimeMillis();
    
        SumThread sumThread = new SumThread();
		sumThread.start();
		
		phaser.arriveAndAwaitAdvance();
		
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
			try {
				result = sum();
				phaser.arriveAndAwaitAdvance();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
