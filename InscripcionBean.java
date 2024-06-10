import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class InscripcionBean {
    @Inject
    private InscripcionDAO inscripcionDAO;
    @Inject
    private AlumnoDAO alumnoDAO;
    @Inject
    private MateriaDAO materiaDAO;
    
    private Inscripcion inscripcion;
    private List<Inscripcion> inscripciones;
    private List<Alumno> alumnos;
    private List<Materia> materias;

    @PostConstruct
    public void init() {
        inscripcion = new Inscripcion();
        inscripciones = inscripcionDAO.findAll();
        alumnos = alumnoDAO.findAll();
        materias = materiaDAO.findAll();
    }

    public void save() {
        if (inscripcion.getId() == null) {
            inscripcion.setFechaInscripcion(new Date());
            inscripcionDAO.create(inscripcion);
        } else {
            inscripcionDAO.update(inscripcion);
        }
        inscripciones = inscripcionDAO.findAll();
        inscripcion = new Inscripcion();
    }

    public void delete(Long id) {
        inscripcionDAO.delete(id);
        inscripciones = inscripcionDAO.findAll();
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
