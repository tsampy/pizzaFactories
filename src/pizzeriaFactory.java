public class pizzeriaFactory {

    private FabriquePizza fabrique;

    public pizzeriaFactory(FabriquePizza fabrique) {
        this.fabrique = fabrique;
    }

    public Pizza CommanderPizza(String type) {

        return fabrique.creerPizza(type);
    }
}