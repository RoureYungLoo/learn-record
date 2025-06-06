package consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaMessageConsumer {
    private KafkaConsumer consumer;

    public void init() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");  // 指定 Broker
        properties.put("group.id", "experiment");              // 指定消费组群 ID
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // 将 key 的字节数组转成 Java 对象
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");  // 将 value 的字节数组转成 Java 对象

        consumer = new KafkaConsumer(properties);

        consumer.subscribe(Collections.singleton("order-events"));


    }

    public void consumer() {
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record :
                        records) {
                    String info = String.format("[Topic: %s][Partition: %d][Offset: %d][Key: %s][Message: %s]");
                    System.out.println(info);
                }
            }
        } catch (Exception e) {


        }
        finally {
            consumer.close();
        }

    }
}
