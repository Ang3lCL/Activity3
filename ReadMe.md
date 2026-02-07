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
````text
dame un numero entero: 22
dame otro numero entero: 31
La suma de 22 y 31 es: 53
````

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
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 2
        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingresa tu edad: ");
        int edadC = sc.nextInt();

        if (edadC < 13) {
        System.out.println("Hola " + nombre + " eres un niño");
        } else if (edadC < 18) {
        System.out.println("Hola " + nombre + " eres un adolescente");
        } else if (edadC < 65) {
        System.out.println("Hola " + nombre + " eres un adulto");
        } else {
        System.out.println("Hola " + nombre + " eres un adulto mayor");
        }
        sc.nextLine();

        sc.close();
    }   
}
        
````

**Salida**  
````text
Ingresa tu nombre: angel
Ingresa tu edad: 18
Hola angel eres un adulto
````
---

## 3. Tabla de multiplicar con `for` (fácil)

**Enunciado**  
Pide un número entero entre 1 y 10.  
Muestra su tabla de multiplicar del 1 al 10 usando un ciclo `for`.  
Si el usuario ingresa algo no entero, usa manejo de errores para pedir el dato de nuevo.

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 3
        System.out.print("dame un numero entero: ");
        int numEntx = sc.nextInt();
        
        for (int i = 1; i < 11; i++)
            System.out.println( + numEntx + " x " + i + " = " + (numEntx * i));

        sc.close();
    }   
}
        
````

**Salida**  
````text
dame un numero entero: 7
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
7 x 4 = 28
7 x 5 = 35
7 x 6 = 42
7 x 7 = 49
7 x 8 = 56
7 x 9 = 63
7 x 10 = 70
````

---

## 4. Arreglo de calificaciones y promedio (fácil–medio)

**Enunciado**  
Pide al usuario cuántas calificaciones desea capturar (máximo 10).  
Luego pide cada calificación (double) y guárdalas en un arreglo.  
Calcula y muestra:  

- El promedio.  
- Cuántas calificaciones son mayores o iguales a 70 (aprobadas).  
- Cuántas son menores a 70 (reprobadas).

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 4

        int cal;

        do{
            System.out.println("cuantas calificaciones quieres poner: ");
            cal = sc.nextInt();
        } while (cal < 1 || cal > 10);


            double[] cali = new double[cal];
            double suma = 0;
            int apro = 0;
            int repro = 0;
        for (int i = 0; i < cal; i++){

            System.out.print("dime la calificacion: ");
            cali[i] = sc.nextDouble();
            suma += cali[i];
            if (cali[i] >= 70) {
                apro++;
            } else {
                repro++;
            }
        }

        double prome = suma/cal;

        System.out.println("tu promedio es de " + prome);
        System.out.println("tus calidicaciones aprovadas son " + apro);
        System.out.println("tus calificaciones reprovadas son " + repro);
        sc.nextLine();

        sc.close();
    }   
}
````

**Salida**  
````text
cuantas calificaciones quieres poner: 3
dime la calificacion: 89
dime la calificacion: 77
dime la calificacion: 54
tu promedio es de 73.33333333333333
tus calidicaciones aprovadas son 2
tus calificaciones reprovadas son 1
````

---

## 5. Contador de vocales y consonantes en una palabra (medio)

**Enunciado**  
Pide al usuario una palabra (sin espacios).  
Convierte la palabra a minúsculas y recórrela carácter por carácter.  
Cuenta cuántas vocales (a, e, i, o, u) y cuántas consonantes (letras que no son vocales).  
Ignora caracteres que no sean letras.

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 5
        System.out.print("ingresa una palabra: ");
        String pal = sc.nextLine();

        pal = pal.toLowerCase();

        int voca = 0;
        int cons = 0;

        for (int i = 0; i < pal.length(); i++) {
            char c = pal.charAt(i);

            if (Character.isLetter(c)) {

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    voca++;
                } else {
                    cons++;
                }

            }
        }
        System.out.println("cantidad de vocales: " + voca);
        System.out.println("cantidad de consonantes: " + cons);

        sc.close();
    }   
}
````

**Salida**  
````text
ingresa una palabra: computadora
cantidad de vocales: 5
cantidad de consonantes: 6
````

