package strategy;

import model.Message;

public class MessageActive implements IMessage {

	
	private Message message;
	
	public MessageActive(Message message){
		this.message = message;
	}
	
	@Override
	public Message sendMessage() {
		// TODO Auto-generated method stub
		String text = "Funcionalidad activa sin featureToggle";
		message.setMessage(text);
		return message;
	}

}
