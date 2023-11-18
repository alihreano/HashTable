import java.util.Random;
import java.lang.Math;

public class AQPHashTable extends OAHashTable {
	private long p;
	ModHash h;
	public AQPHashTable(int m, long p) {
		super(m);
		this.p=p;
		this.h=ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		if (i%2==0) {
			return Math.floorMod((h.Hash(x)+i*i), m);
		}
		return Math.floorMod((h.Hash(x)-i*i), m);

		
	}
}
