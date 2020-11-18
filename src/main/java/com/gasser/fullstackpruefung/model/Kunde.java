package com.gasser.fullstackpruefung.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "kunden")
public class Kunde {
	
	@Id
	private UUID id;
	
	@NotNull
	@Size(max = 50)
	private String nachname;
	
	@NotNull
	@Size(max = 50)
	private String vorname;
	
	public Kunde(@Size(max = 50) String nachname, @Size(max = 50) String vorname) {
		this.id = id;
		this.nachname = nachname;
		this.vorname = vorname;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}
