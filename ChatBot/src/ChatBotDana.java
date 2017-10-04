import java.util.Random;

public class ChatBotDana {

	String refPronoun = "";
	Random r = new Random();
	//working on the music topic
	private String [] randomMusicTopic = {"band", "song", "genre", "artist"};
	
	private String getRandomQuestion()
	{
		chosenMusicTopic = randomMusicTopic[r.nextInt(randomMusicTopic.length)];
		System.out.println("What is your favorite " + chosenMusicTopic + "?");
	}
	
	if (chosenMusicTopic == "band" || chosenMusicTopic == "artist")
	{
		refPronoun = "them";
	}
	else
	{
		refPronoun = "that";
	}
	private String [] randomResponses = {"I also love", "I also like", "Really? Why?", "Can you tell me why?"}
	
	private String getResponse(String statement)
	{
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
	}
}
