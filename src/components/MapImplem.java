package components;

import java.util.HashMap;
import java.util.Map;

import services.Cell;
import services.Coordinate;
import services.MapService;

public class MapImplem implements MapService{

	
	public MapImplem(int height, int width, Map<Coordinate, Cell> cellnature) {
		super();
		this.height = height;
		this.width = width;
		this.cellnature = cellnature;
	}

	private int height;
	private int width;
	private Map<Coordinate,Cell> cellnature;
	
	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public Cell getCellNature(int x, int y) {
		// TODO Auto-generated method stub
		return cellnature.get(new Coordinate(x,y));
	}

	@Override
	public void init(int height, int width) throws Exception {
		// TODO Auto-generated method stub
		this.height=height;
		this.width=width;
		this.cellnature= new HashMap();
		
	}

	@Override
	public void OpenDoor(int x, int y) throws Exception {
		// TODO Auto-generated method stub
		Coordinate p = new Coordinate(x,y);
		if (getCellNature(x,y)== Cell.DNC){
			cellnature.put(p, Cell.DNO);
		}else{
			if (getCellNature(x,y)== Cell.DWC){
			 cellnature.put(p, Cell.DWO);
		}
		}
		
	}

	@Override
	public void CloseDoor(int x, int y) throws Exception {
		// TODO Auto-generated method stub
		Coordinate p = new Coordinate(x,y);
		if (getCellNature(x,y)== Cell.DNO){
			cellnature.put(p, Cell.DNC);
		}else{
			if (getCellNature(x,y)== Cell.DWO){
			 cellnature.put(p, Cell.DWC);
		}
		}
		
	}

}
