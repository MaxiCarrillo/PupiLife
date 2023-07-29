package max.sofi.pupilife.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class Testimonio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Usuario usuario;
	@NotEmpty(message="Debes dejar tu comentario")
	private String comentario;
	private LocalDate fecha;
	private boolean estado;
	
	public Testimonio() {
		// TODO Auto-generated constructor stub
	}

	public Testimonio(Long id, Usuario usuario, String comentario, LocalDate fecha, boolean estado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.comentario = comentario;
		this.fecha = fecha;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
	
	

}
