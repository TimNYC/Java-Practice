package test.unit.core;

/**
 * Created by Tim Wang on 3/20/2016.
 */
import java.io.IOException;
import java.net.URL;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
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

    public static void ReleaseConnection() {
        String url = "http://www.google.com";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                // Get hold of the response entity
                HttpEntity entity = response.getEntity();

                // If the response does not enclose an entity, there is no need
                // to bother about connection release
                if (entity != null) {
                    InputStream instream = entity.getContent();
                    try {
                        System.out.println((char)instream.read());
                        // do something useful with the response
                    } catch (IOException ex) {
                        // In case of an IOException the connection will be released
                        // back to the connection manager automatically
                        throw ex;
                    } finally {
                        // Closing the input stream will trigger connection release
                        instream.close();
                    }
                }
            } finally {
                System.out.println("inner close");
                //response.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                System.out.println("outer close");
                httpclient.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        ReleaseConnection();
    }
}
