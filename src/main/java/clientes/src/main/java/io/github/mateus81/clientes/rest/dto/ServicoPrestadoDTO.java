package clientes.src.main.java.io.github.mateus81.clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ServicoPrestadoDTO {
	private String descricao;
	private String preco;
	private String data;
	private Integer idCliente;
}
