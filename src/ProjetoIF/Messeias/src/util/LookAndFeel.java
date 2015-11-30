package util;

import java.awt.Font;

import javax.swing.UIManager;

public class LookAndFeel {

	public static final Font TEXT_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	public static final Font BTN_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 16);
	public static final Font TABLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 12);
	public static final Font COMMENT_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 14);
	public static final Font TITLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 25);
	public static final Font APP_TITLE_FONT = null;
	
	public static void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
