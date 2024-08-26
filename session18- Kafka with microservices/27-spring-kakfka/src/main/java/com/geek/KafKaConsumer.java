package com.geek;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);
    @KafkaListener(topics = "productTopic1",
                    groupId = "group_id")
    //once a message received automatically 
    //this method gets invoked.....
    public void consume( ConsumerRecord<String, String>    record){
    	String message = record.value();
    	System.out.println("Key : "+record.key());
        // Get the timestamp of the message
        long timestamp = record.timestamp();

        // Do something with the message and timestamp
        System.out.println("Received message: " + message);
        System.out.println("Message timestamp: " + timestamp);
        System.out.println(new Date(timestamp));
  	  }
   
}