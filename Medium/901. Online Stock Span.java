class StockSpanner {
    List<Integer> prices;
    List<Integer> bounds;

    public StockSpanner() {
        prices = new ArrayList<>();
        bounds = new ArrayList<>();
    }
    
    public int next(int price) {
        int bound = bounds.size() - 1;
        while (bound > -1 && prices.get(bound) <= price) {
            bound = bounds.get(bound);
        }
        prices.add(price);
        bounds.add(bound);
        return bounds.size() - bound - 1;
    }
}