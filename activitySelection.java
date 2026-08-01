import java.util.ArrayList;
import java.util.Arrays;

public class activitySelection {
    static class Activity{
        int start,end;
        Activity(int s,int e){
            start=s;
            end=e;

        }
    }
    public static void main(String[] args) {
        Activity[] activities={
            new Activity(1, 2),
            new Activity(3 , 4),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(8, 9),
            new Activity(5 , 9)        
        };
        Arrays.sort(activities,(a,b)-> a.end-b.end);
        ArrayList<Activity> result= new ArrayList<>();
        result.add(activities[0]);
        int lastEnd= activities[0].end;
        
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start>=lastEnd) {
                result.add(activities[i]);
                lastEnd=activities[i].end;
            }
        }
        System.out.println("Selected activites : "+ result.size());
        for (Activity a : result) {
            System.out.println("("+ a.start+","+ a.end+")");
        }
    }
}