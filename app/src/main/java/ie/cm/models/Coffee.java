package ie.cm.models;

import java.io.Serializable;

public class Coffee implements Serializable
{

	int coffeeId;
	String coffeeName;
	String shop;
	double rating;
	double price;
	boolean favourite;


	public Coffee() {}

	public Coffee(String name, String shop, double rating, double price, boolean fav)
	{
		this.coffeeName = name;
		this.shop = shop;
		this.rating = rating;
		this.price = price;
		this.favourite = fav;
	}

	@Override
	public String toString() {
		return "Coffee [coffeeName=" + coffeeName
				+ ", shop =" + shop + ", rating=" + rating + ", price=" + price
				+ ", fav =" + favourite + "]";
	}
}
