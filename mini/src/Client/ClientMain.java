package Client;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Common.*;
class LoginFrame extends JFrame implements ActionListener, FocusListener{
	private static final long serialVersionUID = 1L;
	private Container con;
	private NetworkO networkout = new NetworkO();
	private JTextField idtf = new JTextField("아이디");
	private JTextField nametf = new JTextField();
	private JTextField signupidtf = new JTextField();
	private JPasswordField signuppwdtf = new JPasswordField();
	private JPasswordField signuprepwdtf = new JPasswordField();
	private JTextField teltf = new JTextField();
	private JTextField birthtf = new JTextField();
	private JPasswordField pwtf = new JPasswordField("비밀번호");
	private JButton login = new JButton("로그인");
	private JButton signup = new JButton("회원가입");
	private JButton seachid = new JButton("ID찾기");
	private JButton seachpw = new JButton("PW찾기");
	private JButton space = new JButton("             ");
	private JButton space2 = new JButton("             ");
	private JButton okbt = new JButton("확인");
	private JButton idokbt = new JButton("확인");
	private JButton pwokbt = new JButton("확인");
	private JButton ccbt = new JButton("취소");
	private JButton idccbt = new JButton("취소");
	private JButton pwccbt = new JButton("취소");
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
	private JLabel namelb = new JLabel("이 름", JLabel.RIGHT);
	private JLabel idlb = new JLabel("아이디", JLabel.RIGHT);
	private JLabel pwdlb = new JLabel("비밀번호", JLabel.RIGHT);
	private JLabel repwdlb = new JLabel("비밀번호 재확인", JLabel.RIGHT);
	private JLabel tellb = new JLabel("전화번호", JLabel.RIGHT);
	private JLabel birthlb = new JLabel("생년월일", JLabel.RIGHT);
	private JLabel namerelb = new JLabel("이름패턴", JLabel.LEFT);
	private JLabel idrelb = new JLabel("아이디패턴", JLabel.LEFT);
	private JLabel pwdrelb = new JLabel("비밀번호패턴", JLabel.LEFT);
	private JLabel repwdrelb = new JLabel("");
	private JLabel telrelb = new JLabel("");
	private JLabel birthrelb = new JLabel("생일패턴", JLabel.LEFT);
	private JButton idcheck = new JButton("중복체크");
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
			JOptionPane.showMessageDialog(this, "회원가입이 완료 되었습니다.");
		}else if(str.equals("-1")){
			JOptionPane.showMessageDialog(this, "등록된 아이디 입니다.");
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
			idtf.setText("아이디");
		}else if(e.getSource() == pwtf && pwtf.getPassword().equals("")){
			pwtf.setText("비밀번호");
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
		signupf = new JDialog(this, "회원가입", false);
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
