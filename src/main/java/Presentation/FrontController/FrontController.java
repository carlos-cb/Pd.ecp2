package Presentation.FrontController;

import Web.Http.HttpRequest;
import Web.Http.HttpResponse;

public class FrontController {

	    private Dispatcher dispatcher;

	    public FrontController() {
	        dispatcher = new Dispatcher();
	    }

	    public void doGet(HttpRequest request, HttpResponse response) {
	        dispatcher.doGet(request, response);
	    }
	    
	    public void doPost(HttpRequest request, HttpResponse response) {
	        dispatcher.doPost(request, response);
	    }

	
}
