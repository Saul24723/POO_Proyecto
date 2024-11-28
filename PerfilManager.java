import java.util.ArrayList;
import java.util.Scanner;

public class PerfilManager {
    private ArrayList<String[]> perfiles; // Cada perfil es un arreglo [nombre, relacion, email]
    private Scanner scanner;
    //Metodo constructor
    public PerfilManager() {
        this.perfiles = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    //Metodo para mostrar el perfil
    public void mostrarMenuPerfiles() {
        int opcion;
        do {
            System.out.println("\n----- MENÚ DE PERFILES -----");
            System.out.println("1. Crear Perfil");
            System.out.println("2. Seleccionar Perfil");
            System.out.println("3. Regresar al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            if (opcion == 1) {
                crearPerfil();
            } else if (opcion == 2) {
                seleccionarPerfil();
            } else if (opcion == 3) {
                System.out.println("Regresando al Menú Principal.");
            } else {
                System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    private void crearPerfil() {
        System.out.println("\n----- CREAR PERFIL -----");
        System.out.print("Nombre del Usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("Relación: ");
        String relacion = scanner.nextLine();

        System.out.print("Email (opcional): ");
        String email = scanner.nextLine();

        // Crear un perfil como un arreglo de Strings y agregarlo a la lista
        perfiles.add(new String[]{nombre, relacion, email});
        System.out.println("Perfil creado con éxito.");
    }

    private void seleccionarPerfil() {
        if (perfiles.isEmpty()) {
            System.out.println("No hay perfiles disponibles.");
            return;
        }

        System.out.println("\n----- SELECCIONAR PERFIL -----");
        for (int i = 0; i < perfiles.size(); i++) {
            System.out.println((i + 1) + ". " + perfiles.get(i)[0]); // Mostrar el nombre del perfil
        }

        System.out.print("Seleccione un perfil: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        if (seleccion > 0 && seleccion <= perfiles.size()) {
            String[] perfilSeleccionado = perfiles.get(seleccion - 1);
            System.out.println("Perfil seleccionado: " + perfilSeleccionado[0]); // Mostrar nombre
            mostrarOpcionesPerfil(perfilSeleccionado);
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private void mostrarOpcionesPerfil(String[] perfil) {
        System.out.println("\n----- Opciones para: " + perfil[0] + " -----");
        // Implementa opciones adicionales según el perfil seleccionado
        System.out.println("Funcionalidad pendiente...");
    }
    //Metodo main para mostrar por pantalla los perfiles disponibles

    public static void main(String[] args) {
        PerfilManager manager = new PerfilManager();
        manager.mostrarMenuPerfiles();
    }
}
