<html>
<head>
    <title>Question</title>
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

        <form method="post" action="question">
            <div class="row">
                <div class="input-field col s12">
                    <input id="first_name" name="answer" type="number" step="any" class="validate">
                    <label for="first_name">Votre réponse</label>
                </div>
                <button class="btn waves-effect waves-light right" type="submit" name="action">Valider réponse
                    <i class="material-icons right">send</i>
                </button>
            </div>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/vendor/materialize/js/materialize.js"></script>
</body>
</html>
