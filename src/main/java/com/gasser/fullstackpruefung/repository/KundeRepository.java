package com.gasser.fullstackpruefung.repository;

import com.gasser.fullstackpruefung.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KundeRepository extends JpaRepository<Kunde, Long> {
}
