import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends JFrame{
	private static final long serialVersionUID = 1L;
	public static Container con;
	private JLabel namelb = new JLabel("�̸�", JLabel.RIGHT);
	private JLabel idlb = new JLabel("���̵�", JLabel.RIGHT);
	private JLabel pwdlb = new JLabel("�н�����", JLabel.RIGHT);
	private JLabel pwdrelb = new JLabel("�н����� ��Ȯ��", JLabel.RIGHT);
	private JLabel tellb = new JLabel("��ȭ��ȣ", JLabel.RIGHT);
	private JLabel namese = new JLabel("�̸�����", JLabel.LEFT);
	private JLabel idse = new JLabel("���̵� ����", JLabel.LEFT);
	private JLabel pwdse = new JLabel("", JLabel.LEFT);
	private JLabel pwdrese = new JLabel("�н����� ����", JLabel.LEFT);
	private JLabel telse = new JLabel("��ȭ��ȣ ����", JLabel.LEFT);
	private JTextField nametf = new JTextField();
	private JTextField idtf = new JTextField();
	private JTextField pwdtf = new JTextField();
	private JTextField pwdretf = new JTextField();
	private JTextField teltf = new JTextField();
	private JPanel centerp = new JPanel();
	private JPanel southp = new JPanel();
	public SignUp() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("Center", centerp);
		centerp.setLayout(new GridLayout(5,3));
		centerp.add(idlb);		centerp.add(idtf);		centerp.add(idse);
		centerp.add(pwdlb);		centerp.add(pwdtf);		centerp.add(pwdse);
		centerp.add(pwdrelb);		centerp.add(pwdretf);		centerp.add(pwdrese);
		centerp.add(namelb);		centerp.add(nametf);		centerp.add(namese);
		centerp.add(tellb);		centerp.add(teltf);		centerp.add(telse);
		con.add("South", southp);
		this.setSize(500, 800);
		this.setLocation(300, 300);
		this.setResizable(false);
	}
}