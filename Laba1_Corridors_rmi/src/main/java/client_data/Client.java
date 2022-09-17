package client_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import server_data.ColorEnum;
import server_data.RemoteServerMethods;

public class Client {
    private static RemoteServerMethods stub;
    private static ColorEnum myColor;
    private boolean gameOver = false;
    
    public Client() {
        // Runnable task автоматически удалит поток по окончании
        Runnable task = new Runnable() {
            public void run() {
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
    
    private static void createAndShowGUI(ColorEnum myColor_, RemoteServerMethods stub_) {
        Gui app = new Gui(myColor_, stub_);
        app.setVisible(true); 
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        String host = "localhost";
        int port = 8080;
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            System.out.println("registry :" +host+":"+port);
            // получаем из регистра нужный объект и приводим его к интерфейсу Edges
            stub = (RemoteServerMethods) registry.lookup("HelloServer");
            System.out.println(stub);
            Scanner scanner = new Scanner(System.in);
            String s1;
            do {
                if(stub.getRedPlayer() == false && stub.getBlackPlayer() == false)
                    System.out.println("Введите цвет, которым хотите играть (red или black)");
                else if(stub.getRedPlayer() == true && stub.getBlackPlayer() == false)
                    System.out.println("Введите цвет, которым хотите играть (остался цвет black, цвет red уже занят)");
                else if(stub.getRedPlayer() == false && stub.getBlackPlayer() == true)
                    System.out.println("Введите цвет, которым хотите играть (остался цвет red, цвет black уже занят)");
                else
                    System.out.println("Мест в игре больше нет. Игра только для 2 игроков");
                s1 = scanner.nextLine();
            } while(!stub.changeColor(s1));
            if (s1.equals("black"))
                myColor = ColorEnum.BLACK;
            else
                myColor = ColorEnum.RED;
            System.out.println("Ваш цвет - " + myColor);
            scanner.close();
            
            createAndShowGUI(myColor, stub);
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
