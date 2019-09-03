package com.poiapp.poiapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
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
    public void testSetNome()
    {

        Poi p1 = new Poi();
        p1.setNome("Ponto1");
        assertEquals("Ponto1", p1.getNome());
    }
	
	@Test
    public void testSetPontoX()
    {

        Poi p2 = new Poi();
        p2.setPontoX(20);
        Integer pontoX = 20;
        assertEquals(pontoX, p2.getPontoX());
    }
	
	@Test
    public void testSetPontoY()
    {

        Poi p3 = new Poi();
        p3.setPontoY(10);
        Integer pontoY = 10;
        assertEquals(pontoY, p3.getPontoY());
    }

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
	
	@Test
	public void testCadastraPoi() throws Exception {
		Integer novoId = 10;	
		Poi p = new Poi();
		p.setId(novoId);
		p.setNome("Ponto");
        p.setPontoX(30);
        p.setPontoY(40);
        
        pr.save(p);
        
        
        Iterable<Poi> pois = pr.findAll();
		
		ArrayList<Poi> listaPoi = new ArrayList<>();
		
		for(Poi poi: pois){
						
			if(poi.getNome().equals(p.getNome()) ) {
				
				Assertions.assertThat(poi.getNome()).isEqualTo(p.getNome());
				assertEquals(p.getPontoX(), poi.getPontoX());
				assertEquals(p.getPontoY(), poi.getPontoY());
			}
			
		}              	
	}

	@Test
	public void testDeletaPoi() throws Exception {
			
		Poi p = new Poi();
		p.setId(99);
		p.setNome("Ponto");
        p.setPontoX(30);
        p.setPontoY(40);
        
        pr.delete(p);
        
        Poi poi = pr.findById(p.getId());
        
        assertNull(poi);
	}
	
}

