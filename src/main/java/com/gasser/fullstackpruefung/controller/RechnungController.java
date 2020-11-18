package com.gasser.fullstackpruefung.controller;

import com.gasser.fullstackpruefung.repository.KundeRepository;
import com.gasser.fullstackpruefung.repository.KundeService;
import com.gasser.fullstackpruefung.repository.RechnungRepository;
import com.gasser.fullstackpruefung.repository.RechnungService;
import com.gasser.fullstackpruefung.model.Rechnung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RechnungController {
	
	@Autowired
	private RechnungRepository rechnungRepository;
	
	@Autowired
	private KundeRepository kundeRepository;
	
	@GetMapping("/kunden/{kundeId}/rechnungen")
	public Page<Rechnung> getAllRechnungenByKunde(@PathVariable(value = "kundeId") Long kundeId, Pageable pageable) {
		return rechnungRepository.findByRechnungId(kundeId, pageable);
	}
	
	@PostMapping("/kunden/{kundeId}/rechnungen")
	public void addRechnung(@PathVariable(value = "kundeId") Long kundeId, @RequestBody Rechnung rechnung) {
		return rechnungRepository.findById(kundeId).map(kunde -> {
			rechnung.setKunde(kunde);
		});
	}
	
	@DeleteMapping()
	
	@GetMapping("/rechnungen/{kundeId}/rechnungen")
	public List<Rechnung> getAllRechnungen() {
		return rechnungService.getAllRechnungen();
	}
	
	@GetMapping("/rechnungen/{id}")
	
}
