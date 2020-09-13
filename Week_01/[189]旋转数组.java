class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length, swapCnt = 0;
        k = k % len;

        for (int startIdx = 0; swapCnt < len; startIdx++) {
            int nextIdx = startIdx, prev = nums[startIdx];
            do {
                nextIdx = (nextIdx + k) % len;
                // swap
                int temp = nums[nextIdx];
                nums[nextIdx] = prev;
                prev = temp;

                swapCnt++;
            } while (startIdx != nextIdx);
        }
    }
}