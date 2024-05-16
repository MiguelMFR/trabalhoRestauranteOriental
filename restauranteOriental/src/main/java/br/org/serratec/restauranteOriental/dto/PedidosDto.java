package br.org.serratec.restauranteOriental.dto;

import br.org.serratec.restauranteOriental.model.Pedido;
import br.org.serratec.restauranteOriental.model.Prato;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record PedidosDto(
		Long idPedido,
		String cliente,
		Prato prato){
		
	public Pedido toEntity() {
		return new Pedido(this.idPedido, this.cliente, this.prato);
	}
}
