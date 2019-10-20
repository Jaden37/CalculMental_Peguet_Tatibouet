<html>
<head>
    <title>Result</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/vendor/materialize/css/materialize.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<!-- Affichage du résultat du test -->
<div class="container">
    <h1 class="center-align">Test terminé</h1>
    <div class="card-panel indigo">
        <p class="white-text text-lighten-5">Votre score est de <b>${nbVictoire} / ${nbQuestion}</b></p>
    </div>
    <!-- Redirection vers l'accueil -->
    <div class="right-align">
        <a class="waves-effect waves-light btn blue-grey lighten-5 black-text" href="home"><i class="material-icons left">home</i>Retour à l'accueil</a>
    </div>
</div>
<script src="${pageContext.request.contextPath}/vendor/materialize/js/materialize.js"></script>
</body>
</html>