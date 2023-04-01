class BinarySearch{
	public static void main(String []ar){
		int[] nums = {-1,0,3,5,9,12};
		BS bs = new BS();
		System.out.println(bs.search(nums, 9));
	}
}

class BS {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        } 
        return -1;
    }
}