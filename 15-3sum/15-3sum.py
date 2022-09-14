class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        counter = Counter(nums)

        uniques = sorted(counter.keys())

        res = []

        # breakpoint()

        for first in uniques:

            if first > 0:

                break

            counter[first] -= 1

            for third in uniques[::-1]:

                second = 0 - first - third

                # if second > third, we must have seen this triplet already

                if third < 0 or second > third:

                    break

                if second < first:  # third is too big, keep searching

                    continue

                if third != second and counter[second] > 0 and counter[third] > 0:

                    res.append([first, second, third])

                elif third == second and counter[second] > 1:

                    res.append([first, second, third])

        return res