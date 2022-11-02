package com.esliceu.PracticaFigures.DAO;

import com.esliceu.PracticaFigures.Model.Figure;

import java.util.ArrayList;
import java.util.List;

public class FigureDAO implements FigureDAOInter{

    public static List<Figure> figureList = new ArrayList<>();
    static int idFigure= 0;

    @Override
    public boolean insert(Figure figure) {
        figure.setId(idFigure);
        figureList.add(figure);
        idFigure+=1;
        return false;
    }

}
