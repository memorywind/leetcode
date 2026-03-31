# 1、两数之和-哈希表

给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出 **和为目标值** *`target`* 的那 **两个** 整数，并返回它们的数组下标。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
```

**思路**：使用哈希表存储数组中的数和下标，判断target-当前数字是否存在与哈希表中，如果存在则添加对应的下标，不存在则添加进哈希表

# 2、字母异位词分组-哈希表-数组排序

给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

**输入:** strs = ["eat", "tea", "tan", "ate", "nat", "bat"]

**输出:** [["bat"],["nat","tan"],["ate","eat","tea"]]

**思路**：1、遍历给定的数组，每一个字符串转换为字符数组，将排序后的字符串作为哈希表的键

2、判断表中是否已经存在的key，存在则加入key对应的列表中

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            if (map.containsKey(s)) {
                map.get(s).add(temp);
            }else{
                List<String> list = new ArrayList<>();
                list.add(temp);
                map.put(s,list);
            }
        }
        ans.addAll(map.values());
        return ans;
    }
}
```

# 3、最长连续序列-set集合去重

给定一个未排序的整数数组 `nums` ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

```
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
```

**思路**：定义set集合去重，存储数组中的所有元素，遍历数组，判断集合中是否存在当前数字的前一个数字，存在则直接跳过，不存在说明是当前子序列的最小值避免重复计算。判断是否存在当前数字的下一个数字，如果存在，长度加1，循环判断。

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int size = 1;
            while (set.contains(i + 1)) {
                size++;
                i++;

            }
            ans = Math.max(ans, size);
        }
        return ans;
    }
}
```

# 4、移动0

给定一个数组 `nums`，编写一个函数将所有 `0` 移动到数组的末尾，同时保持非零元素的相对顺序。

```
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
```

**思路**：遍历数组，判断数组中有几个不为零的数，如果当前数不为零，则将其依次放入数组中。第二次从第一个不为的位置开始，后面的位置全部填充为0

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i =j; j < nums.length; j++) {
            nums[i] = 0;
        }
    }
}
```

# 5、盛水最多的容器-双指针

给定一个长度为 `n` 的整数数组 `height` 。有 `n` 条垂线，第 `i` 条线的两个端点是 `(i, 0)` 和 `(i, height[i])` 。找出其中的两条线，使得它们与 `x` 轴共同构成的容器可以容纳最多的水。

![image-20260330214647510](C:\Users\王浩\AppData\Roaming\Typora\typora-user-images\image-20260330214647510.png)

**思路**：定义左右指针，盛水的多少取决于两端比较矮的那根，面积等于左右之差*矮的那根柱子的高度。遍历数组，不断更新面积最大值。左右指针谁矮动谁

```java
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
```

# 6、三数之和-双指针+有序数组

给你一个整数数组 `nums` ，判断是否存在三元组 `[nums[i], nums[j], nums[k]]` 满足 `i != j`、`i != k` 且 `j != k` ，同时还满足 `nums[i] + nums[j] + nums[k] == 0` 。请你返回所有和为 `0` 且不重复的三元组。

```
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
```

