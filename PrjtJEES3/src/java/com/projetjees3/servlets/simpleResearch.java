package com.projetjees3.servlets;

import com.projetjees3.beans.BeanException;
import com.projetjees3.dao.ChercheurDaoImpl;
import com.projetjees3.dao.DaoException;
import com.projetjees3.dao.DaoFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddMarkUser")

public class simpleResearch extends HttpServlet 
{

    private static final long serialVersionUID = 1L;
    private ChercheurDaoImpl chercheurDao;
    
        public void init() throws ServletException
    {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.chercheurDao = daoFactory.getChercheurDao();
    }
    
    public simpleResearch()
     {
         super();
     }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {   
        try {
            request.setAttribute("users5",chercheurDao.lister5());
        } catch (BeanException | DaoException ex) {
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/simpleresearch.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }

}
