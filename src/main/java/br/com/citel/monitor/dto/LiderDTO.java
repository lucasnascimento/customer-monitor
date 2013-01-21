package br.com.citel.monitor.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import br.com.citel.monitor.model.Monitor;


@RequiredArgsConstructor
@NoArgsConstructor
public @Data class LiderDTO {

	@NonNull
	private Long codigoLider;
	@NonNull
	private String nomeLider;
	private List<Monitor> problemas;
	
}
