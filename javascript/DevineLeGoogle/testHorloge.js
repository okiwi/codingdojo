module("horloge")

asyncTest("Si une seconde passe, on a un tic", function() {
    var tic_saved = $.horloge.tic
    var called = false
    $.horloge.tic = function() {
        called = true
    }

    demarre({"dur": []})

    window.setTimeout( function(){
        start()
        ok(called)
    }, 1200)
    $.horloge.tic = tic_saved
})

