package max.sofi.pupilife.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * @author maxi1
 * Clase que representa un usuario.
 */
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String sexo;
	private LocalDate fechaNac;
	private Double estatura;
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<IndiceMasaCorporal> imc = new ArrayList<IndiceMasaCorporal>();
	
	/**
	 * Constructor vacio
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado
	 */
	public Usuario(Long id, String nombre, String apellido, String email, String telefono, String sexo,
			LocalDate fechaNac, Double estatura, List<IndiceMasaCorporal> imc) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.estatura = estatura;
		this.imc = imc;
	}

	/**
	 * Getters y Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public List<IndiceMasaCorporal> getImc() {
		return imc;
	}

	public void setImc(List<IndiceMasaCorporal> imc) {
		this.imc = imc;
	}

	
	
}
