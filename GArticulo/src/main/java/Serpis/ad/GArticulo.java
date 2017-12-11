package Serpis.ad;

import java.math.BigDecimal;
import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class GArticulo {
	
	private static Scanner scanner = new Scanner(System.in);
	private static Connection connection;
	public enum Option{Salir,Nuevo,Editar,Eliminar,Consultar,Listar};
	public enum State{Vacío, Medio, Lleno}
	
	public static class Articulo{
		private long id;
		private String nombre;
		private BigDecimal precio;
		private long categoria;
	}

	public static void main(String[] args) {
		
	
		showFields(String.class);
		
		Articulo articulo=new Articulo();
		
		//scan(Option.class);
		//scan(State.class);
		//connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		
//		new Menu.add("Salir",null)
//			.add("Nuevo", ()->nuevo())
//			.add("Editar",()->editar())
//			.run();
		
//		while(true) {
//			Option option=scanOption();
//			Runnable runnable=null;
//			if(option==Option.Salir)
//				break;
//			else if(option==Option.Nuevo);
//			else if(option==Option.Editar);
//			else if(option==Option.Eliminar);
//			else if(option==Option.Consultar);
//			else//(option==Option.Listar)
//				;
//			
//		}
		
//		int opcion = 0;
//		do{
//			System.out.println("------------------ MENU -------------------");
//			System.out.println("O. Salir");
//			System.out.println("1. Nuevo");
//			System.out.println("2. Modificar");
//			System.out.println("3. Eliminar");
//			System.out.println("4. Consultar");
//			System.out.println("5. Listar");
//			System.out.print("Escoja una opción, por favor: ");
//			opcion = scanner.nextInt();
//			
//			System.out.println("-------------------------------------------");
//			
//			switch(opcion){
//				case 0: 
//					System.out.println("Conexión cerrada. Vuelva pronto.");
//					connection.close();
//					break;
//				case 1:format
//					NuevoRegistro();
//				case 2:
//					Modificar();
//				case 3:
//					Eliminar();
//				case 4:
//					Consultar();
//				case 5:
//					Listar();
//			}
//		} while(opcion!=0);
	}
	private static void showfields(Class<?>type) {
		
	}
	
	
	public static void nuevo(){
		//TODO implantar
	}
	
	
		//GENERICO
	public static <T extends Enum<T>> T scan(Class<T>enumType){
		T[]constants=enumType.getEnumConstants();
		for(int index=0;index<constants.length;index++)
			System.out.printf("%s - %s\n",index,constants.length-1);
		String options=String.format("^[0-%s]$", constants.length-1);
		while (true) {
			System.out.println("Elija una opción:");
			String line=scanner.nextLine();
			if(line.matches(options))
				return constants[Integer.parseInt(line)];
			System.out.println("Opción invalida. Vuelva a introducir");
		}
	
	}
		
		
	public static int scanInt(String label) {
		while(true) {
			try {
				System.out.print(label);
				String line=scanner.nextLine();
				return Integer.parseInt(line);
			}catch (NumberFormatException ex) {
				System.out.println("Debe introducir un número. Vuelva a intentarlo");
			}
		}
	}
	public static Option scanOption() {
		for(int index=0;index<Option.values().length;index++)
			System.out.printf("%s-%s\n",index,Option.values()[index]);
		String options=String.format("^[0-%s]$", Option.values().length-1);
		while(true) {
			System.out.println("Elija una opción:");
			String line=scanner.nextLine();
			if(line.matches(options))
				return Option.values()[Integer.parseInt(line)];
			System.out.println("Opción invalida. Vuelva a introducir");
			
		}
	}
	
	public static State scanState() {
		for(int index=0;index<State.values().length;index++)
			System.out.printf("%s-%s\n",index,State.values()[index]);
		String options=String.format("^[0-%s]$", State.values().length-1);
		while(true) {
			System.out.println("Elija una opción:");
			String line=scanner.nextLine();
			if(line.matches(options))
				return State.values()[Integer.parseInt(line)];
			System.out.println("Opción invalida. Vuelva a introducir");
			
		}
	}	
}
	


