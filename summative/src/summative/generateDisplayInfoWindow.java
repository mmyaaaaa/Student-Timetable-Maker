package summative;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class generateDisplayInfoWindow {

	private JFrame generateFrame;
	private JTable generatedisplayinfotable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generateDisplayInfoWindow window = new generateDisplayInfoWindow();
					window.generateFrame.setVisible(true);
					window.generateFrame.setTitle("Optimizing Timetables");
					window.generateFrame.setSize(500, 400);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public generateDisplayInfoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		generateFrame = new JFrame();
		generateFrame.setBounds(100, 100, 450, 300);
		generateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		generateFrame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		generateFrame.getContentPane().add(panel, "name_270292908570099");
		
		JLabel lblTimetablesAreCurrently = new JLabel("Timetables Are Currently Being Generated");
		lblTimetablesAreCurrently.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNumberOfGenerations = new JLabel("Number of generations:");
		lblNumberOfGenerations.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel numberOfGenerationsLabel = new JLabel("0");
		numberOfGenerationsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(lblTimetablesAreCurrently, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNumberOfGenerations, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numberOfGenerationsLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(lblTimetablesAreCurrently)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfGenerations, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(numberOfGenerationsLabel))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		generatedisplayinfotable = new JTable();
		generatedisplayinfotable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Generation Data Listed Below "
			}
		));
		scrollPane.setViewportView(generatedisplayinfotable);
		panel.setLayout(gl_panel);
	}
}
