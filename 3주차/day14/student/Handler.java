package student;

public class Handler {
	private int size = 10;
	private Student[] arr = new Student[size];
	
	public Handler() {}
	
	public int add(Student student) {
		int row = 0;
		for(int i = 0 ; i < size; i++) {
			if(arr[i]==null) {
				arr[i] = student;
				row = 1;
				break;
			}
		}
		return row;
	}
	
	public Student[] getArray() {
		return arr;
	}
	
	public Student[] getSortedArray() {
		Student[] tmpArr = arr;
		for(int i = 0 ; i < tmpArr.length-1; i++) {
			for(int j = i+1; j < tmpArr.length; j++) {
				if(tmpArr[i] != null 
				   &&
				   tmpArr[j] != null)
				{
					if(tmpArr[j].getAvg() > tmpArr[i].getAvg()) {
						Student tmp = tmpArr[i];
						tmpArr[i] = tmpArr[j];
						tmpArr[j] = tmp;
					}
				}
			}
		}
		return tmpArr;
	}
	
	public int delete(String name) {
		int row = 0;
		for(int i = 0 ; i < size; i++) {
			if(arr[i]!=null && arr[i].getName().equals(name)) {
				arr[i] = null;
				row = 1;
				System.out.println(name + "이(가) 제거되었습니다.");
			}
		}
		return row;
	}
	
	public Student[] search(String keyword) {
		Student[] result;
		int count = 0;
		for(int i = 0 ; i < size; i ++) {
			if(arr[i] != null && arr[i].getName().contains(keyword)) {
				count++;
			}
		}
		result = new Student[count];
		
		int index = 0;
		for(int i = 0 ; i < size; i++) {
			if(arr[i]!=null && arr[i].getName().contains(keyword)) {
				result[index++] = arr[i];
			}
		}
		return result;
	}
}
