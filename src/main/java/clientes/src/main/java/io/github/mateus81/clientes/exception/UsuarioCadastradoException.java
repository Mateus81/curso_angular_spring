package clientes.src.main.java.io.github.mateus81.clientes.exception;

public class UsuarioCadastradoException extends RuntimeException {

	public UsuarioCadastradoException(String login) {
		super("Usuário já cadastrado para o login." + login);
	}
}
