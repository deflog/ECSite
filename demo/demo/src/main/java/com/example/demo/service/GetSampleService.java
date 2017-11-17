package com.example.demo.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.RestDataDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class GetSampleService {

	public String service(String type,String count,String sa) throws URISyntaxException{
		//URI uri = new URI("http://webservice.recruit.co.jp/hotpepper/gourmet/v1/?key=cab9b7edab23bec4&format=json&genre={type}") ;
		String uri = "http://webservice.recruit.co.jp/hotpepper/gourmet/v1/?key=cab9b7edab23bec4&format=json&genre={type}&start="+count+"&service_area="+sa;
		String s = new RestTemplate().getForObject(uri,String.class,type);

		return s;
	}
	public String Idservice(String type) {
		String uri = "http://webservice.recruit.co.jp/hotpepper/gourmet/v1/?key=cab9b7edab23bec4&format=json&id={type}";
		String s = new RestTemplate().getForObject(uri,String.class,type);
		return s;
	}
	public JsonNode resultnum(String text) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		JsonNode rootNode = mapper.readValue(text,JsonNode.class);

		JsonNode nameFirst = rootNode.get("results");

		return nameFirst;
	}

	public JsonNode jsonservice(String text) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		JsonNode rootNode = mapper.readValue(text,JsonNode.class);

		JsonNode nameFirst = rootNode.get("results").get("shop");





		return nameFirst;
	}
	public String resultNumber(JsonNode results) {

		return strip(results.get("results_available").toString());
	}
	public ArrayList<RestDataDTO> restMapping(JsonNode shop) {
		ArrayList<RestDataDTO> rdd = new ArrayList<>();

		for(int i=0;i<shop.size();i++) {
			JsonNode current = shop.get(i);
			RestDataDTO result = new RestDataDTO();
			//result.setAddress(strip(current.get("address").toString()));
			//result.setCard(strip(current.get("card").toString()));
			//result.setCharter(strip(current.get("charter").toString()));
			//result.setCourse(strip(current.get("course").toString()));
			//result.setFree_drink(strip(current.get("free_drink").toString()));
			//result.setGenre(strip(current.get("genre").get("name").toString()));
			//result.setHorigotatsu(strip(current.get("horigotatsu").toString()));
			result.setId(strip(current.get("id").toString()));
			//result.setLogo_image(strip(current.get("logo_image").toString()));
			//result.setMobile_access(strip(current.get("mobile_access").toString()));
			result.setName(strip(current.get("name").toString()));
			//result.setNon_smoking(strip(current.get("non_smoking").toString()));
			result.setOpen(strip(current.get("open").toString()));
			//result.setParking(strip(current.get("parking").toString()));
			//result.setParty_capacity(strip(current.get("party_capacity").toString()));
			result.setPhoto(strip(current.get("photo").get("pc").get("m").toString()));
			//result.setShop_detail_memo(strip(current.get("shop_detail_memo").toString()));
			//result.setShow(strip(current.get("show").toString()));
			//result.setUrl(strip(current.get("urls").get("pc").toString()));
			result.setWifi(strip(current.get("wifi").toString()));
			rdd.add(result);
		}


		return rdd;
	}
	public ArrayList<RestDataDTO> RestDetail(JsonNode shop) {
		ArrayList<RestDataDTO> rdd = new ArrayList<>();


			JsonNode current = shop.get(0);
			RestDataDTO result = new RestDataDTO();
			result.setAddress(strip(current.get("address").toString()));
			result.setCard(strip(current.get("card").toString()));
			result.setCharter(strip(current.get("charter").toString()));
			result.setCourse(strip(current.get("course").toString()));
			result.setFree_drink(strip(current.get("free_drink").toString()));
			result.setGenre(strip(current.get("genre").get("name").toString()));
			result.setHorigotatsu(strip(current.get("horigotatsu").toString()));
			result.setId(strip(current.get("id").toString()));
			result.setLogo_image(strip(current.get("logo_image").toString()));
			result.setMobile_access(strip(current.get("mobile_access").toString()));
			result.setName(strip(current.get("name").toString()));
			result.setNon_smoking(strip(current.get("non_smoking").toString()));
			result.setOpen(strip(current.get("open").toString()));
			result.setParking(strip(current.get("parking").toString()));
			result.setParty_capacity(strip(current.get("party_capacity").toString()));
			result.setPhoto(strip(current.get("photo").get("pc").get("m").toString()));
			result.setShop_detail_memo(strip(current.get("shop_detail_memo").toString()));
			result.setShow(strip(current.get("show").toString()));
			result.setUrl(strip(current.get("urls").get("pc").toString()));
			result.setWifi(strip(current.get("wifi").toString()));
			rdd.add(result);



		return rdd;
	}

	private String strip(String string) {

		return string.substring(1,string.length()-1);

	}



}
