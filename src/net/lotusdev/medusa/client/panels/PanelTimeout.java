package net.lotusdev.medusa.client.panels;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTimeout extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTimeout() {
		
		final JLabel lblTimeout = new JLabel("Timeout:");
		
		final JSpinner spinner = new JSpinner();
		
		final JLabel lblminutes = new JLabel("(minutes)");
		
		final JLabel lblTime = new JLabel("Hour:");
		
		final JSpinner spinner_1 = new JSpinner();
		
		final JComboBox comboBox = new JComboBox();
		
		final JLabel lblsystemThatStub = new JLabel("(system time that server is on)");
		
		lblTime.setEnabled(false);
    	spinner_1.setEnabled(false);
    	comboBox.setEnabled(false);
		
		JRadioButton rdbtnMinuteDelay = new JRadioButton("Minute schedule");
		rdbtnMinuteDelay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   	lblTime.setEnabled(false);
		    	spinner_1.setEnabled(false);
		    	comboBox.setEnabled(false);
		    	lblsystemThatStub.setEnabled(false);
		    	
		       	lblTimeout.setEnabled(true);
		    	lblminutes.setEnabled(true);
		    	spinner.setEnabled(true);
			}
		});
		rdbtnMinuteDelay.setSelected(true);
		
		JRadioButton rdbtnTimelySchedule = new JRadioButton("Time schedule");
		rdbtnTimelySchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    	lblTimeout.setEnabled(false);
		    	lblminutes.setEnabled(false);
		    	spinner.setEnabled(false);
		    	
		    	lblTime.setEnabled(true);
		    	spinner_1.setEnabled(true);
		    	comboBox.setEnabled(true);
		    	lblsystemThatStub.setEnabled(true);
			}
		});
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnMinuteDelay);
	    group.add(rdbtnTimelySchedule);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));

		lblsystemThatStub.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnMinuteDelay)
						.addComponent(rdbtnTimelySchedule, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTimeout)
								.addComponent(lblTime))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinner_1)
								.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblminutes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblsystemThatStub)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblminutes)
								.addComponent(lblTimeout)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnMinuteDelay))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(48)
									.addComponent(rdbtnTimelySchedule))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(51)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTime)
										.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblsystemThatStub))
						.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
