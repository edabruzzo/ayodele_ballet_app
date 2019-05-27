package org.ayodele_ballet.model;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Version;

@Entity
public class Responsavel_Mensalidade implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private int id_responsavel;

	@Column
	private int id_mensalidade;

	@Column
	private boolean pagamento_realizado;

	@Column
	private Date data_pagamento;

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
		if (!(obj instanceof Responsavel_Mensalidade)) {
			return false;
		}
		Responsavel_Mensalidade other = (Responsavel_Mensalidade) obj;
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

	public int getId_responsavel() {
		return id_responsavel;
	}

	public void setId_responsavel(int id_responsavel) {
		this.id_responsavel = id_responsavel;
	}

	public int getId_mensalidade() {
		return id_mensalidade;
	}

	public void setId_mensalidade(int id_mensalidade) {
		this.id_mensalidade = id_mensalidade;
	}

	public boolean isPagamento_realizado() {
		return pagamento_realizado;
	}

	public void setPagamento_realizado(boolean pagamento_realizado) {
		this.pagamento_realizado = pagamento_realizado;
	}

	public Date getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		result += "pagamento_realizado: " + pagamento_realizado;
		return result;
	}
}