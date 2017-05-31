import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{

	public static void main(String[] args)
	{
	
		int puzzleSize = 3;
		Process process = new Process();

		List<String> steps = new ArrayList<String>(
				process.solve(process.generataPuzzle(puzzleSize), puzzleSize));
		
		Collections.reverse(steps);
		for(int i = 0 ; i < steps.size() ; i++)
		{
			System.out.println(steps.get(i));
		}
	}
	
}
