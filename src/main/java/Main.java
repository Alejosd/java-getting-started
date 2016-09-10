
import static spark.Spark.*;

import static spark.Spark.get;

import model.Message;
import strategy.IMessage;
import strategy.MessageFeatureToggle;
import util.JsonTransformer;

public class Main {


	public static void main(String[] args) {

		configPort();

		Notification notification = featureToggle();

		requestGet(notification);


	}

	public static void configPort(){

		//Config Port

		Integer defectPort = 8080;

		Integer valuePort;

		if(System.getenv("PORT")!=null){

			valuePort = Integer.valueOf(System.getenv("PORT"));

		}else{
			valuePort = defectPort;
		}

		port(valuePort);

		//End Config Port

	}

	public static Notification featureToggle(){

		//FeatureToggle 

		IMessage messageStrategy =  new MessageFeatureToggle();

		Notification notification = new Notification();

		notification.setMessage(messageStrategy);

		return notification;
		//End Feature Toggle
	}

	public static void requestGet( Notification notification){
		//Request HTTP GET

		get("/", "application/json", (request, response) -> {

			String defectValue = "";

			String valueParameterUser = request.queryParams("user");

			String valueParameterNumberPhone = request.queryParams("numberPhone");

			String user = valueParameterUser!=null?valueParameterUser:defectValue;

			String numberPhone = valueParameterNumberPhone!=null?valueParameterNumberPhone:defectValue;

			Message message = new Message(notification.StrategyNotification(user,numberPhone).getMessage());

			return message;

		}, new JsonTransformer());

		//End Request HTTP GET
	}
}