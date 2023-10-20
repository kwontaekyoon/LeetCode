public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peekFirst().isInteger()) {
            List<NestedInteger> list = stack.pollFirst().getList();
            prepareStack(list);
        }
        return !stack.isEmpty();
    }

    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.offerFirst(nestedList.get(i));
        }
    }
}