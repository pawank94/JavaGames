import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*<applet code="x.java" height=350 width=350>
</applet>*/
public class x extends JApplet
{
   JPanel jpt;
   Timer tm;   
   JLabel jli=new JLabel("3"),cor;
   int count=0,mark=0,c=0,RATE;
   Font f=new Font("Times New Roman",Font.BOLD,25);
   JPanel bp=new JPanel();
   JRootPane jp;
   JTextField a;
   JLabel al,head;
   JButton bu,jb;
   GridBagLayout gbl;
   JCheckBox jrb1,jrb2;
   GridBagConstraints gbc;
   public void init()
   {
	try
	{
	SwingUtilities.invokeAndWait(new Runnable(){
	public void run()
	{
	   new app();
	}
	});
	}catch(Exception e)
	{
	}
   }
	public class app implements ActionListener
	{
	public app()
	{
	getContentPane().removeAll();
	JPanel ap=new JPanel();
	jp=new JRootPane();
	gbl=new GridBagLayout();
	gbc=new GridBagConstraints();
	ap.setLayout(gbl);
	a=new JTextField(15);
	ap.setSize(250,250);
	al=new JLabel("<html><b><u>Name:- </b></u></html>");
	bu=new JButton("register");
	ap.setBackground(Color.magenta);
	head=new JLabel("<html><u><b><i>WELCOME!!!</b></i></u></html>");
	head.setForeground(Color.BLUE);
	gbc.anchor=GridBagConstraints.NORTH;
	gbc.gridwidth=GridBagConstraints.REMAINDER;
	gbl.setConstraints(head,gbc);
	gbc.anchor=GridBagConstraints.CENTER;
	gbc.weightx=0.7;
	gbc.weighty=1;
	gbc.ipadx=3;
	gbc.gridwidth=GridBagConstraints.RELATIVE;
	gbl.setConstraints(al,gbc);
	gbc.gridwidth=GridBagConstraints.REMAINDER;
	gbl.setConstraints(a,gbc);
	gbc.gridwidth=GridBagConstraints.REMAINDER;
	gbl.setConstraints(bu,gbc);
	ap.add(head);
	ap.add(al);
	ap.add(a);	
	ap.add(bu);	
	add(jp);
	jp.setContentPane(ap);
	bu.addActionListener(this);
	a.addActionListener(this);
	a.requestFocusInWindow();
	revalidate();
	repaint();
	}
	public void actionPerformed(ActionEvent ae)
       {
	   if(a.getText().length()==0)
	   {
		JOptionPane.showMessageDialog(null,"Empty Field");
		a.requestFocusInWindow();
	   }
	   else
	   {
		showStatus("success");
		new intro();
	   }
       }
   }  
   public class intro extends JPanel implements ActionListener
   {
	public intro()
	{
	   JPanel jpli=new JPanel();
	   jpli.setBackground(Color.CYAN);
	   jb=new JButton("start");
	   JLabel intr=new JLabel("<html><b><font color=\"blue\"><u>RULES</b></u></font></html>");
	   JLabel intr1=new JLabel("<html><font face=\"Times New Roman\" ><b>:-Welcome!!, its a very simple game to test your IQ.<br> :p !!</font></html>");	
  	   JLabel intr2=new JLabel("<html><font face=\"Times New Roman\" ><b>:-Only used keys are up(^),down(v),left(),right(>) <br>direction keys with 0,1,2,3,4,5,6 numpad keys.</font></html>");	
	   JLabel intr3=new JLabel("<html><font face=\"Times New Roman\" ><b>:-Press the key shown on screen just after it flashes.</font></html>");	
	   JLabel intr4=new JLabel("<html><font face=\"Times New Roman\" ><b>:-Game will start after 'ready!!!' will flash<br> followed by two second lag.plz don't panic ;p<font></html>");		
	   JLabel intr5=new JLabel("<html><font face=\"Times New Roman\" color=\"blue\"><center><u><b>TIPS TO REMEMBER</b></u></center><font></html>");		
	   JLabel intr6=new JLabel("<html><font face=\"Times New Roman\"><b>:-Please check NUMLOCK...make sure it is open <br>before game...<font></html>");
	   JLabel intr7=new JLabel("<html><font face=\"Times New Roman\" ><b>:-Players having 14.1 inch laptops would be at <br>considerable advantage..:p ;D<font></html>");
	   JLabel intr8=new JLabel("<html><font -face=\"Times New Roman\" ><u><b>:-Don't forget to enjoy (this) little things..:D :D<font></u></html>");
           jrb1=new JCheckBox("easy");
	   jrb1.addActionListener(this);
           jrb2=new JCheckBox("hard");
	   jrb2.addActionListener(this);
	   ButtonGroup bg=new ButtonGroup();
	   bg.add(jrb1);
	   bg.add(jrb2);
	   GridBagLayout bl=new GridBagLayout();
	   GridBagConstraints bc=new GridBagConstraints();
	   bc.weighty=1.0;
	   bc.anchor=GridBagConstraints.NORTH;
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(intr,bc);
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(intr1,bc);
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(intr2,bc);
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(intr3,bc);
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(intr4,bc);
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(intr5,bc);
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(intr6,bc);
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(intr7,bc);
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(intr8,bc);
	   bc.anchor=GridBagConstraints.SOUTH;
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(jb,bc);
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(jrb1,bc);
	   bc.gridwidth=GridBagConstraints.REMAINDER;
	   bl.setConstraints(jrb2,bc);
	   jpli.setLayout(bl);
	   jpli.add(intr);
	   jpli.add(intr1);
	   jpli.add(intr2);
	   jpli.add(intr3);
	   jpli.add(intr4);
	   jpli.add(intr5);
	   jpli.add(intr6);
	   jpli.add(intr7);
	   jpli.add(intr8);
	   jpli.add(jrb1);
	   jpli.add(jrb2);
	   //
	   jp.setContentPane(jpli);
	   jp.revalidate();
	   jp.repaint();
	   
	   jpli.add(jb);
	   jb.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent ae)
	   {
		if(jrb1.isSelected()==true || jrb2.isSelected()==true)
		{
		   new actlis();
		}
		else
		{
		   JOptionPane.showMessageDialog(null,"select a level....!!!");
		   jb.requestFocusInWindow();
		}
	   }
	   });
   }
   public void actionPerformed(ActionEvent ae)
   {
	 String s=ae.getActionCommand();
	 if(s.equals("easy"))
	 {
	   RATE=1000;
	 }
	 else if(s.equals("hard"))
	 {
	   RATE=725;
	 }
	 else { }
   }
   }
  public class actlis extends JPanel implements ActionListener
   {
	public actlis()
	{
	count=0;
	mark=0;
   	jpt=new JPanel();
   	tm=new Timer(RATE,this);
   	tm.setInitialDelay(1);
	jp.setContentPane(jpt);		
	jpt.add(jli);
	cor=new JLabel();
	jpt.setBackground(Color.white);
	GridBagLayout gl=new GridBagLayout();
	GridBagConstraints gc=new GridBagConstraints();
	gc.anchor=GridBagConstraints.CENTER;
	gc.gridwidth=GridBagConstraints.REMAINDER;
	gl.setConstraints(jli,gc);
	gc.gridwidth=GridBagConstraints.REMAINDER;
	gl.setConstraints(cor,gc);
	jpt.add(cor);
	jpt.setLayout(gl);
	jli.setFont(f);
	tm.start();
      }
   public void actionPerformed(ActionEvent ae)
   {	
	String a="21  ^v<>34^1><03>6^><x";
	c=0;
	if(count==(a.length()))
	{
	   jli.setText("Thankyou");
	   jpt.add(jli);
	   cor.setText("");
	   count++;
 	   tm.stop();
	   try{
	   Thread.sleep(1000);
	   }catch(Exception e){ }
	   new finali();
	}
	else if(count==0)
	{
	   jli.setFont(new Font("Times New Roman",Font.BOLD,60));
	   jpt.add(jli);
	   count++;
	   revalidate();
	   repaint();
	}
	else if(count==3)
	{
	   jli.setText("READY!!!");
	   jpt.add(jli);
	   count++;
	   revalidate();
	   repaint();
        }
	else if(count==4)
	{
	   try
	   { 
		Thread.sleep(3000); 
	   }catch(Exception e) { }
	   count++;
	}
	else
	{
	   jli.setText(""+a.charAt(count-1));
	   jpt.add(jli);
	   count++;
	   jp.revalidate();
	   jp.repaint();
	}
	getContentPane().setFocusable(true);
	getContentPane().requestFocus();
	if(count>4 && count<a.length())
	{
	getContentPane().addKeyListener(new KeyAdapter() {
	public void keyPressed(KeyEvent ke)
	{
	  	int key=ke.getKeyCode();
		switch(count)
 	  	{
		   case 6:
		   if(key==KeyEvent.VK_UP && c==0)
		   {
			mark++;
			c++;
			cor.setText("Right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 7:
		   if(key==KeyEvent.VK_DOWN && c==0)
		   {
			mark++;
			c++;
			cor.setText("Right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
	   	   break;
		   case 8:
		   if(key==KeyEvent.VK_LEFT && c==0)
		   {
			mark++;
			c++;
			cor.setText("Right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 9:
		   if(key==KeyEvent.VK_RIGHT && c==0)
		   {
			mark++;
			c++;
			cor.setText("right");	
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 10:
		   if(ke.getKeyChar()=='3' && c==0)
		   {
			mark++;
			c++;
			cor.setText("right");		
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
	           case 11:
		   if(ke.getKeyChar()=='4' && c==0)
		   {
			mark++;
			c++;
			cor.setText("right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 12:
		   if(key==KeyEvent.VK_UP && c==0)
		   {
			mark++;
			c++;
			cor.setText("right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 13:
		   if(ke.getKeyChar()=='1' && c==0)
		   {
			mark++;
			c++;
			cor.setText("right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 14:
		   if(key==KeyEvent.VK_RIGHT && c==0)
		   {
			mark++;
			c++;
			cor.setText("Right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 15:
		   if(key==KeyEvent.VK_LEFT && c==0)
		   {
			mark++;
			c++;
			cor.setText("Right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 16:
		   if(ke.getKeyChar()=='0' && c==0)
		   {
			mark++;
			c++;
			cor.setText("right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 17:
		   if(ke.getKeyChar()=='3' && c==0)
		   {
			mark++;
			c++;
			cor.setText("right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 18:
		   if(key==KeyEvent.VK_RIGHT && c==0)
		   {
			mark++;
			c++;
			cor.setText("Right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 19:
		   if(ke.getKeyChar()=='6' && c==0)
		   {
			mark++;
			c++;
			cor.setText("right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 20:
		   if(key==KeyEvent.VK_UP && c==0)
		   {
			mark++;
			c++;
			cor.setText("Right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 21:
		   if(key==KeyEvent.VK_RIGHT && c==0)
		   {
			mark++;
			c++;
			cor.setText("Right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		   case 22:
		   if(key==KeyEvent.VK_LEFT && c==0)
		   {
			mark++;
			c++;
			cor.setText("Right");
			cor.setForeground(Color.blue);
		   }
		   else if(c==0)
		   {
			cor.setText("Wrong");
			c++;
			cor.setForeground(Color.RED);
		   }
		   else { }
		   break;
		}	
	   }
	});
	}
        }
   public class finali extends JPanel
   {
	public finali()
	{
	   JPanel fina=new JPanel();
	   JButton ret=new JButton("retry");
	   GridBagLayout gblz=new GridBagLayout();
	   GridBagConstraints gblc=new GridBagConstraints();
	   JLabel cngr=new JLabel("<html><u><b>Thankyou for trying!!</u></b></html>");
	   cngr.setForeground(Color.MAGENTA);
	   cngr.setFont(new Font("Comic Sans MS",Font.BOLD|Font.ITALIC,15));
	   JLabel jn=new JLabel("Name:- "+a.getText());
	   jn.setForeground(Color.BLUE);
	   jn.setFont(new Font("Comic Sans MS",Font.BOLD,35));
	   JLabel mar=new JLabel("marks:- "+mark+"/17");
	   mar.setFont(new Font("Calibri",Font.BOLD,50));
	   mar.setForeground(Color.RED);
	   fina.setBackground(Color.CYAN);
	   JLabel line=new JLabel("------------------------");
	   line.setFont(new Font("Times New Roman",Font.BOLD,50));
	   gblc.weighty=1.0;
    	   gblc.anchor=GridBagConstraints.NORTH;
	   gblc.gridwidth=GridBagConstraints.REMAINDER;
	   gblz.setConstraints(cngr,gblc);
	   gblc.gridwidth=GridBagConstraints.REMAINDER;
	   gblz.setConstraints(jn,gblc);
	   gblc.gridwidth=GridBagConstraints.REMAINDER;
	   gblz.setConstraints(line,gblc);
	   gblc.gridwidth=GridBagConstraints.REMAINDER;
	   gblz.setConstraints(mar,gblc);	
	   gblc.anchor=GridBagConstraints.SOUTH;
	   gblc.gridwidth=GridBagConstraints.REMAINDER;
	   gblz.setConstraints(ret,gblc);
	   fina.setLayout(gblz);
	   fina.add(cngr);
	   fina.add(jn);
	   fina.add(line);
	   fina.add(mar);
	   fina.add(ret);
	   ret.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent ae)
	   {
	  	new app();
		count=0;
	   }
	   });
	   jp.setContentPane(fina);
	   jp.revalidate();
	   jp.repaint();
	}
   }
   }
}
