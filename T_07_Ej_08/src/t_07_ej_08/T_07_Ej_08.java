package t_07_ej_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 12, 2019 3:29:28 PM<p>                                                               *
 * <p>nombre del proyecto: T_07_Ej_08.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>8. Escribir un programa que emule el comando copy o cp de cualquier sistema operativo, pero                       *
 *       sólo para ficheros de texto. Debe usarse la siguiente sintaxis:                                                *
 *                      java ejer8 original copia</p>                                                                   *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: 1 horas 35 minutos 22 segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class T_07_Ej_08 {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Cada vez que se le invoque con dos argumentos ruta, debe copiar el archivo de texto de la ruta 1 en un nuevo   *
    *    archivo creado en la ruta 2</p>                                                                                *
    * @param args son dos rutas introducidas al acceder al programa.                                                    *
    *   args[0] es la ruta origen de la que copiar.                                                                     *
    *   args[1] es la ruta en la que copiar el archivo.                                                                 *
    *                                                                                                                   *
    ********************************************************************************************************************/
    public static void main(String[] args) {
      // CONSTANTES //
        final String RUTA_ARCHIVOS = "/home/baha/FicherosNetBeans/";
        final String ERROR_ENTRADA_SALIDA = "Hubo un error de Entrada / Salida";
        final String ERROR_ORIGEN_NO_EXISTE = "La ruta origen no contenia ningun fichero ya existente para copiar.";
        final String ERROR_ARGUMENTOS = "Por favor, introduzca dos argumentos al acceder al programa.";
        
      // VARIABLES LOCALES //
        String original;
        String copia;
        
      // CONTROL DE ARGUMENTOS DEL PROGRAMA //
        try
        {
            original = args[0];
            copia = args[1];
        }catch(ArrayIndexOutOfBoundsException exc)
        {
            System.err.println(ERROR_ARGUMENTOS);
            System.err.println(exc);
            return;
        }
        if(args.length > 2)
        {
            System.out.println("Este programa no permite la creación de varias copias del programa.");
            System.err.println(ERROR_ARGUMENTOS);
            return;
        }
        
      // CREACION DE FICHEROS //
        File origin = new File(original);
        File copy = new File(copia);
        BufferedReader br;
        BufferedWriter bw;
        String linea;
        try
        {
            br = new BufferedReader(new FileReader(origin));
            bw = new BufferedWriter(new FileWriter(copy));
        }catch(FileNotFoundException exBR)
        {
            System.out.println(ERROR_ORIGEN_NO_EXISTE);
            System.err.println(exBR);
            return;
        }
        catch(IOException exBW)
        {
            System.err.println(ERROR_ENTRADA_SALIDA);
            System.err.println(exBW);
            return;
        }
        
      // COPIAMOS EL FICHERO //
        try
        {
            while((linea = br.readLine()) != null)
            {
                bw.write(linea);    //¿Hace falta pasar de linea en el write? SI.//
                bw.newLine();
            }
        }catch(IOException exLectura)
        {
            System.err.println(ERROR_ENTRADA_SALIDA + exLectura);
            return;
        }
      
      // CERRAMOS BUFFERS //
        try 
        {
            bw.close();
            br.close();
        } catch (IOException ex)
        {
            System.err.println("ERROR AL CERRAR LOS BUFFERS: " + ex);
        }
    }
}