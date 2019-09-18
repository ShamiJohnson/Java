//imperative statement hash table
			//contains "mneumonic", "opcode"
			Hashtable<String, String> imperative = new Hashtable<String, String>();
			imperative.put("ADD", "18");
			imperative.put("ADDR", "90");
			imperative.put("COMPR", "A0");
			imperative.put("JLT", "38");

			//declarative hash table
			//contains "mneumonic", "opcode"
			Hashtable<String, String> declarative = new Hashtable<String, String>();
			declarative.put("LDS", "6C");
			declarative.put("LDT", "74");
			declarative.put("LDX", "04");
			declarative.put("LDA", "00");
			declarative.put("STA", "0C");

			//Assembler Directives hash table
			//contains "mneumonic", "opcode"
			Hashtable<String, String> asmDirectives = new Hashtable<String, String>();
			asmDirectives.put("START", "");
			asmDirectives.put("END", "");
			asmDirectives.put("RESW", "");

			//creating hash table data structure for type String, String
			Hashtable<String, String> symTable = new Hashtable<String, String>();



