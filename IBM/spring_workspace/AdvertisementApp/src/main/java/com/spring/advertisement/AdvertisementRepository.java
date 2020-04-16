package com.spring.advertisement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AdvertisementRepository extends CrudRepository<AdvertisementEntity,Long>{
	List<AdvertisementEntity> findByAdvId(long advId);
	//List<AdvertisementEntity> findByUserId(long userId);
}
