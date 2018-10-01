import java.util.*;

class Solution {

  class Course {
    ArrayList<Integer> prereqFor = new ArrayList<>();
    int numberPrereqs = 0;
    boolean completed = false;

    public void incrementPrereqs() {
      numberPrereqs++;
    }

    public void decrementPrereqs() {
      numberPrereqs--;
    }
  }

  public static void main(String[] args) {
    int[][] input = {{1, 0}};
    int[] result = new Solution().findOrder(2, input);
    for (int num : result) {
      System.out.println(num);
    }
  }
  
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    
    HashMap<Integer, Course> map = new HashMap<>();

    for (int i = 0; i < numCourses; i++) {
      map.put(i, new Course());
    }

    for (int[] pair : prerequisites) {
      int wantedNumber = pair[0];
      int prereqNumber = pair[1];

      Course wantedCourse = map.get(wantedNumber);
      Course prereqCourse = map.get(prereqNumber);

      wantedCourse.incrementPrereqs();
      prereqCourse.prereqFor.add(wantedNumber);

      System.out.println("made graph edge from " + prereqNumber + " to " + wantedNumber);
    }

    int[] courseOrder = new int[numCourses];
    int orderIndex = 0;
    boolean completable = true;

    
    while (completable && orderIndex != numCourses) {
      
      boolean existsACourseThatCanDo = false;

      Set<Map.Entry<Integer, Course>> entries = map.entrySet();
      TreeSet<Map.Entry<Integer, Course>> sortedEntries = new TreeSet<>(new Comparator<Map.Entry<Integer, Course>>() {
        public int compare(Map.Entry<Integer, Course> a, Map.Entry<Integer, Course> b) {
          if (a.getValue().numberPrereqs < b.getValue().numberPrereqs) return -1;
          if (a.getValue().numberPrereqs > b.getValue().numberPrereqs) return 1;
          return 0;
        }
      });

      for (Map.Entry<Integer, Course> entry : sortedEntries) {
        
      }
      
      for (Map.Entry<Integer, Course> entry : sortedEntries) {
        int courseNumber = entry.getKey();
        Course course = entry.getValue();

        if (course.numberPrereqs != 0) {
          break;
        }

        System.out.println(courseNumber + " " + course.numberPrereqs);
  
        if (!course.completed) {
          existsACourseThatCanDo = true;
          for (int prereqNumber : course.prereqFor) {
            map.get(prereqNumber).decrementPrereqs();
          }
          course.completed = true;
          courseOrder[orderIndex] = courseNumber;
          orderIndex++;
        }
      }

      if (!existsACourseThatCanDo) {
        completable = false;
      }
    }

    if (!completable) {
      return new int[0];
    } else {
      return courseOrder;
    }
    
  }
}