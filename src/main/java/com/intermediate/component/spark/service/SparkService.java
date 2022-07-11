package com.intermediate.component.spark.service;

import com.intermediate.component.spark.dto.WordCount;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

@Service
public class SparkService {
    @Autowired
    private JavaSparkContext javaSparkContext;

    public List<WordCount> doWordCount(){
        JavaRDD<String> file = javaSparkContext.textFile("/Users/ELLIE/study/example/src/main/resources/README.md");

        JavaRDD<String> words = file.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

        JavaRDD<WordCount> wordCount = words.map(word -> new WordCount(word,1));

        JavaPairRDD<String,Integer> pair = wordCount.mapToPair(wc -> new Tuple2<>(wc.getWord(),wc.getCount()));

        JavaPairRDD<String,Integer> wordcounts = pair.reduceByKey((count1,count2) ->count1 +count2);

        JavaRDD<WordCount> map = wordcounts.map((tuple2) -> new WordCount(tuple2._1,tuple2._2));

        List<WordCount> result = map.collect();
        return result;
    }
}
