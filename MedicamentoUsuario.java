import java.util.ArrayList;
import java.util.Scanner;

public class MedicamentoUsuario extends Medicamento {
    private String frecuenciaDia;
    private int horaToma;
    private int dosis;
    private static ArrayList<MedicamentoUsuario> registro = new ArrayList<>();
    
    // Constructor
    public MedicamentoUsuario(String nombreMedicamento, int cantidadUnidades, String presentacionMedicamento,
                              String frecuencia, String frecuenciaDia, int horaToma, int dosis) {
        super(nombreMedicamento, cantidadUnidades, presentacionMedicamento, frecuencia);
        this.frecuenciaDia = frecuenciaDia;
        this.horaToma = horaToma;
        this.dosis = dosis;
    }

    // Getters
    public String getFrecuenciaDia() {
        return frecuenciaDia;
    }

    public int getHoraToma() {
        return horaToma;
    }

    public int getDosis() {
        return dosis;
    }

    // Método para añadir medicamento
    public static void añadirMedicina() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del medicamento: ");
        String nombreMedicamento = sc.nextLine();

        System.out.println("Ingrese la cantidad de unidades disponibles: ");
        int cantidadUnidades = sc.nextInt();
        sc.nextLine();  // Limpiar buffer

        System.out.println("Seleccione una opción de presentación: ");
        System.out.println("- Pastilla\n- Inyección\n- Solución\n- Gotas\n- Inhalador\n- Polvo");
        String presentacionMedicamento = sc.nextLine();

        System.out.println("Seleccione la frecuencia de toma:");
        System.out.println("- Cada día\n- Cada dos días\n- Días específicos de la semana (L Ma Mi J V)\n- Cada x días\n- Cada x semanas\n- Cada x meses");
        String frecuencia = sc.nextLine();

        System.out.println("Opción de tomar la medicina:");
        System.out.println("- Una vez al día\n- Dos veces al día\n- Tres veces al día");
        String frecuenciaDia = sc.nextLine();

        System.out.println("Ingrese la hora para cada toma (en formato 24 horas): ");
        int horaToma = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        System.out.println("Ingrese la cantidad de medicamento a tomar en cada ocasión: ");
        int dosis = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        // Crear el objeto MedicamentoUsuario y añadirlo al registro
        MedicamentoUsuario nuevoMedicamento = new MedicamentoUsuario(
                nombreMedicamento, cantidadUnidades, presentacionMedicamento, frecuencia,
                frecuenciaDia, horaToma, dosis);
        registro.add(nuevoMedicamento);

        System.out.println("Medicamento añadido con éxito.");
    }

    // Método para listar los medicamentos del usuario
    public static void listaMedicamentos() {
        if (registro.isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
        } else {
            System.out.println("Lista de medicamentos registrados:");
            for (MedicamentoUsuario medicamento : registro) {
                System.out.println("Nombre: " + medicamento.getNombreMedicamento() + 
                        " | Cantidad: " + medicamento.getCantidadUnidades() + 
                        " | Presentación: " + medicamento.getPresentacionMedicamento() + 
                        " | Frecuencia: " + medicamento.getFrecuencia() +
                        " | Frecuencia del día: " + medicamento.getFrecuenciaDia() +
                        " | Hora de toma: " + medicamento.getHoraToma() +
                        " | Dosis: " + medicamento.getDosis());
            }
        }
    }

    // Método para eliminar un medicamento
    public static void eliminarMedicina() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del medicamento que desea eliminar: ");
        String nombreMedicamentoEliminar = sc.nextLine();

        boolean encontrado = false;
        for (MedicamentoUsuario medicamento : registro) {
            if (medicamento.getNombreMedicamento().equalsIgnoreCase(nombreMedicamentoEliminar)) {
                registro.remove(medicamento);
                encontrado = true;
                System.out.println("Medicamento eliminado con éxito.");
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Medicamento no encontrado.");
        }
    }

    // Método para registrar la toma de un medicamento
    public static void registrarToma() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el medicamento para registrar la toma: ");
        String nombreMedicamento = sc.nextLine();

        boolean encontrado = false;
        for (MedicamentoUsuario medicamento : registro) {
            if (medicamento.getNombreMedicamento().equalsIgnoreCase(nombreMedicamento)) {
                System.out.println("Se registrará la toma del medicamento: " + nombreMedicamento);
                System.out.println("Ingrese la fecha de la toma (DD/MM/AAAA): ");
                String fechaToma = sc.nextLine();
                System.out.println("Ingrese la hora de la toma (24 horas): ");
                int horaToma = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                System.out.println("Toma registrada exitosamente para el medicamento: " + nombreMedicamento);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Medicamento no encontrado en el registro.");
        }
    }
}
