	package br.com.citel.monitor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="VW_MONITOR")
public @Data class Monitor {
	
	@Id
	@Column(name="MON_SEQMON")
	private Long sequencia;
	@Column(name="MON_CODEMP")
	private Long codigoCliente;
	@Column(name="MON_NOMCLI")
	private String nomeCliente;
	@Column(name="MON_CODOPE")
	private Long codigoLider;
	@Column(name="MON_NOMOPE")
	private String nomeLider;
	@Column(name="MON_IDETAR")
	private String identificadorProblema;
	@Column(name="MON_DESTAR")
	private String descricaoProblema;
	@Column(name="MON_HEXCOR")
	private String corProblema;

}