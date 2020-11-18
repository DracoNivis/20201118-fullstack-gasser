package com.gasser.fullstackpruefung.model;


import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "rechnungen")
public class Rechnung {
	
	@Id
	private UUID id;
	
	@NotNull
	private int rechnungsNr; //uuid?
	
	@Column(name = "rechnungsDatum", nullable = false, updatable = false)
	private Date date;
	
	@Column(name = "rechnungsBetrag", nullable = false, updatable = false)
	private long rechnungsBetrag;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "kunde_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Kunde kunde;
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public int getRechnungsNr() {
		return rechnungsNr;
	}
	
	public void setRechnungsNr(int rechnungsNr) {
		this.rechnungsNr = rechnungsNr;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public long getRechnungsBetrag() {
		return rechnungsBetrag;
	}
	
	public void setRechnungsBetrag(long rechnungsBetrag) {
		this.rechnungsBetrag = rechnungsBetrag;
	}
	
	public Kunde getKunde() {
		return kunde;
	}
	
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
}
