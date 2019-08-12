package t_07_ej_04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 10, 2019 8:56:43 PM<p>                                                               *
 * <p>nombre del proyecto: T_07_Ej_04.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>4. Implementar un programa que pregunte al usuario una ruta y un fichero para crear dicho                         *
 *       fichero en la ruta elegida. El programa se detendrá cuando el usuario lo desee, es decir, creará               *
 *       tantos ficheros como quiera.</p>                                                                               *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: 0 horas 22 minutos 42 segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class T_07_Ej_04 {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Mantenemos un bucle mientras el usuario responda que si, y solo lo cerraremos cuando diga que no.              *
    *    Mientras que el usuario diga que si, se le pedirá una ruta y un fichero a crear en dicha ruta.                 *
    *    dicha ruta o fichero estará creado a partir de la carpeta RUTA_ARCHIVOS</p>                                    *
    *                                                                                                                   *
    ********************************************************************************************************************/
    public static void main(String[] args) throws IOException{
      // CONSTANTES //
        final String RUTA_ARCHIVOS = "/home/baha/FicherosNetBeans/";
        
      // VARIABLES LOCALES //
        String centinela;
        String ruta;
        Scanner in = new Scanner(System.in);
        
        do
        {
            // CREACION DE LA RUTA DEL FICHERO //
            System.out.print("Introduzca el directorio en que colocar el fichero: " + RUTA_ARCHIVOS);
            ruta = in.nextLine();
            new File(RUTA_ARCHIVOS + ruta).mkdirs();
            
            // CREACION DEL FICHERO //
            System.out.println("Introduzca ahora el nombre del fichero: ");
            System.out.print(RUTA_ARCHIVOS + ruta + "/");
            new File(RUTA_ARCHIVOS + ruta + "/" + in.nextLine()).createNewFile();
            
            // CENTINELA //
            do
            {
                System.out.println("¿Desea crear otro fichero? SI // NO");
                centinela = in.nextLine();
            }while(!centinela.equalsIgnoreCase("si") && !centinela.equalsIgnoreCase("no"));
            
        }while(centinela.equalsIgnoreCase("si"));
    }
}