package Exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex3pkt2 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:/Users/Administrator/Desktop/DesctopShits/Academy/";
        Scanner fil = new Scanner(System.in);
        System.out.println("Filnamn? ");
        String file = fil.next();
        Scanner in = new Scanner(new File(path + file));
        String s = "";
        while (in.hasNextLine()){
            s += in.next()+"\n";
        }
        System.out.println(s);
        in.close();
        fil.close();
    }
}
