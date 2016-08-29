/**
 * Created by iripl-83 on 23-08-2016.
 */

function placeAnOrder(orderNumber){console.log("Customer Order: ", orderNumber);
    cookAndDeliverFood(function () {
        console.log("delivered food order", orderNumber);

    })
}

// Similate a 5 second
function cookAndDeliverFood(callBack){
    setTimeout(callBack, 5000);
}


//Simulates users

placeAnOrder(1);
placeAnOrder(2);
placeAnOrder(3);placeAnOrder(4);placeAnOrder(5);placeAnOrder(6);