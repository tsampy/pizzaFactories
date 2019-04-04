public class factoryProvider {

    public static pizzaFactory getFactory(String choice)
    {
        if("1".equalsIgnoreCase(choice))
            return new pizzaFactoryItaly();
        else
            if("2".equalsIgnoreCase(choice))
                return new pizzaFactoryNY();
            else return null;
    }
}