---

## 6. Verificar si un arreglo está ordenado (medio)

**Enunciado**  
Pide n números enteros y guárdalos en un arreglo.  
Escribe un método estático que reciba el arreglo y regrese true si está ordenado de forma ascendente (cada elemento >= anterior), o false en caso contrario.  
Desde main, muestra un mensaje indicando si el arreglo está ordenado.

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 6
        int n = 0; 

        while (true) {
            try {
                System.out.print("¿Cuántos números vas a ingresar?: ");
                n = sc.nextInt();
                if (n > 0) break;
                System.out.println("Debe ser mayor que 0.");
            } catch (Exception e) {
                System.out.println("Error: escribe un entero.");
                sc.nextLine();
            }
        }

        int[] arreglo = new int[n];


        for (int j = 0; j < n; j++) {
            while (true) {
                try {
                    System.out.print("Número " + (j + 1) + ": ");
                    arreglo[j] = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Error: escribe un entero.");
                    sc.nextLine();
                }
            }
        }


        if (Orden(arreglo)) {
            System.out.println("El arreglo está ordenado.");
        } else {
            System.out.println("El arreglo NO está ordenado.");
        }

        sc.close();
    }   
}
````

**Salida**  
````text
¿Cuántos números vas a ingresar?: 4
Número 1: 2
Número 2: 8
Número 3: 1
Número 4: 4
El arreglo NO está ordenado.
````


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

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 7

        double ancho = 0;
        double alto = 0;

        while (true) {
            try {
                System.out.print("Ingresa el ancho: ");
                ancho = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Error accion invalida.");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Ingresa LA altura: ");
                alto = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Error accion invalida.");
                sc.nextLine();
            }
        }

        Rectangulo rectangulo = new Rectangulo(ancho, alto);

        System.out.println("Área: " + rectangulo.calcularArea());
        System.out.println("Perímetro: " + rectangulo.calcularPerimetro());

        sc.close();
    }   
}
````


**Salida**  
````text
Ingresa el ancho: 22
Ingresa LA altura: 30
Área: 660.0
Perímetro: 104.0
````

---

## 8. Buscar un número en un arreglo (medio)

**Enunciado**  
Pide n enteros y guárdalos en un arreglo.  
Luego pide un número x a buscar.  
Usa un método estático buscarElemento(int[] arr, int x) que regrese el índice donde se encuentra la primera ocurrencia de x, o -1 si no existe.  
En main, muestra un mensaje adecuado.

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 8
         System.out.print("Cuántos números deseas ingresar? ");
        int nu = sc.nextInt();

        int[] numeros = new int[nu];

        for (int j = 0; j < nu; j++) {
            System.out.print("Ingresa el número " + (j + 1) + ": ");
            numeros[j] = sc.nextInt();
        }


        System.out.print("que numero desea buscar? ");
        int busqueda = sc.nextInt();

        int indice = buscarElemento(numeros, busqueda);
        if (indice == -1){
            System.out.println("No se encontro el numero");
        } else {
            System.out.println("el numero " + busqueda + " se encontro en el indice "+ indice);
        }
        sc.nextLine();

        sc.close();
    }   
}
````


**Salida**  
````text
Cuántos números deseas ingresar? 4
Ingresa el número 1: 2
Ingresa el número 2: 8
Ingresa el número 3: 1
Ingresa el número 4: 5
que numero desea buscar? 1
el numero 1 se encontro en el indice 2
````

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

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //parte 9
        Libro libro = new Libro("El Señor de los Anillos", "Tolkien", "Fantasía", 1954, 3);

        int opcion; 

        do {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Ver información del libro");
            System.out.println("2. Pedir prestado un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = sc.nextInt(); 
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("informacion del libro");
                    System.out.println(libro);

                case 2:
                    if (libro.prestar()) {
                        System.out.println("Se ha prestado correctamente");
                    } else {
                        System.out.println("No hay ejemplares disponibles");
                    }
                    break;

                case 3:
                    if (libro.devolver()) {
                        System.out.println("Se ha devuelto correctamente");
                    } else {
                        System.out.println("No hay libros prestados");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 4);




        sc.close();
    }   
}
````


