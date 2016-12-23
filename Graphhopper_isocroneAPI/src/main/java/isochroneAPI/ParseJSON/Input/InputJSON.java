package isochroneAPI.ParseJSON.Input;

import java.util.List;

public class InputJSON {
	
	private int timelimit;
	private List<Coordinate> bos;
	
	public int getTime_min(){
		return timelimit;
	}
	
	public List<Coordinate> getCoordinates() {
            return bos;
	}
}
