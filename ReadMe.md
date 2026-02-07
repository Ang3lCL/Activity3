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
¿Cuántos productos va a capturar? (máx 2): 2

Producto 1
Nombre del producto: Leche  
Descripción: Leche deslactosada
Costo del producto: 35
Impuesto (escribir sin sinbolo de porcentaje): 15

Producto 2
Nombre del producto: Cereal
Descripción: Cereal de chocolate
Costo del producto: 50
Impuesto (escribir sin sinbolo de porcentaje): 15

Porcentaje de utilidad general (escribir sin simbolo de porcentaje): 15

____________________________________________
Nombre | Descripción | Costo | Impuesto% | Precio Final
____________________________________________
Leche | Leche deslactosada | 35.0 | 15.0% | 46.2875
Cereal | Cereal de chocolate | 50.0 | 15.0% | 66.125
____________________________________________
````

---
---

## Actividades extras

# 15 ejercicios integrados de Java (niveles mixtos)

Incluyen: tipos de datos, operadores, condicionales, estructuras repetitivas, arreglos, métodos, clases/objetos y manejo básico de errores.

---

## 1. Suma simple con validación de entrada (fácil)

**Enunciado**  
Escribe un programa que pida al usuario dos números enteros, valide que realmente sean enteros usando manejo de errores, y luego muestre la suma de ambos.

**Codigo**
````java  
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 1

        int numEnt1 = 0;
        int numEnt2 = 0;

        while (true) {
            try {
                System.out.print("dame un numero entero: ");
                numEnt1 = sc.nextInt(); 
                break;              
            } catch (Exception e) {
                System.out.println("Error: debes escribir un número entero.");
                sc.nextLine(); 
            }
        }
        while (true) {
            try {
                System.out.print("dame otro numero entero: ");
                numEnt2 = sc.nextInt(); 
                break;
            } catch (Exception e) {
                System.out.println("Error: debes escribir un número entero.");
                sc.nextLine();
            }
        }

        int suma1 = numEnt1 + numEnt2;
        System.out.println("La suma de " + numEnt1 + " y " + numEnt2 + " es: " + suma1);
        sc.nextLine();
        sc.close();
    }   
}
````   

**Salida**  


---

## 2. Clasificación de edad con mensaje personalizado (fácil)

**Enunciado**  
Pide el nombre y la edad del usuario.  
Usa condicionales para mostrar:  
- Menos de 13: "Hola <nombre>, eres un niño."  
- 13 a 17: "Hola <nombre>, eres un adolescente."  
- 18 a 64: "Hola <nombre>, eres un adulto."  
- 65 o más: "Hola <nombre>, eres un adulto mayor."

**Codigo**  


**Salida**  

---

## 3. Tabla de multiplicar con `for` (fácil)

**Enunciado**  
Pide un número entero entre 1 y 10.  
Muestra su tabla de multiplicar del 1 al 10 usando un ciclo `for`.  
Si el usuario ingresa algo no entero, usa manejo de errores para pedir el dato de nuevo.

**Codigo**  


**Salida esperada**  


---

## 4. Arreglo de calificaciones y promedio (fácil–medio)

**Enunciado**  
Pide al usuario cuántas calificaciones desea capturar (máximo 10).  
Luego pide cada calificación (double) y guárdalas en un arreglo.  
Calcula y muestra:  

- El promedio.  
- Cuántas calificaciones son mayores o iguales a 70 (aprobadas).  
- Cuántas son menores a 70 (reprobadas).

**Entrada (ejemplo)**  


**Salida esperada**  


---

## 5. Contador de vocales y consonantes en una palabra (medio)

**Enunciado**  
Pide al usuario una palabra (sin espacios).  
Convierte la palabra a minúsculas y recórrela carácter por carácter.  
Cuenta cuántas vocales (a, e, i, o, u) y cuántas consonantes (letras que no son vocales).  
Ignora caracteres que no sean letras.

**Entrada (ejemplo)**  


**Salida esperada**  


---

## 6. Verificar si un arreglo está ordenado (medio)

**Enunciado**  
Pide n números enteros y guárdalos en un arreglo.  
Escribe un método estático que reciba el arreglo y regrese true si está ordenado de forma ascendente (cada elemento >= anterior), o false en caso contrario.  
Desde main, muestra un mensaje indicando si el arreglo está ordenado.

**Entrada (ejemplo 1)**  


**Salida esperada**  



---

## 7. Clase Rectangulo con métodos de área y perímetro (medio)

**Enunciado**  

Crea una clase `Rectangulo` con atributos privados ancho y alto (double).  
Incluye:  

- Constructor que reciba ancho y alto.  
- Getters y setters.  
- Método `calcularArea()` que regrese el área.  
- Método `calcularPerimetro()` que regrese el perímetro.  

En main:  

- Pide al usuario ancho y alto (con manejo de errores).  
- Crea un objeto Rectangulo.  
- Muestra su área y perímetro.

**Entrada (ejemplo)**  



**Salida esperada**  


---

## 8. Buscar un número en un arreglo (medio)

