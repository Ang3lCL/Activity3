package actividad_3;

import java.util.Scanner;

public class Tarea3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 
           int nun = 0;

        do {
            try {
                System.out.print("Cuántos productos va a capturar?: ");
                nun = sc.nextInt();

                if (nun < 1 || nun > 5) {
                    System.out.println("Debe ser un número entre 1 y 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        } while (nun < 1 || nun > 5);

        Producto[] productos = new Producto[nun];

        for (int i = 0; i < nun; i++) {
            sc.nextLine();

            System.out.println("\nProducto " + (i + 1));

            System.out.print("Nombre: ");
            String nombrer = sc.nextLine();

            double costo = 0;
            double impuesto = 0;

            while (true) {
                try {
                    System.out.print("Costo: ");
                    costo = sc.nextInt();
                    if (costo < 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Costo inválido.");
                }
            }

            while (true) {
                try {
                    System.out.print("Impuesto: ");
                    impuesto = sc.nextDouble();
                    if (impuesto < 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Impuesto inválido.");
                }
            }

            productos[i] = new Producto(nombrer, costo, impuesto);
        }

        double porcentajeUtilidad = 0;
        while (true) {
            try {
                System.out.print("\nPorcentaje de utilidad general: ");
                porcentajeUtilidad = sc.nextDouble();
                if (porcentajeUtilidad < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Porcentaje inválido.");
            }
        }

        System.out.println("____________________________________________");
        System.out.println("Nombre, Costo, Impuesto, Precio Final");
        System.out.println("____________________________________________");


        for (Producto p : productos) {
            double utilidad = p.getCosto() * (porcentajeUtilidad / 100);
            double precioFinal = p.calcularPrecio(utilidad);

            System.out.println(
            p.getNombre() + ", " +
            p.getCosto() + ", " +
            p.getImpuesto() + ", " +
            precioFinal
            );
        }
        System.out.println("____________________________________________");
    
    sc.close();
    }



   
}
