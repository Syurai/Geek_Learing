package asyncRun;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock配合Condition
 * 还有一种与wait/notify等价的方法，就是结合Condition，通过Condition的await和signalAll/signal方法。
 * 在启用了计算线程之后，通过Condition的await方法阻塞，待计算线程执行完毕再执行signal方法。
 */
public class AsyncRun07 {
	
	private static final ReentrantLock lock = new ReentrantLock(true);
	private static final Condition c1 = lock.newCondition();
	
    public static void main(String[] args) throws InterruptedException {
        
        long start = System.currentTimeMillis();
    
        SumThread sumThread = new SumThread();
		sumThread.start();
		
		TimeUnit.MILLISECONDS.sleep(1);
		lock.lock();
		try {
			System.out.println("***");
		} finally {
			lock.unlock();
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
			lock.lock();
			try {
				result = sum();
				c1.signalAll();
			} finally {
				lock.unlock();
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
