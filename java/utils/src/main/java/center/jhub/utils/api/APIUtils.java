package center.jhub.utils.api;


import static center.jhub.constants.APIConstants.HEADER_ACCEPT;
import static center.jhub.constants.APIConstants.HEADER_ACCEPT_JSON_VALUE;
import static center.jhub.constants.APIConstants.HEADER_CONTENT_TYPE;

import center.jhub.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

/**
 *
 */
public class APIUtils {

    public static HttpResponse<String> getResponse(HttpClient client, String baseUrl, String path) {
        return getResponse(client, baseUrl, path, HttpRequestOptions.empty());
    }

    public static <T> HttpResponse<String> postResponse(ObjectMapper objectMapper, HttpClient client, String baseUrl, String path, T o) {
        return postResponse(objectMapper, client, baseUrl, path, o, HttpRequestOptions.empty());
    }

    public static <T> HttpResponse<String> putResponse(ObjectMapper objectMapper, HttpClient client, String baseUrl, String path, T o)  {
        return putResponse(objectMapper, client, baseUrl, path, o, HttpRequestOptions.empty());
    }

    public static HttpResponse<String> getResponse(HttpClient client, String baseUrl, String path, HttpRequestOptions options) {
        String uri = baseUrl + path;
        HttpRequest request = buildGetRequest(uri, options);
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> HttpResponse<String> postResponse(ObjectMapper objectMapper, HttpClient client, String baseUrl, String path, T o, HttpRequestOptions options) {
        String uri = baseUrl + path;
        HttpRequest request = buildPostRequest(objectMapper, uri, o, options);
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> HttpResponse<String> putResponse(ObjectMapper objectMapper, HttpClient client, String baseUrl, String path, T o, HttpRequestOptions options)  {
        String uri = baseUrl + path;
        HttpRequest request = buildPutRequest(objectMapper, uri, o, options);
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static HttpRequest buildGetRequest(String uri, HttpRequestOptions options) {
        options.addHeaderIfNonExists(HEADER_ACCEPT, HEADER_ACCEPT_JSON_VALUE);
        if (options.hasPathVariables()) {
            uri = options.parsePathVariables(uri);
        }
        return HttpRequest.newBuilder()
                   .uri(URI.create(uri + options.parsedParams()))
                   .headers(options.mappedHeaders())
                   .GET()
                   .build();
    }

    public static <T> HttpRequest buildPostRequest(ObjectMapper objectMapper, String uri, T body, HttpRequestOptions options) {
        options.addHeader(HEADER_ACCEPT, HEADER_ACCEPT_JSON_VALUE);
        options.addHeaderIfNonExists(HEADER_CONTENT_TYPE, HEADER_ACCEPT_JSON_VALUE);
        if (options.hasPathVariables()) {
            uri = options.parsePathVariables(uri);
        }
        return HttpRequest.newBuilder()
                   .uri(URI.create(uri + options.parsedParams()))
                   .headers(options.mappedHeaders())
                   .POST(BodyPublishers.ofString(JsonUtils.deserialize(objectMapper, body)))
                   .build();
    }

    public static <T> HttpRequest buildPutRequest(ObjectMapper objectMapper, String uri, T body, HttpRequestOptions options) {
        options.addHeader(HEADER_ACCEPT, HEADER_ACCEPT_JSON_VALUE);
        options.addHeaderIfNonExists(HEADER_CONTENT_TYPE, HEADER_ACCEPT_JSON_VALUE);
        if (options.hasPathVariables()) {
            uri = options.parsePathVariables(uri);
        }
        return HttpRequest.newBuilder()
                   .version(options.getVersion())
                   .uri(URI.create(uri + options.parsedParams()))
                   .headers(options.mappedHeaders())
                   .PUT(BodyPublishers.ofString(JsonUtils.deserialize(objectMapper, body)))
                   .build();
    }

}