package ThreadPool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 自定义线程工厂
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;

    private final AtomicInteger nextId = new AtomicInteger(1);

    UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "UserThreadFactory's:" + whatFeatureOfGroup + "-Worker-";
    }
    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(task, name);
        System.out.println(thread.getName());
        return thread;
    }
}

class Task implements Runnable {
    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}
