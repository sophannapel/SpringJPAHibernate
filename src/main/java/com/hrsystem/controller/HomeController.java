package com.hrsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class HomeController {

	@RequestMapping({"/map"})
	public String showHome(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyC2k6TNrIQALpZq7dxzi4t0Pjj3ebgOhgQ";
		String list = restTemplate.getForObject(url, String.class);
		System.out.println(list.toString());
		model.addAttribute("map", list);
		return "map01";
	}
}
