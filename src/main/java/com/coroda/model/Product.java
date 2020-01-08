package com.coroda.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Product {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	@NotBlank (message = "no ingresado")
	private String model;

	@NotBlank (message = "no ingresado")
	private String material;

	@NotBlank (message = "no ingresado")
	private String description;

	@NotBlank (message = "no ingresado")
	private String dimensions;

	@NotNull(message = "no ingresado")
	private int cost;

}