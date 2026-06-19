package center.jhub.utils.service;


import center.jhub.utils.api.APIUtils;
import center.jhub.utils.api.HttpRequestOptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

/**
 * Skeleton for creating HTTP requests
 */
public abstract class BaseHttpService {


    /**
     * GET Responses
     */

    protected HttpResponse<String> getResponse(String path) {
        return APIUtils.getResponse(getClient(), getBaseUrl(), path);
    }

    protected HttpResponse<String> getResponse(String path, HttpRequestOptions options) {
        return APIUtils.getResponse(getClient(), getBaseUrl(), path, options);
    }

    /**
     * POST Responses
     */

    protected <T> HttpResponse<String> postResponse(String path) {
        return APIUtils.postResponse(getObjectMapper(), getClient(), getBaseUrl(), path, null);
    }

    protected <T> HttpResponse<String> postResponse(String path, HttpRequestOptions options) {
        return APIUtils.postResponse(getObjectMapper(), getClient(), getBaseUrl(), path, null, options);
    }

    protected <T> HttpResponse<String> postResponse(String path, T body) {
        return APIUtils.postResponse(getObjectMapper(), getClient(), getBaseUrl(), path, body);
    }

    protected <T> HttpResponse<String> postResponse(String path, T body, HttpRequestOptions options) {
        return APIUtils.postResponse(getObjectMapper(), getClient(), getBaseUrl(), path, body, options);
    }

    protected <T> HttpResponse<String> putResponse(String path, T o, HttpRequestOptions options)  {
        return APIUtils.putResponse(getObjectMapper(), getClient(), getBaseUrl(), path, o, options);
    }

    /**
     * DELETE Responses
     */

    /**
     * PUT Responses
     */

    /**
     * PATCH Responses
     */

    protected boolean isOkResponse(HttpResponse<?> response) {
        return response.statusCode() == 200 || response.statusCode() == 201;
    }

    public abstract HttpClient getClient();
    public abstract ObjectMapper getObjectMapper();
    public abstract String getBaseUrl();
}