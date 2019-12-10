package introspeccion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class UsoEmpleado {

    public static void main(String[] args) throws ClassNotFoundException {

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.print("1. Nombre de la clase\n"
                    + "2. Constructores\n"
                    + "3. Fields\n"
                    + "4. Methods\n"
                    + "5. Salir\n"
                    + "Introduzca una opción: ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    nombreClase();
                    break;
                case 2:
                    nombreConstructores();
                    break;
                case 3:
                    Atributos();
                    break;
                case 4:
                    Metodos();
                    break;
            }

        } while (opcion != 5);
    }

    private static void nombreClase() {
        String clase;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el paquete.clase: ");
        clase = entrada.next();
        Class c1;
        try {
            c1 = Class.forName(clase);
            System.out.println("DEVUELVE:\n" + c1.getName());
        } catch (ClassNotFoundException ex) {
            System.out.println("DEVUELVE:\nLa clase no existe");
        }
    }

    private static void nombreConstructores() {
        String clase;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el paquete.clase: ");
        clase = entrada.next();
        Class c1;
        try {
            c1 = Class.forName(clase);

            Constructor constructores[] = c1.getConstructors();
            for (int i = 0; i < constructores.length; i++) {
                System.out.println("DEVUELVE:\n" + constructores[i].toGenericString());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("DEVUELVE:\nLa clase no existe");
        }
    }

    private static void Atributos() {
        String clase;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el paquete.clase: ");
        clase = entrada.next();
        Class c1;
        try {
            c1 = Class.forName(clase);
            Field fields[] = c1.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println("DEVUELVE:\n" + fields[i].toGenericString());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("DEVUELVE:\nLa clase no existe");
        }
    }

    private static void Metodos() {
        String clase;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el paquete.clase: ");
        clase = entrada.next();
        Class c1;
        try {
            c1 = Class.forName(clase);
            Method metodo[] = c1.getMethods();
            for (int i = 0; i < metodo.length; i++) {
                System.out.println("DEVUELVE:\n" + metodo[i].toGenericString());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("DEVUELVE:\nLa clase no existe");
        }
    }
}

class Persona {

    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Empleado extends Persona {

    private double salario;

    public Empleado(String nombre, double salario) {
        super(nombre);
        this.salario = salario;
    }

    public void setIncentivo(double incentivo) {
        salario = salario + incentivo;
    }

    public String getSalario() {
        return "El salario es: " + salario;
    }
}
