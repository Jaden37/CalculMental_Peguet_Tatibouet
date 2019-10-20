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
        <p>${expression.pile}</p>
        <b>Voici le calcul à résoudre :</b>
        <div class="card-panel blue-grey darken-4">
            <b class="white-text text-lighten-5">${expression.chaineCalcul}</b>
        </div>
        <form method="post" action="question">
            <div class="row">
                <div class="input-field col s12">
                    <input id="response_user" name="answer" type="number" step="any" class="validate" required>
                    <label for="response_user">Votre réponse</label>
                </div>
                <button class="btn waves-effect waves-light green darken-2 right" type="submit" name="action">Valider réponse
                    <i class="material-icons right">gamepad</i>
                </button>
            </div>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/vendor/materialize/js/materialize.js"></script>
</body>
</html>
