package DigitalTimer;


public class Model{

	int start = 0;
	int reset = 0;
	int mode = 0;
	int minup = 0;
	int mindown = 0;
	int secup = 0;
	int secdown = 0;
    int minup2 = 0;
	int secup2 = 0;
	
	public int start(){
		return start;
    }
	
	public void setStart(int n){
		start = n;
    }
	
	public void setReset(int n){
		reset = n;
	}
	   
	  public void setMode(int n) {
	     mode = n;
	   }
	  public void setMinup(int n) {
	     minup = n;
	   }
	   public void setMindown(int n) {
	      minup = n;
	   }
	   public void setSecup(int n) {
	      secup = n;
	   }
	   public void setSecdown(int n) {
	      secdown = n;
	   }
	   public void setMinup2(int n) {
		  minup2 = n;
	   }
	   public void setSecup2(int n) {
		  secup2 = n;
	   }

}
