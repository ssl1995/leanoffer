package 剑指Offer.分类版.C05_栈和队列.剑指Offer40_最小的k个数;


public class Solution {

    // 快速排序法:只用返回坐标k左边的数即可
    // 注意：与NC119相比，力扣剑指Offer40使用我的那个堆排序解法会超时
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < k || k == 0) {
            return new int[]{};
        }
        int[] res = new int[k];
        quickSort(arr, res, k, 0, arr.length - 1);
        return res;
    }

    private void quickSort(int[] arr, int[] res, int k, int l, int r) {
        int i = l;
        int j = r;
        while (l < r) {
            while (l < r && arr[r] >= arr[i]) {
                r--;
            }
            while (l < r && arr[l] <= arr[i]) {
                l++;
            }
            swap(arr, l, r);
        }
        swap(arr, i, l);
        if (l > k) {
            quickSort(arr, res, k, i, l - 1);
        } else if (l < k) {
            quickSort(arr, res, k, l + 1, j);
        } else {
            // 取前面的k个即可
            for (int m = 0; m < k; ++m) {
                res[m] = arr[m];
            }
        }

    }

    //交换数组中两个元素的值
    private void swap(int[] arr, int i, int j) {
        // 防止下标越界
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
