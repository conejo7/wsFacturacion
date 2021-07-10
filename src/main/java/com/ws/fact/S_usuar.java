package com.ws.fact;

import javax.persistence.*;


@Entity
@Table(name = "s_usuar")
public class S_usuar {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	   	    
	    private String usuario;
	    private String descrip;
	    private String clave;
	    
	    public S_usuar() {
			// TODO Auto-generated constructor stub
		}
	    
		public S_usuar(String usuario, String descrip) {
			super();
			this.usuario = usuario;
			this.descrip = descrip;
		}
		
		
		public S_usuar(String usuario, String descrip, String clave) {
			super();
			this.usuario = usuario;
			this.descrip = descrip;
			this.clave = clave;
		}

		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getDescrip() {
			return descrip;
		}
		public void setDescrip(String descrip) {
			this.descrip = descrip;
		}		
		
		public String getClave() {
			return clave;
		}

		public void setClave(String clave) {
			this.clave = clave;
		}

		@Override
		public String toString() {
			return "S_usuar [usuario=" + usuario + ", descrip=" + descrip + "]";
		}	  
	    
	    
	    
	    
}
