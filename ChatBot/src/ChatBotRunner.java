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
		boolean userChose=false;
		while(!userChose)
		{
			String response = in.nextLine();
			if (response.toLowerCase().equals("movies"))
			{
				userChose=true;
				ChatBotHuang chatbot1 = new ChatBotHuang();
				System.out.println (chatbot1.getGreeting());
				statement = in.nextLine();
				while (!byeCheck(statement))
				{
					System.out.println (chatbot1.getResponse(statement));
					statement = in.nextLine();
				}
			}
			else if (response.toLowerCase().equals("music"))
			{
				userChose=true;
				ChatBotDana chatbot1 = new ChatBotDana();
				System.out.println (chatbot1.getGreeting());
				statement = in.nextLine();
				while (!byeCheck(statement))
				{
					System.out.println (chatbot1.getResponse(statement));
					statement = in.nextLine();
				}
			}
			else if (response.toLowerCase().equals("tv"))
			{
				userChose=true;
				ChatBotHasan chatbot1 = new ChatBotHasan();
				System.out.println (chatbot1.getGreeting());
				statement = in.nextLine();
				while (!byeCheck(statement))
				{
					System.out.println (chatbot1.getResponse(statement));
					statement = in.nextLine();
				}
			}
			else
			{
				System.out.println("That was not a valid choice.");
				System.out.println("Please respond with movies, music, or tv.");
			}
		}
		in.close();
	}
	public static boolean byeCheck(String sentence)
	{
		boolean goodbye=false;
		for(int x=0;x<byeStatements.length;x++)
		{
			if(sentence.toLowerCase().equals(byeStatements[x]))
			{
				goodbye=true;
			}
		}
		return goodbye;
	}
	public static String[] byeStatements= {"goodbye","farewell","bye","adios","until next time"};
}
