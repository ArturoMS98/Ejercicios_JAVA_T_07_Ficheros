package t_07_ej_02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 10, 2019 8:22:28 PM<p>                                                               *
 * <p>nombre del proyecto: T_07_Ej_02.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>2. Modificar el programa anterior para que sea el usuario el que decida el nombre del fichero a                   *
 *       crear, el cual será pasado como parámetro a través de la línea de comandos.</p>                                *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: 0 horas 04 minutos 43 segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class T_07_Ej_02 {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Creamos un fichero y mostramos si se ha podido crear. Lo haremos sumando dos Strings en el constructor</p>     *
    *    Además, pediremos al usuario el nombre de dicho fichero a crear.                                               *
    *                                                                                                                   *
    ********************************************************************************************************************/
    public static void main(String[] args) throws IOException {
      // CONSTANTES //
        //ruta donde estarán todos los archivos que se crearán a partir de ahora//
        //final String RUTA_ARCHIVOS = "/home/baha/NetbeansProyects/Ejercicios_JAVA_T_07_Ficheros/T_07_Ej_01/ficheros/ NO
        final String RUTA_ARCHIVOS = "/home/baha/FicherosNetBeans/";
        final String ARCHIVO_CREADO = "El archivo ya estaba creado";
        final String ARCHIVO_NO_CREADO = "El archivo no estaba creado, y hay que crearlo.";
        final String ESCRIBIR_LINEA = "Escribimos la primera linea del fichero";
        final String SOBREESCRIBIR_LINEA = "Sobrescribimos la primera linea del fichero";

        Scanner in = new Scanner(System.in);
        
       // CREAMOS DE FICHEROS //
        System.out.println("INTRODUZCA EL NOMBRE DEL PRIMER FICHERO");
        File archivo1 = new File(RUTA_ARCHIVOS + in.nextLine());
        System.out.println("INTRODUZCA EL NOMBRE DEL SEGUNDO FICHERO");
        File archivo2 = new File(RUTA_ARCHIVOS + in.nextLine());
        BufferedWriter bw1;
        BufferedWriter bw2;
        
      //Escribimos sobre fichero1//
        if(archivo1.exists())
        {
            System.out.println(ARCHIVO_CREADO);
            bw1 = new BufferedWriter(new FileWriter(archivo1));
            bw1.write(SOBREESCRIBIR_LINEA);
        }
        else
        {
            System.out.println(ARCHIVO_NO_CREADO);
            bw1 = new BufferedWriter(new FileWriter(archivo1));
            bw1.write(ESCRIBIR_LINEA);
        }
      //Escribimos sobre fichero2//
        if(archivo2.exists())
        {
            System.out.println(ARCHIVO_CREADO);
            bw2 = new BufferedWriter(new FileWriter(archivo2));
            bw2.write(SOBREESCRIBIR_LINEA);
        }
        else
        {
            System.out.println(ARCHIVO_NO_CREADO);
            bw2 = new BufferedWriter(new FileWriter(archivo2));
            bw2.write(ESCRIBIR_LINEA);
        }
      // CERRAMOS BUFFERS //
        bw1.close();
        bw2.close();
    }
}