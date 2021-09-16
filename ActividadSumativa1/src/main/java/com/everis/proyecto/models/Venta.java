package com.everis.proyecto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //representacion de entidad modelo
@Table(name="ventas") 
public class Venta {
	@Id // clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //para auto incrementar
	private Long id;
	
	private String producto;
	private Integer cantidad;
	private String comentario;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Venta() {
		super();
	}

	public Venta(String producto, Integer cantidad, String comentario) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.comentario = comentario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@PrePersist //se ejecuta antes de que sea insertado el objeto
	protected void onCreate(){
	this.createdAt = new Date();
	}
	@PreUpdate // se ejecuta antes de ser actualizado
	protected void onUpdate(){
	this.updatedAt = new Date();
	}
	
	
}
