package br.com.boavista.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.boavista.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	
	@Query("select usuario from UsuarioModel usuario"
			+ " where usuario.idUsuario = :idUsuario")
	UsuarioModel consultarPorId(Long idUsuario);
}
