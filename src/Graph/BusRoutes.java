package Graph;

import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if(source == target){
            return 0;
        }

        // Map each bus stop to the routes passing through it.
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < routes.length; ++i){
            for(int j = 0; j < routes[i].length; ++j){
                adj.computeIfAbsent(routes[i][j], k -> new ArrayList<>()).add(i);
            }
        }

        if(!adj.containsKey(source) || !adj.containsKey(target)){
            return -1;
        }

        Set<Integer> visitedRoutes = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();

        // Start with all routes containing the source.
        for(int route : adj.get(source)){
            visitedRoutes.add(route);
            q.offer(route);
        }

        int busRoutes = 1;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int curRoute = q.poll();

                for(int stop : routes[curRoute]){

                    if(stop == target){
                        return busRoutes;
                    }

                    if(visitedStops.contains(stop)){
                        continue;
                    }

                    visitedStops.add(stop);

                    for(int route : adj.get(stop)){
                        if(visitedRoutes.add(route)){
                            q.offer(route);
                        }
                    }
                }
            }

            busRoutes++;
        }

        return -1;
    }
}
