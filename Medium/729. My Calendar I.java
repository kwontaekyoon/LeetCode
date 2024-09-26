import java.util.TreeMap;

class MyCalendar {
    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        final var floor = map.floorEntry(start);
        final var ceiling = map.ceilingEntry(start);
        if ((floor == null || floor.getValue() <= start) && (ceiling == null || ceiling.getKey() >= end)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}