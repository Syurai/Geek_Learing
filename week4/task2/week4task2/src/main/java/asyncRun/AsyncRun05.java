package asyncRun;

import java.util.concurrent.locks.LockSupport;

/**
 * park/unpark
 * 也可以利用同步工具中的lockSupport的park/unpark方法来实现。
 * 在主线程启动计算线程之后执行park，之后再在计算线程执行完毕之后，调用主线程的unpark方法。
 */
public class AsyncRun05 {
	
    public static void main(String[] args) throws InterruptedException {
        
        long start = System.currentTimeMillis();
    
        SumThread sumThread = new SumThread();
        sumThread.setMainThread(Thread.currentThread());
		sumThread.start();
		
		LockSupport.park();
		
		int result = sumThread.getResult();
        
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    
    static class SumThread extends Thread {

		private Thread mainThread;
		private Integer result;

		public Integer getResult() {
			return result;
		}

		public Thread getMainThread() {
			return mainThread;
		}

		public void setMainThread(Thread mainThread) {
			this.mainThread = mainThread;
		}

		@Override
		public void run() {
			result = sum();
			LockSupport.unpark(getMainThread());
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
