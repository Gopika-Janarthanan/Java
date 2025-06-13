import java.util.*;

class User {
    String username, password;
    List<String> searchHistory = new ArrayList<>();
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Product {
    int id;
    String name;
    double price;
    String gender; // "Men", "Women", "Unisex"
    Product(int id, String name, double price, String gender) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.gender = gender;
    }
}




public class JGKart {
    static Scanner sc = new Scanner(System.in);
    static List<User> users = new ArrayList<>();
    static List<Product> products = new ArrayList<>();
    static Map<String, List<Product>> carts = new HashMap<>();
    static String currentUser = null;

    public static void main(String[] args) {
        loadProducts();
        while (true) {
            System.out.println("\n=== E-Commerce App ===");
            if (currentUser == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1: register(); break;
                    case 2: login(); break;
                    case 3: System.exit(0);
                    default: System.out.println("Invalid choice");
                }
            } else {
                System.out.println("\nWelcome, " + currentUser);
                System.out.println("1. View All Products");
                System.out.println("2. Add to Cart");
                System.out.println("3. View Cart");
                System.out.println("4. Checkout");
                System.out.println("5. Search Products");
                System.out.println("6. View Search History");
                System.out.println("7. Recommended Products");
                System.out.println("8. Filter Products");
                System.out.println("9. Logout");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: viewProducts(products); break;
                    case 2: addToCart(); break;
                    case 3: viewCart(); break;
                    case 4: checkout(); break;
                    case 5: searchProducts(); break;
                    case 6: viewSearchHistory(); break;
                    case 7: showRecommendations(); break;
                    case 8: filterProducts(); break;
                    case 9: currentUser = null; break;
                    default: System.out.println("Invalid choice");
                }
            }
        }
    }

    static void register() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        for (User u : users) {
            if (u.username.equals(username)) {
                System.out.println("Username already exists!");
                return;
            }
        }
        users.add(new User(username, password));
        System.out.println("Registration successful!");
    }

    static void login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        for (User u : users) {
            if (u.username.equals(username) && u.password.equals(password)) {
                currentUser = username;
                System.out.println("Login successful!");
                return;
            }
        }
        System.out.println("Invalid credentials!");
    }

    static void loadProducts() {
        products.add(new Product(1, "Men's Laptop Bag", 2500, "Men"));
        products.add(new Product(2, "Women's Handbag", 3000, "Women"));
        products.add(new Product(3, "Unisex Hoodie", 1800, "Unisex"));
        products.add(new Product(4, "Men's Shoes", 2200, "Men"));
        products.add(new Product(5, "Women's Sandals", 1500, "Women"));
        products.add(new Product(6, "Unisex Smartwatch", 3500, "Unisex"));
        products.add(new Product(7, "Women's Jacket", 4000, "Women"));
        products.add(new Product(8, "Men's Sunglasses", 1200, "Men"));
    }

    static void viewProducts(List<Product> productList) {
        System.out.println("\nAvailable Products:");
        for (Product p : productList) {
            System.out.printf("%d. %s - ₹%.2f [%s]\n", p.id, p.name, p.price, p.gender);
        }
    }

    static void addToCart() {
        viewProducts(products);
        System.out.print("Enter product ID to add: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Product p : products) {
            if (p.id == id) {
                carts.putIfAbsent(currentUser, new ArrayList<>());
                carts.get(currentUser).add(p);
                System.out.println(p.name + " added to cart.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Invalid Product ID.");
        }
    }

    static void viewCart() {
        List<Product> cart = carts.get(currentUser);
        if (cart == null || cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("Your Cart:");
        double total = 0;
        for (Product p : cart) {
            System.out.println("- " + p.name + " - ₹" + p.price);
            total += p.price;
        }
        System.out.println("Total: ₹" + total);
    }

    static void checkout() {
        List<Product> cart = carts.get(currentUser);
        if (cart == null || cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        viewCart();
        System.out.println("Checkout successful. Thank you for your purchase!");
        cart.clear();
    }

    static User getCurrentUserObject() {
        for (User u : users) {
            if (u.username.equals(currentUser)) return u;
        }
        return null;
    }

    static void searchProducts() {
        sc.nextLine();
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine().toLowerCase();
        getCurrentUserObject().searchHistory.add(keyword);
        List<Product> matched = new ArrayList<>();
        for (Product p : products) {
            if (p.name.toLowerCase().contains(keyword)) {
                matched.add(p);
            }
        }
        if (matched.isEmpty()) {
            System.out.println("No products matched.");
        } else {
            viewProducts(matched);
        }
    }

    static void viewSearchHistory() {
        List<String> history = getCurrentUserObject().searchHistory;
        if (history.isEmpty()) {
            System.out.println("No search history found.");
        } else {
            System.out.println("Your search history:");
            for (String k : history) {
                System.out.println("- " + k);
            }
        }
    }

    static void showRecommendations() {
        List<String> history = getCurrentUserObject().searchHistory;
        Set<Product> recommended = new LinkedHashSet<>();
        for (String keyword : history) {
            for (Product p : products) {
                if (p.name.toLowerCase().contains(keyword)) {
                    recommended.add(p);
                }
            }
        }
        if (recommended.isEmpty()) {
            System.out.println("No recommendations available. Try searching first.");
        } else {
            System.out.println("Recommended products for you:");
            viewProducts(new ArrayList<>(recommended));
        }
    }

    static void filterProducts() {
        sc.nextLine();
        System.out.print("Filter by gender (Men/Women/Unisex/All): ");
        String gender = sc.nextLine().toLowerCase();

        System.out.print("Enter minimum price: ");
        double min = sc.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = sc.nextDouble();

        List<Product> filtered = new ArrayList<>();
        for (Product p : products) {
            boolean genderMatch = gender.equals("all") || p.gender.toLowerCase().equals(gender);
            boolean priceMatch = p.price >= min && p.price <= max;
            if (genderMatch && priceMatch) {
                filtered.add(p);
            }
        }

        filtered.sort(Comparator.comparingDouble(p -> p.price)); // Low to high

        if (filtered.isEmpty()) {
            System.out.println("No products match your filters.");
        } else {
            System.out.println("Filtered and sorted products (Low to High):");
            viewProducts(filtered);
        }
    }
}
