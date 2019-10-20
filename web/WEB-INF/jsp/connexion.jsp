<html>
<head>
    <title>Connexion</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/vendor/materialize/css/materialize.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body class="home">
<div class="container">
    <!--Permet d'afficher un message d'erreur si un problème survient lors de la connexion de l'utilisateur -->
    <c:if test="${ !empty connexionBean.authentResult}">
        <div class="row" id="alert_box">
            <div class="col s12 m12">
                <div class="card red darken-1">
                    <div class="row">
                        <div class="col s12 m12">
                            <div class="card-content white-text center-align">
                                <p>${connexionBean.authentResult}</p>
                            </div>
                        </div>
                        <div class="col s12 m2">
                            <i class="fa fa-times icon_style" id="alert_close" aria-hidden="true"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <!--Affichage du formulaire de connexion -->
    <form method="post" action="connexion" >
        <div class="row">
            <div class="col s12 m6 offset-m3">
                <div class="card white darken-1 connexion-form" >
                    <div class="card-content darken-1">
                        <span class="card-title">Connexion</span>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="first_name" name="login" type="text" class="validate" required value="${connexionBean.login}">
                                <label for="first_name">Login</label>
                            </div>
                            <div class="input-field col s12">
                                <input id="last_name" name="password" type="password" class="validate" required>
                                <label for="last_name">Password</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-action">
                    <button class="btn waves-effect waves-light right" type="submit" name="action">Se connecter
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </div>
    </form>
    <%--<div class="row" >
        <div class="col s12 m6 offset-m3">
            <div class="card horizontal">
                <div class="card-image">
                    <img src="https://lorempixel.com/100/190/nature/6">
                </div>
                <div class="card-stacked">
                    <div class="card-content">
                        <p>Vous voulez tenter vôtre chance ?</p>
                    </div>
                    <div class="card-action">
                        <button class="btn waves-effect waves-light right" type="submit" name="action">Inscrivez vous
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>--%>
</div>
<script src="${pageContext.request.contextPath}/vendor/materialize/js/materialize.js"></script>
</body>
</html>
