
import static spark.Spark.*;

import static spark.Spark.get;

import model.Message;
import strategy.IMessage;
import strategy.MessageActive;
import strategy.MessageFeatureToggle;
import util.JsonTransformer;

public class Main {


  public static void main(String[] args) {

   port(Integer.valueOf(System.getenv("PORT")));
  
   Message text = new Message();
   IMessage messageStrategy =  new MessageFeatureToggle(text);
   Notification notification = new Notification(messageStrategy);

    get("/", "application/json", (request, response) -> {
        return notification.StrategyNotification().getMessage();
        
        
    }, new JsonTransformer());
    
  }

}
