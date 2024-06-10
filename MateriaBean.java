import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class MateriaBean {
    @Inject
    private MateriaDAO materiaDAO;
    private Materia materia;
    private List<Materia> materias;

    @PostConstruct
    public void init() {
        materia = new Materia();
        materias = materiaDAO.findAll();
    }

    public void save() {
        if (materia.getId() == null) {
            materiaDAO.create(materia);
        } else {
            materiaDAO.update(materia);
        }
        materias = materiaDAO.findAll();
        materia = new Materia();
    }

    public void delete(Long id) {
        materiaDAO.delete(id);
        materias = materiaDAO.findAll();
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
