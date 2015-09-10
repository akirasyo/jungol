import java.awt.*;
import javax.swing.*;
public class Seach extends JFrame{
	private String name;
	private String pwd;
	private String id;
	private String tel;
	protected static Container con;
	private JPanel idcp = new JPanel();
	private JPanel pwcp = new JPanel();
	private JPanel cnp = new JPanel();
	private JPanel ccp = new JPanel();
	private JPanel csp = new JPanel();
	private JLabel namelb = new JLabel("이름", JLabel.RIGHT);
	private JLabel tellb = new JLabel("전화번호", JLabel.RIGHT);
	private JLabel idlb = new JLabel("아이디", JLabel.RIGHT);
	private JTextField nametf = new JTextField();
	private JTextField teltf = new JTextField();
	private JTextField idtf = new JTextField();
	
	Seach(String title){
		this.setFrame(title);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)(dim.getWidth()/2 - this.getWidth()/2);
		int y = (int)(dim.getHeight()/2 - this.getHeight()/2);
		this.setLocation(x, y);
		this.setResizable(false);
	}
	public void setFrame(String title){
		super.setTitle(title);
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		if(title.equals("ID찾기")){
			searchid(title.substring(0, 1));
			con.add("Center", idcp);
		}else {
			searchpw(title.substring(0, 2));
			con.add("Center", pwcp);
		}
	}
	public void searchid(String id){
		idcp.setLayout(new GridLayout(2,2));
		idcp.add(namelb);
		idcp.add(nametf);
		idcp.add(tellb);
		idcp.add(teltf);
	}
	public void searchpw(String pwd){
		pwcp.setLayout(new GridLayout(3,1));
		pwcp.add(cnp);
		cnp.setLayout(new BorderLayout());
		cnp.add("West",namelb);		cnp.add("Center",nametf);
		pwcp.add(ccp);
		ccp.setLayout(new BorderLayout());
		ccp.add("West", tellb);		ccp.add("Center", teltf);
		pwcp.add(csp);
		csp.setLayout(new BorderLayout());
		csp.add("West", idlb);		csp.add("Center", idtf);
	}
}
