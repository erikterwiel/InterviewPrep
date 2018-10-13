class Solution {
  public List<Integer> killProcess(List<Integer> pids, List<Integer> ppids, int kill) {
    
    HashMap<Integer, ArrayList<Integer>> toDeleteMap = new HashMap<>();
    
    for (int i = 0; i < pids.size(); i++) {

      if (!toDeleteMap.containsKey(ppids.get(i))) {
        toDeleteMap.put(ppids.get(i), new ArrayList<Integer>());
      }

      toDeleteMap.get(ppids.get(i)).add(pids.get(i));
    }

    return kill(toDeleteMap, kill, new ArrayList<Integer>());
  }

  public List<Integer> kill(HashMap<Integer, ArrayList<Integer>> map, int toKill, List<Integer> killed) {

    killed.add(toKill);
  
    if (!map.containsKey(toKill)) {
      return killed;
    }
   
    for (int toKillChild : map.get(toKill)) {
      kill(map, toKillChild, killed);
    }

    return killed;
  }
}