import service.PessoaService;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        PessoaService service = new PessoaService();
        service.streamFilter();
        service.streamForeach();
        service.streamMap();
        service.streamMapDois();
        service.findFirst();
        service.findAnyWithNonNullValue();
        service.findAnyWithNullValue();

    }
}
