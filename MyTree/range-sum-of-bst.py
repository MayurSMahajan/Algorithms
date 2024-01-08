// Time: 106ms beats 98%, space: 24.4mb beats 97.66%
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        if not root:
            return 0
        
        total_sum = 0

        if low <= root.val <= high:
            total_sum += root.val

        if root.val > low:
            total_sum += self.rangeSumBST(root.left, low, high)

        if root.val < high:
            total_sum += self.rangeSumBST(root.right, low, high)

        return total_sum
