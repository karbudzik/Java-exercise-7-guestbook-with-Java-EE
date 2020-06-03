<%@ page import="model.Entry" %>
<%@ page import="java.util.List" %>
<%@ page import="model.EntryJDBCDAO" %>
<%@ page import="model.EntryDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!doctype html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>90's Guest Book</title>
    <meta name="description" content="Java EE exercise">
</head>

<body>
    <h1>Guestbook</h1>
    <h2>How did others like our website?</h2>
    <div class="entries">
        <%
            EntryDAO entryDao = new EntryJDBCDAO();
            List<Entry> allEntries = entryDao.getAllEntries();
            if(allEntries.size() == 0){
        %>

        <p class="book-empty-message">The guestbook is empty. Be the first to add your opinion.</p>

        <%
            } else {
                for (Entry entry : allEntries) {
        %>

        <div class="entry">
            <p class="name"><%= entry.getName() %></p>
            <p class="city"><%= entry.getCity() %></p>
            <p class="content"><%= entry.getContent() %></p>
            <p class="date"><%= entry.getDate() %></p>
        </div>

        <%
            }}
        %>

    </div>
    <h2>It's your turn! Share your thoughts!</h2>
    <form action="/example-url" method="post">
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





<%--<div class="sign-block">--%>
<%--        <%--%>
<%--        int styleChange = 1;--%>
<%--        List<Sign> allSigns = ServiceSign.getAllSigns();--%>
<%--        if(allSigns.size() == 0){--%>
<%--            %>--%>
<%--    <p>The book is empty</p>--%>
<%--        <%--%>
<%--        }--%>
<%--        for(Sign oneSign :allSigns){--%>
<%--            if(styleChange % 2 == 1){--%>
<%--      %>--%>
<%--    <div class="sign sign-even">--%>
<%--        <%--%>
<%--        }else{--%>
<%--        %>--%>
<%--        <div class="sign">--%>
<%--            <%--%>
<%--                }--%>
<%--            %>--%>
<%--            <div class="message"><%= oneSign.getMessage() %></div>--%>
<%--            <div class="info">--%>
<%--                <span>Name: </span>--%>
<%--                <span class="name-content"><%= oneSign.getName() %></span>--%>
<%--            </div>--%>
<%--            <div class="info">--%>
<%--                <span>Date: </span>--%>
<%--                <span class="date-content"><%= oneSign.getDate() %> <%=oneSign.getTime()%></span>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <%--%>
<%--                styleChange++;--%>
<%--            }--%>
<%--        %>--%>

<%--    </div>--%>
<%--    <form id="sign-to-guestbook" action="Servlet" method="POST">--%>
<%--        <label>Message:</label>--%>
<%--        <textarea name="provide-message"></textarea>--%>
<%--        <label>Name:</label>--%>
<%--        <input name="provide-name" type="text">--%>
<%--        <button id="submit-btn">Submit</button>--%>
<%--    </form>--%>

<%--</body>--%>
<%--</html>--%>