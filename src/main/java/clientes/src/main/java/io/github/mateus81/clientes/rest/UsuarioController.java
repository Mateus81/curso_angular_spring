package clientes.src.main.java.io.github.mateus81.clientes.rest;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import clientes.src.main.java.io.github.mateus81.clientes.exception.UsuarioCadastradoException;
import clientes.src.main.java.io.github.mateus81.clientes.model.entity.Usuario;
import clientes.src.main.java.io.github.mateus81.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody @Valid Usuario usuario) {
		try {
			service.salvar(usuario);
	  } catch (UsuarioCadastradoException ex) {
		  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
	  }
  }
}
