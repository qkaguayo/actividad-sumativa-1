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
@Table(name="productos")
public class Producto {
	@Id // clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //para auto incrementar
	private Long id;
	
	private String nombre;
	private Integer cantidad;
	private String descripcion;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Producto() {
		super();
	}
	
	public Producto(String nombre, Integer cantidad, String descripcion) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
