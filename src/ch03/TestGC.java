package ch03;

/**
 *  3.6.1 对象优先在 eden 区分配
 *
 * -Xms20m
 -Xmx20m
 -Xmn10m
 -verbose:gc
 -XX:+PrintGCDetails #输出详细GC日志模式
 -XX:+PrintTenuringDistribution #输出每次minor GC后新的存活周期的阈值
 -XX:+PrintGCTimeStamps #输出gc的触发时间
 */
public class TestGC {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void main(String argsp[]){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];  // 出现一次Minor GC
    }
    /**
     * 结论: 使用 -XX:+UseParallelGC 并不会导致 minorGC,大对象会直接进入老年代, 新生代会有个1166k 的一个未知大小占用
     * 使用 默认的 serial 收集器和 ParNew收集器 都会导致 minorGc
     */


}
