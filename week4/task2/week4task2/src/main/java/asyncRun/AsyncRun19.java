package asyncRun;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompleteFuture
 * jvm1.8中引入了CompleteFuture，也能在这个场景中来使用。
 */
public class AsyncRun19 {
	
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, ExecutionException {
        
        long start = System.currentTimeMillis();
    
        ExecutorService service = Executors.newCachedThreadPool();

		CompletableFuture<Integer> future = new CompletableFuture<>();
		SumThread sumThread = new SumThread(future);
		service.submit(sumThread);
		service.shutdown();
		
        System.out.println("异步计算结果为："+future.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    
    static class SumThread implements Runnable {

		private CompletableFuture<Integer> future;

		public SumThread(CompletableFuture<Integer> future) {
			this.future = future;
		}

		@Override
		public void run() {
			future.complete(sum());
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
