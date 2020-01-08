package com.coroda.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
//Create  table
@Data
@Entity
@Table(name = "Producto")


public class Product {

	//Atributes
	//	primary key
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	@Column(name = "nombre")
	@NotBlank (message = "no ingresado")
	private String nombre;

	@Column(name = "material")
	@NotBlank (message = "no ingresado")
	private String material;

	@Column(name = "costo")
	@NotNull(message = "no ingresado")
	private int costo;


}