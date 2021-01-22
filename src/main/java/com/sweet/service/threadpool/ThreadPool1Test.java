package com.sweet.service.threadpool;

import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class ThreadPool1Test implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> System.out.println("hello"));

        // 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险，以下阻塞队列最大值为Integer的最大值有风险
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        threadPoolExecutor.submit(() -> System.out.println("hello1"));

        
      
    }
}
