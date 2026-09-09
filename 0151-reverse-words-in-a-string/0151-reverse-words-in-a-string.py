class Solution:
    def reverseWords(self, s: str) -> str:
        v = s.split()
        v.reverse()
        return" ".join(v)
        