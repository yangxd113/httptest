package com.my.test.httptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;


@SpringBootApplication

public class HttptestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttptestApplication.class, args);
		System.out.println("jinru httptest");		
		System.out.println(getDataByCityName() );
		System.out.println(postDataByJson());
		System.out.println(postDataForHao());
	}
	public static String getDataByCityName()   //get方法获取String类型结果；
	{
    RestTemplate restTemplate=new RestTemplate();
    String uri="http://10.125.128.30:9027/contest44/demo/hello"; 
	HttpHeaders headers = new HttpHeaders(); 
	headers.setContentType(MediaType.APPLICATION_JSON_UTF8); 
	HttpEntity<String> entity = new HttpEntity<String>(headers); 
	String strbody=restTemplate.exchange(uri, HttpMethod.GET, entity,String.class).getBody(); 
	//String weatherResponse= JSONObject.parseObject(strbody,WeatherResponse.class);
	return strbody; 
	}
	public static String postDataByJson()  
	{
		RestTemplate restTemplate=new RestTemplate();
	    String uri="http://10.125.128.30:9027/contest44/demo/body"; 
		HttpHeaders headers = new HttpHeaders(); 
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8); 
		JSONObject  postData = new JSONObject();
		postData.put("id", "321");
		postData.put("name", "yangxd113");
		postData.put("pwd", "2018");
		JSONObject json = restTemplate.postForEntity(uri, postData, JSONObject.class).getBody();
		return json.toString();
	}
	public static String postDataForHao() //post方法发送json-body请求并获取json响应；
	{
		RestTemplate restTemplate=new RestTemplate();
		String uri="http://10.124.164.110:8000/api/sendBox/isBlackName/v1";
		HttpHeaders headers = new HttpHeaders(); 
		headers.add("Content-Type", "application/json");
	    headers.add("Accept", "application/soap+xml");
	    headers.add("Accept-Encoding", "application/zip");
		String str=" {\n" + 
				"  \"UNI_BSS_HEAD\" : {\n" + 
				"    \"APP_ID\": \"GSLT\", \n" + 
				"    \"TIMESTAMP\": \"2018-10-31 16:06:06 100\", \n" + 
				"    \"TRANS_ID\": \"20181031160606100335423\", \n" + 
				"    \"TOKEN\": \"f1a2309a16adf6751b932677973af5e3\"\n" + 
				"  },\n" + 
				"  \"UNI_BSS_BODY\" : {\n" + 
				"       \"provinceCode\": \"87\",\n" + 
				"       \"psptTypeCode\": \"01\",\n" + 
				"       \"psptId\": \"622626199205134921\" \n" + 
				"  }\n" + 
				"}";
		JSONObject  postData = JSONObject.parseObject(str);  
		JSONObject json = restTemplate.postForEntity(uri, postData, JSONObject.class).getBody();
		JSONObject json2 = json.getJSONObject("UNI_BSS_HEAD");
		System.out.println("json2:"+json2);		
		System.out.println("json2.resp:"+json2.getString("RESP_DESC"));
		return json.toString();
	}
}
