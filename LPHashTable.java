import java.util.Random;

public class LPHashTable extends OAHashTable {
	private long p;
	ModHash h;
	public LPHashTable(int m, long p) {
		super(m);
		this.p=p;
		this.h=ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return Math.floorMod((this.h.Hash(x)+i), m);

		
	}
	

	
}
