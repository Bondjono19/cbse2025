package dk.sdu.cbse.common.data;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtil {
    private static HttpClient client = HttpClient.newHttpClient();

    //fetch points via HTTP
    public static String getPointsHTTP(){
        HttpResponse<String> res;
        HttpRequest getScore = HttpRequest.newBuilder().uri(URI.create("http://localhost:8081/score")).GET().build();
        try {
            res = client.send(getScore,HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("error fetching points");
        }
        return res.body();
    }
    //increase points by value via HTTP
    public static void increasePointsHTTP(int value){
        HttpResponse<String> res;
        String reqBody = String.format("{\"points\":%d}", value);
        String uri = "http://localhost:8081/score/increase";
        HttpRequest req = HttpRequest.newBuilder()
        .uri(URI.create(uri))
        .header("Content-Type", "application/json")
        .PUT(HttpRequest.BodyPublishers.ofString(reqBody))
        .build();
        try {
            res = client.send(req,HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("error updating points");
        }
    }
}
