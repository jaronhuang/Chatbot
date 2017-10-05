/*
*	Author: Amir Hasan
*	Last Updated: 10-4-17
*	Description: My chatbot
*/
public class ChatBotHasan
{
	int userSilence=0;
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
	public String getGreeting()
	{
		return greetings[getRandomInteger(0,greetings.length)];
	}
	private int getRandomInteger(int low, int high)
	{
		if(high<low)
		{
			int x=low;
			low=high;
			high=x;
		}
		return (int)(Math.random()*(high-(low-1))+low);
	}
	public String getResponse(String userSays)
	{
		String response="";
		if(userSays.length()==0)
		{
			response="";
		}
		return response;
	}
	private String[] greetings= {"Hello!","Hi!","Howdy!","What's up?"};
}