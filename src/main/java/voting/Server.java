package voting;

import Presentation.FrontController.FrontController;
import Web.Http.HttpMethod;
import Web.Http.HttpRequest;
import Web.Http.HttpResponse;
import Web.Http.HttpStatus;

public class Server {

    public HttpResponse send(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        if (HttpMethod.GET.equals(request.getMethod())) {
            new FrontController().doGet(request, response);
        } else if (HttpMethod.POST.equals(request.getMethod())) {
            new FrontController().doPost(request, response);
        }
        response.setStatus(HttpStatus.OK);
        return response;
    }

}
