package br.com.boavista;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.boavista.model.UsuarioModel;
import br.com.boavista.service.UsuarioService;

@SpringBootTest
public class UsuarioTest {

	@Autowired
	UsuarioService usuarioService;

	@Test
	public void salvarUsuario() {

		UsuarioModel usuario = new UsuarioModel();

		usuario.setCpf("394.854.985-11");
		usuario.setEndereco("Rua 999");
		usuario.setNomeUsuario("Julia F Moraes");
		usuario.setRg("32.985.555-5");
		usuario.setTelefone("(11) 99856-6589");

		UsuarioModel retornoSave = usuarioService.salvarUsuario(usuario);

		assertNotNull(retornoSave);
	}

	@Test
	public void consultarUsuario() {

		List<UsuarioModel> listaUsuarios = usuarioService.consultarUsuario();

		assertNotNull(listaUsuarios);
	}

	@Test
	public void consultarPorId() {

		UsuarioModel usuario = new UsuarioModel();

		usuario.setIdUsuario(1l);

		UsuarioModel retornoConsulta = usuarioService.consultaUsuarioPorId(usuario.getIdUsuario());

		assertNotNull(retornoConsulta);

	}

	@Test
	public void removerUsuario() {

		UsuarioModel usuario = new UsuarioModel();
		usuario.setIdUsuario(3l);
		usuario.setCpf("394.854.985-11");
		usuario.setEndereco("Rua 999");
		usuario.setNomeUsuario("Julia F Moraes");
		usuario.setRg("32.985.555-5");
		usuario.setTelefone("(11) 99856-6589");

		usuarioService.removerUsuario(usuario);

	}
}
