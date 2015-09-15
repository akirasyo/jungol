package Server;
import java.net.*;
import Common.*;
import java.io.*;
public class NetworkIn extends Thread{
	private Socket soc;
	public NetworkIn(Socket soc) {
		this.soc = soc;
	}
	public void search(Object obj, Socket soc){
		try{
			BufferedOutputStream bos = new BufferedOutputStream(soc.getOutputStream());
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run(){
			try{
				BufferedInputStream bis = new BufferedInputStream(soc.getInputStream());
				ObjectInputStream ois = new ObjectInputStream(bis);
				while(true){
				Member member = (Member) ois.readObject();
				new MemberDAO(member, soc);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}
}
