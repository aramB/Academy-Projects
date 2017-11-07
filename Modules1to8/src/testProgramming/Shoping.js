
var superSoup = {
    potatis: 2,
    lök : 1,
    vitlök : 2,
    morot : 3
};

var godMat = {
    potatis: 2,
    majs : 1,
    äpple : 2,
    lök : 2
};

var ICA = {
    potatis : 12,
    majs : 7,
    lök : 3,
    äpple : 5,
    vitlök : 8,
    morot : 12
};

var COOP = {
    potatis : 11,
    majs : 9,
    lök : 5,
    äpple : 2,
    vitlök : 4,
    morot : 11
};

var butiker={
    ICA : ICA,
    COOP : COOP
};

function costOfRecipe(recept, butik) {
    var total = 0;
    for (var vara in recept){
        total += recept[vara] * butik[vara];
    }
    return total;
}



/**
 * Skriver man butik så får man strängen/nyckeln butik
 * men om man skriver butiker[butik] får man värdet vilket är ett objekt i sin tur.
 *
 **/
function findCheapestShop(recept, butiker) {
    var min = Infinity;
    var cheapestStore;
    for (var butikNyckel in butiker){
        var butikObjekt = butiker[butikNyckel];
        if (costOfRecipe(recept, butikObjekt) < min){
            min = costOfRecipe(recept, butikObjekt);
            cheapestStore = butikNyckel;
        }
    }
    return cheapestStore;
}

var recept = superSoup;
var butik = ICA;

console.log("Totala priset för"+ "blir: " + costOfRecipe(recept, butik) + "kr");
console.log("Totala priset för"+ "blir: " + costOfRecipe(recept, COOP) + "kr");

console.log("billigast: " + findCheapestShop(recept, butiker));
