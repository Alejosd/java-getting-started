package strategy;

import java.io.IOException;

import model.Message;

public interface IMessage {
public Message sendMessage(String user,String numberPhone) throws IOException;
}
