public class Element 
{
	private int value;
	private int maxTotal;

	public Element(int num)
	{
		value = num;
		maxTotal = -1;
	}
	
	public int getVal()
	{
		return value;
	}
	
	public int getMaxTotal()
	{
		return maxTotal; 
	}
	
	public void setMaxTotal(int total)
	{
		maxTotal = total;
	}

}
