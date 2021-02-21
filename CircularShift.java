
public class CircularShift extends Filter{

	private void shiftString(String[] inputArray){
		String temp = inputArray[0];
		for(int i = 0; i < inputArray.length; i++){
			inputArray[i] = inputArray[i + 1];
		}
		inputArray[inputArray.length - 1] = temp;
	}

	@Override
	public void run() {
		try{
			String input = pull();
			write(input);

			String[] inputArray = input.split(" ");
			for(int i = 0; i < inputArray.length; i++){
				shiftString(inputArray);
				write(String.join(" ", inputArray));
			}

		}catch(Exception e){}
	}
}