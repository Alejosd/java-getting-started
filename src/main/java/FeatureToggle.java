import java.io.IOException;

import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;

public class FeatureToggle {

	private Message message;

	public FeatureToggle(Message message){
		this.message=message;
	}

	  public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Message featureToggle() throws IOException{

		Message message = new Message("");

		   LDClient client = new LDClient("sdk-548dca6e-ae25-4a5f-861d-8f854a267956");
	       LDUser user = new LDUser("alejosd5@gmail.com");
	       		boolean showFeature = client.boolVariation("sd", user,false);

	       		if (showFeature) {
	       		  System.out.println("Showing your feature");
	       		  message.setMessage("Java Spark Activado Feature Toggle Agile");

	       		} else {
	       		  System.out.println("Not showing your feature");
	       		message.setMessage("Java Spark Desactivado Feature Toggle Agile");

	       		}
	       		client.flush();
	       		client.close();

	       		return message;
	  }

}
