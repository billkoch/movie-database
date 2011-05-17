<g:textField name="${variableName}" name="${variableName}" value="${date ? date.format('MM/dd/yyyy') : ''}" />
<g:hiddenField name="${variableName}_month" value="${date ? date.format('MM') : ''}" />
<g:hiddenField name="${variableName}_day" value="${date ? date.format('dd') : ''}" />
<g:hiddenField name="${variableName}_year" value="${date ? date.format('yyyy') : ''}" />

<script type="text/javascript">
	$(document).ready(function() {
		$("#${variableName}").datepicker({
			onClose: function(dateText, datePicker) {
				$("#${variableName}_month").val(datePicker.selectedMonth + 1);	
				$("#${variableName}_day").val(datePicker.selectedDay);	
				$("#${variableName}_year").val(datePicker.selectedYear);	
			}
		});
	});
</script>