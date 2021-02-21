
public class main {

	static Filter[] filters = {new CircularShift(), new Sorter()};
	public static void main(String[] args){
		
		DataSource source = new DataSource();
		DataSink sink = new DataSink();

		for(int i = 0; i < filters.length + 1; i++){

			Pipe newPipe = new Pipe();

			if(i == 0){
				source.setOut(newPipe);
				filters[i].setIn(newPipe);
				continue;
			}

			if(i == filters.length){
				sink.setIn(newPipe);
				filters[i - 1].setOut(newPipe);
				continue;
			}

			filters[i - 1].setOut(newPipe);
			filters[i].setIn(newPipe);

		}

		new Thread(source).start();
		for(int i = 0; i < filters.length; i++){
			new Thread(filters[i]).start();
		}
		new Thread(sink).start();

	}

}