**思路：**先对数组进行排序，遍历数组，定义左右指针，判断当前数与左右指针的和，如果为0,将三个数加入结果，去重：新的指针指向数和之前的指向数相等则继续移动指针。大于零说明右边的太大了，左移右指针，小于0,右边太小了，右移左指针。

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int x = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = length - 1;
            while (j<k) {
                int sum = x + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
                if (sum == 0) {
                    ArrayList<Integer> sub = new ArrayList<>();
                    Collections.addAll(sub, x, nums[j], nums[k]);
                    ans.add(sub);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}
```

# 7、接雨水-双指针

给定 `n` 个非负整数表示每个宽度为 `1` 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

![image-20260330221110773](C:\Users\王浩\AppData\Roaming\Typora\typora-user-images\image-20260330221110773.png)

**思路：**定义左右指针，接多少雨水取决于左右两边最高的柱子和当前的差值，如果左边的矮，那么总雨水就是当前答案加左边最高的和当前的差值

```
class Solution {
    public int trap(int[] height) {
        int L = 0, R = height.length - 1;
        int leftMax = 0, rightMax = 0, ans = 0;
        while (L < R) {
            leftMax = Math.max(leftMax, height[L]);
            rightMax = Math.max(rightMax, height[R]);
            if (leftMax <= rightMax) {
                ans = ans + leftMax - height[L];
                L++;
            } else if (leftMax > rightMax) {
                ans = ans + rightMax - height[R];
                R--;
            }
        }
        return ans;
    }
}
```

# 8、无重复字符的最长字串-滑动窗口+哈希表

给定一个字符串 `s` ，请你找出其中不含有重复字符的 **最长 子串** 的长度。

```
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
```

**思路：**定义哈希表存储字符串中各个字符出现的次数，定义左右指针，移动右指针，如果当前字符的出现次数超过了1，则将左指针不断右移，缩小窗口，并将做指针对应的字符出现次数减1；最长字串的长度就是左右指针下标之差加1.

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
```

# 9、找到字符串中的所有字母异位词-滑动窗口+哈希表

给定两个字符串 `s` 和 `p`，找到 `s` 中所有 `p` 的 **异位词** 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

```
输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
```

**思路**：先使用哈希表统计目标字符串中的字符出现次数。遍历字符串，定义左指针，构建滑动窗口，滑动窗口做指针的值为：右指针-滑动窗口大小+1。如果大于等于0，说明窗口能成功构建，小于0继续遍历不做处理。统计窗口内各个字符出现的次数，如果相等，则说明是一个异位词，将当前的左指针加入答案（起始位置）。然后向右缩减窗口，将当前位置的字符的出现次数减1，如果当前位置字符的出现次数已经为0，则将对应的字符移除。

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int L = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
            L = i - p.length() + 1;
            if (L >= 0) {
                if (map1.equals(map)) {
                    ans.add(L);
                }
                map1.put(s.charAt(L), map1.get(s.charAt(L)) - 1);
                if (map1.get(s.charAt(L)) == 0) {
                    map1.remove(s.charAt(L));
                }
            }
        }
        return ans;
    }
}
```

# 10、和为k的子数组-哈希表+前缀和

给你一个整数数组 `nums` 和一个整数 `k` ，请你统计并返回 *该数组中和为 `k` 的子数组的个数* 。子数组是数组中元素的连续非空序列。

**示例 1：**

```
输入：nums = [1,1,1], k = 2
输出：2
```

**思路：**定义哈希表存储和为sum的子数组的个数。key为sum，值为出现次数。`map.put(0, 1)` 是为了处理 **从数组开头开始的和为 k 的子数组**。
当当前前缀和 `sum` 刚好等于 `k` 时，需要有一个前缀和 `0` 与之匹配，使得 `sum - k = 0` 存在，这样才能正确计数。
初始化时放入 `(0, 1)` 表示前缀和为 0 出现了一次，这样遍历过程中就可以正常统计出所有满足条件的子数组，包括从索引 0 开始的那些。

遍历数组，统计到当前数为止的所有数的和出现的次数，如果当前哈希表中已经存在当前和-目标值的元素（因为子数组的和等于 `k` 等价于当前前缀和减去某个之前的前缀和等于 `k`，即之前的前缀和等于 `当前前缀和 - k`。）。

在遍历数组时计算当前前缀和，通过查找哈希表中是否存在前缀和等于当前前缀和减去k，来统计以当前元素结尾的和为k的子数组个数，并将当前前缀和存入哈希表，从而在一次遍历中完成计数。

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
```

# 11、滑动窗口最大值-双端队列

给你一个整数数组 `nums`，有一个大小为 `k` 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 `k` 个数字。滑动窗口每次只向右移动一位。返回 *滑动窗口中的最大值* 。

**思路：**使用双端队列维护一个单调递减的索引序列，遍历数组时，先移除队尾所有小于当前值的索引（保证队首始终是窗口最大值），再将当前索引加入队尾，并移除队首超出窗口范围的索引，当窗口形成后，队首对应的值即为当前窗口最大值，最终得到所有滑动窗口的最大值。

```
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>(); // 存储索引
        for (int i = 0; i < nums.length; i++) {
            // 移除队尾所有小于当前值的元素（它们不可能成为窗口最大值）
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i); // 当前索引入队

            // 移除超出窗口的队首元素
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 当窗口形成时，记录最大值 窗口的下标为i-k+1到i
            if (i >= k - 1) {
                ans.add(nums[deque.peekFirst()]);
            }
        }
        // 转换为 int[]
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
```

