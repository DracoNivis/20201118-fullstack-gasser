package com.gasser.fullstackpruefung.dao;

import com.gasser.fullstackpruefung.model.Kunde;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KundeDao {
	
	int insertKunde(UUID id, Kunde kunde);
	
	default int insertKunde(Kunde kunde) {
		UUID id = UUID.randomUUID();
		return insertKunde(id, kunde);
	}
	
	List<Kunde> selectAllKunden();
	
	Optional<Kunde> selectKundeById(UUID id);
	
	int deleteKundeById(UUID id);
	
	int updateKundeById(UUID id, Kunde kunde);

}
