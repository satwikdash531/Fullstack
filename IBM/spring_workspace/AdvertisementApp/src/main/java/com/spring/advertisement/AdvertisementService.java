package com.spring.advertisement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdvertisementService {
	
	@Autowired
	private AdvertisementRepository advertisementRepository;
	
	public void postNewAd(AdvertisementEntity advertisement) {
		advertisementRepository.save(advertisement);
	}
	
	public AdvertisementEntity updateAd(AdvertisementEntity advertisement,long advId) {
		AdvertisementEntity advertisementEntity = advertisementRepository.findByAdvId(Long.valueOf(advId)).get(0);
		if(advertisementEntity != null) 
		{
			advertisementEntity.setPostId(advertisement.getPostId());
			advertisementEntity.setName(advertisement.getName());
			advertisementEntity.setDescription(advertisement.getDescription());
			advertisementEntity.setCategory(advertisement.getCategory());
			advertisementEntity.setStatus(advertisement.getStatus());
			advertisementEntity.setTitle(advertisement.getTitle());
			advertisementEntity = advertisementRepository.save(advertisementEntity);
			return advertisementEntity;
		}
		return null;
	}
	
	/*public List<AdvertisementEntity> getAdvByUser(long userId) {
		List<AdvertisementEntity> advertisementEntityList = new ArrayList<AdvertisementEntity>();
		advertisementRepository.findByUserId(userId).forEach(advertisementEntityList::add);
		return advertisementEntityList;
	}*/
}
