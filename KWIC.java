
public class KWIC {

	static Filter[] filters = {new CircularShift(), new Sorter()};
	static DataSource source;
	static DataSink sink;

	public static void main(String[] data){

		sink = new DataSink();

		inputTransfer transfer = new gui(sink, (CircularShift)filters[0]);

		source = new DataSource(transfer);

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