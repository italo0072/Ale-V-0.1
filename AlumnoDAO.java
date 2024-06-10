import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AlumnoDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Alumno> findAll() {
        return em.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
    }

    public Alumno find(Long id) {
        return em.find(Alumno.class, id);
    }

    public void create(Alumno alumno) {
        em.persist(alumno);
    }

    public void update(Alumno alumno) {
        em.merge(alumno);
    }

    public void delete(Long id) {
        Alumno alumno = find(id);
        if (alumno != null) {
            em.remove(alumno);
        }
    }
}
