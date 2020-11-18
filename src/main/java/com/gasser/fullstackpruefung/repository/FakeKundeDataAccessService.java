package com.gasser.fullstackpruefung.repository;

import com.gasser.fullstackpruefung.model.Kunde;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeRepo")
public class FakeKundeDataAccessService implements KundeRepository {
	
	private static List<Kunde> db = new ArrayList<>();
	
	@Override
	public int insertKunde(UUID id, Kunde kunde) {
		db.add(new Kunde(id, kunde.getNachname(), kunde.getVorname()));
		return 1;
	}
	
	@Override
	public List<Kunde> selectAllKunden() {
		return db;
	}
	
	@Override
	public Optional<Kunde> selectKundeById(UUID id) {
		return db.stream()
		.filter(kunde -> kunde.getId().equals(id))
		.findFirst();
	}
	
	@Override
	public int deleteKundeById(UUID id) {
		Optional<Kunde> schroedingersKunde = selectKundeById(id);
		if (schroedingersKunde.isEmpty()) return 0;
		db.remove(schroedingersKunde.get());
		return 1;
	}
	
	@Override
	public int updateKundeById(UUID id, Kunde kunde) {
		return selectKundeById(id).map(k -> {
			int indexOfKundeToDelete = db.indexOf(k);
			if (indexOfKundeToDelete >= 0) {
				db.set(indexOfKundeToDelete, new Kunde(id, kunde.getNachname(), kunde.getVorname()));
				return 1;
			} else return 0;
		}).orElse(0);
	}
}
