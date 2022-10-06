package clientes.src.main.java.io.github.mateus81.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clientes.src.main.java.io.github.mateus81.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
