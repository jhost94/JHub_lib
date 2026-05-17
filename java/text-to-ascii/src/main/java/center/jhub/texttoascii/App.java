package center.jhub.texttoascii;

import center.jhub.texttoascii.font.patorjk.Doh;

public class App {

    public static void main(String[] args) {
        Doh doh = new Doh(false);

        String exampleText = "testa";

        System.out.println(doh.process(exampleText));
        System.out.println(doh.maxWith());
    }
}
