package com.poiapp.poiapp.resources;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.poiapp.poiapp.models.Poi;
import com.poiapp.poiapp.repository.PoiRepository;

@RestController
@RequestMapping("/poi")

public class PoiResources {
	@Autowired
	private PoiRepository pr;
	
	
	@GetMapping(value="/listaTodos",produces="application/json")
	public @ResponseBody  Iterable<Poi> listaPois(){
		Iterable<Poi> listaPois = pr.findAll();		
		return listaPois;
	}
	
	
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Poi poi(@PathVariable(value="id") Integer id){
		Poi poi = pr.findById(id);
		return poi;
	}
	
	
	@PostMapping()
	public Poi cadastraPoi(@RequestBody @Valid Poi poi){
		pr.save(poi);
		return poi;
	}
	
	
	@DeleteMapping(value="/remove/{id}",produces="application/json")
	public Iterable<Poi> deletaPoi(@PathVariable(value="id") Integer id){
		Poi poi = pr.findById(id);
		pr.delete(poi);
		Iterable<Poi> listaPois = pr.findAll();		
		return listaPois;
	}
	
	@GetMapping
	public ArrayList<Poi> calculaDistancia(@RequestParam(value="pontoX") Integer pontoX,@RequestParam(value="pontoY") Integer pontoY,@RequestParam(value="dMax") Integer dMax) {
		
		Iterable<Poi> pois = pr.findAll();
		
		ArrayList<Poi> listaPoi = new ArrayList<>();
		
		for(Poi poi: pois){
			double distancia = Math.sqrt(Math.pow(poi.getPontoX() - pontoX, 2) + Math.pow(poi.getPontoY() - pontoY, 2));
			
			if(distancia <= dMax) {
				listaPoi.add(poi);
			}
			
		}
		
		return listaPoi;
	}
	
	
}
