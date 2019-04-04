public class pizzaFactoryNY implements pizzaFactory {

    public Pizza getPizza(String typePizza)
    {
        switch (typePizza.toUpperCase())
        {
            case "1":
                return new pizzaFromagesNY();
            case "2":
                return new pizza4SaisonsNY();
            case "3":
                return new pizzaPoireauxNY();
            case "4":
                return new pizzaFraisesJambonNY();
            default:
                return null;
        }
    }
}