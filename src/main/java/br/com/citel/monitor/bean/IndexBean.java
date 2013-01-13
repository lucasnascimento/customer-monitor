package br.com.citel.monitor.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import lombok.Getter;
import lombok.Setter;

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
	@ManagedProperty(value="br.com.citel.monitor.repository.MonitorRepository") @Getter @Setter
	MonitorRepository repository;
	
	public List<String> getLideres(){
		return repository.findLideres();
	}
	
	public List<Monitor> getProblemas(String nomeLider){
		return repository.findByLider(nomeLider);
	}

	
}
