<html>
<head>
    <title>Home</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/vendor/materialize/css/materialize.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body class="scores">
<div class="container">
    <div class="row center-align">
        <h1 class="blue-grey-text text-lighten-5">Tableau des scores</h1>
        <table class="responsive-table striped white">
            <thead>
            <tr class="">
                <th>Position</th>
                <th>Login</th>
                <th>Best Score</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${ homeBean.listUsers }" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.login}</td>
                <td>${user.bestScore}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="center-align start_game">
        <a class="waves-effect waves-light btn light-blue darken-4" href="question"><i class="material-icons left">videogame_asset</i>Commencer la partie</a>
    </div>
</div>
<script src="${pageContext.request.contextPath}/vendor/materialize/js/materialize.js"></script>
</body>
</html>
