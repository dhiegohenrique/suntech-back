package br.com.suntech;

import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.client.TestRestTemplate.HttpClientOption;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.suntech.suntechback.SuntechBackApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=SuntechBackApplication.class)
public abstract class BaseTest {
    
	private static final String SERVER_ADDRESS = "http://localhost:";
	private static final String SERVER_CONTEXT = "/";
	
	protected static final String URL_USERS = "/users";
	
	@LocalServerPort 
	private int port;
	
	protected String url;
	
	protected TestRestTemplate restTemplate = new TestRestTemplate(HttpClientOption.ENABLE_COOKIES);

	public void setUrl(String urlParam) {
    	this.url = this.getServerPath().concat(urlParam);
    }
    
    private String getServerPath() {
    	return SERVER_ADDRESS + this.port + SERVER_CONTEXT;
    }
}