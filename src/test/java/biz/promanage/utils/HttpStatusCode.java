package biz.promanage.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HttpStatusCode {

    private static Map<String, String> statusMessage = null;

    private  static void LoadHttpStatusCodes() {
        statusMessage = new HashMap<>();
        statusMessage.put("200", "OK");
        statusMessage.put("201", "Success");
        statusMessage.put("204", "Success");
        statusMessage.put("301", "Login required");
        statusMessage.put("304", "Not Modified");
        statusMessage.put("400", "Possible errors : Parsing error, Bad request, Missing reference, Serialization error, Validation error");
        statusMessage.put("401", "Possible errors :  Login required, Unauthorized");
        statusMessage.put("403", "Possible errors : Forbidden, This service has not been enabled for your site, XSRF Protection Failure");
        statusMessage.put("404", "The requested resource was not found");
        statusMessage.put("409", "There was a conflict");
        statusMessage.put("412", "The resource you are attempting to delete has dependencies, and cannot be deleted");
        statusMessage.put("413", "Storage space exceeded");
        statusMessage.put("429", "Too Many Requests");
        statusMessage.put("500", "Possible errors : The service has encountered an error, Internal Server Error");
        statusMessage.put("502", "Bad Gateway");
        statusMessage.put("503", "Service Unavailable, There was a timeout processing the request");
    }

    public static String getStatusInfoByStatusCode(String statusCode) {
        LoadHttpStatusCodes();
        String info = "";
        info = statusMessage.getOrDefault(statusCode, "An error occurred");
        return info;
    }

    public static int checkHttpStatusCode(String webappUrl) throws IOException, InterruptedException {
        URI uri = URI.create(webappUrl);
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        return response.statusCode();
    }
}
