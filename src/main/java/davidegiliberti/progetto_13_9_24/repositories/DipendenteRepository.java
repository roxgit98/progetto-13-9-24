package davidegiliberti.progetto_13_9_24.repositories;

import davidegiliberti.progetto_13_9_24.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {

}
