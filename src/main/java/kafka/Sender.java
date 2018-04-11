	package kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


	@Value("${jsa.kafka.topic}")
	String kafkaTopic = "jsa-kafka-topic";
	
    public void send(String data) {
        LOGGER.info("sending payload='{}' to topic='{}'", data, kafkaTopic);
	    kafkaTemplate.send(kafkaTopic, data);
	    //kafkaTemplate.send(kafkaTopic, 0, null, data);
    }
}
