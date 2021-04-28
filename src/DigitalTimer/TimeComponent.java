package DigitalTimer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class TimeComponent extends JComponent
{
	private Model model;
	int ss = 1;
	
	
	public TimeComponent(final Model model)
	{
		this.model = model;
		try
		{
			BufferedImage digits_board = ImageIO.read(digits_file);
			
			digits = new BufferedImage[10];
			int digit_width = digits_board.getWidth() / 5;
			int digit_height = digits_board.getHeight() / 2;
			
			int current = 0;
			
			for (int y = 0; y < digits_board.getHeight(); y += digit_height)
			{
				for (int x = 0; x < digits_board.getWidth(); x += digit_width)
				{
					digits[current] = digits_board.getSubimage(x, y, digit_width, digit_height);
					
					current++;
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		try
		{
			BufferedImage dots_board = ImageIO.read(dots_file);
			
			dots = new BufferedImage[2];
			
			int dots_width = dots_board.getWidth() / 2;
			int dots_height = dots_board.getHeight() / 1;
			
			int current = 0;
			
			for (int y = 0; y < dots_board.getHeight(); y += dots_height)
			{
				for (int x = 0; x < dots_board.getWidth(); x += dots_width)
				{
					dots[current] = dots_board.getSubimage(x, y, dots_width, dots_height);
					
					current++;
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	File digits_file = new File("images/digits.png");
	File dots_file = new File("images/dots.png");
	
	BufferedImage[] digits;
	BufferedImage[] dots;
	
	int mili1 = 0;
	int mili2 = 0;
	int sec1 = 0;
	int sec2 = 0;
	int min1 = 0;
	int min2 = 0;
			
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		if(mili2 == 9){
			mili2 = 0;
			mili1 +=1;
		}
		
		if(mili1 == 9){
			mili1 = 0;
			sec2 += 1;
		}
		
		if(sec2 == 9){
			sec2 = 0;
			sec1 +=1;
		}
		
		if(sec1 == 6){
			sec1 = 0;
			min2 += 1;
		}
		
		if(min2 == 9){
			min2 = 0;
			min1 +=1;
		}
		
		if(min1 == 6){
			min1 = 0;
		}
		if(min2 ==1 && min1 ==0 && sec1 ==0 && sec2 ==0 && mili1 ==0 && mili2 ==0) {
		JOptionPane.showMessageDialog(null,"1�а��!");
		JOptionPane.showConfirmDialog(this, "��� �̾��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		}
		if(min2 ==0 && min1 ==1 && sec1 ==0 && sec2 ==0 && mili1 ==0 && mili2 ==0) {
			JOptionPane.showMessageDialog(null,"10�а��!");
			JOptionPane.showConfirmDialog(this, "��� �̾��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			}
		if(min2 ==0 && min1 ==3 && sec1 ==0 && sec2 ==0 && mili1 ==0 && mili2 ==0) {
			JOptionPane.showMessageDialog(null,"30�а��!");
			JOptionPane.showConfirmDialog(this, "��� �̾��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			}
		int currentXPos = 0;

		if(model.start == 1 && model.reset == 0){
			g2d.drawImage(digits[min1], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();

			g2d.drawImage(digits[min2], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();
			
			g2d.drawImage(dots[0], null, currentXPos, 0);
			currentXPos += dots[0].getWidth();
			
			g2d.drawImage(digits[sec1], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();

			g2d.drawImage(digits[sec2], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();
			
			g2d.drawImage(dots[0], null, currentXPos, 0);
			currentXPos += dots[0].getWidth();
			
			g2d.drawImage(digits[mili1], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();

			g2d.drawImage(digits[mili2], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();
			
			try {
			    Thread.sleep(10);  
			    mili2++;
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			repaint();
		}
		else if(model.start == 0 && model.reset == 0){
			g2d.drawImage(digits[min1], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();

			g2d.drawImage(digits[min2], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();
			
			g2d.drawImage(dots[0], null, currentXPos, 0);
			currentXPos += dots[0].getWidth();
			
			g2d.drawImage(digits[sec1], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();

			g2d.drawImage(digits[sec2], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();
			
			g2d.drawImage(dots[0], null, currentXPos, 0);
			currentXPos += dots[0].getWidth();
			
			g2d.drawImage(digits[mili1], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();

			g2d.drawImage(digits[mili2], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();
		}
		else if(model.reset == 1){
			g2d.drawImage(digits[0], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();

			g2d.drawImage(digits[0], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();
			
			g2d.drawImage(dots[0], null, currentXPos, 0);
			currentXPos += dots[0].getWidth();
			
			g2d.drawImage(digits[0], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();

			g2d.drawImage(digits[0], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();
			
			g2d.drawImage(dots[0], null, currentXPos, 0);
			currentXPos += dots[0].getWidth();
			
			g2d.drawImage(digits[0], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();

			g2d.drawImage(digits[0], null, currentXPos, 0);
			currentXPos += digits[0].getWidth();
			mili1 = 0;
			mili2 = 0;
			sec1 = 0;
			sec2 = 0;
			min1 = 0;
			min2 = 0;
			model.reset = 0;
		}
	}
	
}
