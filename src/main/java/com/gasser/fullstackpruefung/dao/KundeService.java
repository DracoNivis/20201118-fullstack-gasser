package com.gasser.fullstackpruefung.dao;

import com.gasser.fullstackpruefung.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KundeService {
	
	private final KundeDao kundeDao;
	
	@Autowired
	public KundeService(KundeDao kundeDao) {
		this.kundeDao = kundeDao;
	}
	
	public int addKunde(Kunde kunde) {
		return kundeDao.insertKunde(kunde);
	}
	
	public List<Kunde> getAllKunden() {
		return kundeDao.selectAllPersons();
	}
	
	public Optional<Kunde> getKundeById(UUID id) {
		return kundeDao.selectKundeById(id);
	}
	
	public int deleteKunde(UUID id) {
		return kundeDao.deleteKundeById(id);
	}
	
	public int updateKunde(UUID id, Kunde newKunde) {
		return kundeDao.updatekunde(id, newKunde);
	}
}
