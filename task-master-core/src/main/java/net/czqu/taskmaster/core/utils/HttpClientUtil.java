package net.czqu.taskmaster.core.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
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

}
