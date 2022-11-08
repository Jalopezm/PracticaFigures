package com.esliceu.PracticaFigures.services;

import com.esliceu.PracticaFigures.DAO.FigureDAO;
import com.esliceu.PracticaFigures.DAO.FigureDAOInter;
import com.esliceu.PracticaFigures.Model.Figure;
import com.esliceu.PracticaFigures.Model.User;

import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class FigureServ {
    FigureDAOInter figureDAO = new FigureDAO();

    public static List<Figure> listFigures() {
        List<Figure> list = FigureDAO.figureList;

        return list;
    }

    public static List<Figure> userListFigures(User user) {
        List<Figure> userFigureList = new ArrayList<>();
        for (Figure figure:listFigures()) {
            if (figure.getUser().getId() == user.getId()){
                userFigureList.add(figure);
            }
        }
        return userFigureList;
    }

    public void figureCreation(String name, String type, String color, int posX, int posY, int width, User userName){
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
        List<Figure> list = listFigures();
        for (Figure figure : list) {
            if (id == figure.getId()){
                return figure;
            }
        }
       return null;
    }

    public void deleteFigureById(int id){
        figureDAO.deleteFigure(id);
    }
}
