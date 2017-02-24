package principal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.*;

public class Main {
	
	
	public final static int INSERTAR_LIBRO = 1;
	public final static int INSERTAR_SOCIO = 2;
	public final static int VER_LIBROS = 3;
	public final static int VER_SOCIOS = 4;
	public final static int VER_LIBRO_POR_ID = 5;
	public final static int VER_SOCIO_POR_ID = 6;
	public final static int DELETE_LIBRO_POR_ID = 7;
	public final static int DELETE_SOCIO_POR_ID = 8;
	public final static int VER_LIBROS_POR_AUTOR = 9;
	public final static int SALIR = 10;
	
    int id;
	
	public static void main(String[] args) {
		// MAIN DE PRUEBA PARA LIBRO

		// Instanciar

		Libro_modelo lm = new Libro_modelo("biblioteka");
		Socio_modelo sm = new Socio_modelo("biblioteka");
		
		Scanner scan = new Scanner(System.in);

		int opcion;
		do {
			System.out.println("\n~~~~~ MENÚ PRINCIPAL ~~~~~");
			System.out.println("1. Insertar libro");
			System.out.println("2. Insertar socio");
			System.out.println("3. Ver libros");
			System.out.println("4. Ver socios");
			System.out.println("5. Ver libro por id");
			System.out.println("6. Ver socio por id");
			System.out.println("7. Delete libro por id");
			System.out.println("8. Delete socio por id");
			System.out.println("9. Ver libros por autor");
			System.out.println("10. Salir del menú\n");
			
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {

			case INSERTAR_LIBRO: // INSERT LIBRO
				System.out.println("Introduce el titulo del libro:");
				String titulo = scan.nextLine();
				
				System.out.println("Introduce el autor del libro:");
				String autor = scan.nextLine();
				System.out.println("Introduce el numero de paginas del libro:");
				int num_pag = Integer.parseInt(scan.nextLine());
				
				lm.insert(new Libro(0, titulo, autor, num_pag));
				break;

			case INSERTAR_SOCIO: // INSERT SOCIO
				
				System.out.println("Mete los siguientes datos requeridos.");
				System.out.print("Nombre:");
				String nombre = scan.nextLine();
				System.out.print("Apellido:");
				String apellido = scan.nextLine();
				System.out.print("Direccion:");
				String direccion = scan.nextLine();
				System.out.print("Poblacion:");
				String poblacion = scan.nextLine();
				System.out.print("Provincia:");
				String provincia = scan.nextLine();
				System.out.print("DNI:");
				String dni = scan.nextLine();

				Socio socio = new Socio(0,nombre,apellido,direccion,poblacion,provincia,dni);
				sm.insert(socio);
				break;

			case VER_LIBROS: // VER LIBROS
				ArrayList<Libro> libros = lm.select();
				Iterator<Libro> il = libros.iterator();
				
				while(il.hasNext()){
					il.next().mostrarInfo();
				}
				break;
				
			case VER_SOCIOS: // VER SOCIOS
				ArrayList<Socio> socios = sm.select();
				Iterator<Socio> is = socios.iterator();
				
				while(is.hasNext()){
					is.next().mostrarInfo();
				}
				break;
				
            case VER_LIBRO_POR_ID:
            	System.out.println("Sartu liburuaren id-a");
				Scanner s = new Scanner(System.in);
				int id =(Integer.parseInt(scan.nextLine()));
				Libro libro  = lm.select(id);
				libro.mostrarInfo();
				
				break;
			
            case VER_SOCIO_POR_ID:
            	System.out.println("Sartu sozioaren id-a");
            	id =(Integer.parseInt(scan.nextLine()));
            	socio = sm.select(id); //socio objetua matxakatu
            	socio.mostrarInfo();
            	
            case DELETE_LIBRO_POR_ID:
            	
            	System.out.println("-ELIMINAR LIBRO POR ID-");
				System.out.print("Id del libro que desees eliminar: ");
				int idLibroElim = scan.nextInt();
				lm.delete(idLibroElim);
            	
                break;
            case DELETE_SOCIO_POR_ID:
            	
            	System.out.println("-BUSCAR SOCIO POR ID-");
				System.out.print("Id del socio del que deseas informacion: ");
				int idSocio = scan.nextInt();
				sm.select(idSocio).mostrarInfo();
				break;
            

            case VER_LIBROS_POR_AUTOR:
            	System.out.println("Sartu autore bat");
            	autor = scan.nextLine();
            	//no se puede crear un objeto libro de libro sino que hay que usar librosporque es una arraylistlo que queremos guardar (la arraylist)
            	Iterator<Libro> i = lm.selectLibrosDeAutor(autor).iterator();
				while (i.hasNext()){
					i.next().mostrarInfo();
				}
            	
            	break;
				
			case SALIR:
				System.out.println("Saliendo....");
				break;

			default:
				System.out.println("Elige una de las opciones del menú.");
			}
		} while (opcion != 0);

	}

}
