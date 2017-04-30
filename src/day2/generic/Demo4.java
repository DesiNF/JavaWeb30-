package day2.generic;

public class Demo4 {

	//��дһ�����ͷ�����ʵ��ָ��λ���ϵ�����Ԫ�صĽ���
	public <T> void swap(T arr[],int pos1,int pos2){
		T temp=arr[pos1];
		arr[pos1]=arr[pos2];
		arr[pos2]=temp;
	}
	
	//��дһ�����ͷ���������һ���������飬���ߵ�����������Ԫ��
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
