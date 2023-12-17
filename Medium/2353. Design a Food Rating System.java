class Food implements Comparable<Food> {
    public String name;
    public String cuisine;
    public int rating;

    public Food(String name, String cuisine, int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    @Override
    public int compareTo(Food other) {
        if (this.rating == other.rating) {
            return this.name.compareTo(other.name);
        }
        return -1 * Integer.compare(this.rating, other.rating);
    }
}

class FoodRatings {
    private Map<String, Food> nameToFood;
    private Map<String, PriorityQueue<Food>> cuisineToFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        nameToFood = new HashMap<>();
        cuisineToFoods = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            nameToFood.put(foods[i], food);
            cuisineToFoods.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).offer(food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food oldFood = nameToFood.get(food);
        oldFood.name = "";
        Food newFood = new Food(food, nameToFood.get(food).cuisine, newRating);
        nameToFood.put(food, newFood);
        cuisineToFoods.get(newFood.cuisine).offer(newFood);
    }

    public String highestRated(String cuisine) {
        String highestOne = cuisineToFoods.get(cuisine).peek().name;
        while (highestOne.equals("")) {
            cuisineToFoods.get(cuisine).poll();
            highestOne = cuisineToFoods.get(cuisine).peek().name;
        }
        return highestOne;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */