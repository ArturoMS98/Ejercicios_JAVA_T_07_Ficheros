
import java.io.Serializable;


/**
 *
 * @author baha
 * Tipo: FrontEnd // BackEnd
 * Paquete: 
 *
 * Funcion: 
 *          
 */
public class Empleado implements Serializable{
    private String nombre, apellidos, dni, departamento;
    private String titulaciones[];
    private String idiomas[];

    public Empleado(String nombre, String apellidos, String dni, String[] titulaciones, String[] idiomas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.departamento = departamento;
        this.titulaciones = titulaciones;
        this.idiomas = idiomas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String[] getTitulaciones() {
        return titulaciones;
    }

    public String[] getIdiomas() {
        return idiomas;
    }
    
    
}
