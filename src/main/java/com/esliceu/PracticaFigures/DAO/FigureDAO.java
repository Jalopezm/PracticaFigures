package com.esliceu.PracticaFigures.DAO;

import com.esliceu.PracticaFigures.Model.Figure;

import java.util.ArrayList;
import java.util.List;

public class FigureDAO implements FigureDAOInter{

    public static List<Figure> figureList = new ArrayList<>();
    static int idFigure= 0;

    @Override
    public void insert(Figure figure) {
        figure.setId(idFigure);
        figureList.add(figure);
        idFigure+=1;
    }

    public void deleteFigure(int id){
        int currFig = -1;
        for (Figure figure :figureList) {
            if (id == figure.getId()){
                currFig = figureList.indexOf(figure);
            }
        }
        if(currFig != -1){
            figureList.remove(currFig);
        }
    }
}
