package com.gasser.fullstackpruefung.model;


import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "rechnungen")
public class Rechnung {
	
	@Id
	private UUID id;
	
	@NotNull
	@Size(max = 15)
	private String nr; //uuid?
	
	@NotNull
	@Size(max = 10)
	private String datum;
	
	@NotNull
	@Size(max = 20)
	private String betrag;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "kunde_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Kunde kunde;
	
	public Rechnung() {
		this.id = UUID.randomUUID();
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getNr() {
		return nr;
	}
	
	public void setNr(String nr) {
		this.nr = nr;
	}
	
	public String getDatum() {
		return datum;
	}
	
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	public String getBetrag() {
		return betrag;
	}
	
	public void setBetrag(String betrag) {
		this.betrag = betrag;
	}
	
	public Kunde getKunde() {
		return kunde;
	}
	
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
}
