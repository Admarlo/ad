package Serpis.ad;

import java.sql.SQLException;
import java.util.Scanner;

import Serpis.ad.GArticulo.Option;
import Serpis.ad.GArticulo.State;

public class Menu {

	public static void main(String[] args) {

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
