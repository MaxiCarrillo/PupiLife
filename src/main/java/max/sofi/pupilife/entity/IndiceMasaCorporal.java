package max.sofi.pupilife.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class IndiceMasaCorporal {
	//nos conviene usar Long para poder usar sus funciones
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Boolean estado;
    
    public IndiceMasaCorporal() {
		// TODO Auto-generated constructor stub
	}

	public IndiceMasaCorporal(Long id, LocalDate fecha, Usuario usuario, Boolean estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
    
}
