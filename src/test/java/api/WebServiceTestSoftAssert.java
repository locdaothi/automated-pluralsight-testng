package api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.apache.http.entity.ContentType.getOrDefault;

public class WebServiceTestSoftAssert {
    @Test
    public void softAssertStopsImmediately() throws IOException {
        //Arrange: Create a client
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        SoftAssert softAssert = new SoftAssert();

        //Act : Execute https request
        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(new HttpGet("https://api.github.com"));

        //Assert: This response object contains all headers(
        System.out.println("The First test");
        softAssert.assertEquals(closeableHttpResponse.getStatusLine().getStatusCode(),404);

        System.out.println("The Second test");
        softAssert.assertEquals(getOrDefault(closeableHttpResponse.getEntity()).getMimeType(),"application/xml");

        System.out.println("The Third Test");
        softAssert.assertEquals(getOrDefault(closeableHttpResponse.getEntity()).getCharset().toString(),"UTF-8");

        closeableHttpClient.close();
        closeableHttpResponse.close();
        softAssert.assertAll();
    }
}
