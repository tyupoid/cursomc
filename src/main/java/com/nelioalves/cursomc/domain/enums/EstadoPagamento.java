package com.nelioalves.cursomc.domain.enums;

public enum EstadoPagamento {
	PENDENTE(0, "pendente"), QUITADO(1, "quitado"), CANCELADO(2, "cancelado");

	private Integer cod;
	private String descricao;

	private EstadoPagamento(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (EstadoPagamento estadoPagamento : EstadoPagamento.values()) {
			if (cod.equals(estadoPagamento.getCod())) {
				return estadoPagamento;
			}
		}
		throw new IllegalArgumentException("id invalido:  " + cod);
	}

}
