package FinalProjectMongoDB;
import java.util.Scanner;

public class ValidadorDeTipo {
    static Scanner sc= new Scanner(System.in);

    public static int ValidarEnteros(){
        int value=sc.nextInt();
        sc.nextLine();
        return value;
    }

    public static String ValidarString(){
        String value=sc.nextLine();

        while(value.isEmpty()){
            System.out.println("El campo no puede estar vacio");
            value=sc.next();
        }
        return value;
    }

    public static double ValidarDouble(){
        Double value=sc.nextDouble();
        sc.nextLine();
        return value;
    }
}
