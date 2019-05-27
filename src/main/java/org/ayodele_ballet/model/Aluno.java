package org.ayodele_ballet.model;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Version;

@Entity
public class Aluno implements Serializable {

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
	private int idade;

	@Column
	private char sexo;

	@Column
	private String local_aula;

	@Column
	private String nivel;
        
        
        Responsavel responsavel;

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
        
        

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
		if (!(obj instanceof Aluno)) {
			return false;
		}
		Aluno other = (Aluno) obj;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	
	public String getLocal_aula() {
		return local_aula;
	}

	public void setLocal_aula(String local_aula) {
		this.local_aula = local_aula;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (nome != null && !nome.trim().isEmpty())
			result += "nome: " + nome;
		result += ", sexo: " + sexo;
		if (responsavel.getNome() != null && !responsavel.getNome().trim().isEmpty())
			result += ", nome_responsavel: " + responsavel.getNome();
		if (local_aula != null && !local_aula.trim().isEmpty())
			result += ", local_aula: " + local_aula;
		if (nivel != null && !nivel.trim().isEmpty())
			result += ", nivel: " + nivel;
		return result;
	}
}