package br.com.citel.monitor.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.citel.monitor.dto.LiderDTO;
import br.com.citel.monitor.repository.MonitorRepository;

@Controller
public class IndexBean {

	@Autowired
	MonitorRepository monitorRepository;
	
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
	
	@RequestMapping(value="/setor", method=RequestMethod.GET)
	public List<String> recuperaSetores(){
		return  monitorRepository.listSetores();
	}


}
