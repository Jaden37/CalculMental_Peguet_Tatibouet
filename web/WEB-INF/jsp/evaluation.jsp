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
    <h1 class="center-align">Questionnaire</h1>
    <div>
        <h2>${question.libelle}</h2>
        <p>${question.resultat}</p>
        <p>${expression.pile}</p>
        <p>Voici le calcul à résoudre :</p>
        <p>${expression.chaineCalcul}</p>

        <form method="post" action="evaluation">
            <div class="row">
                <div class="input-field col s12">
                    <input id="first_name" name="login" type="text" class="validate">
                    <label for="first_name">Login</label>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/vendor/materialize/js/materialize.js"></script>
</body>
</html>
