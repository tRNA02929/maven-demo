package cn.snail;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.SlidingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 * 使用滑动窗口，每5秒计算一次前10秒内来自web套接字的单词计数。
 */
public class WindowOperatorDemo2 {
    public static void main(String[] args) throws Exception {
        // 设置流执行环境
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // 加载数据-转换-执行窗口操作
        // 读取socket数据源
        String HOST = "localhost";
        int PORT = 9999;

        DataStream<Tuple2<String, Integer>> dataStream = env
                .socketTextStream(HOST, PORT)
                .map(String::toLowerCase)
                .flatMap(new Splitter())
                .keyBy(0)                       // keyed stream
                .window(SlidingProcessingTimeWindows.of(Time.seconds(10), Time.seconds(5))) // 滑动窗口，注意这里使用的是处理时间
                .sum(1);                        // 对元组第二个字段求和

        dataStream.print();

        env.execute("Window WordCount");
    }

    // 自定义的FlatMap函数
    public static class Splitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String sentence, Collector<Tuple2<String, Integer>> out) throws Exception {
            for (String word : sentence.split("W+")) {
                out.collect(new Tuple2<>(word, 1));
            }
        }
    }
}