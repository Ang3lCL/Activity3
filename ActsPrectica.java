package actividad_3;

import java.util.Scanner;

public class ActsPrectica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parte 1

        System.out.print("dame un numero entero: ");
        int numEnt1 = sc.nextInt(); 
        System.out.print("dame otro numero entero: ");
        int numEnt2 = sc.nextInt(); 

        int suma1 = numEnt1 + numEnt2;
        System.out.println("la suma de " + numEnt1 + " y " + numEnt2 + " es: " + suma1);
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
        
        for (int i = 0; i < 10; i++)
            System.out.println( + numEntx + " x " + i + " = " + (numEntx * i));

        sc.close();

    }
}
