package com.spring.advertisement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class AdvertisementController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	//Q-5
	@PostMapping(value="/user/{userId}/advertise", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void postNewAd(@RequestBody AdvertisementEntity advertisement) {
		advertisementService.postNewAd(advertisement);
	}
	
	//Q-6
	@PutMapping(value="/user/advertise/{advId}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AdvertisementEntity updateAd(@RequestBody AdvertisementEntity advertisement, @PathVariable(value="advId") long advId) {
		return advertisementService.updateAd(advertisement,advId);
	}
	
	//Q-7
	/*@GetMapping(value="/user/{userId}/advertise")
	public List<AdvertisementEntity> getAdvByUser(@PathVariable(value="userId") long userId) {
		return advertisementService.getAdvByUser(userId);
	}*/
	
}
