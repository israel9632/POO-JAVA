package AppContaCorrente;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppAC login;

        System.out.println("Informe sua conta: ");
        String account = sc.next();
        System.out.println();
        System.out.println("Informe sua agencia: ");
        String agency = sc.next();
        login = new AppAC(account, agency);
        sc.close();
    }
}
