package max.sofi.pupilife.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * @author maxi1
 * Clase que representa un usuario.
 */
@Entity
@Component
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El campo nombre no puede estar vacio.")
	private String nombre;
	
	@NotEmpty(message = "El campo apellido no puede estar vacio.")
	private String apellido;
	
	@NotEmpty(message = "El campo email no puede estar vacio.")
	@Email
	private String email;
	
	@NotEmpty(message = "El campo telefono no puede estar vacio.")
	private String telefono;
	
	@NotEmpty(message = "Debe seleccionar una opcion.")
	private String sexo;
	
	@NotNull(message = "Debe ingresar una fecha de nacimiento.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNac;
	
	@NotNull(message = "El campo estatura no puede estar vacio.")
	private Double estatura;
	
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<IndiceMasaCorporal> imc = new ArrayList<IndiceMasaCorporal>();
	
	private Boolean admin=false;
	
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

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", sexo=" + sexo + ", fechaNac=" + fechaNac + ", estatura=" + estatura
				+ ", imc=" + imc + "]";
	}
}
