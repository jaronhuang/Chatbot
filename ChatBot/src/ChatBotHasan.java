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
		String beforeThing="";
		String afterThing="";
		if(where>0)
		{
			boolean checking=true;
			while(checking)
			{
				beforeThing=testResponse.substring(where-1, where);
				afterThing=testResponse.substring(where+testKeyword.length(),where+testKeyword.length()+1);
				if((beforeThing.compareTo("a")<0||beforeThing.compareTo("z")>0)&&(afterThing.compareTo("a")<0||afterThing.compareTo("z")>0))
				{
					checking=false;
					return where;
				}
				else
				{
					where=testResponse.indexOf(testKeyword,where);
				}
			}
		}
		if(where==0)
		{
			boolean checking=true;
			while(checking)
			{
				afterThing=testResponse.substring(where+testKeyword.length(),where+testKeyword.length()+1);
				if(afterThing.compareTo("a")<0||afterThing.compareTo("z")>0)
				{
					checking=false;
					return where;
				}
				else
				{
					where=testResponse.indexOf(testKeyword,where);
					while(checking)
					{
						beforeThing=testResponse.substring(where-1, where);
						afterThing=testResponse.substring(where+testKeyword.length(),where+testKeyword.length()+1);
						if((beforeThing.compareTo("a")<0||beforeThing.compareTo("z")>0)&&(afterThing.compareTo("a")<0||afterThing.compareTo("z")>0))
						{
							checking=false;
							return where;
						}
						else
						{
							where=testResponse.indexOf(testKeyword,where);
						}
					}
				}
			}
		}
		return where;
	}
}