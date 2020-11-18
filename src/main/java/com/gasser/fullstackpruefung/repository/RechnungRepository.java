package com.gasser.fullstackpruefung.repository;

import com.gasser.fullstackpruefung.model.Rechnung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RechnungRepository extends JpaRepository<Rechnung, Long> {
	Page<Rechnung> findById(Long kundeId, Pageable pageable);
	Optional<Rechnung> findByIdAndKundeId(Long Id, Long kundeId);
}
