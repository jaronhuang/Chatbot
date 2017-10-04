import java.util.Scanner;

public class ChatBotRunner 
{
	public static void main(String[] args)
	{
		
		System.out.println ("How are you?");
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		System.out.println ("Do you want to talk about movies, music, or TV shows?");
		System.out.println("Please respond with movies, music, or tv.");
		String response = in.nextLine();
		if (response.toLowerCase().equals("movies"))
		{
			ChatBotHuang chatbot1 = new ChatBotHuang();
		}
		if (response.toLowerCase().equals("music"))
		{
			ChatBotRavvin chatbot1 = new ChatBotRavvin();
		}
		if (response.toLowerCase().equals("tv"))
		{
			ChatBotHasan chatbot1 = new ChatBotHasan();
		}
		
		while (!statement.equals("Bye"))
		{
			System.out.println (chatbot1.getResponse(statement));
			statement = in.nextLine();
		}
	}
	
}
