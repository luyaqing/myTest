package ThreadPool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UserThreadPool {

    public static void main(String[] args) {
        /** 缓存队列设置固定长度为2， 为了快速触发rejectHandler */
        BlockingDeque deque = new LinkedBlockingDeque(2);

        /** 假设外部任务线程的来源由机房1和机房2的混合调用 */
        UserThreadFactory f1 = new UserThreadFactory("第一机房");
        UserThreadFactory f2 = new UserThreadFactory("第二机房");

        UserRejectHandler rejectHandler = new UserRejectHandler();

        // 核心线程1，最大线程是2， 为了保证触发rejectHandler
        ThreadPoolExecutor threadPoolExecutorFirst = new ThreadPoolExecutor(1,2,60, TimeUnit.SECONDS, deque, f1, rejectHandler);

        // 创建第二个线程
        ThreadPoolExecutor threadPoolExecutorSecond = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, deque, f2, rejectHandler);

        // 创建400个任务线程
        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolExecutorFirst.execute(task);
            threadPoolExecutorSecond.execute(task);
        }
    }
}
