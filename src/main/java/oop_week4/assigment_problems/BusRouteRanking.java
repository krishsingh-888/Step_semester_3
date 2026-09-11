package main.java.oop_week4.assigment_problems;
import java.util.Arrays;

class BusRoute implements Comparable<BusRoute> {
    String routeCode;
    String routeName;
    int priority;

    public BusRoute(String routeCode, String routeName, int priority) {
        this.routeCode = routeCode;
        this.routeName = routeName;
        this.priority = priority;
    }

    public BusRoute(String routeCode, String routeName) {
        this(routeCode, routeName, 5); 
    }

    @Override
    public int compareTo(BusRoute other) {
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }
        return this.routeCode.compareToIgnoreCase(other.routeCode);
    }

    public static BusRoute[] rankRoutes(BusRoute[] routes) {
        BusRoute[] sorted = routes.clone();
        Arrays.sort(sorted);
        return sorted;
    }
}

public class BusRouteRanking {
    public static void main(String[] args) {
        BusRoute[] routes = {
            new BusRoute("RT205L", "Airport Express", 3),
            new BusRoute("rt201j", "City Central", 4),
            new BusRoute("RT299T", "Night Service")
        };
        BusRoute[] ranked = BusRoute.rankRoutes(routes);
        for (BusRoute r : ranked) {
            System.out.print("\"" + r.routeCode + "\" ");
        }
    }
}