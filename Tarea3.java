package actividad_3;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Tarea3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nun = 0;


        do {
            try {
                System.out.print("¿Cuántos productos va a capturar? (máx 2): ");
                nun = sc.nextInt();
                sc.nextLine();

                if (nun < 1 || nun > 2) {
                    System.out.println("Solo se permiten 1 o 2 productos.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                sc.nextLine();
            }
        } while (nun < 1 || nun > 2);

        Producto[] productos = new Producto[nun];

        for (int i = 0; i < nun; i++) {

            System.out.println("\nProducto " + (i + 1));

            System.out.print("Nombre del producto: ");
            String nombr = sc.nextLine();

            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();

            double costo = 0;
            double impuesto = 0;

            while (true) {
                try {
                    System.out.print("Costo del producto: ");
                    costo = sc.nextDouble();
                    if (costo < 0) throw new InputMismatchException();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Costo inválido.");
                    sc.nextLine();
                }
            }


            while (true) {
                try {
                    System.out.print("Impuesto (escribir sin sinbolo de porcentaje): ");
                    impuesto = sc.nextDouble();
                    if (impuesto < 0 || impuesto > 100) throw new InputMismatchException();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Impuesto inválido.");
                    sc.nextLine();
                }
            }

            sc.nextLine();

            productos[i] = new Producto(nombr, descripcion, costo, impuesto);
        }

        double porcentajeUtilidad = 0;

        while (true) {
            try {
                System.out.print("\nPorcentaje de utilidad general (escribir sin simbolo de porcentaje): ");
                porcentajeUtilidad = sc.nextDouble();
                if (porcentajeUtilidad < 0) throw new InputMismatchException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Porcentaje inválido.");
                sc.nextLine();
            }
        }

        System.out.println("\n____________________________________________");
        System.out.println("Nombre | Descripción | Costo | Impuesto% | Precio Final");
        System.out.println("____________________________________________");

        for (Producto p : productos) {
            double utilidad = p.getCosto() * (porcentajeUtilidad / 100.0);
            double precioFinal = p.calcularPrecio(utilidad);

            System.out.println(
                p.getNombre() + " | " +
                p.getDescripcion() + " | " +
                p.getCosto() + " | " +
                p.getImpuesto() + "% | " +
                precioFinal
            );
        }

        System.out.println("____________________________________________");

        sc.close();
    }
}
