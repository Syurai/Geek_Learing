package asyncRun;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;

/**
 * BlockingQueue
 * BlockingQueue的take方法，也是有阻塞效果的，那么对于这一类的Queue，或者List，可以在主线程启动起算线程之后，
 * 通过take方法进行阻塞。而一旦计算线程执行完毕，将数据加入到queue，则阻塞被解除。采用ArrayBlockingQueue实现。
 */
public class AsyncRun13 {
	
	private static final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
	
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        
        long start = System.currentTimeMillis();
    
        SumThread sumThread = new SumThread();
		sumThread.start();
		
		Integer result = queue.take();
		
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    
    static class SumThread extends Thread {

		@Override
		public void run() {
			try {
				int result = sum();
				queue.add(result);
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
