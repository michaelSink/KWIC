import java.util.ArrayList;
import java.util.Collections;

public class Sorter extends Filter{

	ArrayList<String> sortedList = new ArrayList<String>();

	@Override
	public void run() {
		while(true){
			try{
				write(pull());
			}catch(Exception e){
				break;
			}
		}

		Collections.sort(sortedList);
		while(!sortedList.isEmpty()){
			write(sortedList.remove(0));
		}

	}
}