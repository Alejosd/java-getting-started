package strategy;

import java.io.IOException;

import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;

import model.Message;

public class MessageFeatureToggle implements IMessage {


	private Message message;

	private final static String desactiveFeatureToggle = "Java Spark Desactivado Feature Toggle Agile.   ";

	private final static String activeFeatureToggle = "Java Spark Activado Feature Toggle Agile.   ";


	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public MessageFeatureToggle(){
		message = new Message("");
	}

	@Override
	public Message sendMessage(String email,String numberPhone) throws IOException {
		// TODO Auto-generated method stub

		boolean showFeature = configFeatureToggle(email, numberPhone);

		if (showFeature) {

			System.out.println("Showing your feature");

			message.setMessage(activeFeatureToggle+"usuario:  "+email+",telefono:"+numberPhone);

		} else {

			System.out.println("Not showing your feature");

			message.setMessage(desactiveFeatureToggle+"usuario:  "+email+",telefono:"+numberPhone);

		}

	
		return message;
	}

	public boolean configFeatureToggle(String user, String numberPhone) throws IOException{

		String nameFlag = "sd";

		LDClient client = new LDClient("sdk-5073596d-fc3d-45e3-9a69-2f49615be793");

		LDUser userFeatureToggle = new LDUser.Builder(user)
				.custom("telefono", numberPhone)   
				.build();

		boolean showFeature = client.boolVariation(nameFlag,userFeatureToggle,false);
		
		client.flush();
		client.close();

		return showFeature;
	}
}
