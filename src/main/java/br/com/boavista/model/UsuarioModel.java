package br.com.boavista.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel  implements Serializable{

	private static final long serialVersionUID = 7150295336574478739L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(name = "nome_usuario")
	private String nomeUsuario;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "rg")
	private String rg;
	
	@Column(name = "telefone")
	private String Telefone;
}
