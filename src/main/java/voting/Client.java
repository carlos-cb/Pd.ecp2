package voting;

import Web.Http.HttpRequest;
import Web.Http.HttpResponse;

public class Client {

    public HttpResponse send(HttpRequest request) {
        return new Server().send(request);
    }

}
