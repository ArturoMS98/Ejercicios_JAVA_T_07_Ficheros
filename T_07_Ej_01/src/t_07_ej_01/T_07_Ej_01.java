package t_07_ej_01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 8, 2019 1:27:18 PM<p>                                                                *
 * <p>nombre del proyecto: T_07_Ej_01.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>1. Escribir un programa en Java que cree un fichero mostrando si se ha podido crear o no.</p>                     *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: 1 horas 02 minutos 46 segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class T_07_Ej_01 {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Creamos un fichero y mostramos si se ha podido crear. Lo haremos sumando dos Strings en el constructor</p>     *
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

       // CREAMOS DE FICHEROS //
        File archivo1 = new File(RUTA_ARCHIVOS + "T_07_Ej01_1.txt");
        File archivo2 = new File(RUTA_ARCHIVOS + "T_07_Ej01_2.md");
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
      // CERRAMOS FICHEROS //
        bw1.close();
        bw2.close();
    }
}