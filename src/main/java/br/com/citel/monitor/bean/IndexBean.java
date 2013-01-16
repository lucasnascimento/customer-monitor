package br.com.citel.monitor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.citel.monitor.dto.LiderDTO;
import br.com.citel.monitor.model.Monitor;
import br.com.citel.monitor.repository.MonitorRepository;

@ManagedBean
@Controller
@Scope(value = "request")
public class IndexBean {

	@Getter
	private List<LiderDTO> lideres;

	@Getter
	private List<Monitor> problemas;

	@Autowired
	MonitorRepository monitorRepository;

	@PostConstruct
	public void init() {
		lideres = monitorRepository.findLideres();
		problemas = new ArrayList<Monitor>();
	}

	public void selecionarLider(LiderDTO liderDTO) {
		problemas = monitorRepository.findByLider(liderDTO.getCodigoLider());
	}

}
