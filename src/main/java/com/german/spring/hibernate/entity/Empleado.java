package com.german.spring.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidom")
	private String apellidoM;

	@Column(name = "apellidop")
	private String apellidoP;

	@Column(name = "edad")
	private int edad;

	@Column(name = "sexo")
	private String sexo;

}
