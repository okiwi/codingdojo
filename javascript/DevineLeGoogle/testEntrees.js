module("Test des entrees")

test("Le champ input est vide apres une saisie invalide", function() {
    demarre({"dur": ['url1', 'url2']});
    
    essaieSaisie("prout");
    
    equals($('#saisie').val(), "");
});

test("Le champ input est vide apres une saisie valide", function() {
    demarre({"dur": ['url1', 'url2'], "mou": ['url1', 'url2']});
    
    essaieSaisie("prout");
    
    equals($('#saisie').val(), "");
});


test("En fin de partie, les images ne sont plus affichees", function() {
    demarre({"dur": ['url1', 'url2']});
    
    essaieSaisie("dur");
    
    equals($('#test img').size(), 0);
    equals($('#test #saisie').size(), 0);
});

test("En fin de partie, un message de felicitation s'affiche", function() {
    demarre({"dur": ['url1', 'url2']});
    
    essaieSaisie("dur");

    equals($("#test #message").html(), "Felicitations !")    
})


test("Lorsqu'on a saisi une entree valide la page contient les images du mot suivant", function() {
    demarre({"dur": [], "pouet": ['url_pouet1', 'url_pouet2']});
    
    essaieSaisie("dur");
    
    equals($("#test img:first").attr('src'), 'url_pouet1');
    equals($("#test img:last").attr('src'), 'url_pouet2');
});


test("Peut afficher l'input", function() {
    demarre({"dur": []});
    
    equals($("#test input[type=text]#saisie").size(), 1)
});

test("Cliquer dans l'input ne duplique pas les images", function() {
    demarre({"dur": ['', '']});
    
    $("#test input[type=text]").click();
    
    equals($("#test img").size(), 2);
});

test("Un message d'erreur s'affiche une seule fois en cas d'erreur", function() {
    demarre({"dur": []});
    
    essaieSaisie("ceci est faux");
    assertErreur();
  
    essaieSaisie("ceci est faux");
    assertErreur();  
});

test("Le score est le nombre de secondes restantes", function() {
    demarre({"dur": [], "pouet": [], "eiffel": [], "apres-dernier": []});
    
    essaieSaisie("dur");
    equals($("#test #score").html(), "15");
    
    $.horloge.tic();
    essaieSaisie("pouet");
    equals($("#test #score").html(), "29");
    
    $.horloge.tic();
    $.horloge.tic();
    essaieSaisie("eiffel");
    equals($("#test #score").html(), "42");
});

test("Le message d'erreur s'efface lorsque je commence a saisir une nouvelle entree", function() {
    demarre({"dur": []});
    essaieSaisie("facile");
    assertErreur();
    
    $("#test #saisie").trigger("keypress", {});
    equals($("#test #message").html(), "");    

});

