var animalRequest = {};
var steps = ["#animal-choose", "#room-choose","#dates-choose", "#personal-data-choose"];
var currentStep = 0;

function chooseAnimalType(animalType) {
    animalRequest.animalType = animalType;

    $("#animal-choose").animate({
        opacity: 0.10
    }, 500, goToNextStep());
}

function chooseRoomType(roomType) {
    animalRequest.roomType = roomType;
    $("#room-choose").animate({
        opacity: 0.10
    }, 500, goToNextStep());
}

function chooseDates() {
    animalRequest.beginDate = $("#begin-date-input").val();
    animalRequest.endDate = $("#end-date-input").val();
    $("#date-choose").animate({
        opacity: 0.10
    }, 500, goToNextStep());
}
function goToNextStep() {
    $(steps[currentStep]).css("display", "none");
    if (currentStep <= steps.length) {
        currentStep++;
        $(steps[currentStep]).css("display", "grid");
    }
}

function sendRequest() {
    animalRequest.animalName = $("#animal-name-input").val();
    animalRequest.phoneNumber = $("#phone-input").val();
    animalRequest.email = $("#email-input").val();
    animalRequest.name = $("#name-input").val();
    animalRequest.surname = $("#surname-input").val();
animalRequest.requestStatus = "NEW";
    if ($("#video-input").val()==="on"){
        animalRequest.videoNeeded = true;
    } else {
        animalRequest.videoNeeded = false;
    }
    animalRequest.location = $("#location-input").val();

    $.ajax({
        url: '/api/animalRequest',
        dataType: 'json',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(animalRequest),
        success: function () {
          alert('Заявка отправлена')
        },
        error:function(error) {
            alert(error)
        }
    })
}

function minDate(){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10){
        dd='0'+dd
    }
    if(mm<10){
        mm='0'+mm
    }

    today = yyyy+'-'+mm+'-'+dd;
    $('#begin-date-input').attr('min',today)
}
$(document).ready(function(){
    minDate()
})
