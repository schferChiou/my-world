package com.qsf.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @ClassName: FirstToMaxPoolExecutorFactory
 * @Description: 多线程工厂类
 * @author: qiusf
 * @date: 2021年2月23日 下午3:33:59
 * @Copyright:
 */

public class FirstToMaxPoolExecutorFactory {


    public static ThreadPoolExecutor newPoolExecutor(int startSize, int maxSize, long time, TimeUnit unit, int queueSize, String featureOfThread) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(startSize, maxSize, time, unit, newLinkedBlockingQueue(queueSize));
        tpe.setThreadFactory(new NewThreadFactory(featureOfThread));
        tpe.setRejectedExecutionHandler(newRejectExecutionHandler());
        return tpe;
    }

    private static RejectedExecutionHandler newRejectExecutionHandler() {
        return new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                try {
                    executor.getQueue().put(r);
                    if (executor.isShutdown()) {
                        throw new RejectedExecutionException("执行器已经停止了  Task" + r + "rejected from " + executor);
                    }
                } catch (InterruptedException e) {
                    System.out.println("执行线程出现错误");
                }
            }
        };
    }


    @SuppressWarnings("serial")
    private static BlockingQueue<Runnable> newLinkedBlockingQueue(int size) {
        return new LinkedBlockingQueue<Runnable>(size) {
            @Override
            public boolean offer(Runnable runnable) {
                if (size() == 0) {
                    return super.offer(runnable);
                } else {
                    return false;
                }
            }
        };
    }

    private static class NewThreadFactory implements ThreadFactory {

        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        public NewThreadFactory(String feature) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "From NewThreadFactory's " + feature + "-Worker-";
        }

        @Override
        public Thread newThread(Runnable r) {
            String name = namePrefix + threadNumber.getAndIncrement();
            Thread t = new Thread(group, r, name, 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("Thread {} got exception");
                }
            });
            return t;
        }
    }

//	public static void main(String[] args) {
//		
//		ThreadPoolExecutor tpe = FirstToMaxPoolExecutorFactory.newPoolExecutor(0, 4+1, 60, TimeUnit.SECONDS, 
//				1000, "test");
//		for (int i = 0; i < 10000; i++) {
//			final int tmpI = i;
//			tpe.execute(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println("tmpI: " + tmpI);
//				}
//			});
//		}
//		tpe.shutdown();
//	}
}
