<%@ page import="model.Entry" %>
<%@ page import="java.util.List" %>
<%@ page import="model.EntryJDBCDAO" %>
<%@ page import="model.EntryDAO" %>
<%@ page import="connection.DatabaseLoader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!doctype html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>90's Guest Book</title>
    <meta name="description" content="Java EE exercise">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;400;500;700&display=swap" rel="stylesheet">
</head>

<body>
    <h1>Guestbook</h1>
    <h2>How did others like our website?</h2>

        <%
            DatabaseLoader dbloader = new DatabaseLoader();
            dbloader.fillDatabase();
            EntryDAO entryDao = new EntryJDBCDAO();
            List<Entry> allEntries = entryDao.getAllEntries();
            if(allEntries.size() == 0){
        %>

    <p class="book-empty-message">The guestbook is empty. Be the first to add your opinion.</p>

        <%
            } else {
        %>

    <div class="entries">

        <%
            for (Entry entry : allEntries) {
        %>

        <div class="entry">
            <p class="name"><%= entry.getName() %></p>
            <p class="city"><%= entry.getCity() %></p>
            <p class="content"><%= entry.getContent() %></p>
            <p class="date"><%= entry.getDate() %></p>
        </div>

        <%
            }
        %>

    </div>

        <%
            }
        %>

    <h2>It's your turn! Share your thoughts!</h2>
    <form action="post_message" method="post">
        <ul>
            <li>
                <label for="name">Name:</label>
                <input type="text" id="name" name="user_name">
            </li>
            <li>
                <label for="city">City:</label>
                <input type="text" id="city" name="user_city">
            </li>
            <li>
                <label for="message">Message:</label>
                <textarea id="message" name="user_message">Enter your message here</textarea>
            </li>
            <li class="button">
                <button type="submit">Send message</button>
            </li>
        </ul>
    </form>
<!--<script src="js/scripts.js"></script>-->
</body>
</html>