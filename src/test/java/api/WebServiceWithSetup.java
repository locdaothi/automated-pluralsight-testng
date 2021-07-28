package api;

import baseclasses.UnitTestBaseClass;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.apache.http.entity.ContentType.getOrDefault;

public class WebServiceWithSetup extends UnitTestBaseClass {
    CloseableHttpResponse closeableHttpResponse;
    CloseableHttpClient closeableHttpClient;

    @Test
    public void statusIs200() throws IOException {
        //Arrange: Create a client


        //Assert: This response object contains all headers(
        System.out.println("The First test");
        Assert.assertEquals(closeableHttpResponse.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void typeIsJSON() throws IOException {
        System.out.println("The Second test");
        Assert.assertEquals(getOrDefault(closeableHttpResponse.getEntity()).getMimeType(), "application/json");

    }

    @Test
    public void charSetIsUTF8() throws IOException {
        System.out.println("The Third Test");
        Assert.assertEquals(getOrDefault(closeableHttpResponse.getEntity()).getCharset().toString(), "UTF-8");

    }

    @AfterClass
    public void afterMethod() throws IOException {
        closeableHttpClient.close();
        closeableHttpResponse.close();
    }
}


