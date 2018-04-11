package kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	private static final Logger log = LoggerFactory.getLogger(Sender.class);

	@Autowired
	MessageStorage storage;
	
	
	
	/*@KafkaListener(id = "{group.id}",
	        topicPartitions = {
	                @TopicPartition(topic = "${kafka.topic.name}",
	                        partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0"))
	        })
	*/
	        
	//@KafkaListener(topicPartitions={@TopicPartition(topic = "${jsa.kafka.topic}", partitions = "0")})
	@KafkaListener(topics="${jsa.kafka.topic}")
    public void processMessage(String content) {
		log.info("received content = '{}'", content);
		storage.put(content);
    }
}


