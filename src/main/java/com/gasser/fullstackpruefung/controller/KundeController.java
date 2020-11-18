package com.gasser.fullstackpruefung.controller;

import com.gasser.fullstackpruefung.model.Kunde;
import com.gasser.fullstackpruefung.repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class KundeController {
	
	@Autowired
	private KundeRepository kundeRepository;
	
	@GetMapping("/kunden")
	public Page<Kunde> getAllKunden(Pageable pageable) {
		return kundeRepository.findAll(pageable);
	}
	
	@PostMapping("/kunden")
	public Kunde addKunde(@RequestBody Kunde kunde) {
		return kundeRepository.save(kunde);
	}
	
	@PutMapping("/kunden/{kundenId}")
	public Kunde updateKunde(@PathVariable(value = "kundenId") Long kundenId, @RequestBody Kunde newKunde) {
		return kundeRepository.findById(kundenId).map(kunde -> {
			kunde.setNachname(newKunde.getNachname());
			kunde.setVorname(newKunde.getVorname());
			return kundeRepository.save(kunde);
		}).orElse(null);
	}
	
	@DeleteMapping("/kunden/{kundenId}")
	public ResponseEntity<?> deleteKunde(@PathVariable(value = "kundenId") Long kundenId) {
		return kundeRepository.findById(kundenId).map(kunde -> {
			kundeRepository.delete(kunde);
			return ResponseEntity.ok().build();
		}).orElse(null);
	}
	
}
