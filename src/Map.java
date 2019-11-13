import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {

    private Box[][] map;

//    Map(int rows, int cols){        //init only with dimensions
//        map = new Box[rows][cols];
//        for (int i=0;i<rows;i++)
//            for (int j=0;j<cols;j++)
//                map[i][j]=new Box();
//    }
//
//    Map(char[][] table){        //init with sample table
//        for (int i=0;i<table.length;i++)
//            for (int j=0;j<table[i].length;j++)
//                map[i][j]=new Box(table[i][j]);
//    }

    Map(){      //init with text file...path+name hardcoded for now
        BufferedReader r=null;
        try {
            r = new BufferedReader(new FileReader(System.getProperty("user.dir")+ "/sampleMap.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<Character>> tabledMap = new ArrayList<>();
        ArrayList<Character> tabledMapLine;
        String line;
        String[] splitLine;

        do {
            tabledMapLine=null;
            line=null;
            splitLine=null;
            try {
                line = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(line == null)
                break;
            splitLine = line.split(" ");
            tabledMapLine = new ArrayList<>();
            for(int i=0;i<splitLine.length;i++)
            {
                tabledMapLine.add(splitLine[i].charAt(0));
            }
            tabledMap.add(tabledMapLine);
        }
        while (line!=null);

        map = new Box[tabledMap.size()][tabledMap.get(0).size()];
        for (int i=0;i<tabledMap.size();i++)
        {
            for (int j=0;j<tabledMap.get(i).size();j++)
            {
                map[i][j]=new Box(tabledMap.get(i).get(j));
//                System.out.print(map[i][j].getContent());   //just for debug
            }
//            System.out.println();   //just for debug
        }
//        System.out.println();   //just for debug
    }

    public Box[][] getMap() {
        return map;
    }

    public int lengthY() {
        return map.length;
    }

    public int lengthX() {
        return map[0].length;
    }

    public Box getBox(Point pos) {
        return map[pos.x][pos.y];
    }


    void explore(int i, int j){
        this.map[i][j].setExplored();
    }

}