package components;

import java.util.Map;

import services.Cell;
import services.Content;
import services.Coordinate;
import services.EnvironmentService;

public class Environment extends MapImplem implements EnvironmentService {

	public Environment(int height, int width, Map<Coordinate, Cell> cellnature) {
		super(height, width, cellnature);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Content getContent(int i, int j) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
