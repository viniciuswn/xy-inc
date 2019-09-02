package com.poiapp.poiapp.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poiapp.poiapp.models.Poi;
import com.poiapp.poiapp.repository.PoiRepository;
	

@Controller
public class PoiController {

	@Autowired
	private PoiRepository pr;
	
	@RequestMapping(value="/cadastrarPoi",method=RequestMethod.GET)
	public String form() {
		return "poi/formPoi";
	}
	
	
	@RequestMapping(value="/cadastrarPoi",method=RequestMethod.POST)
	public String form( @Valid Poi poi,  BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Preencha todos os campos!");
			return "redirect:/cadastrarPoi";
		}
		
		pr.save(poi);
		attributes.addFlashAttribute("mensagem", "Ponto de Encontro adicionado com sucesso.");
		return "redirect:/cadastrarPoi";
	}
	
	@RequestMapping("/pois")
	public ModelAndView listaPois() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Poi> pois = pr.findAll();
		mv.addObject("pois", pois);
		return mv;
	}
	
	@RequestMapping("/deletar")
	public String deletarPoi(Integer id,RedirectAttributes attributes) {
		
		Poi poi = pr.findById(id);
		pr.delete(poi);
		attributes.addFlashAttribute("mensagem", "Ponto de Encontro removido com sucesso.");
		
		return "redirect:/pois";
	}
	
	@RequestMapping(value="/distanciaPoi",method=RequestMethod.GET)
	public String formDistancia() {
		return "poi/formDistanciaPoi";
	}
	
	@RequestMapping(value="/distanciaPoi",method=RequestMethod.POST)
	
	public ModelAndView formDistancia(@RequestParam("dMax") Integer dMax,@RequestParam("pontoX") Integer pontoX,@RequestParam("pontoY") Integer pontoY) {
		
		Iterable<Poi> pois = pr.findAll();
		
		ArrayList<Poi> listaPoi = new ArrayList<>();
		
		for(Poi poi: pois){
			double distancia = Math.sqrt(Math.pow(poi.getPontoX() - pontoX, 2) + Math.pow(poi.getPontoY() - pontoY, 2));
			
			if(distancia <= dMax) {
				listaPoi.add(poi);
			}
			
		}
		
		ModelAndView mv = new ModelAndView("poi/distanciaPoiResult");
		mv.addObject("listaPoi", listaPoi);
		return mv;
	}
	
	

}
