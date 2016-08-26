package strategy;

import java.io.IOException;

import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;

import model.Message;

public class MessageFeatureToggle implements IMessage {

	
	private Message message;
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public MessageFeatureToggle(Message message){
		this.message = message;
	}
	
	@Override
	public Message sendMessage() throws IOException {
		// TODO Auto-generated method stub
		
		message.setMessage("");;

		   LDClient client = new LDClient("sdk-548dca6e-ae25-4a5f-861d-8f854a267956");
	       
		   String valor= "5";
		   String usuario = "alejosd5@gmail.com";
		   
		   LDUser user = new LDUser.Builder(usuario)
				   .email("alejosd5@gmail.com")
				   .custom("telefono", valor)   
				   .build();
	       
		   boolean showFeature = client.boolVariation("sd", user,false);
		
	       		if (showFeature) {
	       		 
	       		  System.out.println("Showing your feature");
	       		  
	       		  message.setMessage("Java Spark Activado Feature Toggle Agile.   "+"usuario:  "+usuario+",telefono:"+valor);

	       		} else {
	       		
	       			System.out.println("Not showing your feature");
	       		
	       			message.setMessage("Java Spark Desactivado Feature Toggle Agile.   "+"usuario:  "+usuario+",telefono:"+valor);

	       		}
	    
	       		client.flush();
	       		client.close();

	       		return message;
	}
}
