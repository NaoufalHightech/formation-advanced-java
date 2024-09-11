package jour3.ex6;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class AsyncHttpClient {

    private static HttpRequest getHttpRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }


}
