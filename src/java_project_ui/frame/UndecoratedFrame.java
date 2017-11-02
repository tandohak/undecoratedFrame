package java_project_ui.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;

public class UndecoratedFrame {
	private static Point point = new Point();

	public static void main(String[] args) {
		final JFrame frame = new JFrame();

		frame.setUndecorated(true);

		JPanel menuPanel = new JPanel();
		menuPanel.setLocation(new Point(100, 0));
		menuPanel.setPreferredSize(new Dimension(10, 40));
		menuPanel.setMinimumSize(new Dimension(1, 10));
		frame.getContentPane().add(menuPanel, BorderLayout.NORTH);
		
		JButton btnMinimize = new JButton("-");
		btnMinimize.setBounds(183, 0, 37, 23);
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		menuPanel.setLayout(null);
		menuPanel.add(btnMinimize);
		
		JButton btnMaxmize = new JButton("ㅁ");
		btnMaxmize.setBounds(219, 0, 43, 23);
		btnMaxmize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getWidth();
				Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
				
				if(dimen.getWidth()>frame.getWidth()){
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}else{
					frame.setExtendedState(JFrame.NORMAL);
				}
			}
		});
		menuPanel.add(btnMaxmize);
		
		JButton btnClose = new JButton("x");
		btnClose.setAlignmentY(Component.TOP_ALIGNMENT);
		btnClose.setBounds(261, 0, 39, 23);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                System.exit(0);
			}
		});
		menuPanel.add(btnClose);
		menuPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
			
		});
		
		menuPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = frame.getLocation();
				frame.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});
		frame.setSize(300, 300);
		frame.setLocation(200, 200);
		frame.setVisible(true);
	}

}
