import java.util.Random;

/*
 * Written by Dana Ravvin
 * 10/5/17
 * My music Chatbot
 */

public class ChatBotDana {

	int emotion = 0;
	int responseCount = 0;
	
	public String getGreeting()
	{
		return "Welcome, I'm the music chatbot! How's it going?";
	}
	
	String refPronoun = "";
	Random r = new Random();
	
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		int psn = phrase.indexOf(goal, startPos);

		while (psn >= 0)
		{
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(),psn + goal.length() + 1);
			}

			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
			{
				return psn;
			}
			psn = phrase.indexOf(goal, psn + 1);
		}
		return -1;
	}
	 
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	
	//creates an array of random topics to talk about with the user
	private String [] randomMusicTopic = {"band", "song", "genre", "artist"};
	
	//gets a question to ask the user to begin the conversation in the music subtopic
	private String getRandomStarterQuestion()
	{
		String chosenMusicTopic = randomMusicTopic[r.nextInt(randomMusicTopic.length)];
		return "What is your favorite " + chosenMusicTopic + "?";
	}
	
	private String [] randomQuestions = {"Who would you say is the most popular artist of this decade?", "What is the best way to listen to music?" , "Have you been to any concerts?", "Do you like singing?", "What's the best genre?", "Is there anyone in the world who doesn't like music?" , "How often do you listen to music?" , "Do you ever get sick of music?", "Do you like any specific artist?" , "What is your favorite band?" , "During what years do you think music was the most interesting?" , "When do you listen to music the most?"};
	
	private String getRandomQuestion()
	{
		return randomQuestions[r.nextInt(randomQuestions.length)];
	}
	
	//creates an array of possible random responses
	private String [] randomPositiveResponses = {"It's the best!", "I agree!", "That's cool!" , "Wow!", "Awesome.", "Love it!" , "Good opinion."};
	private String [] randomNegativeResponses = {"Really? " + refPronoun + "I disagree.", "That's terrible sense of taste." , "Ew!" , "I don't agree." , "That's unfortunate.", "Now that's ridiculous.", "Who raised you?"};
	private String [] randomNeutralResponses = {"Oh, please, tell me more." , "Why do you think that is?" , "How interesting.", "What else do you like?", "That's cool." , "Oh, nice." , "Okay."};
	//gets a response to send to the user 
	public String getResponse(String statement)
	{
		if (findKeyword(statement, "no") >= 0)
		{
			emotion--;
		}
		if (findKeyword(statement, "yes") >= 0)
		{
			emotion++;
		}
		
		String chosenResponse = "";
		statement = statement.trim();
		String response = "";
		
		if (responseCount == 0)
		{
			chosenResponse = getRandomStarterQuestion();
		}
		
		if (findKeyword(statement, "like") >= 0)
		{
			response = "I also like them.";
			return response;
		}
		if (findKeyword(statement, "love") >= 0)
		{
			response = "I also love them.";
			return response;
		}
		
		if (responseCount%2 == 0)
		{
			chosenResponse = getRandomQuestion();
		}
		else
		{	
			if (emotion > 0)
			{
				chosenResponse = randomPositiveResponses[r.nextInt(randomPositiveResponses.length)];
			}
			if (emotion < 0)
			{
				chosenResponse = randomNegativeResponses[r.nextInt(randomNegativeResponses.length)];
			}
			else 
			{
				chosenResponse = randomNeutralResponses[r.nextInt(randomNeutralResponses.length)];
			}
		}
		
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else
		{
			response = chosenResponse; 
		}
		responseCount++;
		return response; 
	}
}
