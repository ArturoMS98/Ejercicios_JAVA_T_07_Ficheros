package t_07_ej_05;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 10, 2019 9:30:26 PM<p>                                                               *
 * <p>nombre del proyecto: T_07_Ej_05.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>5. Basándonos en los métodos de la clase File para obtener información sobre un archivo,                          *
 *       implementar un programa que pregunte al usuario por un archivo y muestre toda la información                   *
 *       posible acerca del mismo.</p>                                                                                  *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: 0 horas 27 minutos 50 segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class T_07_Ej_05 {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Pregunta al usuario por la ruta y nombre del archivo, y muestra la informacion contenida en el si existe.</p>  *
    *                                                                                                                   *
    ********************************************************************************************************************/
    public static void main(String[] args) {
      // CONSTANTES //
        final String RUTA_ARCHIVOS = "/home/baha/FicherosNetBeans/";
        
      // VARIABLES LOCALES //
        String rutaArchivo;
        Scanner in = new Scanner(System.in);

      //PETICION DE DATOS//
        System.out.print("Introduce la ruta al archivo a mostrar: " + RUTA_ARCHIVOS);
        rutaArchivo = in.nextLine();
        
      // DECLARACION DEL ARCHIVO //
            File fichero = new File(RUTA_ARCHIVOS + rutaArchivo);
            
      // MOSTRAMOS LA INFORMACION DEL ARCHIVO //
            if(fichero.exists())
            {
                System.out.println("SE MOSTRARÁ AHORA LA INFORMACIÓN DEL FICHERO: ");
                System.out.println("RUTA: " + fichero.getAbsolutePath());
                System.out.println("Espacio total reservado para el fichero: " + fichero.getTotalSpace() + " bits");
                System.out.println("Longitud: " + fichero.length() + " caracteres");
                System.out.println("Ultima vez modificado: " + new Date(fichero.lastModified()));
            }
            else
                System.out.println("El fichero no ha sido encontrado");
    }
}