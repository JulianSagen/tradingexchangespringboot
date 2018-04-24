
function bookrender() {
    var data = $.getJSON('/trade/get/buysellorders', function(book) {
        book.buyorder
    });


    $.each(data.buyOrder, function(price, amount) {
        alert("bid: " + price + " amount:" + amount);
    });​
}

bookrender();