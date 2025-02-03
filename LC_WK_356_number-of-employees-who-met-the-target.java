class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        if(hours.length == 0 ) return 0;
        int totalEmployees = hours.length;
        int count = 0;
        for(int index = 0; index < totalEmployees; index++ ) {
            if(hours[index] >= target) count++;
        }
        return count;
    }
}©leetcode
