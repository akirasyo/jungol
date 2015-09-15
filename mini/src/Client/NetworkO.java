package Client;
import java.net.*;
import Common.*;
import java.io.*;
public class NetworkO extends Thread {
	private Socket soc;
	private InetAddress ia;
	public NetworkO(){
		try{
			ia = InetAddress.getByName("192.168.33.60");
			soc = new Socket(ia, 12345);
			Thread th = new Thread(this);
			th.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void send(Member member){
		try{
			BufferedOutputStream bos = new BufferedOutputStream(soc.getOutputStream());
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(member);
			oos.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void search(Member member){
		try{
			BufferedOutputStream bos = new BufferedOutputStream(soc.getOutputStream());
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			while(true){
				oos.writeObject(member);
				oos.flush();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run(){
			try{
				BufferedInputStream bis = new BufferedInputStream(soc.getInputStream());
				ObjectInputStream ois = new ObjectInputStream(bis);
				while(true){
					Object obj = (Object) ois.readObject();
					new LoginFrame(obj);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
	}
}
