package com.self.demo.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description: JMH工具测试类
 * @Author javaJoker
 * @Date 2020/1/13
 * @Version V1.0
 *
 * Benchmark:标记方法，只有被这个注解标记了，该方法才会参与基准测试，被标记的方法必须是public
 * Warmup：配置预热内容，用于类或者方法
 * Measurement：用于控制实际执行的内容，配置选项与Warmup
 * BenchmarkMode：测量的唯独
 * OutputTimeUnit：测量单位
 *
 * @State
 * @Param 参数
 * @Threads 测试线程数量
 **/
@Warmup(iterations = 5, time = 1,timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5,time = 1,timeUnit = TimeUnit.SECONDS)
public class JmhTest {
    static class Demo {
        int id;
        String name;
        public Demo(int id, String name){
            this.id = id;
            this.name = name;
        }
    }
    
    static List<Demo> demoList;
    static {
        demoList = new ArrayList();
        for (int i = 0; i < 10000; i++){
            demoList.add( new Demo( i, "test" ) );
        }
    }
    
    @Benchmark
    @BenchmarkMode( Mode.AverageTime )
    @OutputTimeUnit( TimeUnit.MICROSECONDS )
    public void testHashMapWithoutSize(){
        Map map = new HashMap();
        for (Demo demo : demoList){
            map.put( demo.id, demo.name );
        }
    }
    
    @Benchmark
    @BenchmarkMode( Mode.AverageTime )
    @OutputTimeUnit( TimeUnit.MICROSECONDS )
    public void testHashMap(){
        Map map = new HashMap((int)(demoList.size() / 0.75f) + 1);
        for (Demo demo : demoList){
            map.put( demo.id, demo.name );
        }
    }

    public static void main(String[] args) {
        Options opt = new OptionsBuilder().include( JmhTest.class.getSimpleName() ).forks( 1 ).build();
        try {
            new Runner( opt ).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }
}