# 12、最小覆盖子串-滑动窗口+哈希表

给定两个字符串 `s` 和 `t`，长度分别是 `m` 和 `n`，返回 s 中的 **最短窗口 子串**，使得该子串包含 `t` 中的每一个字符（**包括重复字符**）。如果没有这样的子串，返回空字符串 `""`。

```
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
```

**思路：**使用滑动窗口（双指针）和两个哈希表，先记录目标字符串 `t` 中各字符的出现次数，然后遍历字符串 `s`，用右指针 `R` 扩展窗口并更新窗口内字符计数，当窗口内已包含 `t` 中所有字符（通过 `valid` 变量统计达到所需次数的字符种类数）时，进入内层循环尝试用左指针 `L` 收缩窗口，在收缩过程中不断更新最小覆盖子串的起始位置和长度，直到窗口不再满足条件，最终返回最小长度的子串。

```java
class Solution {
    public String minWindow(String s, String t) {
        int L = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int valid = 0;
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> currentMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        for (int R = 0; R < s.length(); R++) {
            char c = s.charAt(R);
            currentMap.put(c, currentMap.getOrDefault(c, 0) + 1);
            // 检查当前字符是否是目标字符且数量达到要求
            if (targetMap.containsKey(c) && currentMap.get(c).intValue() == targetMap.get(c).intValue()) {
                valid++;
            }

            // 循环检查当前哈希表是否涵盖了目标哈希表
            // 当valid等于targetMap的大小时，说明当前窗口已经涵盖了所有目标字符
            while (valid == targetMap.size()) {
                // 更新最小窗口
                if (R - L + 1 < minLen) {
                    minLen = R - L + 1;
                    start = L;
                }

                // 尝试缩小窗口
                char leftChar = s.charAt(L);
                if (targetMap.containsKey(leftChar)) {
                    if (currentMap.get(leftChar).intValue() == targetMap.get(leftChar).intValue()) {
                        valid--;
                    }
                    currentMap.put(leftChar, currentMap.get(leftChar) - 1);
                } else {
                    currentMap.put(leftChar, currentMap.get(leftChar) - 1);
                }
                L++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
```

# 13、最大子数组和-前缀和

给你一个整数数组 `nums` ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。**子数组**是数组中的一个连续部分。

```
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
```

**思路：**遍历数组，记录每一个位置的前缀和，然后更新最大前缀和和答案。更新前缀和要先计算当前前缀和。

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for(int x : nums){
            pre = Math.max(pre+x,x);
            maxAns = Math.max(pre,maxAns);
        }
        return maxAns;
    }
}
```

# 14、合并区间

以数组 `intervals` 表示若干个区间的集合，其中单个区间为 `intervals[i] = [starti, endi]` 。请你合并所有重叠的区间，并返回 *一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间* 。

```
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
```

**思路：**按照区间的左端点进行排序,定义合并的临时开始和临时结束端点，如果临时结束的端点大于等于区间数组的某个左端点，说明有重叠，就更新当前的结束端点为当前的右端点。如果临时结束的端点小于区间数组的某个右端点，说明没有重叠，找到了当前合并的最大区间。然后更新临时区间的开始和结束为当前的开始和结束。

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        if (intervals.length == 0) {
            return ans.toArray(new int[ans.size()][]);
        }
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);

        int tempStart = intervals[0][0];
        int tempEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (tempEnd >= intervals[i][0]) {
                tempEnd = Math.max(tempEnd, intervals[i][1]);
            } else {
                ans.add(new int[] { tempStart, tempEnd });
                tempStart = intervals[i][0];
                tempEnd = intervals[i][1];
            }
        }
        ans.add(new int[] { tempStart, tempEnd });
        return ans.toArray(new int[ans.size()][]);
    }
}
```

# 15、轮转数组-排序+分别轮转

给定一个整数数组 `nums`，将数组中的元素向右轮转 `k` 个位置，其中 `k` 是非负数。

![image-20260331110114225](C:\Users\王浩\AppData\Roaming\Typora\typora-user-images\image-20260331110114225.png)

