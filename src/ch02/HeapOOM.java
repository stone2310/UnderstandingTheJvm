package ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出
 * 
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * -Xms   初始堆大小
 * -Xmx   最大堆大小
 * -XX:+HeapDumpOnOutOfMemoryError 让JVM在发生内存溢出时自动的生成堆内存快照
 * 默认情况下，堆内存快照会保存在JVM的启动目录下名为java_pid<pid>.hprof 的文件里（在这里<pid>就是JVM进程的进程号）。
 * 也可以通过设置-XX:HeapDumpPath=<path>来改变默认的堆内存快照生成路径，<path>可以是相对或者绝对路径。
 * @author wangsch
 */
public class HeapOOM {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		while(true) {
			list.add(new Object());
		}
	}
	
	/*
	 *  Result: 
	 *  java.lang.OutOfMemoryError: Java heap space
		Dumping heap to java_pid3740.hprof ...
		Heap dump file created [27889538 bytes in 0.171 secs]
		Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		...
	 */
}
