package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;

    /**
     * набор открытых и закрытых вершин со ссылками на новую пустую коллекцию
     */
    public HashMap<Location, Waypoint> openWaypoints = new HashMap<Location, Waypoint>();
    public HashMap<Location, Waypoint> closedWaypoints = new HashMap<Location, Waypoint>();

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        // TODO:  Implement.
        //System.out.println("getMinOpenWaypoint called!");
        if (openWaypoints.isEmpty()) return null;

        float minCost = 3.4e+38f;
        Waypoint minCostObject = null;

        ArrayList<Waypoint> values = new ArrayList<Waypoint>(openWaypoints.values());
        for (Waypoint element : values) {
            if (element.getTotalCost() < minCost) {
                minCost = element.getTotalCost();
                minCostObject = element;
            }
        }

        //System.out.println("\tminWaypoint coords: " + minCostObject.getLocation().xCoord + ", " + minCostObject.getLocation().yCoord + ", cost = " + minCost);
        return minCostObject;
        //return null;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
//    public boolean addOpenWaypoint(Waypoint newWP)
//    {
//        // TODO:  Implement.
//        ArrayList<Location> locations = new ArrayList<Location>(openWaypoints.keySet());
//
//        // находим Location для нового Waypoint
//        Location newLoc = newWP.getLocation();
//        System.out.println("\tnew waypoint coords: " + newLoc.xCoord + ", " + newLoc.yCoord);
//
//        //Просмотр всех ключей из locations
//        for (Location index : locations) {
//            if (newLoc.equals(index)) {
//                //сравнениваем стоимости открытых вершин
//
//                // если стоимость пути до newWP меньше стоимости пути до вершины с такой же Location - заменяем
//                Waypoint oldWP = openWaypoints.get(index);
//                //System.out.println("\tthere is equal point: " + index.xCoord + ", " + index.yCoord);
//                double oldCost = oldWP.getPreviousCost();
//                double newCost = newWP.getPreviousCost();
//                System.out.println("\told cost: " + oldCost + ", new cost: " + newCost);
//
//                if (newCost < oldCost) {
//                    openWaypoints.put(newLoc, newWP);
//                    return true;
//                }
//
//                // если новая вершина не подошла
//                return false;
//
//            }
//        }
//
//        openWaypoints.put(newLoc, newWP);
//        //System.out.println("\tnew point opened");
//        return true;
//    }

    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // Находим локацию новой вершины
        Location location = newWP.getLocation();
        // Проверяем на наличие открытой вершины на новой локации
        if (openWaypoints.containsKey(location))
        {
            // Если есть
            Waypoint current_waypoint = openWaypoints.get(location);
            if (newWP.getPreviousCost() < current_waypoint.getPreviousCost())
            {
                // если у новой вершины цена меньше текущей, заменяем ей текущую
                openWaypoints.put(location, newWP);
                return true;
            }
            return false;
        }
        // Если нет, добавляем в коллекцию открытых вершин
        openWaypoints.put(location, newWP);
        return true;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        // TODO:  Implement.
        return openWaypoints.size();
        //return 0;
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
        Waypoint wp = openWaypoints.get(loc);
        openWaypoints.remove(loc);
        closedWaypoints.put(loc, wp);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        // TODO:  Implement.
        return closedWaypoints.containsKey(loc);
        //return false;
    }


}
