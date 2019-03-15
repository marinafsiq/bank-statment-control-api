package com.marinafsiq.bankStatmentControl.api.response;

import java.util.ArrayList;
import java.util.List;

public class Response <T>{
	
	private T data;
	private List<String> errors;
	
	public Response() {
		
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<String> getErrors() {
		if(errors == null) {
			errors = new ArrayList<String>();
		}
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public void addErrors(String error) {
		if(errors==null)
			errors = new ArrayList<String>();
		errors.add(error);
	}
	

}
