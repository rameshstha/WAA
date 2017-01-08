package com.lab7;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MyBean {
	   
		public String doAction(){
	      return "showAll";
	    }

	    public String undoAction(){
	      return "index";
	    }
}
