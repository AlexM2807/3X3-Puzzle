import java.util.ArrayList;
import java.util.List;

public class MovesForGame
{
	public List<Integer> moveUp(List<Integer> list, int puzzleSize, int currentPice)
	{

		List<Integer> nodeToEdit = new ArrayList<Integer>(list);

		for (int i = 0; i < nodeToEdit.size(); i++)
		{
			if (nodeToEdit.get(i) == currentPice)
			{
				if ((i >= puzzleSize) && (nodeToEdit.get((i - puzzleSize)) == 0))
				{

					nodeToEdit.set(i - puzzleSize, nodeToEdit.get(i));
					nodeToEdit.set(i, 0);

					return nodeToEdit;

				}
			}

		}

		return list;

	}

	public List<Integer> moveRight(List<Integer> list, int puzzleSize, int currentPice)
	{


		List<Integer> nodeToEdit = new ArrayList<Integer>(list);

		
		for (int i = 0; i < nodeToEdit.size(); i++)
		{
			if (nodeToEdit.get(i) == currentPice)
			{
				if ((((i + 1) % puzzleSize) != 0) && (nodeToEdit.get(i + 1) == 0))
				{

					nodeToEdit.set(i + 1, nodeToEdit.get(i));
					nodeToEdit.set(i, 0);
					return nodeToEdit;
					

				}

			}
		}
		
		return list;
	}

	public List<Integer> moveDown(List<Integer> list, int puzzleSize, int currentPice)
	{

		List<Integer> nodeToEdit = new ArrayList<Integer>(list);
		for (int i = 0; i < nodeToEdit.size(); i++)
		{
			if (nodeToEdit.get(i) == currentPice)
			{
				if ((i < ((puzzleSize * puzzleSize) - puzzleSize)) && (nodeToEdit.get(i + puzzleSize) == 0))
				{

					nodeToEdit.set(i + puzzleSize, nodeToEdit.get(i));
					nodeToEdit.set(i, 0);

					return nodeToEdit;

				}
			}
		}
		return list;
	}

	public List<Integer> moveLeft(List<Integer> list, int puzzleSize, int currentPice)
	{
		List<Integer> nodeToEdit = new ArrayList<Integer>(list);

		for (int i = 0; i < nodeToEdit.size(); i++)
		{
			if (nodeToEdit.get(i) == currentPice)
			{
				if (((i % puzzleSize) != 0) && (nodeToEdit.get(i - 1) == 0))
				{

					nodeToEdit.set(i - 1, nodeToEdit.get(i));
					nodeToEdit.set(i, 0);

					return nodeToEdit;

				}
			}
		}

		return list;
	}

	public List<Integer> move(List<Integer> list, int puzzleSize, int currentPice)
	{
		
		List<Integer> checkList = new ArrayList<Integer>(list);
		if(!moveUp(list, puzzleSize, currentPice).equals(checkList))
		{
			list = moveUp(list, puzzleSize, currentPice);
			
		}
			
			
		if(!moveRight(list, puzzleSize, currentPice).equals(checkList))
		{
			list = moveRight(list, puzzleSize, currentPice);
			
		}
			
		
		if(!moveDown(list, puzzleSize, currentPice).equals(checkList))
		{
			list = moveDown(list, puzzleSize, currentPice);
			
		}
			
		
		if(!moveLeft(list, puzzleSize, currentPice).equals(checkList))
		{
			list = moveLeft(list, puzzleSize, currentPice);	
			
		}
		
		

		
		return list;

	}
	
	public boolean checkGame(List<Integer> currentStatus , List<Integer>fianlPuzzle)
	{
		if(currentStatus.equals(fianlPuzzle))
		{
			System.out.println("END GAME");
			return false;
		}
		
		return true;
		
	}

}
