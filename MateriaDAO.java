import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MateriaDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Materia> findAll() {
        return em.createQuery("SELECT m FROM Materia m", Materia.class).getResultList();
    }

    public Materia find(Long id) {
        return em.find(Materia.class, id);
    }

    public void create(Materia materia) {
        em.persist(materia);
    }

    public void update(Materia materia) {
        em.merge(materia);
    }

    public void delete(Long id) {
        Materia materia = find(id);
        if (materia != null) {
            em.remove(materia);
        }
    }
}
