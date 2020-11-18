package com.gasser.fullstackpruefung.controller;

import com.gasser.fullstackpruefung.repository.KundeRepository;
import com.gasser.fullstackpruefung.repository.RechnungRepository;
import com.gasser.fullstackpruefung.model.Rechnung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RechnungController {
	
	@Autowired
	private RechnungRepository rechnungRepository;
	
	@Autowired
	private KundeRepository kundeRepository;
	
	@GetMapping("/kunden/{kundenId}/rechnungen")
	public Page<Rechnung> getAllRechnungenByKunde(@PathVariable(value = "kundenId") UUID kundeId, Pageable pageable) {
		return rechnungRepository.findById(kundeId, pageable);
	}
	
	@GetMapping("/kunden/{kundenId}/rechnungen/{rechnungId}")
	public Page<Rechnung> getRechnungByKundeAndId(@PathVariable(value = "kundenId") UUID kundeId, @PathVariable(value = "rechnungId") UUID id, Pageable pageable) {
		return rechnungRepository.findByIdAndKundeId(id, kundeId, pageable);
	}
	
	@PostMapping("/kunden/{kundenId}/rechnungen")
	public Rechnung addRechnung(@PathVariable(value = "kundenId") UUID kundeId, @RequestBody Rechnung rechnung) {
		return kundeRepository.findById(kundeId).map(kunde -> {
			rechnung.setKunde(kunde);
			return rechnungRepository.save(rechnung);
		}).orElse(null);
	}
	
	@PutMapping("/kunden/{kundenId}/rechnungen/{rechnungId")
	public ResponseEntity<?> updateRechnung(@PathVariable(value = "kundenId") UUID kundeId,
	                                        @PathVariable(value = "rechnungId") UUID rechnungId,
	                                        @RequestBody Rechnung newRechnung) {
		return rechnungRepository.findById(rechnungId).map(rechnung -> {
			rechnung.setId(newRechnung.getId());
			rechnung.setKunde(newRechnung.getKunde());
			rechnung.setDatum(newRechnung.getDatum());
			rechnung.setNr(newRechnung.getNr());
			rechnung.setBetrag(newRechnung.getBetrag());
			return ResponseEntity.ok().build();
		}).orElse(null);
	}
	
	@DeleteMapping("/kunden/{kundenId}/rechnungen/{rechnungId")
	public ResponseEntity<?> deleteRechnung(@PathVariable(value = "kundenId") UUID kundeId,
	                                     @PathVariable(value = "rechnungId") UUID rechnungId) {
		return rechnungRepository.findByIdAndKundeId(rechnungId, kundeId).map(rechnung -> {
			rechnungRepository.delete(rechnung);
			return ResponseEntity.ok().build();
		}).orElse(null);
	}
}
