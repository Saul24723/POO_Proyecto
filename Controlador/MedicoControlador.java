import Modelo;
import java.util.ArrayList;
import java.util.List;

public class MedicoControlador {
    private List<Medico> listMedicos = new ArrayList<>();

// Metodo para agregar medicos
public void anadirMedico(String nombre, String especialidad, String telefono, String email, String direccion){
    Medico medicoM= new Medico(nombre, especialidad, telefono,email,direccion);
    listMedicos.add(medicoM);   
}
// Mostrar el registro de medicos 
public List<Medico> obtenerMedicos() {
        return listMedicos;
    }
}