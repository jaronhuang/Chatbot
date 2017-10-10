import java.util.Random;
import java.lang.Math;
/*
 * Jaron Huang
 * 10/4/17
 * Movie Chatbot
 */
public class ChatBotHuang 
{
	int emotion = 0;
	
	public String getGreeting()
	{
		return "Hi, I'm the movie chatbot! What's going on?";
	}
	
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
	
	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "I'm waiting for a response...";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why not?";
            emotion--;
		}
		else if (findKeyword(statement, "yes") >= 0)
		{
			response = "I also like to too!";
			emotion++;
		}
		else if (findKeyword(statement, "Fast and Furious", 0) >= 0)
		{
			response = "Can you guess my favorite character in the fast and furious?";
			emotion++;
		}
		else if (findKeyword(statement, "Star Wars", 0) >= 9)
		{
			response = "Star Wars is one of my favorite franchises!";
			emotion++;
		}
		else if (findKeyword(statement, "Dom", 0) >= 0 || findKeyword(statement, "Brian", 0) >= 0 || findKeyword(statement, "Roman", 0) >= 0)
		{
			emotion++;
			return getRandomGuess();
		}
		else
		{
			int hold = (int)(Math.random() * 10 + 1);
			if (hold % 2 == 0)
			{
				response = getRandomQuestion();
			}
			else
			{
				response = getRandomStatement();
			}
		}
		return response;
	}
	
	private String getRandomQuestion()
	{
		Random r = new Random ();
		if (emotion == 0)
		{
			return randomMovieGenre [r.nextInt(randomMovieGenre.length)];
		}
		if (emotion < 0)
		{
			return randomDislikeMovie [r.nextInt(randomDislikeMovie.length)];
		}
		return randomEnjoyMovie [r.nextInt(randomEnjoyMovie.length)];
	}
	
	private String getRandomStatement()
	{
		Random r = new Random();
		return randomFillerStatement [r.nextInt(randomFillerStatement.length)];
	}
	private String getRandomGuess()
	{
		Random r = new Random ();
		return randomGuessed [r.nextInt(randomGuessed.length)];
	}
	
	private String [] randomMovieGenre = {"Do you like to watch action movies?", "Do you like to watch horror movies?", 
			"Do you like to watch adventure movies?", " Do you like to watch comedy movies?"};
	private String [] randomDislikeMovie = {"What movies did you not enjoy?", "What movie was overhyped in your opinion?",
			"What movie franchise do you not like?", "Which villain do you dislike?", "Did you enjoy watching IT?"};
	private String [] randomEnjoyMovie = {"What is your favorite movie?", "What movie franchise is your favorite?",
			"Who is your favorite movie character of all time?", "Who is your favorite superhero?"};
	private String [] randomGuessed = {"How did you guess my favorite movie character?!?!", "Who told you my favorite movie character?", 
			"You're a genius! How'd you guess my favorite movie character?"};
	private String [] randomFillerStatement = {"Tell me about your most recent movie you watched.", "Give me a good movie to watch!",
			"I remember when I fell asleep at the theater, did you ever fall asleep?", "I once got jumpscared and spilled popcorn everywhere! :(",
			"How about the overpriced movie theater food! I always sneak food in like the mischievous bot I am."};
}

