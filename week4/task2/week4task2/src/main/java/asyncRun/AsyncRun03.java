package asyncRun;

import java.util.concurrent.TimeUnit;

/**
 * synchronized锁
 * synchronized可以实现这个需求，但是需要一个前提，就是让计算线程先拿到锁，这之后main线程被synchronized阻塞，直到计算线程执行完毕。
 */
public class AsyncRun03 {
	
	private static final Object lock = new Object();
    
    public static void main(String[] args) throws InterruptedException {
        
        long start = System.currentTimeMillis();
    
        SumThread sumThread = new SumThread();
		sumThread.start();
		
		TimeUnit.MILLISECONDS.sleep(1);
		synchronized (lock) {
		}
		
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
			synchronized (lock) {
				result = sum();
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
