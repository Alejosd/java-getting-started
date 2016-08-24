import java.io.IOException;

import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;

import model.Message;
import strategy.IMessage;

public class Notification {

	private IMessage message;

	public Notification(IMessage message){
		this.message=message;
	}

	  public IMessage getMessage() {
		return message;
	}

	public void setMessage(IMessage message) {
		this.message = message;
	}

	public Message StrategyNotification() throws IOException{
		
		return message.sendMessage();
	  }

}
