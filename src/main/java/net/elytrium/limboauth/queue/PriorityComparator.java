package net.elytrium.limboauth.queue;


import net.elytrium.limboauth.model.JoinPriority;

import java.util.Comparator;

public class PriorityComparator implements Comparator<JoinPriority> {


    /*
    -1 : o1 < o2
     0 : o1 == o2
    +1 : o1 > o2
     */
    @Override
    public int compare(JoinPriority p1, JoinPriority p2) {

        int result = -1;

        //if priority value is the same, put new added one to
        if (p2.getPriority().getPriorValue() - p1.getPriority().getPriorValue() == 0)
            result = 1;


        return p1.getPlayerUuid().equals(p2.getPlayerUuid()) ? 0 : result;
    }


}
