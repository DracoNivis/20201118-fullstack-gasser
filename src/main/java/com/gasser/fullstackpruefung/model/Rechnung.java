package com.gasser.fullstackpruefung.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
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
	
	public Rechnung() {
	}
	
	public Rechnung(@JsonProperty("id") UUID id, @JsonProperty("rechnungsNr") int rechnungsNr, @JsonProperty("date") Date date, @JsonProperty("rechnungsBetrag") long rechnungsBetrag) {
		this.id = id;
		this.rechnungsNr = rechnungsNr;
		this.date = date;
		this.rechnungsBetrag = rechnungsBetrag;
	}
	
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
}
