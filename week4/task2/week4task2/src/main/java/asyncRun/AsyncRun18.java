package asyncRun;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * FutureTask
 * 还可以通过FutureTask来拿到线程异步执行的返回结果。
 */
public class AsyncRun18 {
	
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, ExecutionException {
        
        long start = System.currentTimeMillis();
    
        ExecutorService service = Executors.newCachedThreadPool();

		SumThread sumThread = new SumThread();
		FutureTask<Integer> futureTask = new FutureTask<>(sumThread);
		service.submit(futureTask);
		service.shutdown();
		
        System.out.println("异步计算结果为："+futureTask.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    
    static class SumThread implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			return sum();
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
