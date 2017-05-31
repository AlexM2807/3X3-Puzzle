import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

import java.util.Scanner;

public class Process
{

	public LinkedHashMap<Point, Integer> generataPuzzleCoords(List<Integer> in, int puzzleSize)
	{

		int x = 1;
		int y = 1;
		LinkedHashMap<Point, Integer> list = new LinkedHashMap<Point, Integer>();

		for (int i = 0; i < puzzleSize * puzzleSize; i++)
		{
			if (y > puzzleSize)
			{
				y = 1;
				x++;
			}
			list.put(new Point(x, y), in.get(i));
			y++;

		}

		return list;

	}

	public List<Integer> generateFinalPuzzle(int dimeniunePuzzle)
	{
		List<Integer> list = new ArrayList<Integer>();
		int piesa = 1;
		for (int i = 0; i < dimeniunePuzzle * dimeniunePuzzle - 1; i++)
		{
			list.add(piesa);
			piesa++;
		}
		list.add(0);

		return list;

	}

	public List<Integer> generataPuzzle(int puzzleSize)
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();

		// ***** PUZZLE LAB 3x3 =20 moves *******
		//
		list.add(1);
		list.add(2);
		list.add(3);

		list.add(4);
		list.add(8);
		list.add(5);

		list.add(7);
		list.add(0);
		list.add(6);
		//
		// Cost = 20
		// Fringe : 258
		// Closed : 432
		// Time : 0.072969445

		// **** PUZLE 4 X 4 *******
		//
		// list.add(1);
		// list.add(2);
		// list.add(3);
		// list.add(5);
		//
		// list.add(6);
		// list.add(4);
		// list.add(7);
		// list.add(8);
		//
		// list.add(9);
		// list.add(10);
		// list.add(11);
		// list.add(12);
		//
		// list.add(13);
		// list.add(14);
		// list.add(0);
		// list.add(15);

		// Cost = 25
		// Fringe : 19144
		// Closed : 20549
		// Time : 78.54054316

		// TEST 2

		// Cost = 25
		// Fringe : 19144
		// Closed : 20549
		// Time : 14.05722417

		// TEst 3
		// Cost = 25
		// Fringe : 23339
		// Closed : 23857
		// Time : 1.077460969

		// ******** PUZLE 4 X 4 144 MOVES *********
		// list.add(2);
		// list.add(13);
		// list.add(8);
		// list.add(9);
		//
		// list.add(7);
		// list.add(11);
		// list.add(6);
		// list.add(5);
		//
		// list.add(15);
		// list.add(12);
		// list.add(4);
		// list.add(10);
		//
		// list.add(14);
		// list.add(1);
		// list.add(3);
		// list.add(0);

		// *********

		// list.add(13);
		// list.add(2);
		// list.add(10);
		// list.add(3);
		//
		// list.add(1);
		// list.add(12);
		// list.add(8);
		// list.add(4);
		//
		// list.add(5);
		// list.add(0);
		// list.add(9);
		// list.add(6);
		//
		// list.add(15);
		// list.add(14);
		// list.add(11);
		// list.add(7);

		// *********** 5 X 5 ******************

		// list.add(17);
		// list.add(24);
		// list.add(1);
		// list.add(8);
		// list.add(15);
		//
		// list.add(23);
		// list.add(5);
		// list.add(7);
		// list.add(14);
		// list.add(16);
		//
		// list.add(4);
		// list.add(6);
		// list.add(13);
		// list.add(20);
		// list.add(22);
		//
		// list.add(10);
		// list.add(12);
		// list.add(19);
		// list.add(21);
		// list.add(3);
		//
		// list.add(11);
		// list.add(18);
		// list.add(0);
		// list.add(2);
		// list.add(9);

