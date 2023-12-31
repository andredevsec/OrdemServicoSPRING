package br.edu.ifsuldeminas.mch.webii.crudmanager.model;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id; 
	
	@NotBlank(message = "Endereço não pode ser vazio")
	private String name;
	
	@NotBlank(message = "Email não pode ser vazio")
    @Email(message = "Endereço de Email Invalido")
	private String email;
	
	@NotBlank(message = "Endereço não pode ser vazio")
	private String phone;
	
	public Cliente () {
		
	}

	public Cliente(Integer id, String name, String email, String phone) {
		this.id = id;
		setName("");
		setEmail("");
		setPhone("");
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String gender) {
		this.phone = gender;
	}
	
}
