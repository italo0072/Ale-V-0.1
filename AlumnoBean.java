import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class AlumnoBean {
    @Inject
    private AlumnoDAO alumnoDAO;
    private Alumno alumno;
    private List<Alumno> alumnos;

    @PostConstruct
    public void init() {
        alumno = new Alumno();
        alumnos = alumnoDAO.findAll();
    }

    public void save() {
        if (alumno.getId() == null) {
            alumnoDAO.create(alumno);
        } else {
            alumnoDAO.update(alumno);
        }
        alumnos = alumnoDAO.findAll();
        alumno = new Alumno();
    }

    public void delete(Long id) {
        alumnoDAO.delete(id);
        alumnos = alumnoDAO.findAll();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
