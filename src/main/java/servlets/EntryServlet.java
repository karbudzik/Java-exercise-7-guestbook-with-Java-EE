package servlets;


import model.Entry;
import model.EntryDAO;
import model.EntryJDBCDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@WebServlet("/post_message")
public class EntryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) {
        java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        String user_name = request.getParameter("user_name");
        String user_city = request.getParameter("user_city");
        String user_message = request.getParameter("user_message");

        EntryDAO entryDao = new EntryJDBCDAO();
        Entry entry = new Entry(user_name, user_city, user_message, currentDate);

        entryDao.insertNewEntry(entry);
    }
}