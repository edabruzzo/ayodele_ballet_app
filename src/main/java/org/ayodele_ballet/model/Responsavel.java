package org.ayodele_ballet.model;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Version;

@Entity
public class Responsavel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String nome;

	@Column
	private String endereco_logradouro;

	@Column
	private int endereco_numero;

	@Column
	private String endereco_bairro;

	@Column
	private String endereco_cidade;

	@Column
	private String endereco_estado;

	@Column
	private String endereco_cep;

	@Column
	private String telefone_principal;

	@Column
	private String telefone_recados;

	@Column
	private String telefone_dois;

	@Column
	private String talento_1;

	@Column
	private String talento_2;

	@Column
	private String talento_3;

	@Column
	private boolean possui_pendencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Responsavel)) {
			return false;
		}
		Responsavel other = (Responsavel) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco_logradouro() {
		return endereco_logradouro;
	}

	public void setEndereco_logradouro(String endereco_logradouro) {
		this.endereco_logradouro = endereco_logradouro;
	}

	public int getEndereco_numero() {
		return endereco_numero;
	}

	public void setEndereco_numero(int endereco_numero) {
		this.endereco_numero = endereco_numero;
	}

	public String getEndereco_bairro() {
		return endereco_bairro;
	}

	public void setEndereco_bairro(String endereco_bairro) {
		this.endereco_bairro = endereco_bairro;
	}

	public String getEndereco_cidade() {
		return endereco_cidade;
	}

	public void setEndereco_cidade(String endereco_cidade) {
		this.endereco_cidade = endereco_cidade;
	}

	public String getEndereco_estado() {
		return endereco_estado;
	}

	public void setEndereco_estado(String endereco_estado) {
		this.endereco_estado = endereco_estado;
	}

	public String getEndereco_cep() {
		return endereco_cep;
	}

	public void setEndereco_cep(String endereco_cep) {
		this.endereco_cep = endereco_cep;
	}

	public String getTelefone_principal() {
		return telefone_principal;
	}

	public void setTelefone_principal(String telefone_principal) {
		this.telefone_principal = telefone_principal;
	}

	public String getTelefone_recados() {
		return telefone_recados;
	}

	public void setTelefone_recados(String telefone_recados) {
		this.telefone_recados = telefone_recados;
	}

	public String getTelefone_dois() {
		return telefone_dois;
	}

	public void setTelefone_dois(String telefone_dois) {
		this.telefone_dois = telefone_dois;
	}

	public String getTalento_1() {
		return talento_1;
	}

	public void setTalento_1(String talento_1) {
		this.talento_1 = talento_1;
	}

	public String getTalento_2() {
		return talento_2;
	}

	public void setTalento_2(String talento_2) {
		this.talento_2 = talento_2;
	}

	public String getTalento_3() {
		return talento_3;
	}

	public void setTalento_3(String talento_3) {
		this.talento_3 = talento_3;
	}

	public boolean isPossui_pendencia() {
		return possui_pendencia;
	}

	public void setPossui_pendencia(boolean possui_pendencia) {
		this.possui_pendencia = possui_pendencia;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (nome != null && !nome.trim().isEmpty())
			result += "nome: " + nome;
		if (endereco_logradouro != null
				&& !endereco_logradouro.trim().isEmpty())
			result += ", endereco_logradouro: " + endereco_logradouro;
		if (endereco_bairro != null && !endereco_bairro.trim().isEmpty())
			result += ", endereco_bairro: " + endereco_bairro;
		if (endereco_cidade != null && !endereco_cidade.trim().isEmpty())
			result += ", endereco_cidade: " + endereco_cidade;
		if (endereco_estado != null && !endereco_estado.trim().isEmpty())
			result += ", endereco_estado: " + endereco_estado;
		if (endereco_cep != null && !endereco_cep.trim().isEmpty())
			result += ", endereco_cep: " + endereco_cep;
		if (telefone_principal != null && !telefone_principal.trim().isEmpty())
			result += ", telefone_principal: " + telefone_principal;
		if (telefone_recados != null && !telefone_recados.trim().isEmpty())
			result += ", telefone_recados: " + telefone_recados;
		if (telefone_dois != null && !telefone_dois.trim().isEmpty())
			result += ", telefone_dois: " + telefone_dois;
		if (talento_1 != null && !talento_1.trim().isEmpty())
			result += ", talento_1: " + talento_1;
		if (talento_2 != null && !talento_2.trim().isEmpty())
			result += ", talento_2: " + talento_2;
		if (talento_3 != null && !talento_3.trim().isEmpty())
			result += ", talento_3: " + talento_3;
		result += ", possui_pendencia: " + possui_pendencia;
		return result;
	}
}