module("Test de la vue")

test("Avant le debut du jeu, seul le bouton play est present", function() {
    $("#test").devineLeGoogle();
    
    ok($("#test input[type=button]").size() == 1, "il manque un bouton")
    ok($("#test #saisie").size() == 0, "le champ de saisie ne doit pas encore s'afficher")
});

test("Lorsque la partie est demarree, le bouton play disparait", function() {
    demarre({"dur": ['url1', 'url2']})

    ok($("#test input[type=button]").size() == 0, "ce bouton n'a rien a foutre la")
});

test("Lorsqu'on clique sur le bouton play, on interroge Google Image", function() {
    var JSONsave = $.getJSON
    
    $.getJSON = function(url, callback) {
        equals(url, "http://api.pixplorer.co.uk/image?amount=5&size=tb&word=dur")
    }

    $("#test").devineLeGoogle({next: function() {
            return "dur"
        }});
        
    $("#test input[type=button]").click();

    expect(1)
    
    $.getJSON = JSONsave
});

test("Lorsqu'on clique sur le bouton play la page contient les images du premier mot", function() {

    demarre({"dur": ['url1', 'url2']});

    equals($("#test img:first").attr('src'), 'url1');
    equals($("#test img:last").attr('src'), 'url2');    
});

test("Donne le focus en début de partie", function() {
    demarre({"dur": ['url1', 'url2']})

    ok($("#saisie:focus").size() >0)
})

test("Le taille des images est fixee en largeur", function() {
     demarre({"dur": ['http://yaal.fr/media/yaal.png', 
        'http://yaal.fr/media/yaal.png']});
     equals($("#test img").attr('width'), '150');
});

test("Charte marketing de la page qui doit etre centrer", function() {
    demarre({"dur": ['http://yaal.fr/media/yaal.png', 
        'http://yaal.fr/media/yaal.png']});
        
    equals($("#test").css('text-align'), "center");
});

test("Charte graphique de la page d'accueil", function() {
    $("#test").devineLeGoogle();
    
    equals($("#test *:first").html() , "DEVINE LE GOOGLE !!");
    
    equals($("#test input[type=button]").val(), "Play!");
	
});

test("Pas de compteru sur la page de felicitation", function(){
    demarre({"dur": ['http://yaal.fr/media/yaal.png', 
        'http://yaal.fr/media/yaal.png']});
    essaieSaisie("dur");
    
    ok($("#temps").size() == 0);
});


