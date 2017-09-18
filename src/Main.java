import java.awt.Color;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;


public class Main extends JFrame{
	int counter=0;
	boolean coordinatesX[][]=new boolean[3][3];
	boolean coordinatesO[][]=new boolean[3][3];
	Color green=new Color(177,252,172);
	
	public Main(){
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tic Tac Toe");
		setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++){
			int index=i;
			JButton button=new JButton(""){
				int x=index%3;
				int y=(index-x)/3;
				public int getX() {
					return x;
				}
				public int getY() {
					return y;
				}
			};
			add(button);
			button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button=(JButton)e.getSource();
					button.setEnabled(false);
					if(counter%2==0){
						button.setText("X");
						coordinatesX[button.getX()][button.getY()]=true;
						check(coordinatesX);
					}else{
						button.setText("O");
						coordinatesO[button.getX()][button.getY()]=true;
						check(coordinatesO);
					}	
					System.out.println("["+button.getX()+","+button.getY()+"]"+"="+button.getText());
					counter++;
				}
			});
		}
	}
	
	private void finishGame(int first,int second,int third){
		JButton btn=(JButton) getContentPane().getComponent(first);
		
		btn.setBackground(green);
		getContentPane().getComponent(second).setBackground(green);
		getContentPane().getComponent(third).setBackground(green);

		JOptionPane.showMessageDialog(this,"'"+btn.getText()+"' win!","Game Over",JOptionPane.INFORMATION_MESSAGE);
		this.dispose();
		start();
	}
	
	private void check(boolean[][] tab){
		if(tab[0][0] && tab[0][1] && tab[0][2]){
			finishGame(0,3,6);
		}else if(tab[1][0] && tab[1][1] && tab[1][2]){
			finishGame(1,4,7);
		}else if(tab[2][0] && tab[2][1] && tab[2][2]){
			finishGame(2,5,8);
		}else if(tab[0][0] && tab[1][0] && tab[2][0]){
			finishGame(0,1,2);
		}else if(tab[0][1] && tab[1][1] && tab[2][1]){
			finishGame(3,4,5);
		}else if(tab[0][2] && tab[1][2] && tab[2][2]){
			finishGame(6,7,8);
		}else if(tab[0][0] && tab[1][1] && tab[2][2]){
			finishGame(0,4,8);
		}else if(tab[2][0] && tab[1][1] && tab[0][2]){
			finishGame(2,4,6);
		}else if(counter==8){
			JOptionPane.showMessageDialog(this, "Draw","Game Over",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			start();
		}
	}
	
	public static void start(){
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				new Main();
			}
		});
	}
	
	public static void main(String[] args) {
				start();
		  }  
		}     
	

