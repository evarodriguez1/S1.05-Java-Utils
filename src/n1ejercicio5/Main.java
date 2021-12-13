/*
  Mostrar cómo serializar un Objeto Java a un archivo .ser y deserialícelo después.
  Serializar es = a convertir en Bytes, para meten en un pendrive o disco duro x ej. o tambien poder distribuirlo por la red a ordenadores
  remotos y que en esos ordenadores ese objeto pueda ser reestablecido al estado en el que estaba cuando se serealizò
 */
package n1ejercicio5;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[]args) throws IOException {
		String [] nombres = {"Eva","Ambar","Charly"};
		int [] edad = null;
		
		try { 
			String archivo = "pruebaSerializable.txt"; //----> se crea un archivo que recogera datos
			FileOutputStream file = new FileOutputStream(archivo); //--->crea un fichero, salvo que exista y sea solo de lectura
			ObjectOutputStream f = new ObjectOutputStream(file);  // ---> Un objeto ObjectOutputStream se crea a partir de un objeto FileOutputStream asociado al fichero.
			f.writeObject(nombres); // ---> 
			f.close();  // --->
			
			} 
		catch (Exception e) {
			e.getMessage();
		}
		
		
		try {
			String archivo = "pruebaSerializable.txt"; // ---> se recoge el archivo en la raiz
			FileInputStream arch = new FileInputStream(archivo) ;
			ObjectInputStream a = new ObjectInputStream(arch) ;
			
			edad = (int[]) a.readObject(); // ---> se cogen los datos del archivo y se lo añadimos a la nueva variable edad
			System.out.println(edad);
			a.close();
			arch.close();

		}
		catch (Exception e) {
			e.getMessage();
		}
	}
}
