package com.gasser.fullstackpruefung.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table("kunden")
public class Kunde {
	
	@Id
	private UUID id;
	
	@NotNull
	@Size(max = 50)
	private String nachname;
	
	@NotNull
	@Size(max = 50)
	private String vorname;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "kunde")
	private Set<Rechnung> rechnungen = new HashSet<>();
	
	
}
