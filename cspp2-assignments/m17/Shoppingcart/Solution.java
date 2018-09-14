import java.util.*;

class Item {
	private String name;
	private int quantity;
	private float price;
	private boolean inCatlog = false;
	Item(String name, int quantity, float price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.inCatlog = true;
	}

	Item(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}


	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public int getQuantity() {
	    return quantity;
	}

	public void setQuantity(int quantity) {
	    this.quantity = quantity;
	}

	public float getPrice() {
	    return price;
	}

	public void setPrice(float price) {
	    this.price = price;
	}

	public String toString() {
		if (inCatlog) return name + " " + quantity +" "+ price;
		return name + " " + quantity;
	}
}


class ShoppingCart {
	private ArrayList<Item> catlog;
	private ArrayList<Item> cart;
	String[] arr = {"IND10", "IND20", "IND30", "IND50"};
	private ArrayList<String> couponCodes = new ArrayList<>(Arrays.asList(arr));
	private float coupon = 0.0f;
	private boolean cflag = false;

	ShoppingCart () {
		cart = new ArrayList<>();
		catlog = new ArrayList<>();
	}

	public void addToCatlog(Item item) {
		catlog.add(item);
	}

	public void addToCart(Item item) {
		for (Item e : catlog) {
			if (e.getName().equals(item.getName())) {
				for (Item f : cart) {
					if (f.getName().equals(item.getName())) {
						f.setQuantity(f.getQuantity() + item.getQuantity());
						return;
					}
				}
				cart.add(item);
				return;
			}
		}
	}

	public void removeFromCart(Item item) {
		for (Item f : cart) {
			if (f.getName().equals(item.getName())) {
				if (f.getQuantity() == item.getQuantity()) {
					cart.remove(f);
					return;
				}
				f.setQuantity(f.getQuantity() - item.getQuantity());
				return;
			}
		}
	}

	public void showCart() {
		for (Item e: cart)
			System.out.println(e);
	}

	public void showCatlog() {
		for (Item e: catlog)
			System.out.println(e);
	}

	public float getPrice(String name) {
		for (Item e : catlog) {
			if (e.getName().equals(name)) {
				return e.getPrice();
			}
		}
		return 0.0f;
	}

	public float getTotalAmount() {
		float amt = 0.0f;
		for (Item e: cart)
			amt += e.getQuantity() * getPrice(e.getName());
		return amt;
	}


	public float getPayableAmount() {

		float dscnt = 0.01f * coupon;
		return (getTotalAmount() * (1f-dscnt)) * 1.15f;


	}

	public void applyCoupon(String couponCode) {
		if (couponCodes.contains(couponCode)){
			if (!cflag) {
				coupon = Integer.parseInt(couponCode.substring(3));
				cflag = true;
			}
			return;
		}
		System.out.println("Invalid coupon");
	}

	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (Item item : cart)
			System.out.println(item.getName() +
             " " + item.getQuantity() + " " + getPrice(item.getName()));
		float total = getTotalAmount();
		System.out.println("Total:" + total);
		System.out.println("Disc%:" + 0.01 * coupon * total);
		System.out.println("Tax:" + ((int) ( (total * (1f- (0.01f * coupon)) * 0.15f) * 10))/ 10.0);
		System.out.println("Payable amount: " + ((int) ( getPayableAmount() * 10))/ 10.0 );


	}
}


public class Solution {
	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n+1; i++) {
			String[] tokens = sc.nextLine().split(" ");
			// System.out.println(Arrays.toString(tokens));
			switch (tokens[0]) {
				case "Item" :
				if(tokens.length > 1) {
					String[] details = tokens[1].split(",");
					shoppingCart.addToCatlog(new Item(details[0], Integer.parseInt(details[1]), Integer.parseInt(details[2])));
					break;
				}
				break;
				case "catalog":
				shoppingCart.showCatlog();
				break;
				case "add":
				if(tokens.length > 1) {
					String[] details = tokens[1].split(",");
					shoppingCart.addToCart(new Item(details[0], Integer.parseInt(details[1])));
					break;
				}
				break;
				case "show":
				shoppingCart.showCart();
				break;
				case "totalAmount":
				System.out.println("totalAmount: " + shoppingCart.getTotalAmount());
				break;
				case "payableAmount":
				System.out.println("Payable amount: " + ((int) ( shoppingCart.getPayableAmount() * 10))/ 10.0);
				break;
				case "remove":
				if(tokens.length > 1) {
					String[] details = tokens[1].split(",");
					shoppingCart.removeFromCart(new Item(details[0], Integer.parseInt(details[1])));
					break;
				}
				break;
				case "coupon":
				// System.out.println("called");
				if(tokens.length > 1) {
					String coupon = tokens[1];
					shoppingCart.applyCoupon(coupon);
					break;
				}
				case "print":
				// System.out.println("called");
				shoppingCart.printInvoice();
				break;

			}
		}
	}
}

