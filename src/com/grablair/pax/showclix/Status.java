package com.grablair.pax.showclix;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Status extends JFrame {

	private static final long serialVersionUID = 8264954633550451627L;
	
	private JLabel title;
	private JLabel latestShowclixTime;
	private JLabel totalEventCount;
	private JLabel latestEvent;
	private JLabel latestEventURL;
	
	public Status() {
		initComponents();
		setVisible(true);
	}
	
	public void setLatestShowclixCheck(long millis) {
		latestShowclixTime.setText("Latest Showclix Check: " + (millis/1000) + " seconds ago");
		pack();
	}
	
	public void setTotalEventCount(int count) {
		totalEventCount.setText("Total Event Count: " + count);
		pack();
	}
	
	public void setLatestURL(String url) {
		latestEventURL.setText("Latest Event URL: " + url);
		pack();
	}
	
	public void setLatestEvent(String url) {
		latestEvent.setText("Latest Event: " + url);
		pack();
	}
	
	public void initComponents() {
		title = new JLabel();
		latestShowclixTime = new JLabel();
		totalEventCount = new JLabel();
		latestEvent = new JLabel();
		latestEventURL = new JLabel();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		title.setFont(new java.awt.Font("Tahoma", 0, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setText("PAX Showclix Status");
		
		latestShowclixTime.setText("Latest Showclix Check: ");
		totalEventCount.setText("Total Event Count: ");
		latestEvent.setText("Latest Event: ");
		latestEventURL.setText("Latest Event URL: ");
		
		javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(
	      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	      .addGroup(layout.createSequentialGroup()
	        .addContainerGap()
	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	          .addComponent(title)
	          .addComponent(latestShowclixTime)
	          .addComponent(totalEventCount)
	          .addComponent(latestEvent)
	          .addComponent(latestEventURL))
	        .addContainerGap())
	    );
	    layout.setVerticalGroup(
	      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	      .addGroup(layout.createSequentialGroup()
	        .addContainerGap()
	        .addComponent(title)
	        .addGap(18, 18, 18)
	        .addComponent(latestShowclixTime)
	        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	        .addComponent(totalEventCount)
	        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	        .addComponent(latestEvent)
	        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	        .addComponent(latestEventURL)
	        .addContainerGap())
	    );

	    pack();
	}
}
