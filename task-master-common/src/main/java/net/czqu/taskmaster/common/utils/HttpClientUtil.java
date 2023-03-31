package net.czqu.taskmaster.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-15 21:28
 **/
public class HttpClientUtil {
    /**
     * 发送 HTTP GET 请求
     *
     * @param url    请求 URL
     * @param params 请求参数
     * @return 响应体字符串
     * @throws IOException
     */
    public static String httpGet(String url, Map<String, String> params) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder(url);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                uriBuilder.addParameter(entry.getKey(), entry.getValue());
            }
        }
        HttpGet httpGet = new HttpGet(uriBuilder.toString());
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        String responseBody = handleResponse(httpResponse);
        return responseBody;
    }

    public static String httpGet(String url, Map<String, String> params, Map<String, String> headers) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder(url);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                uriBuilder.addParameter(entry.getKey(), entry.getValue());
            }
        }
        HttpGet httpGet = new HttpGet(uriBuilder.toString());
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        String responseBody = handleResponse(httpResponse);
        return responseBody;
    }


    /**
     * Sends HTTP POST request with optional headers, parameters, and request body
     *
     * @param url     Request URL
     * @param params  Request parameters
     * @param headers Request headers
     * @param body    Request body as string
     * @return Response body as string
     * @throws IOException
     */
    public static String httpPost(String url, Map<String, String> params, Map<String, String> headers,
                                  String body) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder(url);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                uriBuilder.addParameter(entry.getKey(), entry.getValue());
            }
        }
        HttpPost httpPost = new HttpPost(uriBuilder.toString());
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (body != null) {
            httpPost.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
        }

        return handleResponse(httpClient.execute(httpPost));
    }


    private static String handleResponse(HttpResponse response) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String responseBody = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
                return responseBody;
            }
        } else {
            EntityUtils.consume(response.getEntity());
            throw new RuntimeException("HTTP status code: " + statusCode);
        }
        return null;
    }

    /**
     * 发送 HTTP PUT 请求
     *
     * @param url     请求 URL
     * @param headers 请求头部信息
     * @param body    请求体内容
     * @return 响应体字符串
     * @throws IOException
     */
    public static String httpPut(String url, Map<String, String> headers, String body) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url);
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPut.addHeader(entry.getKey(), entry.getValue());
            }
        }
        StringEntity entity = new StringEntity(body, ContentType.APPLICATION_JSON);
        httpPut.setEntity(entity);
        CloseableHttpResponse httpResponse = httpClient.execute(httpPut);
        String responseBody = handleResponse(httpResponse);
        return responseBody;
    }

    /**
     * 发送 HTTP DELETE 请求
     *
     * @param url     请求 URL
     * @param headers 请求头
     * @return 响应体字符串
     * @throws IOException
     */
    public static String httpDelete(String url, Map<String, String> headers) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(url);
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpDelete.addHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse httpResponse = httpClient.execute(httpDelete);
        String responseBody = handleResponse(httpResponse);
        return responseBody;
    }


}
