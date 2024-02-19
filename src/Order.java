public class Order
{
    public enum crust
    {
        thin,
        regular,
        deepDish,
        none
    }
    public crust pizzaCrust;
    public enum size
    {
        small,
        medium,
        large,
        extraLarge,
        none
    }
    public size pizzaSize;
    public boolean[] ingredients = new boolean[6];

    public Order()
    {
        pizzaCrust = crust.none;
        pizzaSize = size.none;
        for (boolean i : ingredients)
        {
            i = false;
        }
    }

    public crust getPizzaCrust()
    {
        return pizzaCrust;
    }

    public void setPizzaCrust(crust pizzaCrust)
    {
        this.pizzaCrust = pizzaCrust;
    }

    public size getPizzaSize()
    {
        return pizzaSize;
    }

    public void setPizzaSize(size pizzaSize)
    {
        this.pizzaSize = pizzaSize;
    }

    public void setOneIngredient(int ingredient, boolean setBoolean)
    {
        ingredients[ingredient] = setBoolean;
    }

    public boolean getOneIngredient(int ingredient)
    {
        return ingredients[ingredient];
    }
}
