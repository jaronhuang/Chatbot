/*
*	Author: Amir Hasan
*	Last Updated: 10-4-17
*	Description: My chatbot
*/
public class ChatBotHasan
{
	int userSilence=0;
	boolean silentTreatment=false;
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
		if(userSays.trim().length()==0)
		{
			userSilence++;
			response=respondToSilence();
		}
		else if(userSilence>0)
		{
			userSilence--;
		}
		return response;
	}
	public String respondToSilence()
	{
		if(!silentTreatment)
		{
			if(userSilence==1)
			{
				return "Why so quiet?";
			}
			if(userSilence==2)
			{
				return "Please say something.";
			}
			if(userSilence==3)
			{
				return "This is getting annoying.";
			}
			if(userSilence==4)
			{
				return "Fine, I'm gonna give you the silent treatment as well!";
			}
		}
		return "...";
	}
	private String[] greetings= {"Hello!","Hi!","Howdy!","What's up?"};
}