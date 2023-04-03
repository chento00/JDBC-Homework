package util;

import java.util.Scanner;

public class InputUtils {

    public static String inputText(String lebel, Scanner scanner){
        System.out.print(lebel);
        String name=scanner.nextLine();
        return  name;
    }
}
