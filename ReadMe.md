## Actividad 3

## instrucciones 
En Java, crea una clase llamada Producto
Incluye un método de acceso (get) para cada atributo privado. Recuerda que estos elementos devuelven el valor del atributo y, por tanto, deben ser públicos (public).
Incluye un método “establecedor” (set) para cada atributo privado. Recuerda que estos elementos asignan un valor a los atributos, por lo que no devuelven ningún valor y, por ese motivo, también deben ser públicos.
Incluye un método público llamado muestraProducto que presente el valor de todos los atributos en pantalla.
Incluye un método funcional que calcule y devuelva el precio de venta del producto, de acuerdo con los siguientes requisitos:
El método debe recibir un parámetro de tipo double que se llame utilidad, cuyo valor corresponde al porcentaje de utilidad que se quiere manejar para el producto.
Al costo, se le debe sumar el porcentaje de utilidad; por ejemplo, si el primero es de $100 y la segunda de 20%, el precio antes de impuestos es de $120.
Finalmente, a dicho precio, se le debe sumar el impuesto; entonces, si este es del 16%, el precio de venta total se calcula a partir de la suma de $120 + $16.2, la cual arroja un total de $139.2. Este es el valor que debe devolver el método.
El nombre del método debe ser calcularPrecio.

En la clase principal (main) del programa, realiza las siguientes acciones:
Crea dos objetos de la clase Producto, pide al usuario el valor de todos los atributos y asígnalos mediante los métodos establecedores (set).
Incluye sentencias try-catch para captar excepciones que se puedan presentar en la entrada de datos.
Muestra, en pantalla, los valores de los atributos de los dos objetos a través del método mostrarProducto().
Crea un método estático llamado compararProductos que reciba dos parámetros de tipo Producto; dentro de él, invoca el método de clase calcularPrecio para cada uno de los productos recibidos como argumentos y, luego, determina cuál es mayor. El método debe devolver un String con la descripción del producto con el mayor precio de venta.
Desde la clase principal (main), invoca el método compararProductos y muestra el resultado en la pantalla.

## Codigo ##
````java
package actividad_3;

public class Producto {

    private String nombr;
    private String descripcion;   // NUEVO
    private double costo;
    private double impuesto; // porcentaje

    public Producto(String nombre, String descripcion, double costo, double impuesto) {
        this.nombr = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.impuesto = impuesto;
    }

    public String getNombre() {
        return nombr;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double calcularPrecio(double utilidad) {
        double subtotal = costo + utilidad;
        double montoImpuesto = subtotal * (impuesto / 100.0);
        return subtotal + montoImpuesto;
    }
}

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

````

## Salida Real ##
````text

````