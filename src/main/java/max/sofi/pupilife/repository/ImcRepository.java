package max.sofi.pupilife.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import max.sofi.pupilife.entity.IndiceMasaCorporal;
import max.sofi.pupilife.entity.Usuario;

public interface ImcRepository  extends CrudRepository<IndiceMasaCorporal, Long>{
	List<IndiceMasaCorporal> findByUsuario(Usuario usuario);
}
