
import static spark.Spark.*;

import static spark.Spark.get;

import java.beans.FeatureDescriptor;
import java.io.IOException;

import org.eclipse.jetty.http.HttpStatus;

import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;

public class Main {


  public static void main(String[] args) {

   port(Integer.valueOf(System.getenv("PORT")));
  
   Message message = new Message("hola mundo");
   FeatureToggle featureToggle = new FeatureToggle(message);

    get("/", "application/json", (request, response) -> {
        return new Message(featureToggle.featureToggle().getMessage());
        
        
    }, new JsonTransformer());
    
   
   
  }

}
