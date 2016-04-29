package ija.ija2015.homework2.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ija.ija2015.homework2.game.Game;

public class GBoard extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1684103201226271922L;
	private final int maxWidth = 700;
	private final int maxHeight = 500;
	private final Game game;
	private final Dimension dim;
	//private final List<GField> fields = new ArrayList<>();
	private final int size;
	
	
	public GBoard(Game game) {
		double ratio, rH, rW;
		int gH, gW;
		this.game = game;
		size = game.getBoard().getSize();
		int height = this.game.height();
		int width = this.game.width();
		//Field[][] field = game.getBoard().fieldArray;
		
		rH = (double)maxHeight/height;
		rW = (double)maxWidth/width;
		
		ratio = rH > 1 ? 1 : rH;
		ratio = rW > 1 ? ratio : (rW > rH ? rH : rW);
		
		gH = (int) (height*ratio);
		gW = (int) (width*ratio);
		
		dim = new Dimension(gH, gW);
		
		this.setLayout(new GridLayout(size, size));
		this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setPreferredSize(dim);
        this.setSize(dim);
        this.setBackground(Color.DARK_GRAY);
        this.setOpaque(true);
        

        //JPanel panel = new JPanel(new GridLayout(size, size));
        for(int i = 1; i <= size; i++){
        	for(int j = 1; j <= size; j++){
        		JLabel label = createLabel();
        		if(game.getBoard().getField(i, j).getDisk() != null){
        			if(game.getBoard().getField(i, j).getDisk().toString() == "White"){
        				label.setBackground(Color.WHITE);
        			}
        			else{
        				label.setBackground(Color.BLACK);
        			}
        		}
        		else{
        			label.setBackground(Color.GRAY);
        		}
        		this.add(label);
        	}
        }
        
        //System.out.println(game.getBoard());
	}
	private JLabel createLabel() {
		JLabel label = new JLabel();
		label.setBackground(Color.white);
        //label.setBackground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.RED));
        label.setOpaque(true);
		return label;
	}
}
