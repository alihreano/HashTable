import java.util.Random;

public class ModHash {
	long a;
	long b;
	long p;
	int m;
	public ModHash(long ga,long gb,long gp,int gm) {
		this.a=ga;
		this.b=gb;
		this.p=gp;
		this.m=gm;
		
	}
	public static ModHash GetFunc(int m, long p){
		Random rnd=new Random();
		long a=Math.floorMod(rnd.nextLong(), p-1)+1;
		long b=Math.floorMod(rnd.nextLong(), p)+1;
		ModHash ob=new ModHash(a,b,p,m);
		return ob;
	}
	
	public int Hash(long key) {
		int res;
	    res=Math.floorMod(Math.floorMod((this.a*key+this.b), p), m);
		
		return res;
	}
	
}
