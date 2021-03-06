/*
*	Author: Amir Hasan
*	Last Updated: 10-11-17
*	Description: My chatbot, with the theme of TV shows.
*/
public class ChatBotHasan
{
	int userSilence=0;
	boolean silentTreatment=false;
	boolean userRespond=false;
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
			if(findKeyword(userSays,"you",findKeyword(userSays,"I hate", 0))>0)
			{
				response=upsetBot[getRandomInteger(0,upsetBot.length-1)]+" :(";
			}
			else
			{
				response="Why do you hate it?";
			}
		}
		else if(findKeyword(userSays,"I like", 0)>0)
		{
			if(findKeyword(userSays,"you",findKeyword(userSays,"I like", 0))>0)
			{
				response=flatteredBot[getRandomInteger(0,flatteredBot.length-1)]+" :D";
			}
			else
			{
				response="Why do you like it?";
			}
		}
		else if(findKeyword(userSays,"I don't like",0)>0)
		{
			if(findKeyword(userSays,"you",findKeyword(userSays,"I don't like", 0))>0)
			{
				response=upsetBot[getRandomInteger(0,upsetBot.length-1)]+" :(";
			}
			else
			{
				response="Why don't you like it?";
			}
		}
		else if(findKeyword(userSays,"because",0)>0)
		{
			response=neutralResponses[getRandomInteger(0,neutralResponses.length-1)];
		}
		else if(findKeyword(userSays,"My favorite",0)>0)
		{
			if(findKeyword(userSays,"genre",0)>0||(findKeyword(userSays,"show",0)>0&&findKeyword(userSays,"type",0)>0))
			{
				response="Oh, cool! My favorite TV show genre is "+tvGenres[getRandomInteger(0,tvGenres.length-1)]+".";
			}
			else if(findKeyword(userSays,"show",0)>0)
			{
				response="That's a good TV show!";
			}
			else
			{
				response=neutralResponses[getRandomInteger(0,neutralResponses.length-1)];
			}
		}
		else if(findKeyword(userSays,"Do you like",0)>0)
		{
			response=likeResponses[getRandomInteger(0,likeResponses.length-1)];
		}
		else if(userRespond)
		{
			response=neutralResponses[getRandomInteger(0,neutralResponses.length-1)];
			userRespond=false;
		}
		else if(findKeyword(userSays,"Have you",0)>0)
		{
			response=haveYou[getRandomInteger(0,haveYou.length-1)];
		}
		else
		{
			response=conversationTopics[getRandomInteger(0,conversationTopics.length-1)];
			userRespond=true;
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
				silentTreatment=true;
				return "Fine, I'm gonna give you the silent treatment as well!";
			}
		}
		return "...";
	}
	private String[] greetings= {"Hello!","Hi!","Howdy!","What's up?","Hey!"};
	private String[] neutralResponses= {"Interesting.","Oh.","Okay.","Cool.","Neat."};
	private String[] conversationTopics= {"What is your favorite type of TV show?","What is your favorite TV show?","How many TV shows do you watch?","How often do you watch TV?","Who is your favorite TV character?"};
	private String[] tvGenres= {"action","comedy","romance","mystery","drama","science fiction","fantasy"};
	private String[] likeResponses= {"Well, I can't say for certain.","Just a little bit.","Yes, it's really cool!","I've never really cared much for it."};
	private String[] upsetBot= {"You're mean.","Why would you say that?","Ouch.","I have feelings too, sorta."};
	private String[] haveYou= {"Yes, actually, I have!","No, I haven't."};
	private String[] flatteredBot= {"Aww, thanks!","You're cool, too!","You're super awesome!"};
}