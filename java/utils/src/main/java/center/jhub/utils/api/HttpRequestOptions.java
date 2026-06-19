package center.jhub.utils.api;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import lombok.Getter;

@Getter
public class HttpRequestOptions {
    private Map<String, String> headers;
    private Map<String, String> paramRequest;
    private Map<String, String> pathVariables;
    private HttpClient.Version version = Version.HTTP_2;

    private HttpRequestOptions() {
        this(new HashMap<>(), new HashMap<>(), new HashMap<>());
    }

    private HttpRequestOptions(Map<String, String> headers, Map<String, String> paramRequest, Map<String, String> pathVariables) {
        this.headers = headers;
        this.paramRequest = paramRequest;
        this.pathVariables = pathVariables;
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void setVersion(HttpClient.Version version) {
        this.version = version;
    }

    public void addHeaderIfNonExists(String key, String value) {
        if (!headers.containsKey(key))
            headers.put(key, value);
    }

    public void addPathVariable(String key, String value) {
        pathVariables.put(key, value);
    }

    public void addParamRequest(String key, String value) {
        paramRequest.put(key, value);
    }

    public String[] mappedHeaders() {
        ArrayList<String> result = new ArrayList<>(headers.size() * 2);
        for (Entry<String, String> h : headers.entrySet()) {
            result.add(h.getKey());
            result.add(h.getValue());
        }
        return result.toArray(new String[0]);
    }

    public String parsedParams() {
        if (paramRequest.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder("?");
        for (Entry<String, String> p : paramRequest.entrySet()) {
            if (sb.length() > 1) {
                sb.append("&");
            }
            sb.append(p.getKey());
            sb.append("=");
            sb.append(p.getValue());
        }

        return sb.toString();
    }

    public String parsePathVariables(String uri) {
        for (Entry<String, String> p : pathVariables.entrySet()) {
            Pattern pattern = Pattern.compile("{" + p.getKey() + "}", Pattern.LITERAL);
            uri = uri.replace(pattern.pattern(), p.getValue());
        }
        return uri;
    }

    public boolean hasPathVariables() {
        return !pathVariables.isEmpty();
    }

    public HttpRequestOptions withHeader(String key, String value) {
        addHeader(key, value);
        return this;
    }

    public HttpRequestOptions withPathVariable(String key, String value) {
        addPathVariable(key, value);
        return this;
    }

    public HttpRequestOptions withParamRequest(String key, String value) {
        addParamRequest(key, value);
        return this;
    }

    public HttpRequestOptions withVersion(HttpClient.Version version) {
        setVersion(version);
        return this;
    }

    public static HttpRequestOptions with(Map<String, String> headers, Map<String, String> paramRequest, Map<String, String> pathVariables) {
        return new HttpRequestOptions(headers, paramRequest, pathVariables);
    }

    public static HttpRequestOptions withHeaders(Map<String, String> headers) {
        return new HttpRequestOptions(headers, new HashMap<>(), new HashMap<>());
    }

    public static HttpRequestOptions withParamRequest(Map<String, String> paramRequest) {
        return new HttpRequestOptions(new HashMap<>(), paramRequest, new HashMap<>());
    }

    public static HttpRequestOptions withPathVariables(Map<String, String> pathVariables) {
        return new HttpRequestOptions(new HashMap<>(), new HashMap<>(), pathVariables);
    }

    public static HttpRequestOptions empty() {
        return new HttpRequestOptions();
    }
}
