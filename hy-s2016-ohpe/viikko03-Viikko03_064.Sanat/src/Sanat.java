
import java.util.ArrayList;
import java.util.Scanner;

public class Sanat {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> sanat = new ArrayList<>();

        while (true) {
            System.out.println("Anna sana");
            String sana = lukija.nextLine();
            if (sana.isEmpty()) {
                break;
            } else {
                sanat.add(sana);
            }
        }

        for (String moppe : sanat) {
            System.out.println(moppe);
        }
    }
}
