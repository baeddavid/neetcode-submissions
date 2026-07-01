class Solution {
    public int calPoints(String[] operations) {
        List<Integer> st = new ArrayList<>();
        for(String op : operations) {
            int n = st.size();
            switch(op) {
                case "+" -> st.add(st.get(n - 1) + st.get(n - 2));
                case "D" -> st.add(2 * st.get(n - 1));
                case "C" -> st.remove(n - 1);
                default -> st.add(Integer.parseInt(op));
            }
        }
        return st.stream().mapToInt(Integer::intValue).sum();
    }
}