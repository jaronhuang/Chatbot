/*
*	Author: Amir Hasan
*	Last Updated: 10-4-17
*	Description: My chatbot
*/
public class ChatBotHasan
{
	private int findKeyword(String response, String keyword, int startPos)
	{
		String testResponse=response.toLowerCase();
		String testKeyword=keyword.toLowerCase();
		int where=testResponse.indexOf(testKeyword, startPos);
		if(where>0)
		{
			boolean checking=true;
			while(checking)
			{
				if(testResponse.substring(where+testKeyword.length(), where+testKeyword.length()+1).compareTo("a")<0 && testResponse.substring(where+testKeyword.length(), where+testKeyword.length()+1).compareTo("z")>0)
				{
					return where;
				}
				else
				{
					return -1;
				}
			}
		}
		return -1;
	}
}