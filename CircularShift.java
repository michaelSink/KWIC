
public class CircularShift extends Filter implements circularOutput{

	//Varaible for holding output of circular shifts
	private String circularOutput = "";

	/*
		Input: inputArray
		Output: None
		Purpose: Takes array reference and shifts the contents by one place to the left 
	*/
	private void shiftString(String[] inputArray){
		String temp = inputArray[0];
		for(int i = 0; i < inputArray.length - 1; i++){
			inputArray[i] = inputArray[i + 1];
		}
		inputArray[inputArray.length - 1] = temp;
	}

	/*
		Input: None
		Output: None
		Purpose: Constantly polls for data from the in pipe, and
					passes shifted string to next pipe.
	*/
	@Override
	public void run() {
		while(true){
			try{
				String data = pull();
				write(data);
				if(data != null){
					circularOutput += data + "\n";
					String[] dataArray = data.split(" ");
					for(int i = 1; i < dataArray.length; i++){
						shiftString(dataArray);
						String out = String.join(" ", dataArray);
						circularOutput += out + "\n";
						write(out);
					}
				}

			}catch(Exception e){
				System.out.println(e);
			}
		}
	}

	/*
		Input: None
		Output: String
		Purpose:  Returns the results from the circular shift(s).
	*/
	@Override
	public String getCircularShift() {
		return circularOutput;
	}

	/*
		Input: None
		Output: None
		Purpose:  Resetting circular output.
	*/
	@Override
	public void resetCircularShift() {
		this.circularOutput = "";
	}

}