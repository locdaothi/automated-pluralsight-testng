package baseclasses;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class UnitTestBaseClass {
    CloseableHttpResponse closeableHttpResponse;
    CloseableHttpClient closeableHttpClient;
    @BeforeSuite
    public void globalSetup() throws IOException {
        closeableHttpClient = HttpClientBuilder.create().build();

        //Act : Execute https request
        closeableHttpResponse = closeableHttpClient.execute(new HttpGet("https://api.github.com"));
    }

}
