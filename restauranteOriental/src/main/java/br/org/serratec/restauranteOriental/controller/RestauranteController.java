package br.org.serratec.restauranteOriental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.restauranteOriental.dto.PedidosDto;
import br.org.serratec.restauranteOriental.model.Pedido;
import br.org.serratec.restauranteOriental.service.PedidoService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@Autowired
	private PedidoService servico;
	
	@GetMapping
	public ResponseEntity<List<PedidosDto>> listarPedidos(){
		return ResponseEntity.ok(servico.listarTodosPedidos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidosDto> obterPorId(@PathVariable Long id){
		Optional<PedidosDto> pedido = servico.mostrarPedidoPorId(id);
		
		if(pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
		}
		return ResponseEntity.notFound().build();	
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public PedidosDto fazerPedido(@RequestBody PedidosDto pedido) {
		return servico.salvarPedido(pedido);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PedidosDto> atualizarPedido(@PathVariable Long id,@RequestBody PedidosDto pedidoAlterado ) {
		Optional<PedidosDto> pedido = servico.atualizarPedido(id, pedidoAlterado);
		
		if(pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
		}
		return ResponseEntity.notFound().build();	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
		if(servico.excluirPedido(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/cliente")
	public ResponseEntity<List<PedidosDto>> obterClientePorNome(@RequestBody String nome){
		return ResponseEntity.ok(servico.ObterClienteNome(nome));
	}
	
	
	
	
	
}
