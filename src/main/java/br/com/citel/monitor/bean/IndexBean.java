package br.com.citel.monitor.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.citel.monitor.model.Monitor;
import br.com.citel.monitor.repository.MonitorRepository;

@ManagedBean
@Controller
@Scope(value="request")
public class IndexBean {
	
	@Autowired
	MonitorRepository monitorRepository;

	public List<String> getLideres(){
		return monitorRepository.findLideres();
	}
	
	public List<Monitor> getProblemas(String nomeLider){
		return monitorRepository.findByLider(nomeLider);
	}

	
}
