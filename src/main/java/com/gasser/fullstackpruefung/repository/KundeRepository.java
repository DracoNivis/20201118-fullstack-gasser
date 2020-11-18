package com.gasser.fullstackpruefung.repository;

import com.gasser.fullstackpruefung.model.Kunde;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface KundeRepository extends JpaRepository<Kunde, UUID> {
	Page<Kunde> findById(UUID id, Pageable pageable);
}
