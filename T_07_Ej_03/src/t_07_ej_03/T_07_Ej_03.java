package t_07_ej_03;

import java.io.File;

 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 10, 2019 8:32:16 PM<p>                                                               *
 * <p>nombre del proyecto: T_07_Ej_03.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>3. Escribir un programa en Java que cree un directorio mostrando si se ha podido crear o no. La                   *
 *       ruta será pasada como parámetro a través de la línea de comandos.</p>                                          *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: 0 horas 24 minutos 00 segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class T_07_Ej_03 {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Crea un directorio con mkdir, y muestra si se ha podido o no crear.</p>                                        *
    *                                                                                                                   *
    ********************************************************************************************************************/
    public static void main(String[] args) {
      // CONSTANTES //
        final String RUTA_ARCHIVOS = "/home/baha/FicherosNetBeans/";
        
        // CREACION DE FICHEROS //
        File directorio = new File(RUTA_ARCHIVOS + args[0]);
        
        // COMPROBACION DE EXISTENCIA DE RUTA_ARCHIVOS //
        if(!new File(RUTA_ARCHIVOS).exists())
            System.out.println("Es necesario crear el directorio " + RUTA_ARCHIVOS);
        
        if(!directorio.exists())
        {
            // CREAMOS EL DIRECTORIO //
            directorio.mkdir();
                //FRONTEND//
                if(directorio.exists())
                    System.out.println("El directorio se ha creado correctamente");
                else
                    System.out.println("El directorio no ha podido ser creado");
        }
        else
            System.out.println("El directorio ya existía");
    }
}