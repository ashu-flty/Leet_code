class Solution {
      
    public int[] beautifulArray(int n) {
        List<Integer> ordered = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        return arrangeBeautifully(ordered).stream().mapToInt(it -> it).toArray();
    }
   
    private List<Integer> arrangeBeautifully(List<Integer> numbers) {
        // two numbers or less are already arranged
        if (numbers.size() <= 2) {
            return numbers;
        }
        
        // split into two lists by taking every other number. all odds indexes go left, all even indexes go right
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < numbers.size(); ++i) {
            if (i % 2 == 0) {
                left.add(numbers.get(i));
            } else {
                right.add(numbers.get(i));
            }            
        }
        
        // arrange both halves recursively
        List<Integer> arrangedLeft = arrangeBeautifully(left);
        List<Integer> arrangedRight = arrangeBeautifully(right);
        
        // combine arranged halves into one list
        arrangedLeft.addAll(arrangedRight);
        return arrangedLeft;        
    }    
}