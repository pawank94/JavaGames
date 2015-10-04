//hell of an achievement
//all copyrights -Pawan Kumar BTECH IT (1120555) 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*<applet code="chess.java" height=600 width=700>
</applet>*/
public class chess extends JApplet
{
	int kingcheckb=0,kingcheckw=0;
   int counter=0,turn=0;
   JRootPane jrp;
   JPanel main;
   JButton jb;
   JPanel temp;
   memory mem;
   int row,col,orow,ocol,index,pos,index1,tempr,tempc;
   String piecex=null,piece=null,tem=null;
   JButton[] barr=new JButton[64];
   JPanel[][] com=new JPanel[10][10];
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
	{  }
   }
   public class app implements ActionListener
   {
	public app()
	{
	jrp=new JRootPane();
	main=new JPanel();
	main.setLayout(new GridLayout(8,8));
	for(int i=0;i<8;i++)
	{
	   for(int j=0;j<8;j++)
	   {
		com[i][j]=new JPanel();
	 	main.add(com[i][j]);
		com[i][j].setName(""+(i*8+j));
	   }
	}
	for(int i=0;i<8;i++)
	{
	   for(int j=0;j<8;j++)
	   {
		int index=i*8+j;
		barr[index]=new JButton();
		com[i][j].setLayout(new BorderLayout());
		com[i][j].add(barr[index],BorderLayout.CENTER);	
		if((index/8)%2==0)
		{
		if(index%2==0)
		{
		   barr[index].setBackground(Color.white);
		}
		else
		{
		   barr[index].setBackground(Color.LIGHT_GRAY);
		}
	        }
		else
		{
		if(index%2==0)
		{
		   barr[index].setBackground(Color.LIGHT_GRAY);
		}
		else
		{
		   barr[index].setBackground(Color.white);
		}
		}
	   }
	}
	for(int i=0;i<64;i++)
	{
	   if((i>=48 && i<=55))
	   {
	   barr[i].setName("pawnw");
	   barr[i].setForeground(Color.blue);
	   barr[i].setIcon(new ImageIcon("pawnw.jpg"));
	   }
	   else if((i>=8 && i<=15))
	   {
	   barr[i].setName("pawnb");
	   barr[i].setForeground(Color.gray);
	   barr[i].setIcon(new ImageIcon("pawnb.jpg"));
	   }
	   else if(i==0 || i==7)
	   {
		barr[i].setName("rookb");
		barr[i].setForeground(Color.gray);
		barr[i].setIcon(new ImageIcon("rookb.jpg"));
	   }
	   else if(i==56 || i==63)
	   {
		barr[i].setName("rookw");
		barr[i].setForeground(Color.blue);
		barr[i].setIcon(new ImageIcon("rookw.jpg"));
	   }
	   else if(i==1 || i==6 )
	   {
		barr[i].setName("knightb");
		barr[i].setForeground(Color.gray);
		barr[i].setIcon(new ImageIcon("knightb.jpg"));
	   }
	   else if(i==57 || i==62)
	   {
		barr[i].setName("knightw");
		barr[i].setForeground(Color.blue);
		barr[i].setIcon(new ImageIcon("knightw.jpg"));
	   }
	   else if(i==2 || i==5)
	   {
		barr[i].setName("bishopb");
		barr[i].setIcon(new ImageIcon("bishopb.jpg"));
		barr[i].setForeground(Color.gray);
	   }
	   else if(i==58 || i==61)
	   {
		barr[i].setName("bishopw");
		barr[i].setForeground(Color.blue);
		barr[i].setIcon(new ImageIcon("bishopw.jpg"));
	   }
	   else if(i==4)
	   {
		barr[i].setName("kingb");
		barr[i].setIcon(new ImageIcon("kingb.jpg"));
		barr[i].setForeground(Color.gray);
	   }
	   else if(i==3)
	   {
		barr[i].setName("queenb");
		barr[i].setIcon(new ImageIcon("queenb.jpg"));
		barr[i].setForeground(Color.gray);
	   }
	   else if(i==60)
	   {
		barr[i].setName("kingw");
		barr[i].setIcon(new ImageIcon("kingw.jpg"));
		barr[i].setForeground(Color.blue);
	   }
	   else if(i==59)
	   {
		barr[i].setName("queenw");
		barr[i].setIcon(new ImageIcon("queenw.jpg"));
		barr[i].setForeground(Color.blue);
	   }
	   else
	   {
	   barr[i].setName("");
	   }
	}
	for(int j=0;j<64;j++)
 	{
	   barr[j].addActionListener(this);
	}
	jrp.setContentPane(main);
	add(jrp);
	revalidate();
	repaint();
	JOptionPane.showMessageDialog(jrp, "welcome!!..:D :D");
	}
	//actionperformed
	public void actionPerformed(ActionEvent ae)
	{
	   mem=new memory();
	   jb=(JButton)ae.getSource();
	   temp=(JPanel)jb.getParent();
	   pos=Integer.parseInt(temp.getName());
	   row=pos/8;
	   col=pos%8;
	   piecex=null;
	   piece=null;
	   tem=null;
	   if(jb.getName().length()!=0)
	   {
	   piece=jb.getName().charAt(jb.getName().length()-1)+"";
	   if(piece.equals("w"))
	   {
		piecex="b";
	   }
	   else if(piece.equals("b"))
	   {
		piecex="w";
	   }
	   else { }
	   }
	   if(turn==0)
	   {
		   showStatus("white");
	   }
	   else
	   {
		   showStatus("black");
	   }
	   //System.out.println(jb.getName());
	   //focus request
	   requestFocusInWindow();
	   //key log
	   addKeyListener(new KeyAdapter(){
		   int a=0;
		  public void keyPressed(KeyEvent ke)
		  {
			  int z=0;
			  for(int i=0;i<64;i++)
			  {
				  if(barr[i].getBackground()==Color.red)
				  {
					  z++;
				  }
			  }
			  char p=ke.getKeyChar();
			  //mem counter
			  if(p=='z' && a==0 && mem.counterx==0 && z==0)
			  {
				  mem.counterx++;
				   barr[mem.index1].setIcon(mem.n);
				   barr[mem.index1].setName(mem.nname);
				   barr[mem.index1].setForeground(mem.nc);
				   barr[mem.index].setForeground(mem.oc);
				   barr[mem.index].setIcon(mem.o);
				   barr[mem.index].setName(mem.oname);
				  check();
				   counter=0;
				   if(turn==0)
				   {
					   turn=1;
				   }
				   else
				   {
					   turn=0;
				   }
				   a++;
			  }
		  }
	   });
	   if(counter==0)
	   {
		   painter();
	   if((jb.getName().equals("pawnw") && turn==0) || (jb.getName().equals("pawnb") && turn==1))
	   {
		pawnpro(pos);
	   }
	   else if((jb.getName().equals("rookw") && turn==0) || (jb.getName().equals("rookb") && turn==1))
	   {
		rookpro(pos);
	   }
	   else if((jb.getName().equals("knightw") && turn==0) || (jb.getName().equals("knightb") && turn==1))
	   {
		 knightpro(pos);
	   }
	   else if((jb.getName().equals("bishopw") && turn==0) || (jb.getName().equals("bishopb") && turn==1))
	   {
		   bishoppro(pos);
	   }//
	   else if((jb.getName().equals("queenw") && turn==0) || (jb.getName().equals("queenb") && turn==1))
	   {
		  queenpro(pos);
		}
	   else if((jb.getName().equals("kingw") && turn==0) || (jb.getName().equals("kingb") && turn==1))
	   {
		   kingpro(pos);
	   }
	   else
	   {  }
	   }
	   //else counter
	   else
	   {
		   index=orow*8+ocol;
		   index1=row*8+col;
		   if(jb.getBackground()!=Color.red)
		   {
			   counter=0;
			   painter();
			   return;
		   }
		   else if(jb.getBackground()==Color.RED)
		   {
			   if(barr[index].getName().equals("pawnw") || barr[index].getName().equals("pawnb"))
			   {
				   if(barr[index1].getName().length()==0 && ocol==col)
				   {
					   mem.memo(index,index1,barr[index].getName(),barr[index1].getName(),barr[index].getIcon(),barr[index1].getIcon(),barr[index].getForeground(),barr[index1].getForeground());
					   barr[index1].setIcon(barr[index].getIcon());
					   barr[index1].setName(barr[index].getName());
					   barr[index1].setForeground(barr[index].getForeground());
					   barr[index].setForeground(null);
					   barr[index].setIcon(null);
					   barr[index].setName("");
					   check();
					   counter=0;
					   if(turn==0)
					   {
						   turn=1;
					   }
					   else
					   {
						   turn=0;
					   }
				   }
				   else if(barr[index1].getName().length()!=0 && (ocol==col-1 || ocol==col+1))
				   {
					   mem.memo(index,index1,barr[index].getName(),barr[index1].getName(),barr[index].getIcon(),barr[index1].getIcon(),barr[index].getForeground(),barr[index1].getForeground());
					   barr[index1].setIcon(barr[index].getIcon());
					   barr[index1].setName(barr[index].getName());
					   barr[index1].setForeground(barr[index].getForeground());
					   barr[index].setForeground(null);
					   barr[index].setIcon(null);
					   barr[index].setName("");
					  check();
					   counter=0;
					   if(turn==0)
					   {
						   turn=1;
					   }
					   else
					   {
						   turn=0;
					   }
				   }
				   else
				   { 
					   counter=0;
				   }
			   }
			   else
			   {
				   mem.memo(index,index1,barr[index].getName(),barr[index1].getName(),barr[index].getIcon(),barr[index1].getIcon(),barr[index].getForeground(),barr[index1].getForeground());
				   index=orow*8+ocol;
				   index1=row*8+col;
				   barr[index1].setIcon(barr[index].getIcon());
				   barr[index1].setName(barr[index].getName());
				   barr[index1].setForeground(barr[index].getForeground());
				   barr[index].setForeground(null);
				   barr[index].setIcon(null);
				   barr[index].setName("");
				   check();
				   counter=0;
				   if(turn==0)
				   {
					   turn=1;
				   }
				   else
				   {
					   turn=0;
				   }
			   }
		   }
		   else { }
		   //painter();
	   }
	   if(turn==0)
	   {
		   showStatus("white");
	   }
	   else
	   {
		   showStatus("black");
	   }
	}
	//check
	private void check() {
		int initturn=turn;
		int kingb=0;
		int kingw=0;
			for(int i=0;i<64;i++)
			{
				if(barr[i].getName().equals("kingw"))
				{
					kingw=1;
					   painter();
						turn=1;
						for(int j=0;j<64;j++)
						{
							JButton jb=barr[j];
							if((jb.getName().equals("pawnw") && turn==0) || (jb.getName().equals("pawnb") && turn==1))
							   {
								pawnpro(j);
							   }
							   else if((jb.getName().equals("rookw") && turn==0) || (jb.getName().equals("rookb") && turn==1))
							   {
								rookpro(j);
							   }
							   else if((jb.getName().equals("knightw") && turn==0) || (jb.getName().equals("knightb") && turn==1))
							   {
								 knightpro(j);
							   }
							   else if((jb.getName().equals("bishopw") && turn==0) || (jb.getName().equals("bishopb") && turn==1))
							   {
								   bishoppro(j);
							   }//
							   else if((jb.getName().equals("queenw") && turn==0) || (jb.getName().equals("queenb") && turn==1))
							   {
								  queenpro(j);
								}
							   else if((jb.getName().equals("kingw") && turn==0) || (jb.getName().equals("kingb") && turn==1))
							   {
								   kingpro(j);
							   }
							   //
							   else
							   {  }
						}
						if(barr[i].getBackground()==Color.red && barr[i].getForeground()==Color.blue)
						{
							if(kingcheckw==1)
							{
								sysexit();
								JOptionPane.showMessageDialog(jrp,"Check Mate!!..black wins..plz restart window to play again..");
							}
							painter();
							kingcheckw=1;
							barr[i].setBackground(Color.yellow);
							turn=initturn;
						}
						else
						{
							kingcheckw=0;
							painter();
						}
					}
				if(barr[i].getName().equals("kingb"))
				{
					kingb=1;
					   painter();
						turn=0;
						for(int j=0;j<64;j++)
						{
							JButton jb=barr[j];
							if((jb.getName().equals("pawnw") && turn==0) || (jb.getName().equals("pawnb") && turn==1))
							   {
								pawnpro(j);
							   }
							   else if((jb.getName().equals("rookw") && turn==0) || (jb.getName().equals("rookb") && turn==1))
							   {
								rookpro(j);
							   }
							   else if((jb.getName().equals("knightw") && turn==0) || (jb.getName().equals("knightb") && turn==1))
							   {
								 knightpro(j);
							   }
							   else if((jb.getName().equals("bishopw") && turn==0) || (jb.getName().equals("bishopb") && turn==1))
							   {
								   bishoppro(j);
							   }//
							   else if((jb.getName().equals("queenw") && turn==0) || (jb.getName().equals("queenb") && turn==1))
							   {
								  queenpro(j);
								}
							   //
							   else if((jb.getName().equals("kingw") && turn==0) || (jb.getName().equals("kingb") && turn==1))
							   {
								   kingpro(j);
							   }
							   //
							   else
							   {  }
						}
   					  if(barr[i].getBackground()==Color.red && barr[i].getForeground()==Color.gray)
						{
							if(kingcheckb==1)
							{
								sysexit();
								JOptionPane.showMessageDialog(jrp,"Check Mate!!..white wins..plz restart window to play again..");
							}
							painter();
							kingcheckb=1;
							barr[i].setBackground(Color.yellow);
							turn=initturn;
						}
						else
						{
							kingcheckb=0;
							painter();
					}
			}
			}
			if(kingw==0)
			{
				sysexit();
				JOptionPane.showMessageDialog(jrp,"Check Mate!!..black wins..plz restart window to play again..");
			}
			else if(kingb==0)
			{
				sysexit();
				JOptionPane.showMessageDialog(jrp,"Check Mate!!..white wins..plz restart window to play again..");
			}
			else{ }
			turn=initturn;
			painter();
		}
	private void sysexit() {
		painter();
		mem.counterx++;
		for(int x=0;x<64;x++)
		{
			barr[x].setEnabled(false);
		}
	}
	private void kingpro(int indexer) {
		row=indexer/8;
		col=indexer%8;
		orow=row;
		ocol=col;
		 row=row-1;
		   for(int i=col-1;i<=col+1;i++)
		   {
			index=row*8+i;
			if(index>=0 && index<64)
			{	
		 	if(barr[index].getName().length()==0 && (index)>=((row)*8) && index<=((row)*8+7))
		 	{
			   barr[index].setBackground(Color.red);
			}
		 	else if(barr[index].getName().length()!=0 && (index)>=((row)*8) && index<=((row)*8+7) && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
		 	{
		 		barr[index].setBackground(Color.red);
		 	}
		 	else { }
		   }
		   }
		   row=orow;
		   col=ocol;
		   row=row+1;
		   for(int i=col-1;i<=col+1;i++)
		   {
			index=row*8+i;
			if(index>=0 && index<64)
			{	
		 	if(barr[index].getName().length()==0 && (index)>=((row)*8) && index<=((row)*8+7))
			{
			   barr[index].setBackground(Color.red);
			}
		 	else if(barr[index].getName().length()!=0 && (index)>=((row)*8) && index<=((row)*8+7) && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
		 	{
		 		barr[index].setBackground(Color.red);
		 	}
		 	else { }
		   }
		   }
		   row=orow;
		   col=ocol;
		   for(int i=col-1;i<=col+1;i+=2)
		   {
			index=row*8+i;
			if(index>=0 && index<64)
			{	
		 	if(barr[index].getName().length()==0 && (index)>=((row)*8) && index<=((row)*8+7))
			{
			   barr[index].setBackground(Color.red);
			}
		 	else if(barr[index].getName().length()!=0 && (index)>=((row)*8) && index<=((row)*8+7) && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
		 	{
		 		barr[index].setBackground(Color.red);
		 	}
		 	else { }
		   }
		   }
	   		counter=1;
	}
	private void queenpro(int indexer) {
		row=indexer/8;
		col=indexer%8;
		 orow=row;
			ocol=col;
		   for(int i=row-1;i>=0;i--)
			{		     
			   if(barr[(i*8)+col].getName().length()!=0)
			   {
				if(barr[(i*8)+col].getForeground()==barr[orow*8+ocol].getForeground())
				{
				   break;
				}
				else if(barr[(i*8)+col].getForeground()!=barr[orow*8+ocol].getForeground())
				{
				   barr[(i*8)+col].setBackground(Color.red);	
				   break;
				}
				else { }
			   }
			   else{
			   barr[(i*8)+col].setBackground(Color.red); }
			}
		  	for(int i=row+1;i<8;i++)
			{
			   if(barr[(i*8)+col].getName().length()!=0)
			   {
				if(barr[(i*8)+col].getForeground()==barr[orow*8+ocol].getForeground())
				{
				   break;
				}
				else if(barr[(i*8)+col].getForeground()!=barr[orow*8+ocol].getForeground())
				{
				   barr[(i*8)+col].setBackground(Color.red);	
				   break;
				}
				else { }
			   }  
			   else{ 
			   barr[(i*8)+col].setBackground(Color.red);	  }
			}
			for(int i=col-1;i>=0;i--)
			{   
			   if(barr[(row*8)+i].getName().length()!=0)
			   {
				if(barr[(row*8)+i].getForeground()==barr[orow*8+ocol].getForeground())
				{
				   break;
				}
				else if(barr[(row*8)+i].getForeground()!=barr[orow*8+ocol].getForeground())
				{
				   barr[(row*8)+i].setBackground(Color.red);	
				   break;
				}
				else { }
			   }
			   else{
			    barr[(row*8)+i].setBackground(Color.red); }
			}
			for(int i=col+1;i<8;i++)
			{
			   if(barr[(row*8)+i].getName().length()!=0)
			   {
				if(barr[(row*8)+i].getForeground()==barr[orow*8+ocol].getForeground())
				{
				   break;
				}
				else if(barr[(row*8)+i].getForeground()!=barr[orow*8+ocol].getForeground())
				{
				   barr[(row*8)+i].setBackground(Color.red);	
				   break;
				}
				else { }
			   }
			   else{
			  barr[(row*8)+i].setBackground(Color.red); }
			}
			for(int i=1;i<(8);i++)
			{
			   if((col+i)>=0 && (col+i)<8 && (row+i)>=0 && (row+i)<8)
			   {
			   index1=(row+i)*8+(col+i);
			   if(barr[index1].getName().length()!=0)
			   {
				if(barr[index1].getForeground()==barr[orow*8+ocol].getForeground())
				{
				   break;
				}
				else if(barr[index1].getForeground()!=barr[orow*8+ocol].getForeground())
				{
				   barr[index1].setBackground(Color.red);	
				   break;
				}
				else { }
			   }
			   else
			   {
			   barr[index1].setBackground(Color.red);
			   }
			   }
			}
			for(int i=1;i<8;i++)
			{
			   if((col-i)>=0 && (col-i)<8 && (row-i)>=0 && (row-i)<8)
			   {
			   index1=(row-i)*8+(col-i);
			   if(barr[index1].getName().length()!=0)
			   {
				if(barr[index1].getForeground()==barr[orow*8+ocol].getForeground())
				{
				   break;
				}
				else if(barr[index1].getForeground()!=barr[orow*8+ocol].getForeground())
				{
				   barr[index1].setBackground(Color.red);	
				   break;
				}
				else { }
			   }
			   else
			   {
			   barr[index1].setBackground(Color.red);
			   }
			   }
			}
			for(int i=1;i<8;i++)
			{
			   if((col+i)>=0 && (col+i)<8 && (row-i)>=0 && (row-i)<8)
			   {
			   index1=(row-i)*8+(col+i);
			   if(barr[index1].getName().length()!=0)
			   {
				if(barr[index1].getForeground()==barr[orow*8+ocol].getForeground())
				{
				   break;
				}
				else if(barr[index1].getForeground()!=barr[orow*8+ocol].getForeground())
				{
				   barr[index1].setBackground(Color.red);	
				   break;
				}
				else { }
			   }
			   else
			   {
			   barr[index1].setBackground(Color.red);
			   }
			   }
			}

			for(int i=1;i<8;i++)
			{
			   if((col-i)>=0 && (col-i)<8 && (row+i)>=0 && (row+i)<8)
			   {
			   index1=(row+i)*8+(col-i);
			   if(barr[index1].getName().length()!=0)
			   {
				if(barr[index1].getForeground()==barr[orow*8+ocol].getForeground())
				{
				   break;
				}
				else if(barr[index1].getForeground()!=barr[orow*8+ocol].getForeground())
				{
				   barr[index1].setBackground(Color.red);	
				   break;
				}
				else { }
			   }
			   else
			   {
			   barr[index1].setBackground(Color.red);
			   }
			   }
			}
			counter=1;
	}
	private void bishoppro(int indexer) {
		row=indexer/8;
		col=indexer%8;
		orow=row;
		ocol=col;
		for(int i=1;i<(8);i++)
		{
		   if((col+i)>=0 && (col+i)<8 && (row+i)>=0 && (row+i)<8)
		   {
		   index1=(row+i)*8+(col+i);
		   if(barr[index1].getName().length()!=0)
		   {
			if(barr[index1].getForeground()==barr[orow*8+ocol].getForeground())
			{
			   break;
			}
			else if(barr[index1].getForeground()!=barr[orow*8+ocol].getForeground())
			{
			   barr[index1].setBackground(Color.red);	
			   break;
			}
			else { }
		   }
		   else
		   {
		   barr[index1].setBackground(Color.red);
		   }
		   }
		}
		for(int i=1;i<8;i++)
		{
		   if((col-i)>=0 && (col-i)<8 && (row-i)>=0 && (row-i)<8)
		   {
		   index1=(row-i)*8+(col-i);
		   if(barr[index1].getName().length()!=0)
		   {
			if(barr[index1].getForeground()==barr[orow*8+ocol].getForeground())
			{
			   break;
			}
			else if(barr[index1].getForeground()!=barr[orow*8+ocol].getForeground())
			{
			   barr[index1].setBackground(Color.red);	
			   break;
			}
			else { }
		   }
		   else
		   {
		   barr[index1].setBackground(Color.red);
		   }
		   }
		}
		for(int i=1;i<8;i++)
		{
		   if((col+i)>=0 && (col+i)<8 && (row-i)>=0 && (row-i)<8)
		   {
		   index1=(row-i)*8+(col+i);
		   if(barr[index1].getName().length()!=0)
		   {
			if(barr[index1].getForeground()==barr[orow*8+ocol].getForeground())
			{
			   break;
			}
			else if(barr[index1].getForeground()!=barr[orow*8+ocol].getForeground())
			{
			   barr[index1].setBackground(Color.red);	
			   break;
			}
			else { }
		   }
		   else
		   {
		   barr[index1].setBackground(Color.red);
		   }
		   }
		}

		for(int i=1;i<8;i++)
		{
		   if((col-i)>=0 && (col-i)<8 && (row+i)>=0 && (row+i)<8)
		   {
		   index1=(row+i)*8+(col-i);
		   if(barr[index1].getName().length()!=0)
		   {
			if(barr[index1].getForeground()==barr[orow*8+ocol].getForeground())
			{
			   break;
			}
			else if(barr[index1].getForeground()!=barr[orow*8+ocol].getForeground())
			{
			   barr[index1].setBackground(Color.red);	
			   break;
			}
			else { }
		   }
		   else
		   {
		   barr[index1].setBackground(Color.red);
		   }
		   }
		}
		counter=1;
	}
	private void knightpro(int indexer) {
		row=indexer/8;
		col=indexer%8;
		orow=row;
		ocol=col;
		tempr=row+2;
		tempc=col+1;
		int index=tempr*8+tempc;
		if(tempr>=0 && tempr<8)
		{
		   if(tempc>=0 && tempc<8)
		   {
			tem=barr[index].getName();
			if(barr[index].getName().length()==0)
			{
			   barr[index].setBackground(Color.red);
			}
			else if(tem.length()!=0 && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
			{
				barr[index].setBackground(Color.red);
			}
			else { }
		   }
		   tempc=col-1;  
		   if(tempc>=0 && tempc<8)
		   {
			index=tempr*8+tempc;
			tem=barr[index].getName();
			if(barr[index].getName().length()==0)
			{
			   barr[index].setBackground(Color.red);
			}
			else if(tem.length()!=0 && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
			{
				barr[index].setBackground(Color.red);
			}
			else { }
		   }
		}
		tempr=row-2;
		tempc=col+1;
		index=tempr*8+tempc;
		if(tempr>=0 && tempr<8)
		{
		   if(tempc>=0 && tempc<8)
		   {
			   tem=barr[index].getName();
			   if(barr[index].getName().length()==0)
				{
				   barr[index].setBackground(Color.red);
				}
				else if(tem.length()!=0 && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
				{
					barr[index].setBackground(Color.red);
				}
				else { }
		   }
		   tempc=col-1;  
		   if(tempc>=0 && tempc<8)
		   {
			index=tempr*8+tempc;
			tem=barr[index].getName();
			if(barr[index].getName().length()==0)
			{
			   barr[index].setBackground(Color.red);
			}
			else if(tem.length()!=0 && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
			{
				barr[index].setBackground(Color.red);
			}
			else { }
		   }
		}
		tempr=row+1;
		tempc=col-2;
		index=tempr*8+tempc;
		if(tempr>=0 && tempr<8)
		{
		   if(tempc>=0 && tempc<8)
		   {
			    tem=barr[index].getName();
				if(barr[index].getName().length()==0)
				{
				   barr[index].setBackground(Color.red);
				}
				else if(tem.length()!=0 && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
				{
					barr[index].setBackground(Color.red);
				}
				else { }
		   }
		   tempc=col+2;  
		   if(tempc>=0 && tempc<8)
		   {
			index=tempr*8+tempc;
			tem=barr[index].getName();
			if(barr[index].getName().length()==0)
			{
			   barr[index].setBackground(Color.red);
			}
			else if(tem.length()!=0 && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
			{
				barr[index].setBackground(Color.red);
			}
			else { }
		   }
		}
		tempr=row-1;
		tempc=col+2;
		index=tempr*8+tempc;
		if(tempr>=0 && tempr<8)
		{
		   if(tempc>=0 && tempc<8)
		   {
			   tem=barr[index].getName();
				if(barr[index].getName().length()==0)
				{
				   barr[index].setBackground(Color.red);
				}
				else if(tem.length()!=0 && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
				{
					barr[index].setBackground(Color.red);
				}
				else { }
		   }
		   tempc=col-2;  
		   if(tempc>=0 && tempc<8)
		   {
			index=tempr*8+tempc;
			tem=barr[index].getName();
			if(barr[index].getName().length()==0)
			{
			   barr[index].setBackground(Color.red);
			}
			else if(tem.length()!=0 && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
			{
				barr[index].setBackground(Color.red);
			}
			else { }
		   }
		}
		counter=1;
	}
	private void rookpro(int indexer)
	{
		row=indexer/8;
		col=indexer%8;
		orow=row;
		ocol=col;
		for(int i=row-1;i>=0;i--)
		{		     
		   if(barr[(i*8)+col].getName().length()!=0)
		   {
			if(barr[(i*8)+col].getForeground()==barr[(orow*8)+ocol].getForeground())
			{
			   break;
			}
			else if(barr[(i*8)+col].getForeground()!=barr[(orow*8)+ocol].getForeground())
			{
			   barr[(i*8)+col].setBackground(Color.red);	
			   break;
			}
			else { }
		   }
		   else{
		   barr[(i*8)+col].setBackground(Color.red); }
		}
	  	for(int i=row+1;i<8;i++)
		{
		   if(barr[(i*8)+col].getName().length()!=0)
		   {
			if(barr[(i*8)+col].getForeground()==barr[(orow*8)+ocol].getForeground())
			{
			   break;
			}
			else if(barr[(i*8)+col].getForeground()!=barr[(orow*8)+ocol].getForeground())
			{
			   barr[(i*8)+col].setBackground(Color.red);	
			   break;
			}
			else { }
		   }  
		   else{ 	
		   barr[(i*8)+col].setBackground(Color.red);	  }
		}
		for(int i=col-1;i>=0;i--)
		{   
		   if(barr[(row*8)+i].getName().length()!=0)
		   {
			if(barr[(row*8)+i].getForeground()==barr[(orow*8)+ocol].getForeground())
			{
			   break;
			}
			else if(barr[(row*8)+i].getForeground()!=barr[(orow*8)+ocol].getForeground())
			{
			   barr[(row*8)+i].setBackground(Color.red);	
			   break;
			}
			else { }
		   }
		   else{
		    barr[(row*8)+i].setBackground(Color.red); }
		}
		for(int i=col+1;i<8;i++)
		{
		   if(barr[(row*8)+i].getName().length()!=0)
		   {
			if(barr[(row*8)+i].getForeground()==barr[(orow*8)+ocol].getForeground())
			{
			   break;
			}
			else if(barr[(row*8)+i].getForeground()!=barr[(orow*8)+ocol].getForeground())
			{
			   barr[(row*8)+i].setBackground(Color.red);	
			   break;
			}
			else { }
		   }
		   else{
		  barr[(row*8)+i].setBackground(Color.red); }
		}
		counter=1;
	}
	private void pawnpro(int indexer)
	{
		jb=barr[indexer];
		row=indexer/8;
		col=indexer%8;
		orow=row;
		ocol=col;
		if(jb.getForeground()==Color.blue && turn==0)
		{
		   int temprp=row-1;
		   for(int i=col-1;i<=col+1;i++)
		   {
			index=temprp*8+i;
			if(index>0 && index<64)
			{	
		 	if(barr[index].getName().length()==0 && (index)>=((temprp)*8) && index<=((temprp)*8+7))
			{
			   barr[index].setBackground(Color.red);
			}
		 	else if(barr[index].getName().length()!=0 && (index)>=((temprp)*8) && index<=((temprp)*8+7) && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
		 	{
		 		barr[index].setBackground(Color.red);
		 	}
		 	else { }
		   }
		   }
		}
		else if(jb.getForeground()==Color.gray && turn==1)
		{
		   int temprp=row+1;
		   for(int i=col-1;i<=col+1;i++)
		   {
			index=temprp*8+i;
			if(index>0 && index<64)
			{
			if(barr[index].getName().length()==0 && index>=((temprp)*8) && index<=((temprp)*8+7))
			{
			   barr[index].setBackground(Color.red);
			}
			else if(barr[index].getName().length()!=0 && index>=((row+1)*8) && index<=((row+1)*8+7) && barr[index].getForeground()!=barr[orow*8+ocol].getForeground())
		 	{
		 		barr[index].setBackground(Color.red);
		 	}
		 	else { }
		   }
		   }
		}
		else { }
		counter=1;
	}
	private void painter() {
		  for(int i=0;i<64;i++)
		   {
			if(barr[i].getBackground()==Color.yellow && (kingcheckb==1 || kingcheckw==1))
			{
				continue;
			}
			if((i/8)%2==0)
			{
			if(i%2==0)
			{
			   barr[i].setBackground(Color.white);
			}
			else
			{
			   barr[i].setBackground(Color.LIGHT_GRAY);
			}
		        }
			else
			{
			if(i%2==0)
			{
			   barr[i].setBackground(Color.LIGHT_GRAY);
			}
			else
			{
			   barr[i].setBackground(Color.white);
			}
			}
		   }
	}
   }
}