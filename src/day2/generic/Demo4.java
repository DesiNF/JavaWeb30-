package day2.generic;

public class Demo4 {

	//编写一个泛型方法，实现指定位置上的数组元素的交换
	public <T> void swap(T arr[],int pos1,int pos2){
		T temp=arr[pos1];
		arr[pos1]=arr[pos2];
		arr[pos2]=temp;
	}
	
	//编写一个泛型方法，接收一个任意数组，并颠倒数组中所有元素
	public <T>void reverse(T arr[]){
		int start=0;
		int end=arr.length-1;
		
		while(true){
			if(start>=end){
				break;
			}
			T temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			
			start++;
			end--;
		}
	}
	
}
