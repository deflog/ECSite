package com.example.demo.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.MyForm;
import com.example.demo.dto.RestDataDTO;
import com.example.demo.service.GetSampleService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping
public class FormController {
	@Autowired
	GetSampleService gss;


	@RequestMapping(value = "/Form",method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute(new MyForm());
		return "Form";
	}



	@RequestMapping(value = "/Formresult",method = RequestMethod.GET)
	public String submit(Model model,@RequestParam String selectedValue,@RequestParam String count,@RequestParam String selectedSA) throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		boolean bl = false;
		boolean ch = false;
		if(Integer.parseInt(count)>10) {
			bl=true;

		}

		model.addAttribute("selectedSA",selectedSA);
		model.addAttribute("count",count);
		model.addAttribute("bl",bl);
		model.addAttribute("selectedValue",selectedValue);

		String resultsnum = gss.resultNumber(gss.resultnum(gss.service(selectedValue, count, selectedSA)));
		if(Integer.parseInt(resultsnum) ==0) {
			return "error";
		}
		if(Integer.parseInt(count)<Integer.parseInt(resultsnum)) {
			ch=true;
		}
		model.addAttribute("ch",ch);
		ArrayList<RestDataDTO> rdd = gss.restMapping(gss.jsonservice(gss.service(selectedValue,count,selectedSA)));
		model.addAttribute("result",rdd);

		return "Formresult";
	}
	@RequestMapping(value = "/Resultdetail",method = RequestMethod.GET)
	public String Resultdetail(@RequestParam String id,@RequestParam String selectedValue,@RequestParam String selectedSA,Model model) throws JsonParseException, JsonMappingException, IOException{
		model.addAttribute("selectedValue",selectedValue);
		model.addAttribute("selectedSA",selectedSA);
		model.addAttribute("result",gss.RestDetail(gss.jsonservice(gss.Idservice(id))));

		return "Resultdetail";
	}


}
