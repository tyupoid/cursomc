package com.nelioalves.cursomc.domain.enums;

public enum TipoCliente {
	PessoaFisica(0, "Pessoa Fisica"), PessoaJuridica(1, "Pessoa Juridica");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (TipoCliente tipoCliente : TipoCliente.values()) {
			if (codigo.equals(tipoCliente.getCod())) {
				return tipoCliente;
			}
		}
		
		throw new IllegalArgumentException("id invalido:  "+ codigo);
	}

}
