package api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TimeOut {
    CloseableHttpClient closeableHttpClient;
    CloseableHttpResponse closeableHttpResponse;
    @BeforeMethod
    public void setup(){
        closeableHttpClient = HttpClientBuilder.create().build();
    }
    @Test()
    public void testIsTooSlow() throws IOException {
        //Act
        CloseableHttpResponse response = closeableHttpClient.execute(new HttpGet("https://api.github.com"));
        //Assert
        Assert.assertEquals((response.getStatusLine().getStatusCode()), 200);
    }
}
