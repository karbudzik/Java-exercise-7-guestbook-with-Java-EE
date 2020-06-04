package servlets;

import model.Entry;
import model.EntryDAO;
import model.EntryJDBCDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet("/entries")
public class EntryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        handleNewEntryInsert(request);
        doGet(request, response);
    }

    private void handleNewEntryInsert(HttpServletRequest request) {
        java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String user_name = (request.getParameter("user_name").length() == 0) ? "Anonymous" : request.getParameter("user_name");

        String user_city = request.getParameter("user_city");
        String user_message = request.getParameter("user_message");

        EntryDAO entryDao = new EntryJDBCDAO();
        Entry entry = new Entry(user_name, user_city, user_message, currentDate);
        entryDao.insertNewEntry(entry);
    }
}