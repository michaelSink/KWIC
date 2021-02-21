import java.util.ArrayList;
import java.util.Collections;
import comparator.*;

public class Sorter extends Filter{

	ArrayList<String> sortedList = new ArrayList<String>();

	@Override
	public void run() {

		while(true){
			try{
				String data = pull();
				if(data != null){
					sortedList.add(data);
				}else{
					Collections.sort(sortedList, new stringComparator());
					while(!sortedList.isEmpty()){
						write(sortedList.remove(0));
					}
				}
			}catch(Exception e){
				break;
			}
		}
	}
}