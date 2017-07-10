
<html>
4425lkjdkljf
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.9.0.min.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery.get('http://ipinfo.io/json', function(data) {

			console.log(data);
			$.ajax({
				url : "./ipInfo",
				type : "post",
				dataType : "json",
				async : false,
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(data),
				success : function(result) {

					alert("d");

				}
			})

		});
	});
</script>

</html>



