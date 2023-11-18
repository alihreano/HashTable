import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private long p;
	ModHash h1;
	ModHash h2;
	public DoubleHashTable(int m, long p) {
		super(m);
		this.p=p;
		this.h1=ModHash.GetFunc(m,p);
		this.h2=ModHash.GetFunc(m-1,p);

	}
	
	@Override
	public int Hash(long x, int i) {
		return Math.floorMod((h1.Hash(x)+i*((h2.Hash(x)+1))),m);

	}
	
}
