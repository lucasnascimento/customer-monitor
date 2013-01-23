package br.com.citel.monitor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.citel.monitor.dto.LiderDTO;
import br.com.citel.monitor.model.Monitor;
import br.com.citel.monitor.repository.MonitorRepository;

@ManagedBean
@Controller
@Scope(value = "session")
public class IndexBean {

	@Getter
	private List<LiderDTO> lideres;

	@Getter
	private List<Monitor> problemas;
	
	@Getter
	private LiderDTO liderSelecionado;

	@Autowired
	MonitorRepository monitorRepository;

	@PostConstruct
	public void init() {
		lideres = monitorRepository.findLideres();
		if (liderSelecionado != null){
			problemas = monitorRepository.findByLider(liderSelecionado.getCodigoLider());
		}
		problemas = new ArrayList<Monitor>();
	}

	public void selecionarLider(LiderDTO liderDTO) {
		liderSelecionado = liderDTO;
		problemas = monitorRepository.findByLider(liderDTO.getCodigoLider());
	}
	
	@RequestMapping(value="/lider", method=RequestMethod.GET)
	public List<LiderDTO> recuperaLideres(){
		return  monitorRepository.findLideres();
	}
	
	@RequestMapping(value="/lider/{codigoLider}", method=RequestMethod.GET)
	public LiderDTO recupera(@PathVariable Long codigoLider){
		LiderDTO liderCompleto;
		if (codigoLider != 0){
			liderCompleto = monitorRepository.findLider(codigoLider);
			if (liderCompleto == null) return null;
		}else{
			liderCompleto = new LiderDTO(0l,"Todos");
		}
		
		liderCompleto.setProblemas( monitorRepository.findByLider(codigoLider));
		return liderCompleto;
	}

}
