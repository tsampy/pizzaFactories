public class pizzaFactoryItaly implements pizzaFactory {

    public Pizza getPizza(String typePizza)
    {
        switch (typePizza.toUpperCase())
        {
            case "1":
                return new pizzaFromagesItalienne();
            case "2":
                return new pizza4SaisonsItalienne();
            case "3":
                return new pizzaPoireauxItalienne();
            case "4":
                return new pizzaFraisesJambonItalienne();
            default:
                return null;
        }
    }
}