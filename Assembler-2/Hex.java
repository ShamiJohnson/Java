
public class Hex {
	public String code;
	private String hex_values;
	private int size;
	
	public Hex(int value, int length)
	{	// convert integer to string in hex
		hex_values = new String("0123456789ABCDEF");
		size = length;
		
		code = int_to_hex(value);
		
		if (value < 0)
			Add(1);	// 2's complement
	}
	
	public Hex(String hex_code)
	{
		hex_values = new String("0123456789ABCDEF");
		
		size = hex_code.length();
		code = hex_code;
	}
	
	public String int_to_hex(int value)
	{
		String temp = new String("");
		String result = new String("");
		boolean is_neg = false;
		
		if (value < 0)
			is_neg = true;
		
		while (value > exp())
			value -= exp();
		
		if (value >= 0)		
			for (; value > 0; value /= 16)
				temp += hex_values.charAt(value % 16);
		else
		{
			for (; -value > 0; value /= 16)
				temp += hex_values.charAt(-value % 16);
			
			temp = invert(temp);
		}
		
		int result_length = temp.length();
		
		if (result_length >= size)
			temp = temp.substring(0, size);
		else
		{
			for (int i = 0; i < (size - result_length); i++)
				if (is_neg)
					temp += "F";
				else
					temp += "0";
		}
		
		for (int i = temp.length() - 1; i >= 0; i--)
			result += temp.charAt(i);	// invert hex string
		
		return result;
	}
	
	private int exp()
	{	// returns 16^size, useful for checking overflow
		int result = 1;
		
		for (int i = 0; i < size; i++)
			result *= 16;
			
		return result;
	}
	
	public int hex_to_int(char hex)
	{
		return hex_values.indexOf(hex);
	}
	
	public int hex_to_int(String hex)
	{
		int result = 0;
		
		for (int i = 0; i < hex.length(); i++)
		{
			result *= 16;
			result += hex_values.indexOf(hex.charAt(i));
		}
		
		return result;
	}
	
	public String invert(String hex)
	{
		String result = new String("");
		
		for (int i = 0; i < hex.length(); i++)
			result += hex_values.charAt( 15 - hex_values.indexOf( hex.charAt(i) ) );
			
		return result;
	}
	
	public void Add(char hex)
	{
		Add(hex_to_int(hex));
	}
	
	public void Add(Hex hex)
	{
		this.code = int_to_hex(hex.hex_to_int(hex.code) + hex_to_int(this.code));
	}
	
	public void Add(String hex)
	{
		Add(hex_to_int(hex));
	}
	
	public void Add(int value)
	{	// Performs Addition of some integer constant
		// Will handle signed integers of any size
		int result;
		
		if (value < 0)
		{
			result = - hex_to_int(invert(int_to_hex(value))) + hex_to_int(code);
		}
		else
			result = value + hex_to_int(code);
		
		if (result < 0)
		{
			code = int_to_hex(-result - 1);
			code = invert(code);
		}
		else
			code = int_to_hex(result);
		
		if (code.length() > size)
			code = code.substring(code.length() - size - 1 , code.length() - 1);
	}
}
