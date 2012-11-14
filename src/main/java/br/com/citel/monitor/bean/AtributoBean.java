package br.com.citel.monitor.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import lombok.experimental.Accessors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.citel.monitor.model.Atributo;
import br.com.citel.monitor.repository.AtributoRepository;


@ManagedBean(name="atributoBean")
public class AtributoBean {
	
	@Autowired
	private AtributoRepository atributoRepository;

	@Accessors
	private Atributo atributo;
	
	@Accessors
	private List<Atributo> atributoList;
	
	public String novo(){
		atributo = new Atributo();
		return "novo";
	}
	
	public String save(Atributo atributo){
		//TODO: Implementar métodos de list
		return "list";
	}
	
	
	

}
