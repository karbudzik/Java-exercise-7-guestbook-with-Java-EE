let button = document.querySelector("button");
let message = document.querySelector("#message");

function preventFromSendingEmptyMessage(event) {
    if (message.value == '') {
        event.preventDefault();
        showValidationMessage();
    }
}

function showValidationMessage() {
    let message = document.querySelector(".validation_message");
    message.style.visibility = "visible";
}

button.addEventListener("click", preventFromSendingEmptyMessage);
