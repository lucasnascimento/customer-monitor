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
	@Column(name="RLJ_CODEMP")
	private Long codigoCliente;
	@Column(name="CLI_NOMCLI")
	private String nomeCliente;

	private transient Long codigoLider = 0l;
	
	@Column(name="OPE_NOMOPE")
	private String nomeLider;
	
	@Column(name="TAR_DESTAR")
	private String descricaoProblema;

	private transient String identificadorProblema = "HD";
	
	private transient String corProblema = "FF00FF";

}