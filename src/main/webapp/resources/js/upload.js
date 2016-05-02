$("document").ready(function() {
	$("#uploadBtn").on("change", function() {
	    var filename = $(this).val();
	    $("#uploadFile").val(filename);
	    if(!filename.endsWith(".xml")) {
	    	$("#saveBtn").prop("disabled", true);
	    	var el = $(".fileUpload")[0];
	    	$(el).removeClass();
	    	$(el).addClass("fileUpload pure-button button-error");
	    	$("#uploadBtn").prop("title", "Только XML файлы");
	    } else {
	    	var el = $(".fileUpload")[0];
	    	$(el).removeClass();
	    	$(el).addClass("fileUpload pure-button button-success");
	    	$("#uploadBtn").prop("title", "Ok");
	    	$("#saveBtn").prop("disabled", false);
	    }
	});
	
	$("#send-form").ajaxForm(function(data) {
		var el = $("#upload-result")[0];
		$("#upload-result").html(data);
		 $("#upload-result").removeClass();
		if (data == "Ok") {
			 $("#upload-result").addClass("upload-result-success");
		} else {
			 $("#upload-result").addClass("upload-result-fault");
		}
	});
	
});