QUnit.testDone = function() {
    $("#test").empty();
} 

module("Fonction utiles");

var demarre = function(solutions) {
    var keywords = []
    
    for (var keyword in solutions) {
        keywords.push(keyword)
    }
    
    keywords = keywords.reverse()
    
    var fake_generator = {next: function() {
            return keywords.pop()
        }
    };
    
    $("#test").devineLeGoogle(fake_generator);
    
    $.getJSON = function(url, callback) {
        var query_param = "&word="
        var mot = url.substr(url.lastIndexOf(query_param) + query_param.length)
        var urls = solutions[mot]
        var results = []
        for(var i in urls) {
            results.push({"imageurl":urls[i]})
        }
        callback({"images": results})
    }

    
    $("#test input[type=button]").click();
   
}

function assertErreur(){
    equals($("#test #message").html(), "ERREUR");
    equals($("#test #message").size(), 1);
}

function essaieSaisie(valeur) {
    $("#test #saisie").val(valeur);
    $("#test #saisie").trigger("change", {});
}






module("generateur");

test("Le generateur retourne un mot", function() {
    var _random = Math.random;
    Math.random = function() { return 0.5 }
    var mots = ["bonjour", "maman", "avion", "voiture", "piscine"]

    var generateur = new Generateur(mots)
    
    equals(generateur.next(), "avion");
    equals(generateur.next(), "maman");
    equals(generateur.next(), "voiture");
    equals(generateur.next(), "bonjour");
    equals(generateur.next(), "piscine");
    ok(generateur.next() == null);
    Math.random = _random;
});



// TODO
// HighScores?
// Gerer les plantages (frequents) de Google
// lancer du marketing viral sur facebook
// faire un retour d'xp a Agile Tour puis Agile XXXX
// Sortir les elements d'affichage de la page dans une fonction dediee


