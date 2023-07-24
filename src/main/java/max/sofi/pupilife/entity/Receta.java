package max.sofi.pupilife.entity;

public class Receta {
	private Long id;
	private String nombre;
	private String categoria;
	private Ingrediente ingrediente;
	private String preparacion;
	private String imagen;
	
	public Receta() {
		// TODO Auto-generated constructor stub
	}

	public Receta(Long id, String nombre, String categoria, Ingrediente ingrediente, String preparacion,
			String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.ingrediente = ingrediente;
		this.preparacion = preparacion;
		this.imagen = imagen;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
}