**Salida**  
````text
=== MENÚ BIBLIOTECA ===
1. Ver información del libro
2. Pedir prestado un libro
3. Devolver un libro
4. Salir
Elige una opción: 2
Se ha prestado correctamente

=== MENÚ BIBLIOTECA ===
1. Ver información del libro
2. Pedir prestado un libro
3. Devolver un libro
4. Salir
Elige una opción: 2
Se ha prestado correctamente

=== MENÚ BIBLIOTECA ===
1. Ver información del libro
2. Pedir prestado un libro
3. Devolver un libro
4. Salir
Elige una opción: 2
Se ha prestado correctamente

=== MENÚ BIBLIOTECA ===
1. Ver información del libro
2. Pedir prestado un libro
3. Devolver un libro
4. Salir
Elige una opción: 2
No hay ejemplares disponibles

=== MENÚ BIBLIOTECA ===
1. Ver información del libro
2. Pedir prestado un libro
3. Devolver un libro
4. Salir
Elige una opción: 3
Se ha devuelto correctamente

=== MENÚ BIBLIOTECA ===
1. Ver información del libro
2. Pedir prestado un libro
3. Devolver un libro
4. Salir
Elige una opción: 4
Saliendo del sistema...
````

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

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 10
        System.out.print("Ingresa el primer numero: ");
        int numero1 = sc.nextInt();

        System.out.print("Ingresa el segundo numero: ");
        int numero2 = sc.nextInt();


        int opcione; 

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcione = sc.nextInt(); 
            sc.nextLine();
            int sumar = numero1 + numero2;
            int resta = numero1 - numero2;
            int multiplicacion = numero1 * numero2;
            int division = numero1 / numero2;
            

            switch (opcione) {
                case 1:
                    System.out.println("Suma: "+ sumar);
                    break;

                case 2:
                    System.out.println("resta: "+ resta);
                    break;

                case 3:
                    System.out.println("Multiplicacion: "+ multiplicacion);
                    break;

                case 4:
                    if (numero1 == 0 || numero2 == 0){
                        System.out.println("No se puede dividir entre 0");
                    } else {
                        System.out.println("Division: "+ division);
                    }
                        
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                    
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcione != 5);

        sc.close();
    }   
}
````


**Salida**  
````text
Ingresa el primer numero: 14
Ingresa el segundo numero: 22

=== MENÚ ===
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Elige una opción: 1
Suma: 36

=== MENÚ ===
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Elige una opción: 2
resta: -8

=== MENÚ ===
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Elige una opción: 3
Multiplicacion: 308

=== MENÚ ===
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Elige una opción: 4
Division: 0

=== MENÚ ===
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Elige una opción: 5
Saliendo...
````

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

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 11
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

**Salida**  
````text
¿Cuántos productos va a capturar? (máx 2): 2

Producto 1
Nombre del producto: Leche
Descripción: Leche
Costo del producto: 25
Impuesto (escribir sin sinbolo de porcentaje): 10

Producto 2
Nombre del producto: Cereal
Descripción: Cereal
Costo del producto: 33
Impuesto (escribir sin sinbolo de porcentaje): 10

Porcentaje de utilidad general (escribir sin simbolo de porcentaje): 5

____________________________________________
Nombre | Descripción | Costo | Impuesto% | Precio Final
____________________________________________
Leche | Leche | 25.0 | 10.0% | 28.875
Cereal | Cereal | 33.0 | 10.0% | 38.114999999999995
____________________________________________
````


---

## 12. Verificar si una frase es palíndromo (medio–alto)

**Enunciado**  
Pide una frase al usuario.  
Remueve espacios y conviértela a minúsculas.  
Luego, verifica si se lee igual de izquierda a derecha y de derecha a izquierda (palíndromo).  
No uses métodos de librerías que ya lo hagan directo: trabaja con índices o un arreglo de caracteres y un ciclo for o while.

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 12
          System.out.print("Ingresa una frase: ");
        String frase = sc.nextLine();

        String limpia = "";
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c != ' ') {
                if (c >= 'A' && c <= 'Z') {
                    c = (char)(c + 32); 
                }
                limpia += c;
            }
        }

        boolean esPalindromo = true;
        int i = 0;
        int j = limpia.length() - 1;

        while (i < j) {
            if (limpia.charAt(i) != limpia.charAt(j)) {
                esPalindromo = false;
                break;
            }
            i++;
            j--;
        }

        if (esPalindromo) {
            System.out.println("La frase ES un palíndromo");
        } else {
            System.out.println("La frase NO es un palíndromo");
        }

        sc.close();
    }   
}
````

