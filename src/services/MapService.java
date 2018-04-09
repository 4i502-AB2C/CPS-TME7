package services;

public interface MapService {
	
	public int getHeight();
	public int getWidth();
	public Cell getCellNature(int x, int y ) throws Exception;
	public void init(int height, int width) throws Exception;
	public void OpenDoor(int x , int y) throws Exception;
	public void CloseDoor(int x , int y) throws Exception;

}
