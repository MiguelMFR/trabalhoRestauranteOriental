package br.org.serratec.restauranteOriental.dto;

import br.org.serratec.restauranteOriental.model.Pedido;
import br.org.serratec.restauranteOriental.model.Prato;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidosDto(
		Long idPedido,
		@NotBlank(message = "O nome deverá ser preenchido!")
		String cliente,
		@NotNull(message = "O gênero não pode ser nulo.")
		Prato prato){
		
	public Pedido toEntity() {
		return new Pedido(this.idPedido, this.cliente, this.prato);
	}
}
