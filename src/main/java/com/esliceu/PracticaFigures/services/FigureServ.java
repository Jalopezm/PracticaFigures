package com.esliceu.PracticaFigures.services;

import com.esliceu.PracticaFigures.DAO.FigureDAO;
import com.esliceu.PracticaFigures.DAO.FigureDAOInter;
import com.esliceu.PracticaFigures.Model.Figure;

import java.util.List;

public class FigureServ {
    FigureDAOInter figureDAO = new FigureDAO();

    public static List<Figure> listFigures() {
        List<Figure> list = FigureDAO.figureList;

        return list;
    }

    public void figureCreation(String name,String type,String color,int posX,int posY,int width,String userName){
        Figure figure = new Figure();
        figure.setUser(userName);
        figure.setName(name);
        figure.setFigureType(type);
        figure.setColor(color);
        figure.setCoordX(posX);
        figure.setCoordY(posY);
        figure.setWidth(width);

        figureDAO.insert(figure);
    }
    public Figure getFigureById(int id){
        Figure figure = new Figure();
        listFigures().get(id);
        return figure;
    }
}
