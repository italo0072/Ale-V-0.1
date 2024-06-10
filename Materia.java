import javax.persistence.*;

@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_seq")
    @SequenceGenerator(name = "materia_seq", sequenceName = "materia_seq", allocationSize = 1)
    private Long id;
    private String nombre;
    private String descripcion;
    private String codigo;

    // Getters y Setters
}
