package test.thread;

import java.lang.management.*;
import java.util.List;

public class Jk {

	public static void main(String[] args) {
		
		int total = (int)Runtime.getRuntime().totalMemory()/1024/1024;

		System.out.println("totalMemory" + total + "mb");

		int free = (int)Runtime.getRuntime().freeMemory()/1024/1024;

		System.out.println("freeMemory " + free + "mb");

		int max = (int) (Runtime.getRuntime().maxMemory() /1024 / 1024);

		System.out.println("maxMemory "  + max + "mb");
		
		System.out.println("==========================Memory=======================");

		MemoryMXBean memoryMBean = ManagementFactory.getMemoryMXBean();   

		    MemoryUsage usage = memoryMBean.getHeapMemoryUsage();   

		    System.out.println("init Heap: " + (usage.getInit()/1024/1024) + "mb");

		    System.out.println(" max Heap: " + (usage.getMax()/1024/1024) + "mb");

		    System.out.println("use Heap: " + (usage.getUsed()/1024/1024) + "mb");

		    System.out.println("Heap Memory Usage: " + memoryMBean.getHeapMemoryUsage());   

		    System.out.println("Non-Heap Memory Usage: " + memoryMBean.getNonHeapMemoryUsage());   

		    //==========================Runtime=========================

		    System.out.println("==========================Runtime=======================");

		    RuntimeMXBean runtimeMBean = ManagementFactory.getRuntimeMXBean();

		System.out.println("JVM name : " + runtimeMBean.getVmName());

		System.out.println("lib path : " + runtimeMBean.getLibraryPath());

		System.out.println("class path : " + runtimeMBean.getClassPath());

		System.out.println("getVmVersion() " + runtimeMBean.getVmVersion());  

		//java options

		List<String> argList = runtimeMBean.getInputArguments();

		for(String arg : argList){

		System.out.println("arg : " + arg);

		}

		//==========================OperatingSystem=========================

		System.out.println("===================OperatingSystem====================");

		OperatingSystemMXBean osMBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();  

		//��ȡ����ϵͳ�����Ϣ  

		System.out.println("getName() "+ osMBean.getName());

		System.out.println("getVersion() " + osMBean.getVersion());

		System.out.println("getArch() "+osMBean.getArch());  

		    System.out.println("getAvailableProcessors() " + osMBean.getAvailableProcessors());  

		    //==========================Thread=========================

		    System.out.println("==========================Thread=========================");

		    //��ȡ�����̵߳ĸ���״̬��CPU ռ��������Լ�����ϵͳ�е��߳�״��  

		    ThreadMXBean threadMBean=(ThreadMXBean)ManagementFactory.getThreadMXBean();  

		    System.out.println("getThreadCount() " + threadMBean.getThreadCount());  

		    System.out.println("getPeakThreadCount() " + threadMBean.getPeakThreadCount());  

		    System.out.println("getCurrentThreadCpuTime() " + threadMBean.getCurrentThreadCpuTime());  

		    System.out.println("getDaemonThreadCount() " + threadMBean.getDaemonThreadCount());  

		    System.out.println("getCurrentThreadUserTime() "+ threadMBean.getCurrentThreadUserTime());  

		    //==========================Compilation=========================

		    System.out.println("========================Compilation======================");

		    CompilationMXBean compilMBean=(CompilationMXBean)ManagementFactory.getCompilationMXBean();   

		    System.out.println("getName() " + compilMBean.getName());  

		    System.out.println("getTotalCompilationTime() " + compilMBean.getTotalCompilationTime());  

		    //==========================MemoryPool=========================

		    System.out.println("=======================MemoryPool========================");

		    //��ȡ����ڴ�ص�ʹ�����  

		    List<MemoryPoolMXBean> mpMBeanList= ManagementFactory.getMemoryPoolMXBeans();  

		    for(MemoryPoolMXBean mpMBean : mpMBeanList){  

		        System.out.println("getUsage() " + mpMBean.getUsage());  

		        System.out.println("getMemoryManagerNames() "+ mpMBean.getMemoryManagerNames().toString());  

		    }

		    //==========================GarbageCollector=========================

		    System.out.println("====================GarbageCollector=====================");

		    //��ȡGC�Ĵ����Լ�����ʱ��֮�����Ϣ  

		    List<GarbageCollectorMXBean> gcMBeanList=ManagementFactory.getGarbageCollectorMXBeans();  

		    for(GarbageCollectorMXBean gcMBean : gcMBeanList){  

		        System.out.println("getName() " + gcMBean.getName());  

		        System.out.println("getMemoryPoolNames() "+ gcMBean.getMemoryPoolNames());  

	        }
	}

}
