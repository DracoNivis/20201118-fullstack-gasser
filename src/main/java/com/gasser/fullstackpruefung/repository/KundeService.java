package com.gasser.fullstackpruefung.repository;

import com.gasser.fullstackpruefung.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KundeService {
	
	private final KundeRepository kundeRepository;
	
	@Autowired
	public KundeService(KundeRepository kundeRepository) {
		this.kundeRepository = kundeRepository;
	}
	
	public int addKunde(Kunde kunde) {
		return kundeRepository.insertKunde(kunde);
	}
	
	public List<Kunde> getAllKunden() {
		return kundeRepository.selectAllKunden();
	}
	
	public Optional<Kunde> getKundeById(UUID id) {
		return kundeRepository.selectKundeById(id);
	}
	
	public int deleteKunde(UUID id) {
		return kundeRepository.deleteKundeById(id);
	}
	
	public int updateKunde(UUID id, Kunde newKunde) {
		return kundeRepository.updateKundeById(id, newKunde);
	}
}
