package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
 
@RestController
@RequestMapping(value="/jsa/kafka")
public class ServController {
	
	@Autowired
	Sender sender;
	
	@Autowired
	MessageStorage storage;
	
	@Autowired
	MessageStorage2 storage2;
	
	@GetMapping(value="/producer")
	public String producer(@RequestParam("data")String data){
		sender.send(data);
		return "Done";
	}
	
	@GetMapping(value="/consumer")
	public String getAllRecievedMessage(){
		String messages = storage.toString();
		storage.clear();
		
		return messages;
	}
	
	@GetMapping(value="/consumer2")
	public String getAllRecievedMessage2(){
		String messages = storage2.toString();
		storage2.clear();
		
		return messages;
	}
	
}