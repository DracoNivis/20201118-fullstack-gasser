package com.gasser.fullstackpruefung.repository;

import com.gasser.fullstackpruefung.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface KundeRepository extends JpaRepository<Kunde, Long> {
	
	
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
