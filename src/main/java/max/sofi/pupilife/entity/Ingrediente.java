package max.sofi.pupilife.entity;

public class Ingrediente {
	private Long id;
	private String nombre;
	
	public Ingrediente() {
		// TODO Auto-generated constructor stub
	}

	public Ingrediente(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

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
	
	
}