**思路：**先对整个数组进行反转(0,n-1)，然后分别反转前一段（0，k-1）和后一段（k,n-1）。定义轮转函数，其中交换指定位置的元素。

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // 轮转 k 次等于轮转 k % n 次
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}
```

# 16、除了自身以外数组的乘积-分别计算左边和右边的乘积+前缀积

给你一个整数数组 `nums`，返回 数组 `answer` ，其中 `answer[i]` 等于 `nums` 中除了 `nums[i]` 之外其余各元素的乘积 。

**示例 1:**

```
输入: nums = [1,2,3,4]
输出: [24,12,8,6]
```

**思路：**代码通过预处理每个元素左侧所有元素的乘积 `L[i]` 和右侧所有元素的乘积 `R[i]`，然后将两者相乘得到结果数组 `ans[i]`，从而在 O(n) 时间内计算出除自身外所有元素的乘积，避免使用除法。

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];

        L[0] = 1;
        R[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        for(int i =0;i<n;i++){
            ans[i] = L[i]*R[i];
        }
        return ans;
    }
}
```

# 17、缺失的第一个正数-整理数组元素至nums[nums[i]-1]的位置

给你一个未排序的整数数组 `nums` ，请你找出其中没有出现的最小的正整数。

**示例 1：**

```
输入：nums = [1,2,0]
输出：3
解释：范围 [1,2] 中的数字都在数组中。
```

**思路：**利用原地哈希的思想，通过遍历数组将每个值在 `[1, n]` 范围内的元素交换到其正确的位置（即值 `x` 应放在索引 `x-1` 处），使得数组在理想情况下呈现 `[1,2,...,n]` 的排列，最后再遍历数组找到第一个位置 `i` 上元素不是 `i+1` 的索引，该索引 `i+1` 即为缺失的最小正整数，若全部符合则返回 `n+1`。

```
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (1 <= nums[i] && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
```

# 18、矩阵置零-行数组、列数组标记是否置零

给定一个 `*m* x *n*` 的矩阵，如果一个元素为 **0** ，则将其所在行和列的所有元素都设为 **0** 。

**思路：**定义行数组和列数组，遍历二维数组，分别标记当前哪一行或哪一列是否需要置零。之后遍历二维数组，将对应行列的位置置零

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (row[i]||col[j]) {
                    matrix[i][j]=0;
                    
                }
            }
        }
    }
}
```

# 19、螺旋矩阵-定义边界逐个遍历

给你一个 `m` 行 `n` 列的矩阵 `matrix` ，请按照 **顺时针螺旋顺序** ，返回矩阵中的所有元素。

![image-20260331113713849](C:\Users\王浩\AppData\Roaming\Typora\typora-user-images\image-20260331113713849.png)

**思路：**定义上下左右边界，遍历二维数组，不断更新上下左右边界。

```
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;
        List<Integer> ans = new ArrayList<>();
        while (left < right && bottom > top) {
            for (int i = left; i < right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            if (top >= bottom) {
                break;
            }
            for (int j = top; j < bottom; j++) {
                ans.add(matrix[j][right-1]);
            }
            right--;
            if (left >= right) {
                break;
            }

            for (int k = right - 1; k >= left; k--) {
                ans.add(matrix[bottom-1][k]);
            }

            bottom--;
            if (top >= bottom) {
                break;
            }

            for (int l = bottom - 1; l >= top; l--) {
                ans.add(matrix[l][left]);
            }
            left++;
        }
        return ans;
    }
}
```

# 20、旋转图像-ij位置变成了j(rows-i-1)

给定一个 *n* × *n* 的二维矩阵 `matrix` 表示一个图像。请你将图像顺时针旋转 90 度。

![image-20260331122152626](C:\Users\王浩\AppData\Roaming\Typora\typora-user-images\image-20260331122152626.png)

**思路：**旋转完成后，ij位置的变成了j(rows-i-1)

```
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = arr[i][j];
            }
        }
    }
}
```

# 21、搜索二维矩阵-从右上角进行遍历

编写一个高效的算法来搜索 `*m* x *n*` 矩阵 `matrix` 中的一个目标值 `target` 。该矩阵具有以下特性：

- 每行的元素从左到右升序排列。
- 每列的元素从上到下升序排列。

**思路：**从右上角开始，如果当前元素大于目标值则向右搜索，如果小于等于就往下搜索。

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols - 1; // 从右上角开始
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
```

