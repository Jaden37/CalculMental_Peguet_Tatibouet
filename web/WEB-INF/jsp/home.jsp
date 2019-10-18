<html>
<head>
    <title>Home</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/vendor/materialize/css/materialize.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<div class="container">
    <div class="row center-align">
        <h1>Home Page</h1>
        <table class="responsive-table striped">
            <thead>
            <tr>
                <th>Position</th>
                <th>Login</th>
                <th>Best Score</th>
            </tr>
            </thead>
            <tbody>
            <tr>
            <c:forEach var="user" items="${ homeBean.listUsers }" varStatus="status">
                    <td>${status.index + 1}</td>
                    <td>${user.login}</td>
                    <td>${user.bestScore}</td>
            </c:forEach>
            </tr>

            </tbody>
        </table>
    </div>
    <div>
        <a href="evaluation">Commencer la partie</a>
    </div>
</div>
<script src="${pageContext.request.contextPath}/vendor/materialize/js/materialize.js"></script>
</body>
</html>
