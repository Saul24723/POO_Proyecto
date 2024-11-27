import java.util.ArrayList;

public class Medicamento {
    protected String nombreMedicamento;
    protected int cantidadUnidades;
    protected String presentacionMedicamento;
    protected String frecuencia;
    protected static ArrayList<Medicamento> medicamentosDisponibles = new ArrayList<>();

    // Constructor de la clase Medicamento
    public Medicamento(String nombreMedicamento, int cantidadUnidades, String presentacionMedicamento, String frecuencia) {
        this.nombreMedicamento = nombreMedicamento;
        this.cantidadUnidades = cantidadUnidades;
        this.presentacionMedicamento = presentacionMedicamento;
        this.frecuencia = frecuencia;
    }

    // Getters
    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public String getPresentacionMedicamento() {
        return presentacionMedicamento;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    // Método para agregar un medicamento a la lista de medicamentos disponibles
    public static void agregarMedicamento(Medicamento medicamento) {
        // Validar que la cantidad sea positiva
        if (medicamento.getCantidadUnidades() <= 0) {
            System.out.println("Error: La cantidad de unidades debe ser mayor que cero.");
            return;
        }

        // Validar si el medicamento ya existe en la lista
        if (medicamentosDisponibles.contains(medicamento)) {
            System.out.println("Este medicamento ya está registrado.");
        } else {
            medicamentosDisponibles.add(medicamento);
            System.out.println("Medicamento agregado correctamente: " + medicamento.getNombreMedicamento());
        }
    }

    // Método para listar los medicamentos disponibles
    public static void listaMedicamentos() {
        if (medicamentosDisponibles.isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
        } else {
            System.out.println("Lista de medicamentos disponibles:");
            for (Medicamento medicamento : medicamentosDisponibles) {
                System.out.println("Nombre: " + medicamento.getNombreMedicamento() +
                        " | Cantidad: " + medicamento.getCantidadUnidades() +
                        " | Presentación: " + medicamento.getPresentacionMedicamento() +
                        " | Frecuencia: " + medicamento.getFrecuencia());
            }
        }
    }

    // Método para eliminar un medicamento de la lista
    public static void eliminarMedicamento(String nombreMedicamento) {
        boolean encontrado = false;
        for (Medicamento medicamento : medicamentosDisponibles) {
            if (medicamento.getNombreMedicamento().equalsIgnoreCase(nombreMedicamento)) {
                medicamentosDisponibles.remove(medicamento);
                encontrado = true;
                System.out.println("Medicamento eliminado con éxito.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Medicamento no encontrado.");
        }
    }

    // Método para verificar si hay suficiente cantidad de medicamento
    public static boolean verificarCantidad(String nombreMedicamento, int cantidadRequerida) {
        for (Medicamento medicamento : medicamentosDisponibles) {
            if (medicamento.getNombreMedicamento().equalsIgnoreCase(nombreMedicamento)) {
                return medicamento.getCantidadUnidades() >= cantidadRequerida;
            }
        }
        return false; // Si el medicamento no se encuentra en la lista
    }

    // Método para actualizar la cantidad de un medicamento después de registrar la toma
    public static void actualizarCantidad(String nombreMedicamento, int cantidadTomada) {
        for (Medicamento medicamento : medicamentosDisponibles) {
            if (medicamento.getNombreMedicamento().equalsIgnoreCase(nombreMedicamento)) {
                int nuevaCantidad = medicamento.getCantidadUnidades() - cantidadTomada;
                if (nuevaCantidad < 0) {
                    System.out.println("No hay suficiente cantidad del medicamento para la toma.");
                } else {
                    medicamento.cantidadUnidades = nuevaCantidad;
                    System.out.println("Cantidad actualizada. Nueva cantidad: " + nuevaCantidad);
                }
                return;
            }
        }
        System.out.println("Medicamento no encontrado.");
    }

    // Método equals() y hashCode() para poder comparar correctamente los objetos Medicamento
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Medicamento that = (Medicamento) obj;
        return nombreMedicamento.equalsIgnoreCase(that.nombreMedicamento); // Compara solo el nombre
    }

    @Override
    public int hashCode() {
        return nombreMedicamento.toLowerCase().hashCode(); // Usamos el nombre para calcular el hash
    }
}
