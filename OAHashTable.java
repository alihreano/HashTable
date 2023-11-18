
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	public int m;
	private final HashTableElement DELETED=new HashTableElement(-1,-1);

	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.m=m;
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		for (int i=0;i<m;i++) { 
			int j=this.Hash(key, i); 
			if (this.table[j]==null) {
				return null;
			}
			else if(this.table[j].GetKey()==key) {
				return this.table[j];
			}
		}
		return null;
	}

	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		if (this.Find(hte.GetKey())!=null) {
			throw new KeyAlreadyExistsException(hte);
		}
		for (int i=0; i<m ;i++) {
			int j=this.Hash(hte.GetKey(), i);
			if (this.table[j]==null || this.table[j].GetKey()==-1) {
				this.table[j]=hte;
				return;
			}
		}
		throw new TableIsFullException(hte);
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		for (int i=0; i<m ;i++) {
			int j=this.Hash(key, i);
			if (this.table[j]==null) {break;}
			if (this.table[j].GetKey()==key) {
				this.table[j]=DELETED;
				return;
			}
		}
		throw new KeyDoesntExistException(key);
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
	
	
}
