<%@ page import="java.util.List" %>
<%@ page import="dto.ColorDTO" %>
<%@ page import="dao.ColorDAOImpl" %>

<html>
<head>
    <title>Color List</title>
</head>
<body>
    <h1>Color List</h1>
    <% 
        ColorDAOImpl colorDao = new ColorDAOImpl();
        try {
            List<ColorDTO> colors = colorDao.selectAllColor();
            if (colors != null && colors.size() > 0) {
                for (ColorDTO color : colors) {
                    out.println("<p>" + color.getColorName() + "</p>");
                }
            } else {
                out.println("<p>No colors found.</p>");
            }
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    %>
</body>
</html>
