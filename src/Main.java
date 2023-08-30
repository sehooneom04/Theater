import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int selMenu;
        Scanner scanner = new Scanner(System.in);
        Theater sehoon = new Theater();
        while (true) {
            sehoon.printMenu();
            selMenu = scanner.nextInt();
            if (selMenu == 1) {
                sehoon.register();
            } else if (selMenu == 2) {
                sehoon.reserve();
            } else if (selMenu == 3) {
                sehoon.printTheater();
            } else if (selMenu == 4) {
                sehoon.chkSeat();
            } else if (selMenu == 5) {
                sehoon.delSeat();
            } else if (selMenu == 6) {
                sehoon.printInfo();
            } else {
                break;
            }
        }
    }
}
