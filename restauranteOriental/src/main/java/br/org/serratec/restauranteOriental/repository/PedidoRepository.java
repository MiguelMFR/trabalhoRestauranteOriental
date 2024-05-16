package br.org.serratec.restauranteOriental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.restauranteOriental.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	List<Pedido> findByClienteLike(String nome);
}
