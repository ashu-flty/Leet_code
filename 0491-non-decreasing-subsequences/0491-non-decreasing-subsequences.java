class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
         Map<Integer, List<List<Integer>>> map = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            tmp.add(List.of(nums[i]));
            int maxEqual = -1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    for (List<Integer> l : map.get(j)) {
                        List<Integer> cand = new ArrayList<>(l);
                        cand.add(nums[i]);
                        tmp.add(cand);
                    }
                } 
            }
            map.put(i, tmp);
        }
        for (int i : map.keySet()) {
            for (List<Integer> l : map.get(i)) {
                if (l.size() > 1) res.add(l);
            }
        }
        return new ArrayList(res);
    }
}