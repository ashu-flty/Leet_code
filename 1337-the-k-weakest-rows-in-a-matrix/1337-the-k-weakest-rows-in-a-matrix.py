class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        heap = []    
                
        for idx, row in enumerate(mat):
            heapq.heappush(heap, (sum(val for val in row), idx))
        
        
        return [idx for val, idx in heapq.nsmallest(k, heap)]
        