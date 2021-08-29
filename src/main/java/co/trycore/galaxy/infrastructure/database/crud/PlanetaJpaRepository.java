package co.trycore.galaxy.infrastructure.database.crud;

import co.trycore.galaxy.infrastructure.database.entity.Planeta;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetaJpaRepository {

    List<Planeta> getPlanetasMasVisitados(int top);

}
