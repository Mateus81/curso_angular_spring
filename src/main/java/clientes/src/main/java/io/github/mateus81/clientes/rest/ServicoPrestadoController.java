package clientes.src.main.java.io.github.mateus81.clientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import clientes.src.main.java.io.github.mateus81.clientes.model.entity.Cliente;
import clientes.src.main.java.io.github.mateus81.clientes.model.entity.ServicoPrestado;
import clientes.src.main.java.io.github.mateus81.clientes.model.repository.ClienteRepository;
import clientes.src.main.java.io.github.mateus81.clientes.model.repository.ServicoPrestadoRepository;
import clientes.src.main.java.io.github.mateus81.clientes.rest.dto.ServicoPrestadoDTO;
import clientes.src.main.java.io.github.mateus81.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository repository;
	private final BigDecimalConverter bigDecimalConverter;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto) {
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idCliente = dto.getIdCliente();
		
		Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "Cliente Inexistente."));
				
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setData( data );
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
		
		return repository.save(servicoPrestado);
	}
	
	@GetMapping
	public List<ServicoPrestado> pesquisar(
		@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
		@RequestParam(value = "mes", required = false) Integer mes
	){
		return repository.findbyNomeClienteAndMes("%" + nome + "%", mes);
	}
}
