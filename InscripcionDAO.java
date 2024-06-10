import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class InscripcionDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Inscripcion> findAll() {
        return em.createQuery("SELECT i FROM Inscripcion i", Inscripcion.class).getResultList();
    }

    public Inscripcion find(Long id) {
        return em.find(Inscripcion.class, id);
    }

    public void create(Inscripcion inscripcion) {
        em.persist(inscripcion);
    }

    public void update(Inscripcion inscripcion) {
        em.merge(inscripcion);
    }

    public void delete(Long id) {
        Inscripcion inscripcion = find(id);
        if (inscripcion != null) {
            em.remove(inscripcion);
        }
    }
}
