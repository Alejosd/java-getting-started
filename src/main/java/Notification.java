import java.io.IOException;

import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;

import model.Message;
import strategy.IMessage;

public class Notification {

	private IMessage message;

	public Notification(){
		
	}

	  public IMessage getMessage() {
		return message;
	}

	public void setMessage(IMessage message) {
		this.message = message;
	}

	public Message StrategyNotification(String email,String numberPhone) throws IOException{
		
		return message.sendMessage(email,numberPhone);
	  }

}
