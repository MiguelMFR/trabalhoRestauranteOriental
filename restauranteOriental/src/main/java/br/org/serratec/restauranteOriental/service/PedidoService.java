package br.org.serratec.restauranteOriental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.org.serratec.restauranteOriental.dto.PedidosDto;
import br.org.serratec.restauranteOriental.model.Pedido;
import br.org.serratec.restauranteOriental.repository.PedidoRepository;



@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repositorio;
	
	public List<PedidosDto> listarTodosPedidos(){
		return repositorio.findAll().stream()
				.map(c -> new PedidosDto(c.getIdPedido(), c.getCliente(), c.getPrato()))
				.toList();
	}
	
	public Optional<PedidosDto> mostrarPedidoPorId(Long id){
		Optional<Pedido> pedido = repositorio.findById(id);
		if (pedido.isPresent()) {
			return Optional.of(pedido.get().toDto());
		}
		return Optional.empty();
	}
	
	public PedidosDto salvarPedido(PedidosDto pedido) {
		Pedido pedidoEntity = repositorio.save(pedido.toEntity());
		return pedidoEntity.toDto();
	}
	
	public Optional<PedidosDto> atualizarPedido(Long id, PedidosDto pedido) {
		Pedido entPedido = pedido.toEntity();
		if (repositorio.existsById(id)) {
			entPedido.setIdPedido(id);;;
			repositorio.save(entPedido);
			return Optional.of(entPedido.toDto());
		} 
		return Optional.empty();
	}
	
	public boolean excluirPedido(Long id) {
        if(repositorio.existsById(id)){
            return true;
        }

        repositorio.deleteById(id);
        return false;
    }
	
	public List<PedidosDto> ObterClienteNome(String nome){
		return repositorio.findByClienteLike(nome).stream()
				.map(c -> new PedidosDto(c.getIdPedido(), c.getCliente(), c.getPrato()))
				.toList();
	}
	
}
