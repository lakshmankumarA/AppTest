
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miracle
 */
public class ConfirmOrder {
    
    
    
    public static void main(String[] args) {
        
        
         String input="{ \"transactionId\": \"98765\",\"merchantOrderNumber\": \"12345\"}";
         //String input="{ \"transactionId\": \"98765\",\"merchantOrderNumber\": \"12345\"}";
        Client c = Client.create();
        WebResource resource = c.resource("http://localhost:8180/HybrisConnector/hc/services/confirmOrder");
        com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
        resourceBuilder = resourceBuilder.accept(MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON);
        resourceBuilder = resourceBuilder.type(MediaType.APPLICATION_JSON_TYPE);
        com.sun.jersey.api.client.ClientResponse response;
        System.out.println(input);
        
        response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class, input);
            
        String responseString = response.getEntity(String.class);
        System.err.println("response--->"+response+"----"+responseString);
        
    }
    
}
