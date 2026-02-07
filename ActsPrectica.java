package actividad_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActsPrectica {



    public static boolean Orden(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] < arreglo[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int buscarElemento(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1; 
    }

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
                sc.nextLine(); // limpiar buffer
            }
        }

        int suma1 = numEnt1 + numEnt2;
        System.out.println("La suma de " + numEnt1 + " y " + numEnt2 + " es: " + suma1);
        sc.nextLine();

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

        //parte 3
        System.out.print("dame un numero entero: ");
        int numEntx = sc.nextInt();
        
        for (int i = 1; i < 11; i++)
            System.out.println( + numEntx + " x " + i + " = " + (numEntx * i));

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
        

        



