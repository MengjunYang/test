package test.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;

import com.sun.management.ThreadMXBean;
/**
 * 打印所有线程的信息
 * @author Json
 *
 */
public class MultiThreadPrint {
	public static void main(String[] args) {
		ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean. dumpAllThreads(false, false) ;
		// 遍历线程信息， 仅打印线程ID和线程名 称信息
		for (ThreadInfo threadInfo : threadInfos) {
		System. out. println("[ " + threadInfo. getThreadId() + "] " + threadInfo.
		getThreadName() ) ;
		}
	}
	/**
	 * 会打印： 
	 *  [ 5] Attach Listener
		[ 4] Signal Dispatcher  // 分发处理发送给JVM信号的线程
		[ 3] Finalizer          // 调用对象finalize方法的线程
		[ 2] Reference Handler  // 清除Reference的线程
		[ 1] main               // main线程， 用户程序入口
	 */
}
