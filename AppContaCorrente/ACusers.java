package POO.ADO01;

public class ACusers {
    public static AppAC[] users = new AppAC[5];

    public ACusers() {
        users[0] = new AppAC("ISRAEL DOS SANTOS","0123", "2010", "israel9632", "01234",1200.00,'M');
        users[1] = new AppAC("JOÃO BATISTA","0147", "2010", "joao123", "96321",300.00,'M');
        users[2] = new AppAC("AMANDA DE SOUZA","0789", "2010", "amanda", "sal8123",150.00,'F');
        users[3] = new AppAC("JEFERSON DE LIMA","1234", "3010", "jeferson02", "agua8012",1500.00,'M');
        users[4] = new AppAC("ALAN PEREIRA DA ROCHA","1789", "3010", "casaAzul", "1234",0.0,'M');
    }
}
