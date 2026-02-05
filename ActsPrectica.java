package actividad_3;

import java.util.Scanner;

public class ActsPrectica {

    public static boolean Orden(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++){
            if (arreglo[i] < arreglo[i - 1]){
                return false;
            }
        }
    }
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
        
        for (int i = 1; i < 10; i++)
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
        System.out.println("cantidad de vocales: " + voca);
        System.out.println("cantidad de consonantes: " + cons);

        //parte 6
        System.out.println("dame un numero (1 al 10): ");
        numee = sc.nextInt();
        
        for (int e = 0; e < numee(); e++); {}
            



        }
        sc.close();
    }
}

