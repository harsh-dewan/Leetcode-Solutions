class Solution {


    /*
     * 1. first we are  keeping the order of the characters of the 'order string' in the map, using the index, we just assigning the index in increment order
     * 2. putting all the characters in the priorityqueue which will sort the characters based on the index in the map
     */
    int index = 0;

    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

    class Pair implements Comparable<Pair> {
        char ch;
        int index;

        Pair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }

        public int compareTo(Pair p1) {
            if( p1.index <= this.index) return 1;
            else return -1;
        }

        public char getCh() {
            return this.ch;
        }
    }

    public String customSortString(String order, String s) {
        index = 0;
        int orderlength = order.length();
	/* 
	 * 1.
	 */
        for(int i = 0; i < orderlength; i++ ) {
            if( map.getOrDefault(order.charAt(i) - 'a',-1) == -1 ) {
                map.put(order.charAt(i)-'a',index++);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int slength = s.length();
	/*
	 * 2. 
	 */
        for(int i = 0; i < slength; i++ ) {
            Pair p1 = new Pair(s.charAt(i), map.getOrDefault(s.charAt(i)-'a',27));
            pq.add(p1);
        }
        String str = "";
        while(pq.size() > 0 ) { 
            str = str + pq.poll().getCh();
        }
        return str;
    }
}