**Salida**  
````text
Ingresa una frase: Hola como estas
La frase NO es un palíndromo
````

---

## 13. Matriz de notas (medio–alto)

**Enunciado**  
Un grupo tiene f estudiantes y cada uno tiene c materias.  
Pide f y c (por ejemplo máximo 5x5).  
Crea una matriz double[f][c] con las calificaciones.  
Luego:  

Calcula y muestra el promedio de cada estudiante.  

Calcula y muestra el promedio de cada materia.

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //parte 13
        int f, c;

        System.out.print("Ingresa el número de estudiantes: ");
        f = sc.nextInt();

        System.out.print("Ingresa el número de materias: ");
        c = sc.nextInt();

        double[][] calificaciones = new double[f][c];

        for (int e = 0; e < f; e++) {
            System.out.println("\nEstudiante " + (e + 1));
            for (int t = 0; t < c; t++) {
                System.out.print("Calificación de la materia " + (t + 1) + ": ");
                calificaciones[e][t] = sc.nextDouble();
            }
        }

        System.out.println("\n--- Promedio por estudiante ---");
        for (int e = 0; e < f; e++) {
            double suman = 0;
            for (int t = 0; t < c; t++) {
                suman += calificaciones[e][t];
            }
            double promedio = suman / c;
            System.out.println("Estudiante " + (e + 1) + ": " + promedio);
        }

        System.out.println("\n--- Promedio por materia ---");
        for (int t = 0; t < c; t++) {
            double suman = 0;
            for (int e = 0; e < f; e++) {
                suman += calificaciones[e][t];
            }
            double promedio = suma / f;
            System.out.println("Materia " + (t + 1) + ": " + promedio);
        }


        sc.close();
    }   
}
        
````


**Salida**  
````text
Ingresa el número de estudiantes: 4
Ingresa el número de materias: 2

Estudiante 1
Calificación de la materia 1: 80
Calificación de la materia 2: 77

Estudiante 2
Calificación de la materia 1: 65
Calificación de la materia 2: 90

Estudiante 3
Calificación de la materia 1: 70
Calificación de la materia 2: 80

Estudiante 4
Calificación de la materia 1: 50
Calificación de la materia 2: 100

--- Promedio por estudiante ---
Estudiante 1: 78.5
Estudiante 2: 77.5
Estudiante 3: 75.0
Estudiante 4: 75.0

--- Promedio por materia ---
Materia 1: 55.0
Materia 2: 55.0
````


---

## 14. Sistema simple de login con intentos limitados (medio–alto)

**Enunciado**  
Define, en el código, un usuario y contraseña correctos (por ejemplo, "admin" y "1234").  
Pide al usuario que ingrese usuario y contraseña, y valida con equals.  
Permite máximo 3 intentos.  
Si los datos son correctos, muestra "Acceso concedido" y termina.  
Si se alcanzan 3 intentos fallidos, muestra "Cuenta bloqueada" y termina.  
Usa un ciclo while o for para contar intentos.

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 14
        String user = "admin";
        int contra = 1234;

        boolean acceso = false;

        for (int intentos = 1; intentos <= 3; intentos++) {

            sc.nextLine();
            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Contraseña: ");
            int password = sc.nextInt();

            if (usuario.equals(user) && contra == password) {
                System.out.println("Acceso concedido");
                acceso = true;
                break;
            } else {
                System.out.println("Datos incorrectos. Intento " + intentos + " de 3");
                System.out.println("[" + usuario + "]");
                System.out.println("[" + password + "]");

            }
        }

        if (!acceso) {
            System.out.println("Cuenta bloqueada");
        }


        sc.close();
    }   
}
        
````

**Salida**  
````text
Usuario: yo:v
Contraseña: 1404
Acceso concedido
````


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

