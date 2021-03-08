package br.com.boavista.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.boavista.model.UsuarioModel;

@Service	
public interface UsuarioService {

	
	public UsuarioModel salvarUsuario(UsuarioModel usuarioModel);
	
	public List<UsuarioModel> consultarUsuario();
	
	public UsuarioModel consultaUsuarioPorId(Long idUsuario);
	
	public void removerUsuario(UsuarioModel usuarioModel);
}
