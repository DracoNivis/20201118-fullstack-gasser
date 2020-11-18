package com.gasser.fullstackpruefung.controller;

import com.gasser.fullstackpruefung.dao.KundeDao;
import com.gasser.fullstackpruefung.dao.KundeService;
import com.gasser.fullstackpruefung.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/kunde")
public class KundeController {
	
	private KundeService kundeService;
	
	@Autowired
	public KundeController(KundeService kundeService) {
		this.kundeService = kundeService;
	}
	
	@PostMapping
	public void addKunde (@RequestBody Kunde kunde) {
		kundeService.addKunde(kunde);
	}
	
	@GetMapping
	public List<Kunde> getAllKunden() {
		return kundeService.getAllKunden();
	}
	
	@GetMapping(path = "{id}")
	public Kunde getKundeById(@PathVariable("id")UUID id) {
		return kundeService.getKundeById(id).orElse(null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteKunde(@PathVariable("id") UUID id) {
		kundeService.deleteKunde(id);
	}
	
	@PutMapping(path = "{id}")
	public void updateKunde(@PathVariable("id") UUID id, @RequestBody Kunde kundeToUpdate) {
		kundeService.updateKunde(id, kundeToUpdate);
	}
}
