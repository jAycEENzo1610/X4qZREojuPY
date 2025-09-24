// 代码生成时间: 2025-09-24 08:31:55
package com.example.memory;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
# 扩展功能模块
import java.lang.management.MemoryUsage;

/**
 * The main class of the memory usage analyzer application.
 */
@QuarkusMain
public class MemoryUsageAnalyzer {

    private static final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

    /**
     * Main method to start the application.
     * @param args - command line arguments
     */
    public static void main(String... args) {
        try {
# FIXME: 处理边界情况
            reportMemoryUsage();
        } catch (Exception e) {
            System.err.println("Error analyzing memory usage: " + e.getMessage());
            Quarkus.asyncExit(1);
        }
    }
# 优化算法效率

    /**
     * Reports the current memory usage of the application.
     */
    public static void reportMemoryUsage() {
        System.out.println("Current Memory Usage: ");
        System.out.println("Heap Memory: ");
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.println(" - Used: " + heapMemoryUsage.getUsed());
        System.out.println(" - Committed: " + heapMemoryUsage.getCommitted());
        System.out.println(" - Max: " + heapMemoryUsage.getMax());
        System.out.println(" - Init: " + heapMemoryUsage.getInit());

        System.out.println("Non-Heap Memory: ");
# 改进用户体验
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
        System.out.println(" - Used: " + nonHeapMemoryUsage.getUsed());
        System.out.println(" - Committed: " + nonHeapMemoryUsage.getCommitted());
        System.out.println(" - Max: " + nonHeapMemoryUsage.getMax());
        System.out.println(" - Init: " + nonHeapMemoryUsage.getInit());
    }
}
