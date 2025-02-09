package producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class KafkaMessageProducer {
    private KafkaProducer producer;

    /*  */
    public void init() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");    // 指定 Broker
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");  // 将 key 的 Java 对象转成字节数组
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // 将 value 的 Java 对象转成字节数组
        properties.put("acks", "1");       // 消息至少成功发给一个副本后才返回成功
        properties.put("retries", "5");
        producer = new KafkaProducer<String, String>(properties);
    }

    public void send(ProducerRecord record) {
        try {
            producer.send(record).get(200, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendAsync(ProducerRecord record, Callback callback) {
        try {
            producer.send(record, callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
