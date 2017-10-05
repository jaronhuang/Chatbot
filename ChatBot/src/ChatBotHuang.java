import java.util.Random;
//Jaron

public class ChatBotHuang 
{
	int emotion = 0;
	
	public String getGreeting()
	{
		return "Hi, I'm the movie chatbot! What's going on?";
	}
	
	private int findKeyword(String statement, String goal,
			int startPos)
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
		else if (findKeyword(statement, "I like to", 0) >= 0)
		{
			response = transformILikeToStatement(statement);
		}
		else if (findKeyword(statement, "Fast and Furious", 0) >= 0)
		{
			response = "Can you guess my favorite character in the fast and furious?";
		}
		else if (findKeyword(statement, "Dom", 0) >= 0 || findKeyword(statement, "Brian", 0) >= 0 || findKeyword(statement, "Roman", 0) >= 0)
		{
			return getRandomGuess();
		}
		else
		{
			response = getRandomQuestion();
		}
		return response;
	}
	
	private String transformILikeToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I like to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you like to " + restOfStatement + "?";
	}
	
	private String guessGame(String statement)
	{
		if (findKeyword(statement, "Dom", 0) >= 0 || findKeyword(statement, "Brian", 0) >= 0 || findKeyword(statement, "Roman", 0) >= 0)
		{
			return getRandomGuess();
		}
		else
		{
			return "Haha! You didn't guess my character!";
		}
	}
	
	private String getRandomQuestion ()
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
	
	private String getRandomGuess()
	{
		Random r = new Random ();
		return randomGuessed [r.nextInt(randomGuessed.length)];
	}
	
	private String [] randomMovieGenre = {"Do you like to watch action movies?", "Do you like to watch horror movies?", 
			"Do you like to watch adventure movies?", " Do you like to watch comedy movies?"};
	private String [] randomDislikeMovie = {"What movies did you not enjoy?", "What movie was overhyped in your opinion?",
			"What movie franchise do you not like?", "Which villian do you dislike?", "Did you enjoy watching IT?"};
	private String [] randomEnjoyMovie = {"What is your favorite movie?", "What movie franchise is your favorite?",
			"Who is your favorite movie character of all time?", "Who is your favorite superhero?"};
	private String [] randomGuessed = {"How did you guess?!?!", "Who told you?", "You're a genius!"};
	}

