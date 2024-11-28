import java.util.List;
import java.util.Scanner;
import Modelo;
import Controlador;
public class MedicoVisual {
    private MedicoControlador medicoControlador;

    // Constructor que recibe el controlador como parámetro
    public MedicoVisual(MedicoControlador medicoControlador) {
        this.medicoControlador = medicoControlador;
    }

    // Método para pedir los datos de un médico
    public void pedirDatosMedico(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.print("Ingrese el nombre del médico: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la especialidad del médico: ");
        String especialidad = scanner.nextLine();

        System.out.print("Ingrese el número de contacto del médico: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese la dirección de correo electrónico del médico: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese la dirección del médico: ");
        String direccion = scanner.nextLine();

        // Llamamos al método del controlador para añadir el médico
        medicoControlador.anadirMedico(nombre, especialidad, telefono, email, direccion);
        System.out.println("Datos Guardados con éxito.");
        System.out.println("------------------------------------");
    }

    // Método para mostrar la lista de médicos
    public void listaMedicos(List<Medico> medicos) {
        System.out.println("------------------------------------");
        System.out.println("Lista de Médicos:");
        System.out.println("------------------------------------");
        if(medicos.isEmpty()){
            System.out.println("------------------------------------");
            System.out.println("No hay registro de Médicos.");
            System.out.println("------------------------------------");
        } else {
            for(Medico medico : medicos) {
                System.out.println("Nombre: " + medico.getNombre());
                System.out.println("Especialidad: " + medico.getEspecialidad());
                System.out.println("Teléfono: " + medico.getTelefono());
                System.out.println("Email: " + medico.getEmail());
                System.out.println("Dirección: " + medico.getDireccion());
            }
        }
    }
}
