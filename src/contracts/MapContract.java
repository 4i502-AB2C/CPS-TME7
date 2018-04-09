package contracts;

import services.Cell;
import services.MapService;
import decorators.MapDecorator;

public class MapContract extends MapDecorator{

	public MapContract(MapService delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}

	/*true*/
	public void checkInvariant(){

	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();

	}

	@Override
	public Cell getCellNature(int x, int y) throws Exception {
		// TODO Auto-generated method stub
		// \pre 0 <= x < getwidth() && 0<= y < getHeight()
		if ( ! ( x>=0 && x < this.getWidth() && y >=0 && y< this.getHeight())) throw new Exception ( "pre 0 <= x < getwidth() && 0<= y < getHeight()");
		return super.getCellNature(x, y);

	}

	@Override
	public void init(int height , int width ) throws Exception {


		// \pre w > 0 && h > 0
		if ( !(height >0 && width > 0) )throw new Exception ("pre w > 0 && h > 0");
		super.init(height,width);

		// \post getHeight(init(h,w))=h
		if(this.getHeight() != height ){
			throw new Exception("post getHeight(init(h,w))=h");
		}

		// \post getHeight(init(h,w))=h
		if(this.getWidth() != width ){
			throw new Exception("post getWidth(init(h,w))=w");
		}
	}

	@Override
	public void OpenDoor(int x, int y ) throws Exception {
		// TODO Auto-generated method stub
		// \pre CellNature(x,y) in { DNC, DWC}

		if (this.getCellNature(x, y)!= Cell.DNC && this.getCellNature(x, y)!= Cell.DWC){
			throw new Exception("pre CellNature(x,y) in { DNC, DWC}");
		}
		Cell cn = this.getCellNature(x, y);
		super.OpenDoor(x, y);
		// \post CellNature(x,y) = DWC => CellNatue(OpenDoor(x,y))=DWO
		if (cn== Cell.DWC && this.getCellNature(x, y)!= Cell.DWO ){
			throw new Exception("post CellNature(x,y) = DWC => CellNatue(OpenDoor(x,y))=DWO");
		}
		// \post CellNature(x,y) = DNC => CellNatue(OpenDoor(x,y))=DNO
		if (cn== Cell.DNC && this.getCellNature(x, y)!= Cell.DNO ){
			throw new Exception("post CellNature(x,y) = DNC => CellNatue(OpenDoor(x,y))=DNO");
		}

		// \post forall u in getWidth()-1 for all v in getHeight()-1 u!= x or v=!y => CellNature( OpenDoor()) == cellNature()

		for ( int u=0 ; u < this.getWidth()-1; u++){
			for ( int v = 0; v< this.getHeight(); v++){
				if ( u != x && v!=y){
					if (! (this.getCellNature(x, y)==cn))throw new Exception("post forall u in getWidth()-1 for all v in getHeight()-1 u!= x or v=!y => CellNature( OpenDoor()) == cellNature()");
				}
			}
		}


	}

	@Override
	public void CloseDoor(int x , int y) throws Exception {
		// TODO Auto-generated method stub
		// \pre CellNature(x,y) in { DNO, DWO}

		if (this.getCellNature(x, y)!= Cell.DNC && this.getCellNature(x, y)!= Cell.DWC){
			throw new Exception("pre CellNature(x,y) in {DNO, DWO}");
		}

		Cell cn = this.getCellNature(x, y);

		super.CloseDoor(x, y);

		// \post CellNature(x,y) = DWO => CellNatue(OpenDoor(x,y))=DWC
		if (cn== Cell.DWO && this.getCellNature(x, y)!= Cell.DWC ){
			throw new Exception("post CellNature(x,y) = DWO => CellNatue(OpenDoor(x,y))=DWC");
		}
		// \post CellNature(x,y) = DNC => CellNatue(OpenDoor(x,y))=DNO
		if (cn== Cell.DNO && this.getCellNature(x, y)!= Cell.DNC ){
			throw new Exception("post CellNature(x,y) = DNO => CellNatue(OpenDoor(x,y))=DNC");
		}

		// \post forall u in getWidth()-1 for all v in getHeight()-1 u!= x or v=!y => CellNature( OpenDoor()) == cellNature()

		for ( int u=0 ; u < this.getWidth()-1; u++){
			for ( int v = 0; v< this.getHeight(); v++){
				if ( u != x && v!=y){
					if (! (this.getCellNature(x, y)==cn))throw new Exception("post forall u in getWidth()-1 for all v in getHeight()-1 u!= x or v=!y => CellNature( OpenDoor()) == cellNature()");
				}
			}
		}

	}

}
