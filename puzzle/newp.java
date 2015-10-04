import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*<applet code="newp.java" height=289 width=280>
</applet>*/
public class newp extends JApplet 
{
   JRootPane root=new JRootPane();
   JPanel ap;
   JButton[] barr;
   JPanel jtemp[][]=new JPanel[3][3];
   JButton emp;
   int xc=0;
   public void init()
   {
	try
	{
	   SwingUtilities.invokeAndWait(new Runnable()
	   {
	   public void run()
	   {
		new app();
	   }
	   });
	}catch(Exception e)
	{ }
   }  
   public class app implements ActionListener
   {
	public app()
	{
	   ap=new JPanel();
	   barr=new JButton[9];	
	   emp=new JButton("click here");
	   ap.setLayout(new GridLayout(3,3));
	   
	   for(int i=0;i<3;i++)
	   {
		for(int j=0;j<3;j++)
		{
		   jtemp[i][j]=new JPanel();
		   ap.add(jtemp[i][j]); 
		}
	   }
	   for(int i=0;i<3;i++)
	   {
		for(int j=0;j<3;j++)
		{
		   int index=3*i+j;
		   if(index!=8)
		   {
		   barr[index]=new JButton(index+"",new ImageIcon("pro"+index+".jpg"));
		   jtemp[i][j].setLayout(new BorderLayout()); 
		   jtemp[i][j].add(barr[index],BorderLayout.CENTER); 
		   barr[index].setName(index+"");
		 }
		   else
		   {
			jtemp[i][j].setLayout(new BorderLayout());
			jtemp[i][j].add(emp);
			emp.setName("8");
		   }
		}
	   }
	   add(root);
	   root.setContentPane(ap);
	   root.revalidate();
	   root.repaint();
	   for(int i=0;i<8;i++)
	   {
		barr[i].addActionListener(this);
	   }
	   emp.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent ae)
	   {
		if(xc==0)
	  	{
		   emp.setIcon(new ImageIcon("pro.jpg"));
		   xc=1;
		}
		else
		{
		   emp.setIcon(null);
//		   emp.setLabel("Click Here");
		   xc=0;
		}
		
	   }
	   });
	}
	JButton temp;
	int i,id,empe,row,col,rowe,cole,count=0;
	public void actionPerformed(ActionEvent ae)
	{
	   
	   temp=(JButton)ae.getSource();
	   i=Integer.parseInt(temp.getName());
	   id=Integer.parseInt(temp.getLabel());
	   empe=Integer.parseInt(emp.getName());
 	   row=i/3;
 	   col=i%3;
	   rowe=empe/3;
 	   cole=empe%3;   
	   String che="";
	   if(i==0 || i==2 || i==6 || i==8)
	   {
		switch(i)
		{
		   case 0:
		   if(empe==1 || empe==3)
		   {
			inter();
		   }
		   break;
		   case 2:
		   if(empe==1 || empe==5)
		   {
			inter();
		   }
		   break;
		   case 6:
		   if(empe==7 || empe==3)
		   {
			inter();
		   }
		   break;
		   case 8:
		   if(empe==5 || empe==7)
		   {
			inter();
		   }
		   break;
		}
	   }
	   else if(i==1 || i==3 || i==5 || i==7)
	   {
		switch(i)
		{
		   case 1:
		   if(empe==0 || empe==4 ||  empe==2)
		   {
			inter();
		   }
		   break;	
		   case 3:
		   if(empe==0 || empe==4 ||  empe==6)
		   {
			inter();
		   }
		   break;
		   case 5:
		   if(empe==8 || empe==4 ||  empe==2)
		   {
			inter();
		   }
		   break;		
		   case 7:
		   if(empe==8 || empe==4 ||  empe==6)
		   {
			inter();
		   }
		   break;	
		}
	   }
	   else if(i==4)
	   {
		if(empe==1 || empe==3 ||  empe==5 || empe==7)
		{
		   inter();
		}
	   }
	   else
	   { }
       	   for(int x=0;x<3;x++)
	   {
		for(int y=0;y<3;y++)
		{
		   Component[] z=jtemp[x][y].getComponents();
		   if(z[0] != emp)
		   {
			JButton tempx=(JButton)z[0];
			che=che+tempx.getLabel();	
		   }
		   else
		   {
			che=che+" ";
		   }
		}
	   }
	   if(che.equals("42673015 "))
	   {
		JOptionPane.showMessageDialog(null,"congrats!!you made it :D :D no. of moves:"+count);
		for(i=0;i<8;i++)
		{
		   barr[i].setEnabled(false);	
		   try
		   {
			Thread.sleep(25);
		   }catch(Exception e){ }
		}
		emp.setLabel("Thankyou");
	   }	
	}
	public void inter()
	{
	   jtemp[rowe][cole].removeAll();
	   jtemp[rowe][cole].add(barr[id],BorderLayout.CENTER);
	   barr[id].setName(empe+"");
	   jtemp[row][col].removeAll();
	   emp=new JButton();
	   jtemp[row][col].add(emp,BorderLayout.CENTER);
	   emp.setName(i+"");
	   jtemp[rowe][cole].revalidate();
	   jtemp[row][col].revalidate();
	   count++;
	}
   }
}