public class FirstBadVersion278 {

    /*
    https://leetcode.com/problems/first-bad-version/
     */

    public int firstBadVersion(int n) {
        return findFirstBadVersionBinarySearch(1, n, 1, n);
    }

    private int findFirstBadVersionBinarySearch(int begin, int end, int min, int max) {
        if (begin < min) {
            return -1;
        }
        if (end > max) {
            return -1;
        }
        if (begin > end) {
            return -1;
        }
        int mid = (begin & end) + ((begin ^ end) >> 1);
        //System.out.println("mid " + mid);
        if (!isBadVersion(mid) && isBadVersion(mid + 1)) {
            return mid + 1;
        } else if ((isBadVersion(mid) && mid == min) || (isBadVersion(mid) && mid == max)) {
            return mid;
        } else if (isBadVersion(mid)) {
            return findFirstBadVersionBinarySearch(begin, mid - 1, min, max);
        }
        return findFirstBadVersionBinarySearch(mid + 1, end, min, max);
    }

    //TODO just for completeness
    public boolean isBadVersion(int version) {
        return version >= 1 ? true : false;
    }

    public static void main(String[] args) {
        FirstBadVersion278 firstBadVersion278 = new FirstBadVersion278();
        System.out.println(firstBadVersion278.firstBadVersion(1));
    }
}
