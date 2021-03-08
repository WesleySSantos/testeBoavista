package br.com.boavista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.boavista.model.UsuarioModel;
import br.com.boavista.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Poc para teste")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	
	@RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
	@ApiOperation(value = "Salva o Usuario")
	public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody UsuarioModel usuarioModel) {

		UsuarioModel retornoSave = usuarioService.salvarUsuario(usuarioModel);

		if (retornoSave != null) {

			return new ResponseEntity<UsuarioModel>(HttpStatus.OK);
		}

		return new ResponseEntity<UsuarioModel>(HttpStatus.BAD_REQUEST);
	}

}
