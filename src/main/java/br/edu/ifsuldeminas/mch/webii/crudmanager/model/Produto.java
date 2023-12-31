package br.edu.ifsuldeminas.mch.webii.crudmanager.model;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	
	@NotBlank(message = "Nome não pode ser vazio")
	private String name;
	
	@NotBlank(message = "Marca não pode ser vazio")
	private String marca;
	
	@NotNull(message = "Numero não pode ser vazio")
	private Double valor;
	
	public Produto () {
		
	}
	
	public Produto(Integer id, String name, String marca,Double valor) {
		this.id = id;
		setName("");
		setMarca("");
		this.valor = valor;
	}
	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}	
	
}
