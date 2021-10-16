package asyncRun;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

/**
 * List/Set非阻塞集合
 * 在使用了阻塞的集合实现之后，同样，非阻塞的集合也能实现，这个与通过volatile共享变量类似。
 * 需要主线程轮询集合的状态，是否isEmpty。如下采用ArrayList实现。
 */
public class AsyncRun15 {
	
	private static final ArrayList<Integer> list = new ArrayList<>();
	
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        
        long start = System.currentTimeMillis();
    
        SumThread sumThread = new SumThread();
		sumThread.start();
		
		while (list.isEmpty()) {
			TimeUnit.MILLISECONDS.sleep(1);
		}
		Integer result = list.get(0);
		
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    
    static class SumThread extends Thread {
		
		@Override
		public void run() {
			try {
				int result = sum();
				list.add(result);
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
