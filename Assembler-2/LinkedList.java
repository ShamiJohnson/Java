public class LinkedList {
	private LinkedList Next;
	private Mnemonic OpCode;
	
	public LinkedList()
	{
		Next = null;
		OpCode = null;
	};
	
	public void Add(Mnemonic OpCode)
	{
		if (this.OpCode != null)
		{
			if (Check(OpCode))
			{
				Next = new LinkedList();
				Next.Set(OpCode);
			}
		}
	};
	
	public void Set(Mnemonic OpCode)
	{
		this.OpCode = OpCode;
	};
	
	public Mnemonic Read(int i)
	{
		if (i == 0)
			return OpCode;
		else
		{
			if (Next != null)
				Next.Read(i--);
		}
		
		return null;
	}
	
	public boolean hasNext()
	{
		if (Next != null)
			return true;
		
		return false;
	};
	
	public LinkedList Next()
	{
		return Next;
	};
	
	public boolean Check(Mnemonic Code)
	{
		return (Code.OpCode().hashCode() == OpCode.OpCode().hashCode());
	}
}
