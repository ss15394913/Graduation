window.addEventListener("beforeunload", function (e) {
	var confirmationMessage = "���͓��e��j�����܂��B";
	e.returnValue = confirmationMessage;
	return confirmationMessage;
});