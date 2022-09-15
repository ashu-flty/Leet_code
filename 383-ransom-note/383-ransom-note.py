class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        magazine_mapping = {}
        ransomNote_mapping = {}
        for c in magazine:
            if c not in magazine_mapping:
                magazine_mapping[c] = 1
            else:
                magazine_mapping[c] += 1
        for c in ransomNote:
            if c not in ransomNote_mapping:
                ransomNote_mapping[c] = 1
            else:
                ransomNote_mapping[c] += 1
        
        if len(ransomNote_mapping.keys()) > len(magazine_mapping.keys()):
            return False
        
        for key,value in ransomNote_mapping.items():
            if key not in magazine_mapping or value > magazine_mapping[key]:
                return False
        return True
        