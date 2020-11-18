package com.gasser.fullstackpruefung.controller;

import com.gasser.fullstackpruefung.repository.KundeRepository;
import com.gasser.fullstackpruefung.repository.RechnungRepository;
import com.gasser.fullstackpruefung.model.Rechnung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RechnungController {
	
	@Autowired
	private RechnungRepository rechnungRepository;
	
	@Autowired
	private KundeRepository kundeRepository;
	
	@GetMapping("/kunden/{kundeId}/rechnungen")
	public Page<Rechnung> getAllRechnungenByKunde(@PathVariable(value = "kundeId") Long kundeId, Pageable pageable) {
		return rechnungRepository.findById(kundeId, pageable);
	}
	
	@PostMapping("/kunden/{kundeId}/rechnungen")
	public Rechnung addRechnung(@PathVariable(value = "kundeId") Long kundeId, @RequestBody Rechnung rechnung) {
		return kundeRepository.findById(kundeId).map(kunde -> {
			rechnung.setKunde(kunde);
			return rechnungRepository.save(rechnung);
		}).orElse(null);
	}
	
	@DeleteMapping("/kunden/{kundeId}/rechnungen/{rechnungId")
	public ResponseEntity<?> deleteRechnung(@PathVariable(value = "kundeId") Long kundeId,
	                                     @PathVariable(value = "rechnungId") Long rechnungId) {
		return rechnungRepository.findByIdAndKundeId(rechnungId, kundeId).map(rechnung -> {
			rechnungRepository.delete(rechnung);
			return ResponseEntity.ok().build();
		}).orElse(null);
	}
}
