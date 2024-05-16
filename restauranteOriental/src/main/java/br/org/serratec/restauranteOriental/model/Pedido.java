package br.org.serratec.restauranteOriental.model;

import br.org.serratec.restauranteOriental.dto.PedidosDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	private String cliente;
	@Enumerated(EnumType.STRING)
	private Prato prato;
	
	public Pedido() {
	}
	

	
	public Pedido(Long idPedido, String cliente, Prato prato) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.prato = prato;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Prato getPrato() {
		return prato;
	}
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	
	public PedidosDto toDto() {
        return new PedidosDto(this.idPedido, this.cliente, this.prato);
    }
	
	

}