		return list;
	}

	public LinkedHashMap<Point, Integer> generateFinalPuzzleCoords(int puzzleSize)
	{
		int x = 1;
		int y = 1;
		LinkedHashMap<Point, Integer> list = new LinkedHashMap<Point, Integer>();
		int pice = 1;
		for (int i = 0; i < puzzleSize * puzzleSize - 1; i++)
		{
			if (y > puzzleSize)
			{
				y = 1;
				x++;
			}
			list.put(new Point(x, y), pice);
			y++;
			pice++;
		}
		list.put(new Point(x, y), 0);

		return list;

	}

	public Node moveUp(Node currentNode, int puzzleSize)
	{

		Node node = new Node();

		List<Integer> nodeToEdit = new ArrayList<Integer>(currentNode.getStare());

		for (int i = 0; i < nodeToEdit.size(); i++)
		{
			if ((i >= puzzleSize) && (nodeToEdit.get((i - puzzleSize)) == 0))
			{

				nodeToEdit.set(i - puzzleSize, nodeToEdit.get(i));
				nodeToEdit.set(i, 0);

				node = new Node(nodeToEdit, currentNode, "Moved Up", currentNode.getCost() + 1, manhatten(nodeToEdit));

				return node;

			}
		}

		return null;

	}

	public Node moveRight(Node currentNode, int puzzleSize)
	{

		Node node = new Node();

		List<Integer> nodeToEdit = new ArrayList<Integer>(currentNode.getStare());

		for (int i = 0; i < nodeToEdit.size(); i++)
		{
			if ((((i + 1) % puzzleSize) != 0) && (currentNode.stare.get(i + 1) == 0))
			{

				nodeToEdit.set(i + 1, nodeToEdit.get(i));
				nodeToEdit.set(i, 0);
				node = new Node(nodeToEdit, currentNode, "Moved Right", currentNode.getCost() + 1,
						manhatten(nodeToEdit));

				return node;

			}

		}

		return null;
	}

	public Node moveDown(Node currentNode, int puzzleSize)
	{
		Node node = new Node();
		List<Integer> nodeToEdit = new ArrayList<Integer>(currentNode.getStare());
		for (int i = 0; i < nodeToEdit.size(); i++)
		{
			if ((i < ((puzzleSize * puzzleSize) - puzzleSize)) && (currentNode.stare.get(i + puzzleSize) == 0))
			{

				nodeToEdit.set(i + puzzleSize, nodeToEdit.get(i));
				nodeToEdit.set(i, 0);
				node = new Node(nodeToEdit, currentNode, "Moved Down", currentNode.getCost() + 1,
						manhatten(nodeToEdit));
				return node;

			}

		}
		return null;
	}

	public Node moveLeft(Node currentNode, int puzzleSize)
	{
		List<Integer> nodeToEdit = new ArrayList<Integer>(currentNode.getStare());
		Node node = new Node();
		for (int i = 0; i < nodeToEdit.size(); i++)
		{
			if (((i % puzzleSize) != 0) && (currentNode.stare.get(i - 1) == 0))
			{

				nodeToEdit.set(i - 1, nodeToEdit.get(i));
				nodeToEdit.set(i, 0);
				node = new Node(nodeToEdit, currentNode, "Moved Left", currentNode.getCost() + 1,
						manhatten(nodeToEdit));

				return node;

			}

		}
		return null;
	}

	public List<Node> moves(Node currentNode, int puzzleSize)
	{

		// System.out.println("Q" + currentNode.getStare().toString());
		List<Node> childs = new ArrayList<Node>();

		if (moveUp(currentNode, puzzleSize) != null)
			childs.add(moveUp(currentNode, puzzleSize));
		if (moveRight(currentNode, puzzleSize) != null)
			childs.add(moveRight(currentNode, puzzleSize));
		if (moveDown(currentNode, puzzleSize) != null)
			childs.add(moveDown(currentNode, puzzleSize));
		if (moveLeft(currentNode, puzzleSize) != null)
			childs.add(moveLeft(currentNode, puzzleSize));

		return childs;

	}

	public List<String> showSteps(Node node)
	{

		Node currentNode = node;

		List<String> movesToMake = new ArrayList<String>();
		while (currentNode.parinte != null)
		{

			movesToMake.add(currentNode.getActiune());

			currentNode = currentNode.getParinte();

		}
		createFile(movesToMake);

		System.out.println("Cost = " + node.getCost());

		return movesToMake;

	}

	public void createFile(List<String> stepsList)
	{
		Collections.reverse(stepsList);
		try
		{
			PrintWriter writer = new PrintWriter("steps_4x4.txt", "UTF-8");
			for (int i = 0; i < stepsList.size(); i++)
			{
				writer.println(stepsList.get(i));
			}

			writer.close();
		} catch (IOException e)
		{
			// do something
		}
	}

	// public List<String> solve(List<Integer> puzzleToSolve, int puzzleSize)
	// {
	// PriorityQueue<Node> fringe = new PriorityQueue<>(new NodeComparator());
	// LinkedHashSet<Node> closed = new LinkedHashSet<Node>();
	//
	// List<String> stepList = new ArrayList<String>();
	// List<Integer> finalPuzzle = generateFinalPuzzle(puzzleSize);
	// List<Integer> puzzle = new ArrayList<Integer>(puzzleToSolve);
	//
	// List<Node> child = new ArrayList<Node>();
	//
	// Node node;
	//
	// Node start = new Node(puzzle, null, "", 0, manhatten(puzzle));
	// Node sfarsit = new Node(finalPuzzle, null, "", 0, 0);
	//
	// Node current = start;
	// fringe.add(current);
	// int stop = 0;
	// long startTime = System.nanoTime();
	//
	// if (isSolvable(start.getStare()) == true)
	// {
	// while (fringe.size() > 0)
	// {
	//
	//
	// current = fringe.peek();
	//
	// if (current.hashCode() == sfarsit.hashCode())
	// {
	// System.out.println("END GAME");
	// stepList = showSteps(current);
	// System.out.println("Fringe : " + fringe.size());
	// System.out.println("Closed : " + closed.size());
	//
	// stop++;
	// break;
	// }
	//
	// else
	// {
	//
	//
	// if (!closed.contains(current))
	// {
	// child = moves(current, puzzleSize);
	//
	// for (int i = 0; i < child.size(); i++)
	// {
	// fringe.add(child.get(i));
	// }
	// closed.add(current);
	//
	// System.out.println("Fringe : " + fringe.size());
	// System.out.println("Closed : " + closed.size());
	// } else
	// {
	// fringe.remove();
	// }
	//
	// }
	//
	// if (stop != 0)
	// break;
	//
	// }
	// long endTime = System.nanoTime();
	//
	// long duration = (endTime - startTime);
	// double seconds = (double) duration / 1000000000.0;
	// System.out.println("Time : " + seconds);
	// return stepList;
	//
	// } else
	// {
	// System.out.println("This puzzle can't be solved !");
	// }
	// return stepList;
	// }
	//

	// ************************* A Star *****************

	public List<String> solve(List<Integer> puzzleToSolve, int puzzleSize)
	{
		PriorityQueue<Node> fringe = new PriorityQueue<>(new NodeComparator());
		LinkedHashSet<Node> closed = new LinkedHashSet<Node>();

		List<String> stepList = new ArrayList<String>();
		List<Integer> finalPuzzle = generateFinalPuzzle(puzzleSize);
		List<Integer> puzzle = new ArrayList<Integer>(puzzleToSolve);

		List<Node> child = new ArrayList<Node>();

		Node node;

		Node start = new Node(puzzle, null, "", 0, manhatten(puzzle));
		Node sfarsit = new Node(finalPuzzle, null, "", 0, 0);

		Node current = start;
		fringe.add(current);
		int stop = 0;
		long startTime = System.nanoTime();

		if (isSolvable(start.getStare()) == true)
		{
			while (current.hashCode() != sfarsit.hashCode())
			{
				child = moves(current, puzzleSize);

				for (int i = 0; i < child.size(); i++)
				{

					if (child.get(i).hashCode() == sfarsit.hashCode())
					{
						System.out.println("END GAME");
						stepList = showSteps(child.get(i));
						System.out.println("Fringe : " + fringe.size());
						System.out.println("Closed : " + closed.size());

						stop++;
						break;
					}

					// if (!fringe.contains(child.get(i)))
					//
					// {
					// if (!closed.contains(child.get(i)))

					// {

					fringe.add(child.get(i));

					// }
					// }
				}

				fringe.remove(current);

				closed.add(current);

				current = fringe.peek();

				if (stop != 0)
					break;
			}
			long endTime = System.nanoTime();

			long duration = (endTime - startTime);
			double seconds = (double) duration / 1000000000.0;
			System.out.println("Time : " + seconds);
			return stepList;

		} else
		{
			System.out.println("This puzzle can't be solved  !");
		}
		return stepList;
	}

	public int manhatten(List<Integer> list)
	{
		int manhatten = 0;
		int puzzleSize = (int) Math.sqrt(list.size());

		LinkedHashMap<Point, Integer> in = generataPuzzleCoords(list, puzzleSize);
		LinkedHashMap<Point, Integer> out = generateFinalPuzzleCoords(puzzleSize);

		for (Entry<Point, Integer> entryIn : in.entrySet())
		{
			Point pointIn = entryIn.getKey();
			int elemIn = entryIn.getValue();

			for (Entry<Point, Integer> entryOut : out.entrySet())
			{
				Point pointOut = entryOut.getKey();
				int elemOut = entryOut.getValue();

				if (elemIn == elemOut)
				{
					if (elemIn != 0)
						manhatten = manhatten + (Math.abs(pointIn.getX() - pointOut.getX())
								+ Math.abs(pointIn.getY() - pointOut.getY()));

				}

			}
		}

		return manhatten;
	}

	public static boolean isSolvable(List<Integer> puzzle)
	{
		int parity = 0;
		int gameWidth = (int) Math.sqrt(puzzle.size());
		int row = 0; // the current row we are on
		int blankRow = 0; // the row with the blank tile

		for (int i = 0; i < puzzle.size(); i++)
		{
			if (i % gameWidth == 0) // advance to next row
				row++;

			if (puzzle.get(i) == 0)
			{ // the blank tile
				blankRow = row; // save the row on which encountered
				continue;
			}
			for (int j = i + 1; j < puzzle.size(); j++)
			{
				if (puzzle.get(i) > puzzle.get(j) && puzzle.get(j) != 0)
					parity++;
			}
		}
		if (gameWidth % 2 == 0)
		{ // even grid
			if (blankRow % 2 == 0) // blank on odd row; counting from bottom
				return parity % 2 == 0;
			else // blank on even row; counting from bottom
				return parity % 2 != 0;
		} else // odd grid
			return parity % 2 == 0;
	}

	public Node getFirstChild(LinkedHashMap<Integer, Node> hashMap)
	{
		Node node = null;

		for (Map.Entry<Integer, Node> entry : hashMap.entrySet())
		{

			node = entry.getValue();
			return node;

		}

		return null;
	}

	// public Node getFirstChild(LinkedHashMap<Integer, Node> hashMap)
	// {
	// Node node = null;
	//
	// for (Map.Entry<Integer, Node> entry : hashMap.entrySet())
	// {
	//
	// node = entry.getValue();
	// return node;
	//
	// }
	//
	// return null;
	// }

}
