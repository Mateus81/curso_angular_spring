package clientes.src.main.java.io.github.mateus81.clientes.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import clientes.src.main.java.io.github.mateus81.clientes.model.entity.ServicoPrestado;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
    @Query(" select s from ServicoPrestado s join s.cliente c where.upper( c.nome )"
    		+ " like upper( :nome ) and  FUNCTION('MONTH',c.dataCadastro)= :mes ")
	List<ServicoPrestado> findbyNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);

}