**Enunciado**  
Pide n enteros y guárdalos en un arreglo.  
Luego pide un número x a buscar.  
Usa un método estático buscarElemento(int[] arr, int x) que regrese el índice donde se encuentra la primera ocurrencia de x, o -1 si no existe.  
En main, muestra un mensaje adecuado.

**Entrada (ejemplo)**  



**Salida esperada**  

---

## 9. Sistema simple de biblioteca con clase Libro (medio–alto)

**Enunciado**  
Crea una clase Libro con:  

Atributos privados: titulo (String), autor (String), totalEjemplares (int), ejemplaresPrestados (int).  

Getters y setters.  

Método prestar() que:  

Si hay ejemplares disponibles (totalEjemplares - ejemplaresPrestados > 0), aumente ejemplaresPrestados y regrese true.  

En otro caso regrese false.  

Método devolver() que:  

Si ejemplaresPrestados > 0, lo disminuye y regresa true.  

En otro caso regresa false.  

Método mostrarInfo() que muestre todos los datos.  

En main:  

Crea un objeto Libro con datos fijos.  

Muestra un menú con while o do-while para:  

- Ver información del libro.  
- Prestar un ejemplar.  
- Devolver un ejemplar.  
- Salir.

**Entrada (ejemplo de flujo)**  



**Salida esperada (resumen)**  


---

## 10. Calculadora con menú usando switch (medio)

**Enunciado**  
Crea un programa que muestre un menú:  

- Sumar  
- Restar  
- Multiplicar  
- Dividir  
- Salir  

Cada opción pide dos números y muestra el resultado.  
En la opción de división, valida que el divisor no sea 0 y maneja el error (mensaje y volver a pedir divisor válido).  
Usa do-while para repetir el menú hasta que el usuario elija salir.

**Entrada (ejemplo)**  



**Salida esperada (resumen)**  


---

## 11. Arreglo de productos con precio final (medio–alto)

**Enunciado**  
Crea una clase Producto con atributos privados: nombre (String), costo (double), impuesto (double, %).  
Incluye getters, setters y un método calcularPrecio(double utilidad) que regrese el precio final (costo + utilidad + impuesto).  
En main:  

Pide al usuario cuántos productos va a capturar (máximo 5).  

Usa un arreglo de Producto para almacenarlos.  

Para cada producto, pide nombre, costo, impuesto, con manejo de errores en los números.  

Luego pide un porcentaje de utilidad general para todos.  

Muestra una tabla con: nombre, costo, impuesto, precio final.

**Entrada (ejemplo)**  


**Salida esperada (resumen)**  



---

## 12. Verificar si una frase es palíndromo (medio–alto)

**Enunciado**  
Pide una frase al usuario.  
Remueve espacios y conviértela a minúsculas.  
Luego, verifica si se lee igual de izquierda a derecha y de derecha a izquierda (palíndromo).  
No uses métodos de librerías que ya lo hagan directo: trabaja con índices o un arreglo de caracteres y un ciclo for o while.

**Entrada (ejemplo)**  


**Salida esperada**  


---

## 13. Matriz de notas (medio–alto)

**Enunciado**  
Un grupo tiene f estudiantes y cada uno tiene c materias.  
Pide f y c (por ejemplo máximo 5x5).  
Crea una matriz double[f][c] con las calificaciones.  
Luego:  

Calcula y muestra el promedio de cada estudiante.  

Calcula y muestra el promedio de cada materia.

**Entrada (ejemplo)**  



**Salida esperada**  



---

## 14. Sistema simple de login con intentos limitados (medio–alto)

**Enunciado**  
Define, en el código, un usuario y contraseña correctos (por ejemplo, "admin" y "1234").  
Pide al usuario que ingrese usuario y contraseña, y valida con equals.  
Permite máximo 3 intentos.  
Si los datos son correctos, muestra "Acceso concedido" y termina.  
Si se alcanzan 3 intentos fallidos, muestra "Cuenta bloqueada" y termina.  
Usa un ciclo while o for para contar intentos.

**Entrada (ejemplo)**  



**Salida esperada**  



## 15. Gestión de inventario con clase y menú (difícil)

**Enunciado**  
Crea una clase Articulo con:  

Atributos privados: codigo (String), descripcion (String), precio (double), existencia (int).  

Getters y setters.  

Método mostrar() que imprima todos los datos.  

Método actualizarExistencia(int cantidad) que sume la cantidad a existencia (puede ser negativa para "vender").  

Si la operación dejaría existencia negativa, no la hagas y avisa con un mensaje.  

En main:  

Define un arreglo de Articulo de tamaño fijo (por ejemplo 5).  

Crea un menú con do-while y switch:  

- Agregar artículo (en la primera posición libre del arreglo).  
- Mostrar todos los artículos (solo los no nulos).  
- Vender artículo: pide código y cantidad, busca el artículo en el arreglo, y usa actualizarExistencia(-cantidad) validando que haya suficiente.  
- Reabastecer artículo: similar a vender, pero suma existencias.  
- Salir.

Usa manejo de errores para lectura numérica (precio, existencia, cantidad).

**Entrada (ejemplo, flujo reducido)**  



**Salida esperada (resumen)**  


