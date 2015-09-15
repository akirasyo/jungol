package Server;
import java.awt.*;
import Common.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
public class ServerAdmin extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Container con;
	private NetworkIn netIn;
	private MenuBar mb = new MenuBar();
	private MenuItem mi = new MenuItem("��üȸ������");
	private MenuItem mi1 = new MenuItem("ȸ����������");
	private MenuItem mi2 = new MenuItem("ȸ������");
	private MenuItem mi3 = new MenuItem("ȸ������û");
	private MenuItem mi4 = new MenuItem("��ȸ������û");
	private Menu menu = new Menu("ȸ������");
	private MemberDAO mdao = new MemberDAO();;
	private Vector<String> header = new Vector<String>();
	private Vector<String> data = new Vector<String>();
	private DefaultTableModel dtm;
	private JTable jtb;
	private JScrollPane jsp;
	private JDialog editdl = new JDialog();
	private JLabel namelb = new JLabel("�̸�", JLabel.CENTER);
	private JLabel tellb = new JLabel("��ȭ��ȣ", JLabel.CENTER);
	private JLabel birthlb = new JLabel("�������", JLabel.CENTER);
	private JLabel idlb = new JLabel("���̵�", JLabel.CENTER);
	private JLabel pwdlb = new JLabel("��й�ȣ", JLabel.CENTER);
	private JLabel mileagelb = new JLabel("���ϸ���", JLabel.CENTER);
	private JTextField nametf = new JTextField("");
	private JTextField teltf = new JTextField("");
	private JTextField birthtf = new JTextField("");
	private JTextField idtf = new JTextField("");
	private JPasswordField pwdtf = new JPasswordField("");
	private JTextField mileagetf = new JTextField("");
	private JPanel sp = new JPanel();
	private JPanel cp = new JPanel();
	private JButton okbt = new JButton("Ȯ��");
	private JButton ccbt = new JButton("���");
	private ServerSocket ss;
	private Socket soc;
	public ServerAdmin() {

		init();
		setSize(400,400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)(dim.getWidth()/2 - this.getWidth()/2);
		int ypos = (int)(dim.getHeight()/2 - this.getHeight()/2);
		setLocation(xpos,ypos);
		setResizable(false);
		setVisible(true);
		try{
			ss = new ServerSocket(12345);
			while(true){
				soc = ss.accept();
				new NetworkIn(soc).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void init(){
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		mb.add(menu);
		this.setMenuBar(mb);
		menu.add(mi);
		menu.add(mi2);
		menu.add(mi1);
		menu.add(mi3);
		menu.add(mi4);
		mi.addActionListener(this);
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		nametf.setEditable(false);
		idtf.setEditable(false);
		mileagetf.setEditable(false);
		birthtf.setEditable(false);
		header.add("ȸ����ȣ");
		header.add("�̸�");
		header.add("��ȭ��ȣ");
		header.add("�������");
		header.add("���̵�");
		header.add("���ϸ���");
		DefaultTableModel dtm = new DefaultTableModel(data, header){
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[]{false, false, false, false};
			public boolean isCellEditable(int rowIndex,int columnIndex){
				return canEdit [columnIndex];
			}
		};
		jtb= new JTable(dtm);
		jsp = new JScrollPane(jtb);
	}
	public void setallmemberFrame(){
		JDialog allmember = new JDialog();
		allmember.setLayout(new BorderLayout());
		allmember.add("Center", jsp);
		allmember.setLocation(500, 500);
		allmember.setSize(400, 400);
		allmember.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mi){
			allview();
		}else if(e.getSource() == mi1){
			String name = JOptionPane.showInputDialog("������ �̸��� �Է��ϼ���");
			if(name.equals("")){
				JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���");
				return;
			}else{
				String birth = JOptionPane.showInputDialog("������ �Է��ϼ���.");
				if(birth.equals("")){
					JOptionPane.showMessageDialog(this, "��������� �ȹٷ� �Է��ϼ���");
					return;
				}else{
					boolean issearch = mdao.search(name, birth);
					if(!issearch){
						JOptionPane.showMessageDialog(this, "�˻��Ͻ� ������ �����ϴ�.");
					}else{
						editofsearch(name, birth);
						editFrame();
					}
				}
			}
		}else if(e.getSource() == okbt){
			edit();
			editdl.setVisible(false);
			clear();
		}else if(e.getSource() == ccbt){
			editdl.setVisible(false);
			clear();
		}
	}
	public void clear(){
		sp.removeAll();
		cp.removeAll();
		nametf.setText("");
		teltf.setText("");
		birthtf.setText("");
		idtf.setText("");
		pwdtf.setText("");
		mileagetf.setText("");
	}
	public void editFrame(){
		editdl = new JDialog();
		editdl.setLayout(new BorderLayout());
		editdl.add("Center", cp);
		editdl.add("South", sp);
		sp.setLayout(new FlowLayout());
		cp.setLayout(new GridLayout(6,1));
		sp.add(okbt);
		sp.add(ccbt);
		cp.add(namelb);
		cp.add(nametf);
		cp.add(tellb);
		cp.add(teltf);
		cp.add(birthlb);
		cp.add(birthtf);
		cp.add(idlb);
		cp.add(idtf);
		cp.add(pwdlb);
		cp.add(pwdtf);
		cp.add(mileagelb);
		cp.add(mileagetf);
		okbt.addActionListener(this);
		ccbt.addActionListener(this);
		editdl.setLocation(500, 500);
		editdl.setSize(300, 400);
		editdl.setVisible(true);
	}
	public void editofsearch(String name, String birth){
		ArrayList<Member>al = mdao.editOfsearch(name, birth);
			for (Member mem : al) {
			nametf.setText(mem.getName());
			teltf.setText(mem.getTel());
			birthtf.setText(String.valueOf(mem.getBirth()));
			idtf.setText(mem.getId());
			pwdtf.setText(mem.getPwd());
			mileagetf.setText(String.valueOf(mem.getMileage()));
		}
	}
	public void edit(){
		String tel = teltf.getText();
		String pwd = String.valueOf(pwdtf.getPassword());
		String name = nametf.getText();
		int res = mdao.edit(tel, pwd, name);
		if(res>0){
			JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�.");
		}else{
			JOptionPane.showMessageDialog(this, "������ �Ұ����մϴ�. �����ڿ��� �����ϼ���");
		}
	}
	public void allview(){
		ArrayList<Member> al = mdao.searchAll();
		setallmemberFrame();
		dtm = (DefaultTableModel) jtb.getModel();
		for (int i = dtm.getRowCount()-1; i > 0 ; i--) {
			dtm.removeRow(i);
		}
		for (Member member : al) {
			Vector<String> imsi = new Vector<String>();
			imsi.add(String.valueOf(member.getIdx()));
			imsi.add(member.getName());
			imsi.add(member.getTel());
			imsi.add(String.valueOf(member.getBirth()));
			imsi.add(member.getId());
			imsi.add(String.valueOf(member.getMileage()));
			dtm.addRow(imsi);
		}
	}
	public static void main(String[] args) {
		new ServerAdmin();
	}
}
