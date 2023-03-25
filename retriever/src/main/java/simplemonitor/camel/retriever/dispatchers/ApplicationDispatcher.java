package simplemonitor.camel.retriever.dispatchers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import simplemonitor.camel.retriever.categories.CategoryDto;

public class ApplicationDispatcher extends Dispatcher {

	Logger logger = LoggerFactory.getLogger(ApplicationDispatcher.class);
	
	public ApplicationDispatcher() {
		this.setEndpointProtocol("http://");
		this.setEndpointIPAddress("192.168.122.202");
		this.setEndpointPort(":8083/");
		this.setRoute("api/application");
	}

	@Override
	public void dispatch(CategoryDto categoryDto) {
		HttpClient httpClient = HttpClient.newHttpClient();
		logger.info("DISPATCHING - > [" + categoryDto.toString() + "]");
		Gson gson = new Gson();
		String uriString = this.getEndpointProtocol() + 
					 this.getEndpointIPAddress() + 
					 this.getEndpointPort() + 
					 this.getRoute();
		try {
			String jsonObject = gson.toJson(categoryDto);
			logger.info("JSON-OBJECT: " + jsonObject);
			HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(new URI(uriString))
				.POST(BodyPublishers.ofString(jsonObject))
				.header("Content-Type", "application/json")
				.build();
			logger.info("URI CREATED SUCCESSFULLY: " + uriString);
			HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
			logger.info("RESPONSE FROM ENDPOINT: " + postResponse.body());
		} catch(URISyntaxException e) {
			logger.info("The URI couldn't be created: " + e.getMessage());
		} catch(InterruptedException e) {
			logger.info("Problem creating the HttpRsponse object (InterruptedException): " + e.getMessage());
		} catch(IOException e) {
			logger.info("Problem creating the HttpRsponse object (IOException): " + e.getMessage());
		}
	}

}
