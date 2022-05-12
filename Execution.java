import java.io.*;
import java.util.Scanner;
import java.util.Random;

abstract class Crypto
{
	abstract void encrypt();
	abstract void decrypt();
}

class KeyException extends Exception
{
	KeyException()
	{
		super("KEY CANNOT BE ZERO!");
	}
}

class CryptoSystem extends Crypto
{
	void encrypt()
	{
		Random ran = new Random();
		int key = ran.nextInt(5);
		try
		{
			if(key == 0)
			{
				throw new KeyException();
			}
		}
		catch(KeyException e)
		{
			key += 5;
		}
		System.out.println("\nYour key is: "+key);
		String text;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Text To Encrypt: ");
		text = scan.nextLine();
		char[] chars1 = text.toCharArray();
		System.out.println("");
		for(char c : chars1)
		{
			c += key;
			System.out.print(c);
		}
		System.out.println("");
	}
	void decrypt()
	{
		int key;
		String text;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Text To Decrypt: ");
		text = sc.nextLine();
		System.out.print("Enter Key: ");
		key = sc.nextInt();
		char[] chars2 = text.toCharArray();
		System.out.println("");
		for(char c : chars2)
		{
			c -= key;
			System.out.print(c);
		}
		System.out.println("");
	}
}

class Execution
{
	public static void main(String args[])throws IOException
	{
		int option;
		Scanner sc = new Scanner(System.in);
		CryptoSystem Obj = new CryptoSystem();
		do
		{
			System.out.println("\nMain Menu \n1. Encrypt\n2. Decrypt\n3. Exit");
			System.out.print("Enter your option: ");
			option = sc.nextInt();
			switch(option)
			{
				case 1:
				Obj.encrypt();
				break;
				
				case 2:
				Obj.decrypt();
				break;
				
				case 3:
				break;
				
				default:
				System.out.println("Error! Try again");
			}
		}
		while(option != 3);
	}
}