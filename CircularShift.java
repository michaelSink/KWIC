
public class CircularShift extends Filter{

	private void shiftString(String[] inputArray){
		String temp = inputArray[0];
		for(int i = 0; i < inputArray.length - 1; i++){
			inputArray[i] = inputArray[i + 1];
		}
		inputArray[inputArray.length - 1] = temp;
	}

	@Override
	public void run() {
		while(true){
			try{
				String data = pull();
				write(data);

				if(data != null){
					String[] dataArray = data.split(" ");
					for(int i = 1; i < dataArray.length; i++){
						shiftString(dataArray);
						write(String.join(" ", dataArray));
					}
				}

			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
}