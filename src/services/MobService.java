package services;


public interface MobService {

	public EnvironmentService getEnv();
	public int getCol();
	public int getRow();
	public Dir getFace();
	void init (EnvironmentService env,int col, int row, Dir face) throws Exception, Error;
	 // preCond (0 <= col < env.getHeight()) &&
	 //			(0 <= row < env.getHeight()) 
	
	public void forward () throws Exception, Error;
	public void backward () throws Exception, Error;
	public void turnL() throws Exception, Error;
	public void turnR() throws Exception, Error;
	public void strafeL() throws Exception, Error;
	public void strafeR()throws Exception, Error;
	
}
