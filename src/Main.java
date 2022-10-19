import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
         * 1.- Desarrolla una aplicación en Java que abra el número de ventanas del navegador de tu elección
         * que indique el usuario. Puede indicarlo como entrada de teclado o como argumento del ejecutable.
         * El proceso debe terminar cuando todas las ventanas del navegador se cierren. (3 puntos)
         */

        // Página con información relacionada al ejercicio. (Fuentes)
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/ProcessBuilder.html
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Process.html

        // Instanciamos un Scanner para leer por teclado el num de ventanas
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de ventanas que quieres abrir: ");
        int numVentanas = scanner.nextInt();
        scanner.nextLine();

        // Creamos un ArrayList de procesos para almacenar los procesos que iniciamos
        ArrayList<Process> listaProcesos = new ArrayList<Process>();

        // Configuramos un pb con el comando notepad
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("notepad");

        // Ejecutamos tantos procesos como nos pida el usuario
        try {
            for (int i = 0; i < numVentanas; i++) {
                listaProcesos.add(processBuilder.start());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Comprobamos si hay algún proceso activo dentro de la lista
        int numInactives = 0;
        while (numInactives != listaProcesos.size()) {
            numInactives = 0;

            for (int i = 0; i < listaProcesos.size(); i++) {
                if (!listaProcesos.get(i).isAlive()) {
                    numInactives++;
                }
            }
        }


        // Cuando no hay ningún proceso activo muestra un mensaje final
        System.out.println("Se han cerrado todas las ventanas");
    }
}
