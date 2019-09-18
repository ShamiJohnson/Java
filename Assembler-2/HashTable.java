public class HashTable {
	private LinkedList Table[];
	
	public HashTable()
	{
		Table = new LinkedList[13];
	};
	
	public Key Hash(String OpCode)
	{
		int val = OpCode.hashCode();
		Mnemonic Code = Translate(val);
		val = val % 13;
		
		int i = 0;
		LinkedList Temp = Table[val];
		
		if (Temp != null)
		{
			while (true)
			{
				if (Temp.Check(Code))
					break;
				
				if (Temp.hasNext())
				{
					Temp = Temp.Next();	// increment through linked list
					i++;
				}
				else
					break;
			}
		
			Temp.Add(Code);
		}
		else
		{
			Table[val] = new LinkedList();
			Table[val].Set(Code);
		}
		
		return new Key(val,i);
	};
	
	public Mnemonic Read(Key Access)
	{
		LinkedList Temp = Table[Access.Value()];
		return Temp.Read(Access.Index());
	};
	
	private Mnemonic Translate(int hash)
	{
		switch (hash)
		{
		case 64641:
			//ADD
			return new Mnemonic("000110", 3);

		case 2003941:
			//ADDF
			return new Mnemonic("010110", 3);

		case 2003953:
			//ADDR
			return new Mnemonic("100100", 2);

		case 64951:
			//AND
			return new Mnemonic("010000", 3);

		case 64208429:
			//CLEAR
			return new Mnemonic("101101", 2);

		case 2074383:
			//COMP
			return new Mnemonic("001010", 3);

		case 64305943:
			//COMPF
			return new Mnemonic("100010", 3);

		case 64305955:
			//COMPR
			return new Mnemonic("101000", 3);

		case 67697:
			//DIV
			return new Mnemonic("001001", 3);

		case 2098677:
			//DIVF
			return new Mnemonic("011001", 3);

		case 2098689:
			//DIVR
			return new Mnemonic("100111", 3);

		case 69621:
			//FIX
			return new Mnemonic("110001", 2);

		case 66988604:
			//FLOAT
			return new Mnemonic("110000", 1);

		case 71534:
			//HIO
			return new Mnemonic("111101", 1);

		case 74:
			//J
			return new Mnemonic("001111", 1);

		case 73334:
			//JEQ
			return new Mnemonic("001100", 1);

		case 73399:
			//JGT
			return new Mnemonic("001101", 3);

		case 73554:
			//JLT
			return new Mnemonic("001110", 3);

		case 2286998:
			//JSUB
			return new Mnemonic("001010", 3);

		case 75209:
			//LDA
			return new Mnemonic("000000", 3);

		case 75210:
			//LDB
			return new Mnemonic("011010", 3);

		case 72279920:
			//LDCCH
			return new Mnemonic("010100", 3);

		case 75214:
			//LDF
			return new Mnemonic("011100", 3);

		case 75220:
			//LDL
			return new Mnemonic("000010", 3);

		case 75227:
			//LDS
			return new Mnemonic("011011", 3);

		case 75228:
			//LDT
			return new Mnemonic("011101", 3);

		case 75232:
			//LDX
			return new Mnemonic("000001", 3);

		case 75599:
			//LPS
			return new Mnemonic("110100", 3);

		case 76708:
			//MUL
			return new Mnemonic("001000", 3);

		case 2378018:
			//MULF
			return new Mnemonic("011000", 3);

		case 2378030:
			//MULR
			return new Mnemonic("100110", 2);

		case 2402236:
			//NORM
			return new Mnemonic("110010", 1);

		case 2531:
			//OR
			return new Mnemonic("010001", 3);

		case 2610:
			//RD
			return new Mnemonic("110110", 3);

		case 81268:
			//RMO
			return new Mnemonic("101011", 2);

		case 2525326:
			//RSUB
			return new Mnemonic("010011", 3);

		case -1850009558:
			//SHIFTL
			return new Mnemonic("101001", 2);

		case -1850009552:
			//SHIFTR
			return new Mnemonic("101010", 2);

		case 82105:
			//SIO
			return new Mnemonic("111100", 1);

		case 82411:
			//SSK
			return new Mnemonic("111011", 3);

		case 82432:
			//STA
			return new Mnemonic("000011", 3);

		case 82433:
			//STB
			return new Mnemonic("011110", 3);

		case 2555526:
			//STCH
			return new Mnemonic("010101", 3);

		case 82437:
			//STF
			return new Mnemonic("100000", 3);

		case 82440:
			//STI
			return new Mnemonic("110101", 3);

		case 82443:
			//STL
			return new Mnemonic("000101", 3);

		case 82450:
			//STS
			return new Mnemonic("011111", 3);

		case 2556037:
			//STSW
			return new Mnemonic("111010", 3);

		case 82451:
			//STT
			return new Mnemonic("100001", 3);

		case 82455:
			//STX
			return new Mnemonic("000100", 3);

		case 82464:
			//SUB
			return new Mnemonic("000111", 3);

		case 2556454:
			//SUBF
			return new Mnemonic("011111", 3);

		case 2556466:
			//SUBR
			return new Mnemonic("100101", 2);

		case 82496:
			//SVC
			return new Mnemonic("101100", 2);

		case 2672:
			//TD
			return new Mnemonic("111000", 3);

		case 83066:
			//TIO
			return new Mnemonic("111110", 1);

		case 83075:
			//TIX
			return new Mnemonic("001011", 3);

		case 2575407:
			//TIXR
			return new Mnemonic("101110", 2);

		case 2765:
			//WD
			return new Mnemonic("110111", 3);
		}
		return null;
	}
}
