#include <stdio.h>
#include <stdlib.h>

int* findMissingElements(int* nums, int numsSize, int* returnSize) {
    // 1 <= nums[i] <= 100 hai, isliye 101 size ka array rakhenge
    int seen[101] = {0};
    int minVal = nums[0];
    int maxVal = nums[0];

    // Min, Max find karna aur numbers ko mark karna
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] < minVal) minVal = nums[i];
        if (nums[i] > maxVal) maxVal = nums[i];
        seen[nums[i]] = 1;
    }

    // Result ke liye memory allocate karna
    int* result = (int*)malloc((maxVal - minVal + 1) * sizeof(int));
    int count = 0;

    // Min se Max tak check karna ki kaun sa number gayab hai
    for (int i = minVal; i <= maxVal; i++) {
        if (!seen[i]) {
            result[count++] = i;
        }
    }

    // Return size set karna jo LeetCode C ke liye zaroori hota hai
    *returnSize = count;
    return result;
}