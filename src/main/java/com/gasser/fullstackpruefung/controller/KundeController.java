package com.gasser.fullstackpruefung.controller;

import com.gasser.fullstackpruefung.repository.KundeService;
import com.gasser.fullstackpruefung.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class KundeController {
	
	private KundeService kundeService;
	
	@Autowired
	public KundeController(KundeService kundeService) {
		this.kundeService = kundeService;
	}
	
	@PostMapping("/kunden")
	public void addKunde (@RequestBody Kunde kunde) {
		kundeService.addKunde(kunde);
	}
	
	@GetMapping("/kunden")
	public List<Kunde> getAllKunden() {
		return kundeService.getAllKunden();
	}
	
	@GetMapping("/kunden/{kundeId}")
	public Kunde getKundeById(@PathVariable("kundeId")UUID id) {
		return kundeService.getKundeById(id).orElse(null);
	}
	
	@DeleteMapping("/kunden/{kundeId}")
	public void deleteKunde(@PathVariable("kundeId") UUID id) {
		kundeService.deleteKunde(id);
	}
	
	@PutMapping("/kunden/{kundeId}")
	public void updateKunde(@PathVariable("kundeId") UUID id, @RequestBody Kunde kundeToUpdate) {
		kundeService.updateKunde(id, kundeToUpdate);
	}
}
