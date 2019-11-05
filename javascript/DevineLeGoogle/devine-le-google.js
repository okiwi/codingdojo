(function($) {
    
    $.horloge = function() {
        
    }
    $.horloge.stop = function() {
            $(document).stopTime();        
    }

    $.horloge.demarre = function() {           
            $(document).everyTime(1000, $.horloge.tic)
    }
    
    $.horloge.tic = function() {
        $.horloge.callback();
    }
    
    $.horloge.enregistre = function(callback) {
        $.horloge.callback = callback;           
    }

    $.fn.devineLeGoogle = function(solutions) {
        
        var topLevel = $(this);
        var playButton = $("<input type='button' value='Play!' />");
        var tempsRestant = $("<span id='temps'></span>");

        var page_dacceuil = function(){
            topLevel.css("text-align", "center");
            topLevel.append($("<h1>DEVINE LE GOOGLE !!</h1>"))  
            topLevel.append($("<BR/>"));
            topLevel.append(tempsRestant);
            topLevel.append($("<BR/>"));
            topLevel.append(playButton); 
        }
       
        page_dacceuil()
        
        var msgSpan = $("<span id='message'></span>");
        var score = $("<span id='score'>0</span>");

        var images = $("<div style='width: 600; margin: 0 auto'></div>")
        var input = $("<input id='saisie' type='text'>")

        var inc_score = function() {
            score.html(parseInt(score.html()) + parseInt(tempsRestant.html()));
        }
        
        var display_images_for_keyword = function(mot) {
            $.getJSON("http://api.pixplorer.co.uk/image?amount=5&size=tb&word=" + mot,
              function(data){
              $.each(data["images"],function(i, item) {
                image = item["imageurl"]
                images.append("<img src='" + image + "' width='150' />");
              })
            })
        }
        
        var delete_images = function() {
            topLevel.find("img").remove()
        }        
        
        var display_message = function(msg) {
           msgSpan.html(msg);
        }

        var armerTimer = function() {
            $.horloge.stop();
            tempsRestant.html(15);
            $.horloge.enregistre(function() {
                var temps = parseInt(tempsRestant.html()) - 1                
                tempsRestant.html(temps);
                if( temps <= 0) {
                        $("#saisie").change();
             }},15);
            $.horloge.demarre();           
        }       
        var finirPartie = function(){
            input.remove()
            tempsRestant.remove()
            display_message("Felicitations !")
        }

        var play = function() {
            topLevel.append(images);
            topLevel.append(score);
            topLevel.append(msgSpan);
            topLevel.append(input);
            armerTimer();

            input.keypress(function() {
                msgSpan.html("");
            });
            
            
            var mot = solutions.next()

            display_images_for_keyword(mot);

            input.change(function(event) {
                if (input.val() == mot || parseInt(tempsRestant.html()) <= 0) {
                    inc_score();
                    delete_images()
                    mot = solutions.next()
                    if (mot) {
                        display_images_for_keyword(mot)
                        armerTimer()
                    }
                    else {
                        finirPartie();
                    }
                } else {
                    display_message("ERREUR");
                }
                input.val("")   
            })
            input.focus();
        };

        playButton.click(function() {
            playButton.remove()
            play()
        })        
    };

})(jQuery);

var Generateur = function(mots) {
  return {
    next: function() {
      var index = Math.ceil(Math.random() * mots.length) - 1;
      var mot = mots[index];
      mots.splice(index, 1);
      return mot;
    },
  }
}
