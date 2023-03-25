package simplemonitor.camel.retriever.dispatchers;

import com.google.gson.Gson;

import simplemonitor.camel.retriever.categories.CategoryDto;

public abstract class Dispatcher {

	private String endpointProtocol;
	private String endpointIPAddress;
	private String endpointPort;
	private String route;
	
	public String getEndpointProtocol() {
		return endpointProtocol;
	}
	public void setEndpointProtocol(String endpointProtocol) {
		this.endpointProtocol = endpointProtocol;
	}
	public String getEndpointIPAddress() {
		return endpointIPAddress;
	}
	public void setEndpointIPAddress(String endpointIPAddress) {
		this.endpointIPAddress = endpointIPAddress;
	}
	public String getEndpointPort() {
		return endpointPort;
	}
	public void setEndpointPort(String endpointPort) {
		this.endpointPort = endpointPort;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	
	public abstract void dispatch(CategoryDto category);
	
}
