package criba_eratostenes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 12, 2019 7:12:59 PM<p>                                                               *
 * <p>nombre del proyecto: Criba_Eratostenes.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>Escribir un programa que calcule los números primos de 0 a n utilizando el llamado método de la criba de          *
 *    Eratóstenes. Este método consiste en definir e inicializar con todos sus elementos a true un array de n elementos *
 *    binarios e ir “tachando” (pasando a false) en pasadas sucesivas todos los múltiplos de los números primos (2, 3,  *
 *    5, 7...) hasta obtener sólo los números primos.                                                                   *
 *    Una vez calculados todos los números primos, se deberán escribir en un fichero binario llamado “primos.dat”.      *
 *    Implementar también un método para mostrar el contenido del fichero.                                              *
 *    Se pedirá al usuario el número n.</p>                                                                             *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: 1 horas 18 minutos 33 segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class Criba_Eratostenes {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Crear un array de booleanos en el que en cada posición se irá almacenando si un número es o no es primo.       *
    *    Entonces, llamar al método CribaEratostenes, por medio del cual dicho array se irá pasando a false si los      *
    *    números no son primos. El tamaño del array lo indicará el usuario.</p>                                         *
    *                                                                                                                   *
    ********************************************************************************************************************/
    public static void main(String[] args) {
      // CONSTANTES //
        final String RUTA_ARCHIVOS = "/home/baha/FicherosNetBeans/";
        
      // VARIABLES LOCALES //
        FileOutputStream fos;   //ESTE CREA EL FICHERO//
        DataOutputStream dos;   //ESTE PERMITE METER BINARIOS EN EL FICHERO//
        FileInputStream fis;
        DataInputStream dis;
        
        Scanner in = new Scanner(System.in);
        int n;
        
      // PETICION DE DATOS //
        System.out.print("Introduce el número hasta el que calcular los números primos: ");
        n = in.nextInt();
        
      // CREACION DEL ARRAY //
        boolean[] criba = new boolean[n];
        
      // PASAMOS LAS POSICIONES DEL ARRAY A TRUE //
        conversorTrue(criba);
        
      // LLAMADA AL MÉTODO CALCULADOR DE PRIMOS //
        cribaEratostenes(criba);
        
      // PASAMOS LOS PRIMOS A UN FICHERO BINARIO //
        try
        {
            fos = new FileOutputStream(RUTA_ARCHIVOS + "primos.dat");
            dos = new DataOutputStream(fos);
            fis = new FileInputStream(RUTA_ARCHIVOS + "primos.dat");
            dis = new DataInputStream(fis);
            for(int i = 0; i < criba.length; i++)
            {
                if(criba[i])
                    dos.writeInt(i+1);
            }
        }catch(FileNotFoundException ex)
        {
            System.err.println("La ruta en la que crear el archivo no existe: " + ex);
            return;
        }catch(IOException ex)
        {
            System.err.println(ex);
            return;
        }
      
      // MOSTRAMOS ARRAY //
        try
        {
            while(true)
            {
                System.out.println(dis.readInt());
            }
        }catch(FileNotFoundException ex)
        {
            System.err.println("Archivo no encontrado" + ex);
        }
        catch(EOFException ex)
        {
            System.out.println("Se ha llegado al final del fichero: " + ex);
        }
        catch(IOException ex)
        {
            System.err.println("Algo salió mal con la entrada/salida" + ex);
        }
        
      // CERRAMOS STREAMS //
        try
        {
            fos.close();
            dos.close();
            dis.close();
            fis.close();
        }catch(IOException ex)
        {
            System.err.println(ex);
        }
    }
    

    //Metodos suplementarios de la clase principal//

    /**_________________________________________________________________________________________________________________
     | ~~~~<p>Función del metodo:</p>~~~~                                                                               |
     | <p>Pasar a false las posiciones del array que sean números primos, considerando que el primer número es el 1</p> |
     | ~~~~<p>Parámetros:</p>~~~~                                                                                       |
     | @param numeros trata del array de booleanos que hay que pasar a false si es primo.                             |
     | @return el array convertido.                                                                                     |
     | ~~~~<p>Método dirigido a:   BackEnd</p>~~~~                                                                      |
     |_________________________________________________________________________________________________________________*/
    static void cribaEratostenes(boolean[] numeros)
    {
        //VARIABLES LOCALES//
        
        //CUERPO DEL METODO//
        for(int i = 0; i < numeros.length; i++)
        {
            for(int j = 2; j <= (i+1)/2; j++)
            {
                if(((i+1)%j) == 0)
                {
                    numeros[i] = false;
                }
            }
        }
    }
    
    /**_________________________________________________________________________________________________________________
     | ~~~~<p>Función del metodo:</p>~~~~                                                                               |
     | <p>Pasar a TRUE las posiciones del array</p>                                                                     |
     | ~~~~<p>Parámetros:</p>~~~~                                                                                       |
     | @param numeros trata del array de booleanos que hay que pasar a true.                                            |
     | @return el array convertido a true.                                                                              |
     | ~~~~<p>Método dirigido a:   BackEnd</p>~~~~                                                                      |
     |_________________________________________________________________________________________________________________*/
    static void conversorTrue(boolean[] numeros)
    {
        //CUERPO DEL METODO//
        for(int i = 0; i < numeros.length; i++)
        {
            numeros[i] = true;
        }
    }
}