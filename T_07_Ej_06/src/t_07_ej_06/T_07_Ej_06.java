package t_07_ej_06;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 10, 2019 10:06:10 PM<p>                                                              *
 * <p>nombre del proyecto: T_07_Ej_06.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>6. Implementar un programa que averigue el número de líneas de un fichero de texto pasado                         *
 *       como parámetro a través de la línea de comandos.</p>                                                           *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: 0 horas 15 minutos 42 segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class T_07_Ej_06 {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Buscar el archivo con la ruta que se le pasa desde la linea de comandos, y una vez encontrado, recorrerlo      *
    *    linea a linea, aumentando el contador de lineas del archivo en 1 por cada vez que se recorra.</p>              *
    *                                                                                                                   *
    ********************************************************************************************************************/
    public static void main(String[] args) throws FileNotFoundException, IOException {
      // CONSTANTES //
        
      // VARIABLES LOCALES //
        String nextLine;
        int contadorLineas = 0;
      // CREACION DE FICHEROS //
        File archivo = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        
        while((nextLine = br.readLine()) != null)   //IMPORTANTE VER QUE PUEDES ASIGNAR VALORES EN UN WHILE//
        {
            contadorLineas++;
        }
        
        System.out.println("El numero de lineas del fichero es de: " + contadorLineas);
      // CERRAMOS BUFFERS //
        br.close();
    }
}