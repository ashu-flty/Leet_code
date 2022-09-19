import re
class Solution:
    def myAtoi(self, str: str) -> int:
        x=re.match('^[ ]*[-+]{0,1}[0-9]{1,}', str)
        if(x==None):
            return 0
        number=int(x.group(0))
        if(number<2147483648 and number >-2147483648):
            return number
        elif(number<0):
            return -2147483648
        else:
            return 2147483647