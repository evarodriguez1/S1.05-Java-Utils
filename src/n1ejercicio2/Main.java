/*
 Añada a la clase del nivel anterior la funcionalidad de listar un árbol de directorios 
 con el contenido de todos sus niveles (recursivamente) 
 de modo que se impriman en pantalla en orden alfabético dentro de cada nivel, 
 indicando además si es un directorio (D) o un archivo (F), y su última fecha de modificación.
 */
package n1ejercicio2;

import java.io.File;
import java.util.Date;
import java.util.Arrays;


public class Main {
	
	public static void main(String[] args) {
		
		
		 buscarEnDirectorio(new File("C:\\Users\\maeva\\Downloads"));  //----> llamada al metodo y como parametro recibe la instancia del obj File con la ruta

    }
	
	public static void buscarEnDirectorio(File directorio) {
        System.out.println("D: " + directorio);   //-----> se imprime el nombre del directorio
        File[] listado = directorio.listFiles();  //-----> se crea la lista de array de la clase File
        Arrays.sort(listado);                    //------> se ordena el array
        if (listado!=null) {
            for(File file:listado) {     //----> se recorre el listado
                if (file.isDirectory())   //----> si es directorio (carpeta), entra a buscar en el directorio las carpetas y archivos que contiene
                    buscarEnDirectorio(file);  //-----> recursividad = llamarse a si mismo
                else {
                    System.out.println("F: "+file+"***"+new Date(file.lastModified()));  //------> se imprimen todos los archivos con la ultima fecha de modificacion
                }
            }
        }else {
           System.out.println("F: "+directorio);
        }
    }

}