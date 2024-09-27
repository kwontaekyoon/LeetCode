// failed

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class MyCalendarTwo1 {
    private TreeMap<Integer, Integer> map;

    public MyCalendarTwo1() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        final var higherKey = map.higherKey(start);
        final var lowerEntry = map.lowerEntry(start);
        // one overlap
        if (map.containsKey(start)) {
            // two overlap
            if (higherKey != null && higherKey < end) {
                return false;
            }
            if (lowerEntry != null && lowerEntry.getValue() > start) {
                return false;
            }
        } else {
            // one overlap
            if (higherKey != null && higherKey < end) {
                if (lowerEntry != null && lowerEntry.getValue() > start) {
                    return false;
                }
                final var higherHigherKey = map.higherKey(higherKey);
                if (higherHigherKey != null && higherHigherKey < end) {
                    return false;
                }
            }
            if (lowerEntry != null && lowerEntry.getValue() > start) {
                final var lowerLowerEntry = map.lowerEntry(lowerEntry.getKey());
                if (lowerLowerEntry != null && lowerLowerEntry.getValue() > start) {
                    return false;
                }
            }
        }
        map.put(start, end);
        return true;
    }
}

class Event {
    int start;
    int end;

    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MyCalendarTwo {
    List<Event> overLapBookings;
    List<Event> bookings;

    public MyCalendarTwo() {
        overLapBookings = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for (Event e : overLapBookings) {
            if (isOverlap(e, start, end))
                return false;
        }

        for (Event e : bookings) {
            if (isOverlap(e, start, end)) {
                overLapBookings.add(getOverlapEvent(e, start, end));
            }
        }
        bookings.add(new Event(start, end));

        return true;
    }

    public boolean isOverlap(Event e, int start, int end) {
        return Math.max(e.start, start) < Math.min(e.end, end);
    }

    public Event getOverlapEvent(Event e, int start, int end) {
        return new Event(Math.max(e.start, start), Math.min(e.end, end));
    }
}