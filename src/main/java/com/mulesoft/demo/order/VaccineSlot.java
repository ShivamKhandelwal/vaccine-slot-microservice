package com.mulesoft.demo.order;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.apache.el.stream.Optional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class VaccineSlot {

	public static void main(String[] args) {
		SpringApplication.run(VaccineSlot.class, args);
	}

	@RequestMapping (value = "/appointment/calendarByDistrict", method = RequestMethod.GET)
	@CrossOrigin
	public String concentrators (@RequestParam String date, @RequestParam String district_id) {
		
	    final String uri = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?date=" + date + "&district_id=" + district_id;
	    
        /*
         * final String uri = "http://a3e72c1dab894493189bda728cd29b7d-2027065183.us-east-2.elb.amazonaws.com:3000/";
         * System.out.println(uri);
         * RestTemplate restTemplate = new RestTemplate();
         * String result = restTemplate.getForObject(uri, String.class);
         * 
         * System.out.println(result);
         * 
         * return result;
         */
        
	      //String https_url = "https://cdn-api.co-vin.in/api/v2/admin/location/states";
	      URL url;
	      String output = null;
	      try {

	         url = new URL(uri);
	         HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
	         con.addRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
	            
	         //dumpl all cert info
	        // print_https_cert(con);
	            
	         //dump all the content
	         
	             
	             System.out.println("****** Content of the URL ********");            
	             BufferedReader br = 
	              new BufferedReader(
	                  new InputStreamReader(con.getInputStream()));
	                      
	             String input; 
	                      
	             while ((input = br.readLine()) != null){
	                output=input;
	             }
	             br.close();
	                      
	          
	            
	      } catch (MalformedURLException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
        return output;
	}
}
