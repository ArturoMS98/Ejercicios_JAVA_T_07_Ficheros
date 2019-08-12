package t_07_ej_09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 12, 2019 5:25:33 PM<p>                                                               *
 * <p>nombre del proyecto: T_07_Ej_09.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>9. El archivo CARTAS.DAT contiene un texto con un modelo genérico de carta. Se le desea añadir                    *
 *       el nombre de cada cliente, justo detrás de la palabra “querid@”. Los nombres de los clientes                   *
 *       están en el archivo NOMBRES.DAT</p>                                                                            *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: 1 horas 04 minutos 06 segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class T_07_Ej_09 {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Coger el modelo de carta, y por cada nombre, crear un modelo de carta destinado a dicho nombre.                *
    *    almacenará las cartas creadas en el archivo ENVIOS.DAT</p>                                                     *
    *                                                                                                                   *
    ********************************************************************************************************************/
    public static void main(String[] args) {
      // CONSTANTES //
        final String RUTA_ARCHIVOS = "/home/baha/FicherosNetBeans/";
        final String RUTA_CARTAS = "CARTAS.DAT";
        final String RUTA_NOMBRES = "NOMBRES.DAT";
        final String RUTA_ENVIOS = "ENVIOS.DAT";
        
        final String ERROR_LECTURAESCRITURA = "Error de lectura/escritura:\n";
        
      // VARIABLES LOCALES //
        BufferedReader brCartas;
        BufferedReader brNombres;
        BufferedWriter bwEnvios;
        String lineaNombres;
        String lineaCartas;
        
      // CREACION DE FICHEROS //
        File cartas = new File(RUTA_ARCHIVOS + RUTA_CARTAS);
        File nombres = new File(RUTA_ARCHIVOS + RUTA_NOMBRES);
        File envios = new File(RUTA_ARCHIVOS + RUTA_ENVIOS);
        
      // CREACION DE BUFFERS //
        try
        {
            brCartas = new BufferedReader(new FileReader(cartas));  //Para que si en nombres no hay lineas, aun asi se cree brCartas
            brNombres = new BufferedReader(new FileReader(nombres));
            bwEnvios = new BufferedWriter(new FileWriter(envios));
        }catch(FileNotFoundException ex)
        {
            System.err.println(ARCHIVO_NO_ENCONTRADO + ex);
            return;
        }
        catch(IOException ex)
        {
            System.err.println("No se puede escribir sobre el archivo envios:\n" + ex);
            return;
        }
        
      // COPIAMOS LAS CARTA //
        try
        {
            while((lineaNombres = brNombres.readLine()) != null)
            {
                brCartas = new BufferedReader(new FileReader(cartas));
                
                // ESCRIBIMOS LA PRIMERA LINEA //
                bwEnvios.write(brCartas.readLine() + lineaNombres);
                bwEnvios.newLine();
                // ESCRIBIMOS EL RESTO DE LA CARTA //
                while((lineaCartas = brCartas.readLine()) != null)
                {
                    bwEnvios.write(lineaCartas);
                    bwEnvios.newLine();
                }
                bwEnvios.newLine();
                bwEnvios.newLine();
            }
        }
        catch(FileNotFoundException ex)
        {
            System.err.println(ARCHIVO_NO_ENCONTRADO + ex);
            return;
        }catch(IOException ex)
        {
            System.out.println(ERROR_LECTURAESCRITURA + ex);
            return;
        }

        // CERRAMOS BUFFERS //
        try
        {
            bwEnvios.close();
            brCartas.close();
            brNombres.close();
        }catch(IOException ex)
        {
            System.out.println(ERROR_LECTURAESCRITURA + ex);
        }
    }
    private static final String ARCHIVO_NO_ENCONTRADO = "El archivo no fue encontrado:\n";
}