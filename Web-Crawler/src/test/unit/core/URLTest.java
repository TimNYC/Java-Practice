package test.unit.core;

/**
 * Created by Tim Wang on 3/20/2016.
 */
//import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.URL;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

public class URLTest {
    public static void getURL() {
        String url = "http://www.google.com";
        try {
            URL pageURL = new URL(url);
            InputStream stream = pageURL.openStream();
            byte[] result = new byte[10];
            stream.read(result);
            char c = ' ';
            for (byte b : result) {
                c = (char) b;
                System.out.println(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getClient() {
        String url = "http://www.baidu.com";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            System.out.println("Executing request " + httpget.getRequestLine());
//            HttpPost httppost = new HttpPost();
            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                httpclient.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        getClient();
    }
}
