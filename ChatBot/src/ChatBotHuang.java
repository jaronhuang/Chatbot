import java.util.Random;

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
			response = "I also like that too!";
			emotion++;
		}
		else if (findKeyword(statement, "I like to", 0) >= 0)
		{
			response = transformILikeToStatement(statement);
		}
		else
		{
			response = getRandomResponse();
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
	
	private String transformIYouStatement(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	
	
	private String getRandomQuestion ()
	{
		Random r = new Random ();
		return [r.nextInt(randomMovieGenre.length)];
	}
	
	private String [] randomMovieGenre = {"Do you like to watch action movies?", "Do you like to watch horror movies?", 
			"Do you like to watch adventure movies?", " Do you like to watch comedy movies?"};
	}

