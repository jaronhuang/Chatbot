import java.util.Random;

public class ChatBotDana {

	String refPronoun = "";
	Random r = new Random();
	
	//creates an array of random topics to talk about with the user
	private String [] randomMusicTopic = {"band", "song", "genre", "artist"};
	
	//gets a question to ask the user to begin the conversation in the music subtopic
	private String getRandomQuestion()
	{
		chosenMusicTopic = randomMusicTopic[r.nextInt(randomMusicTopic.length)];
		System.out.println("What is your favorite " + chosenMusicTopic + "?");
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
	private String [] randomResponses = {"I also love", "I also like", "Really? Why?", "Can you tell me why?"}
	
	//gets a response to send to the user 
	private String getResponse(String statement)
	{
		statement = statement.trim();
		String response = "";
		String chosenResponse = randomResponses[r.nextInt(randomResponses.length)];
		
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else
		{
			response = chosenResponse + " " + refPronoun; 
		}
		return response; 
	}
}
