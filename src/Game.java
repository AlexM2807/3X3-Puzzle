import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Game
{

	private JFrame frame;
	private JTextField textField;
	private int puzzleSize = 3;
	private List<Integer> puzzleList;
	private List<Integer> finalPuzzle;
	private Panel panel;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	// public void startGame(List<String> list)
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{

				try
				{
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game()
	{
		initialize();
		// this.steps = list;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 745, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new Panel();
		panel.setBackground(Color.GREEN);

		panel.setBounds(10, 10, 489, 489);
		frame.getContentPane().add(panel);

		GridLayout experimentLayout = new GridLayout(puzzleSize, puzzleSize);
		panel.setLayout(experimentLayout);

		Process process = new Process();

		puzzleList = process.generataPuzzle(puzzleSize);
		finalPuzzle = process.generateFinalPuzzle(puzzleSize);
		// puzzleList =process.generateFinalPuzzle(puzzleSize);

		createGame(panel, puzzleList);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(539, 10, 170, 434);
		frame.getContentPane().add(scrollPane);

		JButton btnSolve = new JButton("Solve");

		btnSolve.setBackground(Color.GREEN);

		btnSolve.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				Process process = new Process();

				List<String> steps = new ArrayList<String>(
						process.solve(process.generataPuzzle(puzzleSize), puzzleSize));

				Collections.reverse(steps);

				// createList(scrollPane, steps);

				createList(scrollPane, steps);

			}
		});
		btnSolve.setBounds(562, 456, 133, 43);
		frame.getContentPane().add(btnSolve);

	}

	public JButton createButton(String number)
	{

		JButton btnNewButton;
		if (number.equals("0"))
		{
			btnNewButton = new JButton();
		} else
		{
			btnNewButton = new JButton(number);
		}

		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MovesForGame mfg = new MovesForGame();
				int nr = Integer.parseInt(btnNewButton.getText());

				if (mfg.checkGame(puzzleList, finalPuzzle) == true)
				{
					if (nr != 0)
					{

						puzzleList = mfg.move(puzzleList, puzzleSize, nr);

						createGame(panel, puzzleList);

						Process process = new Process();

						List<String> steps = new ArrayList<String>(process.solve(puzzleList, puzzleSize));
						Collections.reverse(steps);

						createList(scrollPane, steps);
						if (puzzleList.equals(finalPuzzle))
							JOptionPane.showMessageDialog(null, "PUZZLE SOLVED !!");

					} else
					{
						System.out.println("Can't move !");
					}
				}

			}
		});
		if (Integer.parseInt(number) == 0)
			btnNewButton.setEnabled(false);
		return btnNewButton;

	}

	public JTextField createTextField(String number)
	{

		textField = new JTextField(number);
		textField.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		textField.setEditable(false);

		return textField;

	}

	public void createList(JScrollPane scrollPane, List<String> listSteps)
	{

		Collections.reverse(listSteps);
		JList list = new JList(listSteps.toArray());
		scrollPane.setViewportView(list);

	}

	public void createGame(Panel panel, List<Integer> list)
	{
		panel.removeAll();
		for (int i = list.size() - 1; i >= 0; i--)
		{
			panel.add(createButton(list.get(i).toString()), SwingConstants.CENTER);
		}

		System.out.println(list.toString());
		panel.revalidate();
		panel.repaint();
	}

}
