package com.ws.fact;



public class LoginWS {

	String tipo;
	public S_usuar data;

	public LoginWS() {
		// TODO Auto-generated constructor stub
	}

	public LoginWS(String tipo, S_usuar s_usuar) {
		super();
		this.tipo = tipo;
		this.data = s_usuar;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public S_usuar getS_usuar() {
		return data;
	}

	public void setS_usuar(S_usuar s_usuar) {
		this.data = s_usuar;
	}

	
	
	
}
