package services;


public interface MobService {

	public EnvirenemmentService getEnv();
	public int getCol();
	public int getRow();
	public Dir getFace();
	void init (EnvirenemmentService env,int col, int row, Dir face);
	 // preCond (0 <= col < env.getHeight()) &&
	 //			(0 <= row < env.getHeight()) 
	
	public void forward ();
	public void backward ();
	public void turnL();
	public void turnR();
	public void strafeL();
	public void strafeR();
	
}
