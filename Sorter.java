import java.util.ArrayList;
import java.util.Collections;
import comparator.*;

public class Sorter extends Filter{

	private ArrayList<String> sortedList = new ArrayList<String>();

	/*
		Input: None
		Output: None
		Purpose: Sort the collection of String based on,
					a<A<b<B...z<Z, and write data to 
					out Pipe.
	*/
	private void sort(){
		try{
			if(sortedList.size() == 0){
				return;
			}
			Collections.sort(sortedList, new stringComparator());
			while(!sortedList.isEmpty()){
				write(sortedList.remove(sortedList.size() - 1));
			}
			write(null);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/*
		Input: None
		Output: None
		Purpose: Constantly poll from in data, and add data to sortedList, and
					once a NULL data comes, sort and flush data. 
	*/
	@Override
	public void run() {

		while(true){
			try{
				String data = pull();
				if(data != null){
					sortedList.add(data);
				}else{
					sort();
				}
			}catch(Exception e){
				break;
			}
		}
	}
}