module("timer")

test("On initialise un timer a 15 secondes", function() {
    demarre({"dur": []})

    equals($("#test #temps").html(), 15)
})

test("Re : Si un tic passe, le timer baisse de 1", function() {
    demarre({"dur": []})
    equals($("#test #temps").html(), 15)
    
    $.horloge.tic()

    equals($("#test #temps").html(), 14)
})

test("Si on entre un mot valide,  le timer est remis a son etat initial", function() {
    demarre({"dur": ['url1', 'url2'], "mou": ['url1', 'url2']})
    $.horloge.tic()

    essaieSaisie("dur")

    equals($("#test #temps").html(), 15)
})


test("Si le temps est a zero, je passe au mot suivant", function() {
    demarre({"dur": ['urlDur'],"mot": ['urlMot']})
    $("#test #temps").html(1)

    $.horloge.tic();

    equals($("#test img:first").attr('src'), 'urlMot');
})
