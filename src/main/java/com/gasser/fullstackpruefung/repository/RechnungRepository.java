package com.gasser.fullstackpruefung.repository;

import com.gasser.fullstackpruefung.model.Rechnung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RechnungRepository extends JpaRepository<Rechnung, UUID> {
	Page<Rechnung> findById(UUID kundeId, Pageable pageable);
	Optional<Rechnung> findByIdAndKundeId(UUID Id, UUID kundeId);
	Page<Rechnung> findByIdAndKundeId(UUID id, UUID kundeId, Pageable pageable);
}
