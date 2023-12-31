package br.edu.ifsuldeminas.mch.webii.crudmanager.model;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "ordens")
public class OrdemServico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	
	@ManyToOne
    @NotNull(message = "Cliente não pode ser nulo")
    @Valid
    private Cliente cliente;

    @ManyToOne
    @NotNull(message = "Produto não pode ser nulo")
    @Valid
    private Produto produto;

    @NotBlank(message = "Serviço não pode ser vazio")
    private String servico;
	
	public OrdemServico () {
		
	}
	
	public OrdemServico(Integer id, Cliente cliente, Produto produto, String servico) {
		this.id = id;
		cliente.setName("");
		produto.setName("");
		setServico("");
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public String getServico() {
		return servico;
	}


	public void setServico(String servico) {
		this.servico = servico;
	}
	
	
}


	