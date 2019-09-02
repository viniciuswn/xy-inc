package com.poiapp.poiapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.poiapp.poiapp.models.Poi;

public interface PoiRepository extends CrudRepository<Poi, String>{
	Poi findById(Integer id);
}