**Codigo**  
````java
package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //parte 15
                Articulo[] articulos = new Articulo[5];
        int opcioni;

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Agregar artículo");
            System.out.println("2. Mostrar artículos");
            System.out.println("3. Vender artículo");
            System.out.println("4. Reabastecer artículo");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            try {
                opcioni = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Opción inválida.");
                opcioni = 0;
            }

            switch (opcioni) {

                case 1: 
                    int posLibre = -1;
                    for (int w = 0; w < articulos.length; w++) {
                        if (articulos[w] == null) {
                            posLibre = w;
                            break;
                        }
                    }

                    if (posLibre == -1) {
                        System.out.println("No hay espacio para más artículos.");
                        break;
                    }

                    try {
                        System.out.print("Código: ");
                        String codigo = sc.nextLine();

                        System.out.print("Descripción: ");
                        String descripcion = sc.nextLine();

                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(sc.nextLine());

                        System.out.print("Existencia: ");
                        int existencia = Integer.parseInt(sc.nextLine());

                        articulos[posLibre] = new Articulo(codigo, descripcion, precio, existencia);
                        System.out.println("Artículo agregado correctamente.");

                    } catch (Exception e) {
                        System.out.println("Error en los datos ingresados.");
                    }
                    break;

                case 2: 
                    System.out.println("\n--- ARTÍCULOS ---");
                    for (Articulo a : articulos) {
                        if (a != null) {
                            a.mostrar();
                        }
                    }
                    break;

                case 3: 
                    System.out.print("Código del artículo: ");
                    String codVenta = sc.nextLine();

                    System.out.print("Cantidad a vender: ");
                    try {
                        int cant = Integer.parseInt(sc.nextLine());
                        boolean encontrado = false;

                        for (Articulo a : articulos) {
                            if (a != null && a.getCodigo().equals(codVenta)) {
                                encontrado = true;
                                if (a.actualizarExistencia(-cant)) {
                                    System.out.println("Venta realizada. Nueva existencia: " + a.getExistencia());
                                }
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Artículo no encontrado.");
                        }

                    } catch (Exception e) {
                        System.out.println("Cantidad inválida.");
                    }
                    break;

                case 4: 
                    System.out.print("Código del artículo: ");
                    String codRestock = sc.nextLine();

                    System.out.print("Cantidad a agregar: ");
                    try {
                        int cant = Integer.parseInt(sc.nextLine());
                        boolean encontrado = false;

                        for (Articulo a : articulos) {
                            if (a != null && a.getCodigo().equals(codRestock)) {
                                encontrado = true;
                                a.actualizarExistencia(cant);
                                System.out.println("Reabastecimiento realizado. Nueva existencia: " + a.getExistencia());
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Artículo no encontrado.");
                        }

                    } catch (Exception e) {
                        System.out.println("Cantidad inválida.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcioni != 5);

        sc.close();
    }   
}
        
````


**Salida**  
````text
=== MENÚ ===
1. Agregar artículo
2. Mostrar artículos
3. Vender artículo
4. Reabastecer artículo
5. Salir
Opción: Opción inválida.
Opción no válida.

=== MENÚ ===
1. Agregar artículo
2. Mostrar artículos
3. Vender artículo
4. Reabastecer artículo
5. Salir
Opción: 1
Código: 12
Descripción: comida
Precio: 33
Existencia: 2
Artículo agregado correctamente.

=== MENÚ ===
1. Agregar artículo
2. Mostrar artículos
3. Vender artículo
4. Reabastecer artículo
5. Salir
Opción: 2

--- ARTÍCULOS ---
Código: 12, Descripción: comida, Precio: 33.0, Existencia: 2

=== MENÚ ===
1. Agregar artículo
2. Mostrar artículos
3. Vender artículo
4. Reabastecer artículo
5. Salir
Opción: 3
Código del artículo: 12
Cantidad a vender: 1
Venta realizada. Nueva existencia: 1

=== MENÚ ===
1. Agregar artículo
2. Mostrar artículos
3. Vender artículo
4. Reabastecer artículo
5. Salir
Opción: 4
Código del artículo: 12
Cantidad a agregar: 1
Reabastecimiento realizado. Nueva existencia: 2

=== MENÚ ===
1. Agregar artículo
2. Mostrar artículos
3. Vender artículo
4. Reabastecer artículo
5. Salir
Opción: 5
Saliendo...
````

