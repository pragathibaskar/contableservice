package com.cg.adif.modal.contable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Contable {
	@Id
	@NotNull
	@Column(name="periodo_certificacion")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date periodo_certificacion;
	
	@Column(name="fecha_cierre")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date fecha_cierre;
	
	@Transient
	private long tstamp;
	
	
	public long getTstamp() {
		return periodo_certificacion.getTime();
	}
	public void setTstamp(long tstamp) {
		this.tstamp = tstamp;
	}
	public Date getPeriodo_certificacion() {
		return periodo_certificacion;
	}
	public void setPeriodo_certificacion(Date periodo_certificacion) {
		this.periodo_certificacion = periodo_certificacion;
	}
	public Date getFecha_cierre() {
		return fecha_cierre;
	}
	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

}
