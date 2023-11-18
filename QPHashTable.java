import java.util.Random;

public class QPHashTable extends OAHashTable {
	private long p;
	public ModHash h;
	public QPHashTable(int m, long p) {
		super(m);
		this.p=p;
		this.h=ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return Math.floorMod((h.Hash(x)+(i*i)), m);
	}
	
}
