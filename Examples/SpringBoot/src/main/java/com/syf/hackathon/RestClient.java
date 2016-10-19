package com.syf.hackathon;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.HttpHost;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import java.security.SecureRandom;

public class RestClient {

  private String server = "https://syf2020.syfwebservices.com/syf/";
  private RestTemplate rest;
  private HttpHeaders headers;
  private HttpStatus status;

  public RestClient() throws Exception {
    this.rest = new RestTemplate();
    //this.rest = createProxiedRestTemplate();	
    this.headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("username","giveitatry");
	headers.add("password","Sh0wT!me");
  }
  
  public RestClient(String server) throws Exception{
    this.server = server;
    this.rest = new RestTemplate();
    //this.rest = createProxiedRestTemplate();
    this.headers = new HttpHeaders();	
  }

  public String get(String uri) {
    HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
    ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  public String post(String uri, String json) {   
    HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
    ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.POST, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  } 
  
  public HttpHeaders getHeaders() {
    return headers;
  }
  
  /**
	Use this method if behind proxy. Update the variables below, and update RestClient constructors above
	*/
  private RestTemplate createProxiedRestTemplate() throws Exception {
	final String username = "";
	final String password = "";
	final String proxyUrl = "";
	final int port = 8080;

	CredentialsProvider credsProvider = new BasicCredentialsProvider();
	credsProvider.setCredentials( 
			new AuthScope(proxyUrl, port), 
			new UsernamePasswordCredentials(username, password));

	HttpHost myProxy = new HttpHost(proxyUrl, port);
	HttpClientBuilder clientBuilder = HttpClientBuilder.create();

	clientBuilder.setProxy(myProxy).setDefaultCredentialsProvider(credsProvider).disableCookieManagement();

	SSLContext sslcontext = SSLContexts.custom().useSSL().build();
	sslcontext.init(null, new X509TrustManager[]{new HttpsTrustManager()}, new SecureRandom());
	SSLConnectionSocketFactory factory1 = new SSLConnectionSocketFactory(sslcontext,
			SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
	HttpClient httpClient = clientBuilder.setSSLSocketFactory(factory1).build();	
	
	HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
	factory.setHttpClient(httpClient);

	return new RestTemplate(factory);
  }
}

  