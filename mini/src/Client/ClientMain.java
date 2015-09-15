package Client;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Common.*;
class LoginFrame extends JFrame implements ActionListener, FocusListener{
	private static final long serialVersionUID = 1L;
	private Container con;
	private NetworkO networkout = new NetworkO();
	private JTextField idtf = new JTextField("���̵�");
	private JTextField nametf = new JTextField();
	private JTextField signupidtf = new JTextField();
	private JPasswordField signuppwdtf = new JPasswordField();
	private JPasswordField signuprepwdtf = new JPasswordField();
	private JTextField teltf = new JTextField();
	private JTextField birthtf = new JTextField();
	private JPasswordField pwtf = new JPasswordField("��й�ȣ");
	private JButton login = new JButton("�α���");
	private JButton signup = new JButton("ȸ������");
	private JButton seachid = new JButton("IDã��");
	private JButton seachpw = new JButton("PWã��");
	private JButton space = new JButton("             ");
	private JButton space2 = new JButton("             ");
	private JButton okbt = new JButton("Ȯ��");
	private JButton idokbt = new JButton("Ȯ��");
	private JButton pwokbt = new JButton("Ȯ��");
	private JButton ccbt = new JButton("���");
	private JButton idccbt = new JButton("���");
	private JButton pwccbt = new JButton("���");
	private JPanel mainp = new JPanel();
	private JPanel sdl = new JPanel();
	private JPanel southp = new JPanel();
	private JPanel scp = new JPanel();
	private JPanel scsp = new JPanel();
	private JPanel ssp = new JPanel();
	private JDialog signupf;
	private JDialog searchidd;
	private JDialog searchpwd;
	private JPanel jdlmainp = new JPanel();
	private JPanel jdlmain1p = new JPanel();
	private JPanel jdlmain2p = new JPanel();
	private JPanel jdlmain3p = new JPanel();
	private JPanel jdlmain4p = new JPanel();
	private JPanel jdlmain5p = new JPanel();
	private JPanel jdlmain6p = new JPanel();
	private JLabel namelb = new JLabel("�� ��", JLabel.RIGHT);
	private JLabel idlb = new JLabel("���̵�", JLabel.RIGHT);
	private JLabel pwdlb = new JLabel("��й�ȣ", JLabel.RIGHT);
	private JLabel repwdlb = new JLabel("��й�ȣ ��Ȯ��", JLabel.RIGHT);
	private JLabel tellb = new JLabel("��ȭ��ȣ", JLabel.RIGHT);
	private JLabel birthlb = new JLabel("�������", JLabel.RIGHT);
	private JLabel namerelb = new JLabel("�̸�����", JLabel.LEFT);
	private JLabel idrelb = new JLabel("���̵�����", JLabel.LEFT);
	private JLabel pwdrelb = new JLabel("��й�ȣ����", JLabel.LEFT);
	private JLabel repwdrelb = new JLabel("");
	private JLabel telrelb = new JLabel("");
	private JLabel birthrelb = new JLabel("��������", JLabel.LEFT);
	private JButton idcheck = new JButton("�ߺ�üũ");
	public LoginFrame(String title){
		super(title);
		setFrame();
		setSize(400,400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)(dim.getWidth()/2 - this.getWidth()/2);
		int ypos = (int)(dim.getHeight()/2 - this.getHeight()/2);
		setLocation(xpos,ypos);
		setResizable(false);
		setVisible(true);
	}
	public LoginFrame(Object obj){
		String str = (String) obj;
		if(str.equals("1")){
			JOptionPane.showMessageDialog(this, "ȸ�������� �Ϸ� �Ǿ����ϴ�.");
		}else if(str.equals("-1")){
			JOptionPane.showMessageDialog(this, "��ϵ� ���̵� �Դϴ�.");
		}
		
	}
	public void setFrame(){
		con = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setLayout(new BorderLayout());
		con.add("Center", mainp);
		con.add("West", space);
		con.add("South", southp);
		southp.setLayout(new BorderLayout());
		southp.add("Center", scp);
		scp.setLayout(new BorderLayout());
		scp.add("Center",scsp);
		scp.add("East",login);
		space.setEnabled(false);
		space2.setEnabled(false);
		scsp.setLayout(new GridLayout(2,1));
		scsp.add(idtf);
		scsp.add(pwtf);
		idtf.addFocusListener(this);
		pwtf.addFocusListener(this);
		southp.add("West", space);
		southp.add("East", space2);
		southp.add("South", ssp);
		ssp.setLayout(new FlowLayout());
		ssp.add(signup);
		ssp.add(seachid);
		ssp.add(seachpw);
		signup.addActionListener(this);
		seachid.addActionListener(this);
		seachpw.addActionListener(this);
		login.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==login){
			login();
		}else if(e.getSource() == signup){
			removeDL();
			signupframe();
		}else if(e.getSource() == seachid){
			removeDL();
			searchid(e.getActionCommand());
		}else if(e.getSource() == seachpw){
			removeDL();
			searchpw(e.getActionCommand());
		}else if(e.getSource() == okbt){
			signupf.setVisible(false);
			signup();
			clear();
		}else if(e.getSource() == ccbt){
			signupf.setVisible(false);
			clear();
		}else if(e.getSource() == idokbt){
			searchidd.setVisible(false);
			searchid(e.getActionCommand());
			clear();
		}else if(e.getSource() == idccbt){
			searchidd.setVisible(false);
			clear();
		}else if(e.getSource() == pwokbt){
			searchpw(e.getActionCommand());
			clear();
		}else if(e.getSource() == pwccbt){
			searchpwd.setVisible(false);
			clear();
		}else if(e.getSource() == idcheck){
			Member member = new Member();
			member.setId(signupidtf.getText());
			new SignUpCheck(member);
		}
	}

	public void signup(){
		Member member = new Member();
		member.setName(nametf.getText());
		member.setTel(teltf.getText());
		member.setBirth(Integer.parseInt(birthtf.getText()));
		member.setId(signupidtf.getText());
		member.setPwd(String.valueOf(signuppwdtf.getPassword()));
		member.setMileage(0);
		networkout.send(member);
	}
	public void searchpw(String title) {
		searchpwd = new JDialog(this, title, true);
		searchpwd.setLocation(300, 300);
		searchpwd.setSize(200, 200);
		searchpwd.add(jdlmain1p);
		jdlmain1p.setLayout(new BorderLayout());
		jdlmain1p.add("Center", jdlmain2p);
		jdlmain2p.setLayout(new GridLayout(3,2));
		jdlmain2p.add(namelb);
		jdlmain2p.add(nametf);
		jdlmain2p.add(birthlb);
		jdlmain2p.add(birthtf);
		jdlmain2p.add(idlb);
		jdlmain2p.add(signupidtf);
		jdlmain1p.add("South", jdlmain3p);
		jdlmain3p.setLayout(new FlowLayout());
		jdlmain3p.add(pwokbt);
		jdlmain3p.add(pwccbt);
		pwokbt.addActionListener(this);
		pwccbt.addActionListener(this);
		searchpwd.setVisible(true);
		Member member = new Member();
		member.setName(nametf.getText());
		member.setBirth(Integer.parseInt(birthtf.getText()));
		member.setId(signupidtf.getText());
		networkout.search(member);
	}
	public void clear(){
		nametf.setText("");
		signupidtf.setText("");
		signuppwdtf.setText("");
		signuprepwdtf.setText("");
		teltf.setText("");
		birthtf.setText("");
	}
	public void searchid(String title) {
		searchidd = new JDialog(this, title, true);
		searchidd.setLocation(300, 300);
		searchidd.setSize(200, 200);
		searchidd.add(jdlmain1p);
		jdlmain1p.setLayout(new BorderLayout());
		jdlmain1p.add("Center", jdlmain2p);
		jdlmain2p.setLayout(new GridLayout(2,2));
		jdlmain2p.add(namelb);
		jdlmain2p.add(nametf);
		jdlmain2p.add(birthlb);
		jdlmain2p.add(birthtf);
		jdlmain1p.add("South", jdlmain3p);
		jdlmain3p.setLayout(new FlowLayout());
		jdlmain3p.add(idokbt);
		idokbt.addActionListener(this);
		jdlmain3p.add(idccbt);
		idccbt.addActionListener(this);
		searchidd.setVisible(true);
		Member member = new Member();
		member.setName(nametf.getText());
		member.setBirth(Integer.parseInt(birthtf.getText()));
		networkout.search(member);
	}
	public void removeDL(){
		jdlmain1p.removeAll();
		jdlmain2p.removeAll();
		jdlmain3p.removeAll();
		jdlmain4p.removeAll();
		jdlmain5p.removeAll();
		jdlmain6p.removeAll();
	}
	public void focusGained(FocusEvent e) {
		if(e.getSource()==idtf){
			idtf.setText("");
		}else if(e.getSource() == pwtf){
			pwtf.setText("");
		}
	}
	public void focusLost(FocusEvent e) {
		if(e.getSource()==idtf && idtf.getText().equals("")){
			idtf.setText("���̵�");
		}else if(e.getSource() == pwtf && pwtf.getPassword().equals("")){
			pwtf.setText("��й�ȣ");
		}
	}
	public void login(){
		String id = idtf.getText();
		String pwd = String.valueOf((pwtf.getPassword()));
		sendLogin(id, pwd);
	}
	public void sendLogin(String id, String pwd) {
		new LoginMember();
		this.setVisible(false);
	}
	public void signupframe() {
		signupf = new JDialog(this, "ȸ������", false);
		signupf.setSize(300, 400);
		signupf.setLocation(500, 500);
		signupf.setLayout(new BorderLayout());
		signupf.add("Center", jdlmainp);
		jdlmainp.setLayout(new GridLayout(6,1));
		jdlmainp.add(jdlmain1p);
		jdlmain1p.setLayout(new GridLayout(1,3));
		jdlmain1p.add(namelb);
		jdlmain1p.add(nametf);
		jdlmain1p.add(namerelb);
		jdlmainp.add(jdlmain2p);
		jdlmain2p.setLayout(new GridLayout(1,3));
		jdlmain2p.add(birthlb);
		jdlmain2p.add(birthtf);
		jdlmain2p.add(birthrelb);
		jdlmainp.add(jdlmain3p);
		jdlmain3p.setLayout(new GridLayout(1,3));
		jdlmain3p.add(tellb);
		jdlmain3p.add(teltf);
		jdlmain3p.add(telrelb);
		jdlmainp.add(jdlmain4p);
		jdlmain4p.setLayout(new GridLayout(1,4));
		jdlmain4p.add(idlb);
		jdlmain4p.add(signupidtf);
		jdlmain4p.add(idrelb);
		jdlmain4p.add(idcheck);
		jdlmainp.add(jdlmain5p);
		jdlmain5p.setLayout(new GridLayout(1,3));
		jdlmain5p.add(pwdlb);
		jdlmain5p.add(signuppwdtf);
		jdlmain5p.add(pwdrelb);
		jdlmainp.add(jdlmain6p);
		jdlmain6p.setLayout(new GridLayout(1,3));
		jdlmain6p.add(repwdlb);
		jdlmain6p.add(signuprepwdtf);
		jdlmain6p.add(repwdrelb);
		signupf.add("South", sdl);
		sdl.setLayout(new FlowLayout());
		sdl.add(okbt);
		sdl.add(ccbt);
		signupf.setVisible(true);
		okbt.addActionListener(this);
		ccbt.addActionListener(this);
		idcheck.addActionListener(this);
		}
}
public class ClientMain {
	public ClientMain(Member member) {
		new LoginFrame(member);
	}
	public ClientMain(Object obj){
		new LoginFrame(obj);
	}
	public static void main(String[] args) {
		new LoginFrame("");
	}
}
