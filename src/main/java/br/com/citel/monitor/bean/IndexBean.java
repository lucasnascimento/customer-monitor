package br.com.citel.monitor.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="indexMB")
public class IndexBean {
	
	public String getMessage(){
		return "It's alive!";
	}

}
