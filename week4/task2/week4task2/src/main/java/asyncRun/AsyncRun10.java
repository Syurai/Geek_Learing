package asyncRun;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;

/**
 * Semaphore
 * Semaphore也能很好的实现，Semaphore初始为0，在主线程中执行acquire，自然会被阻塞，等到计算线程执行完毕，执行release。
 */
public class AsyncRun10 {
	
	private static final Semaphore semaphore = new Semaphore(0);
	
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        
        long start = System.currentTimeMillis();
    
        SumThread sumThread = new SumThread();
		sumThread.start();
		
		semaphore.acquire();
		
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
				semaphore.release();
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
