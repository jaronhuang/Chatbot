/*
*	Author: Amir Hasan
*	Last Updated: 10-9-17
*	Description: My chatbot, with the theme of TV shows.
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
					where=testResponse.indexOf(testKeyword,where+1);
					if(where<0)
					{
						checking=false;
					}
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
					where=testResponse.indexOf(testKeyword,where+1);
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
							where=testResponse.indexOf(testKeyword,where+1);
							if(where<0)
							{
								checking=false;
							}
						}
					}
				}
			}
		}
		return where;
	}
	public String getGreeting()
	{
		return greetings[getRandomInteger(0,greetings.length-1)];
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
		if(userSays.trim().length()==0||silentTreatment)
		{
			if(userSays.trim().length()!=0)
			{
				userSilence--;
			}
			else
			{
				userSilence++;
			}
			if(userSilence==0&&silentTreatment)
			{
				silentTreatment=false;
				response="I'll end the silent treatment now.";
			}
			else
			{
				response=respondToSilence();
			}
		}
		else if(findKeyword(userSays,"I hate", 0)>0)
		{
			response="Why do you hate that?";
		}
		else if(findKeyword(userSays,"I don't like",0)>0)
		{
			response="Why don't you like it?";
		}
		else if(findKeyword(userSays,"because",0)>0)
		{
			response=becauseResponses[getRandomInteger(0,becauseResponses.length-1)];
		}
		else if(findKeyword(userSays,"My favorite",0)>0)
		{
			if(findKeyword(userSays,"genre",0)>0)
			{
				response="Oh, cool! My favorite TV show genre is "+tvGenres[getRandomInteger(0,tvGenres.length-1)]+".";
			}
			else if(findKeyword(userSays,"show",0)>0)
			{
				response="That's a good TV show!";
			}
			else
			{
				response="Neat!";
			}
		}
		else if(findKeyword(userSays,"Do you like",0)>0)
		{
			response=likeResponses[getRandomInteger(0,likeResponses.length-1)];
		}
		else
		{
			response=conversationTopics[getRandomInteger(0,conversationTopics.length-1)];
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
	private String[] becauseResponses= {"Interesting.","Oh.","Okay."};
	private String[] conversationTopics= {"What is your favorite type of TV show?","What is your favorite TV show?","How many TV shows do you watch?"};
	private String[] tvGenres= {"action","comedy","romance","mystery"};
	private String[] likeResponses= {"Well, I can't say for certain.","Just a little bit.","Yes, it's really cool!","I've never really cared much for it."};
}