import java.awt.*;
import javax.swing.*;
public class LoginMember extends JFrame{
	public static Container con;
	private JPanel mainp = new JPanel();
	private JPanel southp = new JPanel();
	private JPanel maincnp = new JPanel();
	private JPanel maineast = new JPanel();
	private JButton message = new JButton("Message");
	private JButton bill = new JButton("��ǰ�ֹ�");
	private JLabel user = new JLabel("�����", JLabel.CENTER);
	private JLabel time = new JLabel("���ð�", JLabel.CENTER);
	private JLabel billge = new JLabel("�����", JLabel.CENTER);
	private JLabel milleage = new JLabel("���ϸ���", JLabel.CENTER);
	LoginMember(){
			con = this.getContentPane();
			con.setLayout(new BorderLayout());
			con.add("Center", mainp);
			con.add("South", southp);
			mainp.setLayout(new GridLayout(1,2));
			mainp.add(user);
			mainp.add(maineast);
			maineast.setLayout(new GridLayout(3,1));
			maineast.add(time);
			maineast.add(billge);
			maineast.add(milleage);
			southp.setLayout(new FlowLayout());
			southp.add(bill);
			southp.add(message);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (int)(dim.getWidth()*10.1/12);
			int y = (int)dim.getHeight();
			this.setSize(300, 200);
			this.setLocation(x, 5);
			this.setResizable(false);
			this.setVisible(true);
	}
}
