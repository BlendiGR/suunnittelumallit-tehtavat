package facade;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        APIFacade facade = new APIFacade();

        try {
            String joke = facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Chuck Norris joke: " + joke);
        } catch (IOException e) {
            System.out.println("HTTP error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Attribute not found: " + e.getMessage());
        }

        try {
            String rate = facade.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "base");
            System.out.println("Base currency: " + rate);
        } catch (IOException e) {
            System.out.println("HTTP error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Attribute not found: " + e.getMessage());
        }
    }
}
