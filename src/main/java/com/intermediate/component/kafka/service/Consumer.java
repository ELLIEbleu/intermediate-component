package com.intermediate.component.kafka.service;

import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) {
        logger.info(String.format("##### -> consumed message -> %s", message));
    }

    @KafkaListener(topics = "test", groupId = "group_test")
    public void consumeTest(String message) {
        logger.info(String.format("##### -> consumed message -> %s", message));
    }

    @KafkaListener(topics = "topic-kl")
//    @SendTo
    public void listen(String input, Acknowledgment ack){
        ack.acknowledge();  //
    }



    //Partitioner

    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        if (keyBytes == null) {
//            int nextValue = counter.getAndIncrement();
            int nextValue = 0;    //todo
            List<PartitionInfo> availablePartitions = cluster.availablePartitionsForTopic(topic);
            if (availablePartitions.size() > 0) {
                int part = Utils.toPositive(nextValue) % availablePartitions.size();
                return availablePartitions.get(part).partition();
            } else {
                // no partitions are available, give a non-available partition
                return Utils.toPositive(nextValue) % numPartitions;
            }
        } else {
            // hash the keyBytes to choose a partition
            return Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;
        }
    }

    public static void main(String[] args) {
        System.out.println(Utils.toPositive(100));
        System.out.println(Utils.toPositive(-100));

    }
}
