class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        LinkedList<Integer>[] connections= new LinkedList[roads.length+1];
        for (int i=0; i<=roads.length; i++) connections[i]= new LinkedList<Integer>();
        for (int[] road: roads) {
            connections[road[0]].add(road[1]);
            connections[road[1]].add(road[0]);
        }
        long answer[]= dfs2(0, -1, seats, connections);
        return answer[0];
    }
    long[] dfs2(int startFrom, int prev, int seats, List<Integer>[] connections) {
        long fuel=0, subtreeSize=1;
        for (Integer childCity: connections[startFrom]) if (childCity.intValue()!=prev) {
            long[] result= dfs2(childCity, startFrom, seats, connections);
            fuel += result[0];
            subtreeSize += result[1];
        }
        if (prev != -1) fuel += (subtreeSize + seats - 1)/ seats;    // fuel needed to move up to parent
        // System.out.println("s=" + startFrom + " p=" + prev + " f=" + fuel + " size=" + subtreeSize  );
        return new long[]{fuel, subtreeSize};
    }

}
