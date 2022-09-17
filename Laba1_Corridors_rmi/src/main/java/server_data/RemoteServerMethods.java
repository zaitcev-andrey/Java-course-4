package server_data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author megaa
 */

public interface RemoteServerMethods extends Remote {
    boolean getRedPlayer() throws RemoteException;
    boolean getBlackPlayer() throws RemoteException;
    ColorEnum turnMove() throws RemoteException;
    boolean changeColor(String color) throws RemoteException;
    void addEdgeInArr(int edge_index) throws RemoteException;
    void setLastEdges(int value) throws RemoteException;
    int getLastEdges() throws RemoteException;
    void changeTurn() throws RemoteException;
    void checkAndAddClosedCell() throws RemoteException;
    boolean checkClosedCell() throws RemoteException;
    ArrayList<Integer> getNewClosedCells() throws RemoteException;
    void setCheckClosedCellFalse() throws RemoteException;
    void setLastColor(ColorEnum color) throws RemoteException;
    ColorEnum getLastColor() throws RemoteException;
    boolean checkOnGameOver() throws RemoteException;
    int getRedPoint() throws RemoteException;
    int getBlackPoint() throws RemoteException;
}
