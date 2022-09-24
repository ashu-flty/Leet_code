class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        length=len(s)
        maps={}
        for char in s:
            maps[char]=0
        startIdx=endIdx=result=0
        while endIdx<length:
            while endIdx<length and not maps[s[endIdx]]:
                maps[s[endIdx]]=1
                endIdx+=1  
            result=max(result,endIdx-startIdx)
            if maps[s[startIdx]]:
                maps[s[startIdx]]=0
                startIdx+=1
        return result
        