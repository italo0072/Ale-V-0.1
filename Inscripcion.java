import javax.persistence.*;
import java.util.Date;

@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    private String ciclo;
    private int anio;
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;

    // Getters y Setters
}
