import java.util.Random;

public class ChatBotDana {

	int emotion = 0;
	
	public String getGreeting()
	{
		System.out.println("Welcome, I'm the music chatbot!");
		getRandomQuestion();
	}
	
	String refPronoun = "";
	Random r = new Random();
	
	//creates an array of random topics to talk about with the user
	private String [] randomMusicTopic = {"band", "song", "genre", "artist"};
	
	//gets a question to ask the user to begin the conversation in the music subtopic
	private String getRandomQuestion()
	{
		String chosenMusicTopic = randomMusicTopic[r.nextInt(randomMusicTopic.length)];
		return "What is your favorite " + chosenMusicTopic + "?";
	}
	
	//gets the pronoun to use when responding 
	if (chosenMusicTopic == "band" || chosenMusicTopic == "artist")
	{
		refPronoun = "them";
	}
	else
	{
		refPronoun = "that";
	}
	
	//creates an array of possible random responses
	private String [] randomPositiveResponses = {"I also love " + refPronoun + "." , "I also like " +refPronoun + ".", "It's the best!", "I agree!"};
	private String [] randomNegativeResponses = {"Oh, I hate " + refPronoun + "." , "Really? " + refPronoun + "? I disagree.", "That's terrible sense of taste." , "Ew!"};
	private String [] randomNeutralResponses = {"Oh, please, tell me more." , "Why do you think that is?" , "How interesting.", "What else do you like?"};
	//gets a response to send to the user 
	private String getResponse(String statement)
	{
		String chosenResponse = "";
		
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
		
		statement = statement.trim();
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else
		{
			response = chosenResponse + "."; 
		}
		return response; 
	}
}
