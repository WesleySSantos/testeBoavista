package br.com.boavista.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.boavista.model.UsuarioModel;
import br.com.boavista.repository.UsuarioRepository;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private static Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Override
	public UsuarioModel salvarUsuario(UsuarioModel usuarioModel) {

		UsuarioModel usuarioRetono = null;
		try {
			if (usuarioModel != null) {

				usuarioRetono = usuarioRepository.save(usuarioModel);

				logger.info("Usuario cadastrado com sucesso!!!");
			}
		} catch (Exception e) {
			logger.info("Usuario não pode ser cadastro");
		}

		return usuarioRetono;
	}

	@Override
	public List<UsuarioModel> consultarUsuario() {

		List<UsuarioModel> retornoUsuario = usuarioRepository.findAll();

		try {
			if (retornoUsuario != null) {
				logger.info("Usuario encontrado");
				return retornoUsuario;
			}
		} catch (Exception e) {
			logger.info("Usuario não encontrado");
		}

		return retornoUsuario;
	}

	@Override
	public UsuarioModel consultaUsuarioPorId(Long idUsuario) {
		UsuarioModel retornoPorId = null;

		if (idUsuario == null) {

			logger.info("Id não encontrado ou nulo");
		}

		retornoPorId = usuarioRepository.consultarPorId(idUsuario);

		logger.info("Usuario Encontrado!!");

		return retornoPorId;
	}

	@Override
	public void removerUsuario(UsuarioModel usuarioModel) {

		UsuarioModel retornoPorId = usuarioRepository.consultarPorId(usuarioModel.getIdUsuario());

		if (retornoPorId != null) {

			usuarioRepository.delete(usuarioModel);
			logger.info("Usuario deletado com sucesso");
		}
		else {
			logger.info("Erro ao deletar Usuario");
		}
		
	}

}
