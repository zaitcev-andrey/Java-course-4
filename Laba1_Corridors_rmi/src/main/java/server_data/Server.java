package server_data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements RemoteServerMethods {
    
    private boolean black = false;
    private boolean red = false;
    private ColorEnum turn = ColorEnum.RED;
    private static int edgesArr[] = new int[24]; // изначально нули (если 0, то ребро не покрашено, если 1, то покрашено)
    //private int cellsArr[] = new int[9]; // это массив из ячеек, которые будут красится в цвет последнего ребра, которым они замыкаются
    private int lastEdges = -1;
    private boolean closedCell = false;
    private ArrayList<Integer> newClosedCells = new ArrayList<>();
    private ColorEnum lastColor = ColorEnum.NOT_USED;
    private int redPoint = 0;
    private int blackPoint = 0;
    
    
    public Server() throws java.rmi.RemoteException {
        super();
    }
    
    public static void main(String[] args) {       
        try {
            Server obj = new Server();
            Registry registry = LocateRegistry.createRegistry(8080);
            registry.bind("HelloServer", obj); // название сервера
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public boolean getRedPlayer() throws RemoteException {
        return red;
    }

    @Override
    public boolean getBlackPlayer() throws RemoteException {
        return black;
    }
    
    @Override
    public boolean changeColor(String color) throws RemoteException {
        if (color.equals("black") && !black) {
            black = true;
            return true;
        } else if(color.equals("red") && !red) {
            red = true;
            return true;
        }
        return false;
    }

    @Override
    public ColorEnum turnMove() throws RemoteException {
        return turn;
    }

    @Override
    public void addEdgeInArr(int edge_index) throws RemoteException {
        edgesArr[edge_index - 1] = 1; // - 1, так как индексы массива с 0, а индексы кнопок с 1
        setLastEdges(edge_index);
        checkAndAddClosedCell();
    }
    
    @Override
    public void setLastEdges(int value) throws RemoteException {
        lastEdges = value;
    }
    
    @Override
    public int getLastEdges() throws RemoteException {
        return lastEdges;
    }

    @Override
    public void changeTurn() throws RemoteException {
        if(turn == ColorEnum.RED)
            turn = ColorEnum.BLACK;
        else
            turn = ColorEnum.RED;
    }

    @Override
    public void checkAndAddClosedCell() throws RemoteException {
        int ind = getLastEdges();
        ArrayList <Integer> tmp = new ArrayList<>();
        
        // 1) если горизонтальное ребро вверху
        if(ind == 1 || ind == 2 || ind == 3) {
            if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1) && (edgesArr[ind + 7 - 1] == 1)) {
                if(lastColor == ColorEnum.RED)
                    redPoint++;
                else if(lastColor == ColorEnum.BLACK)
                    blackPoint++;
                
                //cellsArr[ind - 1] = 1;
                closedCell = true;
                tmp.add(ind - 1);
            }
        }
        // 2) если горизонтальное ребро в центре
        else if(ind == 8 || ind == 9 || ind == 10 || ind == 15 || ind == 16 || ind == 17) {
            if(((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1) && (edgesArr[ind + 7 - 1] == 1)) || 
                    ((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1) && (edgesArr[ind - 7 - 1] == 1))) {
                switch(ind) {
                    // именно 2 if, так как за раз могут закрыться 2 ячейки, поэтому проверяем сразу 2
                    case 8:
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1) && (edgesArr[ind + 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[3] = 1;
                            tmp.add(3);
                        }
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1) && (edgesArr[ind - 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[0] = 1;
                            tmp.add(0);
                        }
                        break;
                    case 9:
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1) && (edgesArr[ind + 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[4] = 1;
                            tmp.add(4);
                        }
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1) && (edgesArr[ind - 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[1] = 1;
                            tmp.add(1);
                        }
                        break;
                    case 10:
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1) && (edgesArr[ind + 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[5] = 1;
                            tmp.add(5);
                        }
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1) && (edgesArr[ind - 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[2] = 1;
                            tmp.add(2);
                        }
                        break;
                    case 15:
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1) && (edgesArr[ind + 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[6] = 1;
                            tmp.add(6);
                        }
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1) && (edgesArr[ind - 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[3] = 1;
                            tmp.add(3);
                        }
                        break;
                    case 16:
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1) && (edgesArr[ind + 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[7] = 1;
                            tmp.add(7);
                        }
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1) && (edgesArr[ind - 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[4] = 1;
                            tmp.add(4);
                        }
                        break;
                    case 17:
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1) && (edgesArr[ind + 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[8] = 1;
                            tmp.add(8);
                        }
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1) && (edgesArr[ind - 7 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[5] = 1;
                            tmp.add(5);
                        }
                }
                closedCell = true;
            }
        }
        // 3) если горизонтальное ребро внизу
        else if(ind == 22 || ind == 23 || ind == 24) {
            if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1) && (edgesArr[ind - 7 - 1] == 1)) {
                if(lastColor == ColorEnum.RED)
                    redPoint++;
                else if(lastColor == ColorEnum.BLACK)
                    blackPoint++;
                
                switch(ind) {
                    case 22:
                        //cellsArr[6] = 1;
                        tmp.add(6);
                        break;
                    case 23:
                        //cellsArr[7] = 1;
                        tmp.add(7);
                        break;
                    case 24:
                        //cellsArr[8] = 1;
                        tmp.add(8);
                }
                closedCell = true;
            }
        }
        // 4) если вертикальное ребро слева
        else if(ind == 4 || ind == 11 || ind == 18) {
            if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind + 1 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1)) {
                if(lastColor == ColorEnum.RED)
                    redPoint++;
                else if(lastColor == ColorEnum.BLACK)
                    blackPoint++;
                
                switch(ind) {
                    case 4:
                        //cellsArr[0] = 1;
                        tmp.add(0);
                        break;
                    case 11:
                        //cellsArr[3] = 1;
                        tmp.add(3);
                        break;
                    case 18:
                        //cellsArr[6] = 1;
                        tmp.add(6);
                }
                closedCell = true;
            }
        }
        // 5) если вертикальное ребро в центре
        else if(ind == 5 || ind == 6 || ind == 12 || ind == 13 || ind == 19 || ind == 20) {
            if(((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind + 1 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1)) || 
                    ((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind - 1 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1))) {
                switch(ind) {
                    // именно 2 if, так как за раз могут закрыться 2 ячейки, поэтому проверяем сразу 2
                    case 5:
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind + 1 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[1] = 1;
                            tmp.add(1);
                        }
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind - 1 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[0] = 1;
                            tmp.add(0);
                        }
                        break;
                    case 6:
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind + 1 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[2] = 1;
                            tmp.add(2);
                        }
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind - 1 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[1] = 1;
                            tmp.add(1);
                        }
                        break;
                    case 12:
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind + 1 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[4] = 1;
                            tmp.add(4);
                        }
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind - 1 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[3] = 1;
                            tmp.add(3);
                        }
                        break;
                    case 13:
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind + 1 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[5] = 1;
                            tmp.add(5);
                        }
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind - 1 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[4] = 1;
                            tmp.add(4);
                        }
                        break;
                    case 19:
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind + 1 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[7] = 1;
                            tmp.add(7);
                        }
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind - 1 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[6] = 1;
                            tmp.add(6);
                        }
                        break;
                    case 20:
                        if((edgesArr[ind - 3 - 1] == 1) && (edgesArr[ind + 1 - 1] == 1) && (edgesArr[ind + 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[8] = 1;
                            tmp.add(8);
                        }
                        if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind - 1 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1)) {
                            if(lastColor == ColorEnum.RED)
                                redPoint++;
                            else if(lastColor == ColorEnum.BLACK)
                                blackPoint++;
                            
                            //cellsArr[7] = 1;
                            tmp.add(7);
                        }
                }
                closedCell = true;
            }
        }
        // 6) если вертикальное ребро справа
        else if(ind == 7 || ind == 14 || ind == 21) {
            if((edgesArr[ind + 3 - 1] == 1) && (edgesArr[ind - 1 - 1] == 1) && (edgesArr[ind - 4 - 1] == 1)) {
                if(lastColor == ColorEnum.RED)
                    redPoint++;
                else if(lastColor == ColorEnum.BLACK)
                    blackPoint++;
                
                switch(ind) {
                    case 7:
                        //cellsArr[2] = 1;
                        tmp.add(2);
                        break;
                    case 14:
                        //cellsArr[5] = 1;
                        tmp.add(5);
                        break;
                    case 21:
                        //cellsArr[8] = 1;
                        tmp.add(8);
                }
                closedCell = true;
            }
        }
        newClosedCells = tmp;
    }

    @Override
    public boolean checkClosedCell() throws RemoteException {
        return closedCell;
    }

    @Override
    public ArrayList<Integer> getNewClosedCells() throws RemoteException {
        return newClosedCells;
    }

    @Override
    public void setCheckClosedCellFalse() throws RemoteException {
        closedCell = false;
    }

    @Override
    public void setLastColor(ColorEnum color) throws RemoteException {
        lastColor = color;
    }

    @Override
    public ColorEnum getLastColor() throws RemoteException {
        return lastColor;
    }

    @Override
    public boolean checkOnGameOver() throws RemoteException {
        boolean result;
        boolean flag = false;
        for(int i = 0; i < edgesArr.length; i++)
            if(edgesArr[i] == 0) {
                flag = true;
                break;
            }
        if(flag == true)
            result = false;
        else
            result = true;
        return result;
    }

    @Override
    public int getRedPoint() throws RemoteException {
        return redPoint;
    }

    @Override
    public int getBlackPoint() throws RemoteException {
        return blackPoint;
    }
}
