package com.poiapp.poiapp;

import static org.junit.Assert.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.poiapp.poiapp.models.Poi;
import com.poiapp.poiapp.repository.PoiRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "/sql/insert-poi.sql")
public class PoiappApplicationTests {

	@Autowired
	private PoiRepository pr;
	
	@Test
	public void testBuscaPorId() throws Exception {
		
		Poi poi = pr.findById(1);
		
		Integer id = 1;
		Integer pontoX = 27;
		Integer pontoY = 12;
		
		Assertions.assertThat(poi.getId()).isNotNull();
		assertEquals(id, poi.getId());
		Assertions.assertThat(poi.getNome()).isEqualTo("Lanchonete");
		assertEquals(pontoX, poi.getPontoX());
		assertEquals(pontoY, poi.getPontoY());
		
		poi = pr.findById(5);
		
		id = 5;
		pontoX = 12;
		pontoY = 8;
		
		Assertions.assertThat(poi.getId()).isNotNull();
		assertEquals(id, poi.getId());
		Assertions.assertThat(poi.getNome()).isEqualTo("Pub");
		assertEquals(pontoX, poi.getPontoX());
		assertEquals(pontoY, poi.getPontoY());
				
		
	}
	

	
	

}
