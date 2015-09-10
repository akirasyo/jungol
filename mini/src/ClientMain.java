import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
class LoginFrame extends JFrame implements ActionListener, FocusListener{
	private static final long serialVersionUID = 1L;
	private Container con; Member member;
	private JTextField idtf = new JTextField("아이디");
	private JPasswordField pwtf = new JPasswordField("비밀번호");
	private JButton login = new JButton("로그인");
	private JButton signup = new JButton("회원가입");
	private JButton seachid = new JButton("ID찾기");
	private JButton seachpw = new JButton("PW찾기");
	private JButton space = new JButton("             ");
	private JButton space2 = new JButton("             ");
	private JButton okbt = new JButton("확인");
	private JButton ccbt = new JButton("취소");
	private JPanel mainp = new JPanel();
	private JPanel sdl = new JPanel();
	private JPanel southp = new JPanel();
	private JPanel scp = new JPanel();
	private JPanel scsp = new JPanel();
	private JPanel ssp = new JPanel();
	private JDialog signupf = new JDialog(this, "회원가입", false);
	private JDialog searchiddl = new JDialog(this, "아이디 찾기", false);
	private JDialog searchpwdl = new JDialog(this, "비밀번호 찾기", false);
	private Seach seach;
	
	private ServerSocket ss; private Socket soc;
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
		signupf.setSize(250, 350);
		signupf.setLocation(300, 300);
		signupf.setResizable(false);
		sdl.setLayout(new FlowLayout());
		sdl.add(okbt);
		sdl.add(ccbt);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==login){
			login();
		}else if(e.getSource() == signup){
			signup();
		}else if(e.getSource() == seachid){
			seachid(e.getActionCommand());
		}else if(e.getSource() == seachpw){
			seachpw(e.getActionCommand());
		}
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
		String pwd = new String(pwtf.getPassword());
		sendLogin(id, pwd);
	}
	private void sendLogin(String id, String pwd) {
		new LoginMember();
	
		this.setVisible(false);
	}
	public void signup() {
		SignUp signup = new SignUp();
		signupf.setLayout(new BorderLayout());
		signupf.add("Center", signup.con);
		signupf.add("South", sdl);
		signupf.setVisible(true);
	}
	public void seachid(String id){
		Seach seach = new Seach(id);
		con.revalidate();
		searchiddl.setLayout(new BorderLayout());
		searchiddl.add("Center",seach.con);
		searchiddl.add("South", sdl);
		searchiddl.setSize(300, 150);
		searchiddl.setLocation(400, 400);
		searchiddl.setVisible(true);
	}
	public void seachpw(String pwd){
		new Seach(pwd);
		searchpwdl.setLayout(new BorderLayout());
		searchpwdl.add("Center", seach.con);
		searchpwdl.add("South", sdl);
		searchpwdl.setSize(200, 200);
		searchpwdl.setLocation(400, 400);
		searchpwdl.setVisible(true);
	}

}
public class ClientMain {
	public static void main(String[] args) {
		new LoginFrame("");
	}
}
